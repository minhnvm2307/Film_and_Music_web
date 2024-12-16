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

        // Play the selected video
        video.style.display = 'block';
        video.play();
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