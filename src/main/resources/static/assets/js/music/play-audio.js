document.addEventListener('DOMContentLoaded', function () {
    const playingCard = document.getElementById('playing-card');
    const playPauseButton = document.getElementById('play-pause-button');
    const closeButton = document.getElementById('close-button');

    // Show the playing card when the play button is clicked
    document.querySelectorAll('.play-btn').forEach(button => {
        button.addEventListener('click', function () {
            console.log('clicked');

            const songName = this.getAttribute('data-song-name');
            const singers = this.getAttribute('data-singers');
            const posterSrc = this.getAttribute('data-song-poster');

            document.getElementById('playing-song-name').textContent = songName;
            document.getElementById('playing-singers').textContent = singers;
            document.getElementById('playing-poster').src = posterSrc;

            playAudio.call(this);            

            playingCard.classList.add('show');
        });
    });

    function playAudio() {
        const audioSrc = this.getAttribute('data-audio-src');
        const audioPlayer = document.getElementById('audio-player');
        const audioSource = document.getElementById('audio-source');

        audioSource.src = audioSrc;
        audioPlayer.load();
        audioPlayer.play();
    }

    function pauseAudio() {
        const audioPlayer = document.getElementById('audio-player');
        audioPlayer.pause();
    }

    // Close the playing card
    closeButton.addEventListener('click', function () {
        playingCard.classList.remove('show');
        pauseAudio();
    });
});
