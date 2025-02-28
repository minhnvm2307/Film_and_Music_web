document.addEventListener('DOMContentLoaded', () => {
    initializePlayButton();
});

function initializePlayButton() {
    const playButton = document.querySelector('.slider');
    const videoContainer = document.querySelector('.video-container');
    const video = document.querySelector('.film-video');

    if (video === null || video.link === '' || video.link === null) {
        // Add an message if the video element is not found
        console.log('Video element not found');
        videoContainer.innerHTML = '<h3>Video not found</h3>';
        console.error('Video element not found');
        return;
    }

    playButton.addEventListener('click', () => {
        playFilm();
    });
}

function playFilm() {
    const videoContainer = document.querySelector('.video-container');
    const video = document.querySelector('.film-video');

    if (video.style.display === 'block') {
        video.pause();
        video.currentTime = 0;
        video.style.display = 'none';
        videoContainer.style.display = 'none';
    } else {
        video.style.display = 'block';
        videoContainer.style.display = 'block';
        try {
            video.play();
        } catch (error) {
            console.error('Failed to play the video', error);
        }
    }
}

function toggleDescription(button) {
    const parent = document.querySelector('.film-cell-description');

    if (parent.classList.contains('expanded')) {
        // Collapse the description
        parent.classList.remove('expanded');
        button.textContent = 'Read more';
    } else {
        // Expand the description
        parent.classList.add('expanded');
        button.textContent = 'Show less';
    }
}

function checkNullFilm(card, video) {
    // get the video source
    const videoSource = video.getAttribute('src');

    if (videoSource === null || videoSource === '') {
        // Show an <h3> element with the message if the video element is not found
        const message = document.createElement('h3');
        message.textContent = 'Video not found';

        if (card.querySelector('h3') === null) {
            // get parent element and append the message
            video.parentElement.appendChild(message);
        }
        console.error('Video element not found in the provided card element');
        return false;
    }

    return true;
}