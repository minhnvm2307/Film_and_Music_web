document.addEventListener('DOMContentLoaded', () => {
    const saveButton = document.getElementById('save-btn');
    const addButton = document.getElementById('add-btn');
    const cancelButton = document.getElementById('cancel-btn');

    // disable save button by default
    saveButton.disabled = true;
    addButton.disabled = false;
});

document.getElementById('singer-poster').addEventListener('input', updatePosterPreview);

// Update the poster preview when the poster input changes
function updatePosterPreview() {
    const posterInput = document.getElementById('singer-poster');
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

// Load singer details when Admin clicks on EDIT button a singer in the table
function loadSingerToForm(singerId) {
    const saveButton = document.getElementById('save-btn');
    const addButton = document.getElementById('add-btn');
    saveButton.disabled = false;
    addButton.disabled = true;

    let url = `/admin/singer/singer-detail?singerId=` + singerId;
    console.log('Fetching singer details from:', url);
    fetch(url)
        .then(response => response.json())
        .then(singer => {
            // Populate the form fields with the singer details
            document.getElementById('singer-id').value = singer.singerId;
            document.getElementById('singer-name').value = singer.singerName;
            document.getElementById('singer-description').value = singer.description;
            document.getElementById('singer-date').value = singer.dateOfBirth;
            document.getElementById('singer-poster').value = singer.avatarImg;

            // Update poster preview
            updatePosterPreview();
        })
        .catch(error => {
            console.error('Error fetching singer details:', error);
        });
}