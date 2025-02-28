// Select necessary elements
const createPlaylistButton = document.getElementById('create-section-button');
const playlistFormContainer = document.querySelector('.playlist-form-container-hidden');
const closePlaylistButton = document.getElementById('close-playlist-form');

const visitPlaylistButton = document.getElementById('your-collection');
const addToPlaylistFormContainer = document.querySelector('.add-to-playlist-container-hidden');
const closeAddToPlaylistButton = document.getElementById('close-add-to-playlist');


// Show the playlist form when clicking "Create playlist" (display = block)
createPlaylistButton.addEventListener('click', () => {
    playlistFormContainer.style.display = 'block';
});

// Show the add to playlist form when clicking "Add to playlist" (display = block)
visitPlaylistButton.addEventListener('click', () => {
    addToPlaylistFormContainer.style.display = 'block';
});

// Hide the add to playlist form when clicking the close button
closeAddToPlaylistButton.addEventListener('click', () => {
    addToPlaylistFormContainer.style.display = 'none';
});

// Hide the create playlist form when clicking the close button
closePlaylistButton.addEventListener('click', () => {
    playlistFormContainer.style.display = 'none';
});


