

document.addEventListener('DOMContentLoaded', function () {
    const saveButton = document.getElementById('save-btn');
    const addButton = document.getElementById('add-btn');

    // Save Button: Update existing song
    saveButton.addEventListener('click', function (event) {
        event.preventDefault();
        
        const isConfirmed = confirmDelete('Are you sure you want to update this song?');
        if (isConfirmed) {
            updateSong();
        }
    });

    // Add Button: Add new song
    addButton.addEventListener('click', function (event) {
        event.preventDefault();

        const isConfirmed = confirmDelete('Are you sure you want to add this song?');
        if (isConfirmed) {
            addNewSong();
        }
    });

    // Delete Button: Delete existing song
    document.querySelectorAll('.delete-btn').forEach(btn => btn.addEventListener('click', function (event) {
        event.preventDefault();
        const songId = this.getAttribute('data-id');
        const isConfirmed = confirmDelete('Are you sure you want to delete song with ID: ' + songId + '?');

        if (isConfirmed) {
            deleteSong(songId);
        }
    }));

    // Cancel Button: Reset form
    document.getElementById('cancel-btn').addEventListener('click', function (event) {
        event.preventDefault();
        resetForm();
    });





    /*
        * Functions
        - updateSong: Update an existing song
        - addNewSong: Add a new song
        - deleteSong: Delete an existing song
    */

    function updateSong() {
        const songData = collectFormData();
        fetch(`/admin/music/update`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(songData)
        })
        .then(response => response.text())
        .then(result => {
            if (result === 'success') {
                alert('Song updated successfully!');
                resetForm();
            } else {
                alert('Failed to update song.');
            }
        })
        .catch(error => console.error('Error updating song:', error));
    }

    function addNewSong() {
        const songData = collectFormData();
        // Show the song data in the console
        console.log('Song data:', songData);
        fetch('/admin/music/add', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(songData)
        })
        .then(response => response.text())
        .then(result => {
            if (result === 'success') {
                alert('Song added successfully!');
                resetForm();
            } else {
                alert('Failed to add song.');
            }
        })
        .catch(error => console.error('Error adding song:', error));
    }

    function deleteSong(songId) {
        console.log('Deleting song with ID:', songId);

        fetch(`/admin/music/delete?songId=${songId}`, {
            method: 'POST'
        })
        .then(response => response.text())
        .then(result => {
            if (result === 'success') {
                alert('Song deleted successfully!');
            } else {
                alert('Failed to delete song.');
            }
        })
        .catch(error => console.error('Error deleting song:', error));
    }

    function collectFormData() {
        return {
            songId: document.getElementById('song-id').value.trim() || null,
            songName: document.getElementById('song-name').value.trim(),
            songDescription: document.getElementById('song-description').value.trim(),
            releaseDate: document.getElementById('song-date').value.trim(),
            posterImg: document.getElementById('song-poster').value.trim(),
            audioLink: document.getElementById('audio-input').value.trim().split('\\').pop(), // Extract just the file name
            singers: document.getElementById('song-singers').value.split(',').map(id => ({ singerId: id.trim() })),
            categories: Array.from(document.querySelectorAll('#categories-checkbox-group input[type="checkbox"]:checked')).map(checkbox => ({
                categoryId: checkbox.value
            }))
        };
    }
});

function resetForm() {
    const saveButton = document.getElementById('save-btn');
    const addButton = document.getElementById('add-btn');
    const form = document.getElementById('song-form');

    const audioPreview = document.getElementById('audio-preview');

    const posterPreview = document.getElementById('poster-preview');
    const imageStatus = document.getElementById('image-status');

    saveButton.disabled = true;
    addButton.disabled = false;

    form.reset();
    document.getElementById('selected-singers').innerHTML = ''; // Clear singer cards
    audioPreview.src = '';
    audioPreview.load(); // Clear the audio preview
    posterPreview.src = '';
    imageStatus.textContent = '';
    imageStatus.style.color = 'white';
}

// Function show dialog to confirm song deletion
function confirmDelete(dialogMessage) {
    const isConfirmed = confirm(dialogMessage);
    if (isConfirmed) {
        return true;
    }
    return false;
}
