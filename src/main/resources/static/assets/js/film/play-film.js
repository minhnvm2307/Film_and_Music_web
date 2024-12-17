function playTrailer(card) {
    // Get the video element within the clicked card
    const video = card.querySelector('.film-video:first-of-type');

    // Check if the video element is found
    if (!checkNullFilm(card, video)) {
        return;
    }

    // If the video is already playing, pause it and hide the video
    if (video.style.display === 'block') {
        video.pause();
        video.currentTime = 0;
        video.style.display = 'none';
    } else {
        // Pause any other playing videos
        document.querySelectorAll('.film-video').forEach(v => {
            if (!v.paused) {
                v.pause();
                v.currentTime = 0;
                v.style.display = 'none';
            }
            const parent = v.parentElement;
            // remove the message
            if (parent.querySelector('h3') !== null) {
                parent.querySelector('h3').remove();
            }
            });
        }

        // Play the selected video
        video.style.display = 'block';
        video.play();
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


document.addEventListener('DOMContentLoaded', () => {
    initializeCardSelect();
    initializePlayButton();
});

function initializeCardSelect() {
    const cardSelect = document.querySelectorAll('.film-card');

    cardSelect.forEach(card => {
        card.addEventListener('click', () => {
            goToPlay(card);
        });
    });
}

function goToPlay(card) {
    const filmId = card.getAttribute('data-film-id');
    const username = document.querySelector('.header-menu').getAttribute('data-username');
    window.location.href = `/film/film-cell?username=${encodeURIComponent(username)}&film_id=${encodeURIComponent(filmId)}`;
}

function initializePlayButton() {
    const playButton = document.querySelector('.slider');
    const videoContainer = document.querySelector('.video-container');
    const video = document.querySelector('.film-video');

    if (video === null || video.link === '') {
        // Add an message if the video element is not found
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
        video.play();
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