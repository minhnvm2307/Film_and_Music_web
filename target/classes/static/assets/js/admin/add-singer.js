

document.addEventListener('DOMContentLoaded', function () {
    const saveButton = document.getElementById('save-btn');
    const addButton = document.getElementById('add-btn');

    // Save Button: Update existing song
    saveButton.addEventListener('click', function (event) {
        event.preventDefault();
        
        const isConfirmed = confirmDelete('Are you sure you want to update this singer?');
        if (isConfirmed) {
            updateSinger();
        }
    });

    // Add Button: Add new song
    addButton.addEventListener('click', function (event) {
        event.preventDefault();

        const isConfirmed = confirmDelete('Are you sure you want to add this singer?');
        if (isConfirmed) {
            addNewSinger();
        }
    });

    // Delete Button: Delete existing song
    document.querySelectorAll('.delete-btn').forEach(btn => btn.addEventListener('click', function (event) {
        event.preventDefault();
        const singerId = this.getAttribute('data-id');
        const isConfirmed = confirmDelete('Are you sure you want to delete song with ID: ' + singerId + '?');

        if (isConfirmed) {
            deleteSinger(singerId);
        }
    }));

    // Cancel Button: Reset form
    document.getElementById('cancel-btn').addEventListener('click', function (event) {
        event.preventDefault();
        resetForm();
    });





    /*
        * Functions
        - updateSinger: Update an existing Singer
        - addNewSinger: Add a new Singer
        - deleteSinger: Delete an existing Singer
    */

    function updateSinger() {
        const singerData = collectFormData();
        fetch(`/admin/singer/update`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(singerData)
        })
        .then(response => response.text())
        .then(result => {
            if (result === 'success') {
                alert('Singer updated successfully!');
                resetForm();

                // Fetch the updated fragment
                reloadTable();
            } else {
                alert('Failed to update singer.');
            }
        })
        .catch(error => console.error('Error updating singer:', error));
    }

    function addNewSinger() {
        const singerData = collectFormData();
        // Show the song data in the console
        console.log('Singer data:', singerData);
        fetch('/admin/singer/add', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(singerData)
        })
        .then(response => response.text())
        .then(result => {
            if (result === 'success') {
                alert('Singer added successfully!');
                resetForm();

                // Fetch the updated fragment
                reloadTable();
            } else {
                alert('Failed to add singer.');
            }
        })
        .catch(error => console.error('Error adding singer:', error));
    }

    function deleteSinger(singerId) {
        console.log('Deleting singer with ID:', singerId);

        fetch(`/admin/singer/delete?singerId=${singerId}`, {
            method: 'POST'
        })
        .then(response => response.text())
        .then(result => {
            if (result === 'success') {
                alert('Singer deleted successfully!');

                // Fetch the updated fragment
                reloadTable();
            } else {
                alert('Failed to delete singer.');
            }
        })
        .catch(error => console.error('Error deleting singer:', error));
    }

    function collectFormData() {
        return {
            singerId: document.getElementById('singer-id').value.trim() || null,
            singerName: document.getElementById('singer-name').value.trim(),
            description: document.getElementById('singer-description').value.trim(),
            dateOfBirth: document.getElementById('singer-date').value.trim(),
            country: document.getElementById('singer-country').value.trim(),
            avatarImg: document.getElementById('singer-poster').value.trim()
        };
    }
});

function resetForm() {
    const saveButton = document.getElementById('save-btn');
    const addButton = document.getElementById('add-btn');
    const form = document.getElementById('singer-form');

    const posterPreview = document.getElementById('poster-preview');
    const imageStatus = document.getElementById('image-status');

    saveButton.disabled = true;
    addButton.disabled = false;

    form.reset();
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

// Reload the singer table
function reloadTable() {
    fetch('/admin/music/singer-table-fragment') // Endpoint to fetch updated table
        .then(response => response.text())
        .then(html => {
            // Update the song table fragment
            document.querySelector('.table-container').innerHTML = html;
        })
        .catch(error => console.error('Error updating singer table:', error));
}
