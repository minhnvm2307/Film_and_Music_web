document.addEventListener('DOMContentLoaded', () => {
    const saveButton = document.getElementById('save-btn');
    const addButton = document.getElementById('add-btn');
    const cancelButton = document.getElementById('cancel-btn');

    // disable save button by default
    saveButton.disabled = true;
    addButton.disabled = false;
});

document.getElementById('song-poster').addEventListener('input', updatePosterPreview);

// Update the poster preview when the poster input changes
function updatePosterPreview() {
    const posterInput = document.getElementById('song-poster');
    const posterPreview = document.getElementById('poster-preview');
    const imageStatus = document.getElementById('image-status');
    
    posterPreview.src = posterInput.value;
    
    posterPreview.onload = () => {
        imageStatus.textContent = 'status: Image loaded successfully';
        imageStatus.style.color = 'green';
    };
    
    posterPreview.onerror = () => {
        imageStatus.textContent = 'status: Failed to load image';
        imageStatus.style.color = 'red';
    };
}

// Load song details when Admin clicks on EDIT button a song in the table
function loadSongToForm(songId) {
    const saveButton = document.getElementById('save-btn');
    const addButton = document.getElementById('add-btn');
    saveButton.disabled = false;
    addButton.disabled = true;

    let url = `/admin/music/song-detail?songId=` + songId;
    console.log('Fetching song details from:', url);
    fetch(url)
        .then(response => response.json())
        .then(song => {
            // Populate the form fields with the song details
            document.getElementById('song-id').value = song.songId;
            document.getElementById('song-name').value = song.songName;
            document.getElementById('song-description').value = song.songDescription;
            document.getElementById('song-date').value = song.releaseDate;
            document.getElementById('song-poster').value = song.posterImg;

            // Update poster preview
            updatePosterPreview();

            // Populate selected singers
            const selectedSingersDiv = document.getElementById('selected-singers');
            selectedSingersDiv.innerHTML = ''; // Clear existing singers
            song.singers.forEach(singer => {
                const singerCard = document.createElement('div');
                singerCard.classList.add('singer-card');
                singerCard.setAttribute('data-singer-id', singer.singerId);

                singerCard.innerHTML = `
                    <img src="${singer.avatarImg}" alt="${singer.singerName}">
                    <span>${singer.singerName}</span>
                    <button onclick="removeSinger(this)">Remove</button>
                `;

                selectedSingersDiv.appendChild(singerCard);
            });

            // Update the singers hidden input
            updateSingersInput();

            // Populate categories checkboxes
            const categoryCheckboxes = document.querySelectorAll('#categories-checkbox-group .category-checkbox input[type="checkbox"]');
            categoryCheckboxes.forEach(checkbox => {
                checkbox.checked = song.categories.some(category => category.categoryId == checkbox.value);
            });

            // Audio preview
            const audioInput = document.getElementById('audio-input');
            audioInput.value = ''; // Clear the input value
            const audioPreview = document.getElementById('audio-preview');
            const audioSource = document.getElementById('audio-source');
            audioSource.src = '/assets/audio/' + song.audioLink;
            audioPreview.load();
        })
        .catch(error => {
            console.error('Error fetching song details:', error);
        });
}

// Update the hidden input with the selected singers
function updateSingersInput() {
    const selectedSingersDiv = document.getElementById('selected-singers');
    const singerIds = Array.from(selectedSingersDiv.children).map(card => 
        card.getAttribute('data-singer-id')
    );
    document.getElementById('song-singers').value = singerIds.join(', ');
}


// Load the audio player when choosing a new audio file
document.addEventListener('DOMContentLoaded', function () {
    const audioInput = document.getElementById('audio-input');
    const audioPreview = document.getElementById('audio-preview');
    const audioSource = document.getElementById('audio-source');

    // Audio Preview
    audioInput?.addEventListener('change', function () {
        const file = this.files[0];
        if (file) {
            const objectURL = URL.createObjectURL(file);
            audioSource.src = objectURL;
            console.log('Audio source:', audioSource.src);
            audioPreview.load();
        }
    });
});

/*
* Singer management
* when a singer is selected, a card is created and added to the selected singers div
*/
document.addEventListener("DOMContentLoaded", () => {
    // Select elements
    const singersSelect = document.getElementById("available-singers");
    const selectedSingersDiv = document.getElementById("selected-singers");
    const songSingersInput = document.getElementById("song-singers");

    // Event listener for singer selection
    singersSelect.addEventListener("change", function () {
        const selectedOption = this.options[this.selectedIndex];
        const singerId = selectedOption.getAttribute("data-id");
        const singerName = selectedOption.getAttribute("data-name");
        const singerAvatar = selectedOption.getAttribute("data-avatar");

        // Check if singer is already added
        if (document.querySelector(`[data-singer-id="${singerId}"]`)) {
            alert("Singer already added!");
            return;
        }

        // Create singer card
        const singerCard = document.createElement("div");
        singerCard.classList.add("singer-card");
        singerCard.setAttribute("data-singer-id", singerId);

        singerCard.innerHTML = `
            <img src="${singerAvatar}" alt="${singerName}">
            <span>${singerName}</span>
            <button onclick="removeSinger(this)">Remove</button>
        `;

        selectedSingersDiv.appendChild(singerCard);

        // Update hidden input
        updateSingersInput();
    });

    // Function to remove singer
    window.removeSinger = function (button) {
        const singerCard = button.parentElement;
        singerCard.remove();
        updateSingersInput();
    };

    // Function to update hidden input
    function updateSingersInput() {
        const singerIds = Array.from(selectedSingersDiv.children).map(card => 
            card.getAttribute("data-singer-id")
        );
        songSingersInput.value = singerIds.join(", ");
    }
});
