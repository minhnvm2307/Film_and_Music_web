document.addEventListener('DOMContentLoaded', function () {
    const playingCard = document.getElementById('playing-card');
    const closeButton = document.getElementById('close-button');

    // Function to load the audio state from localStorage
    function loadAudioState() {
        const savedState = JSON.parse(localStorage.getItem('audioState'));
        if (savedState) {
            const { songName, singers, posterSrc, audioSrc, currentTime, isPlaying } = savedState;

            // The playing card is hidden by default, so we need to show it
            document.getElementById('playing-song-name').textContent = songName;
            document.getElementById('playing-singers').textContent = singers;
            document.getElementById('playing-poster').src = posterSrc;

            // Get the audio source from the bottom playing card
            const audioPlayer = document.getElementById('audio-player');
            const audioSource = document.getElementById('audio-source');

            audioSource.src = audioSrc;
            audioPlayer.load();
            audioPlayer.currentTime = currentTime;

            if (isPlaying) {
                audioPlayer.play();
                playingCard.classList.add('show');
            }
        }
    }

    // Save audio player from music-cell page state to localStorage
    function saveAudioState() {
        const audioPlayer = document.getElementById('audio-cell');
        const audioSource = audioPlayer.querySelector('source');

        const audioState = {
            songName: document.getElementById('playing-song-name').textContent,
            singers: document.getElementById('playing-singers').textContent,
            posterSrc: document.getElementById('playing-poster').src,
            audioSrc: audioSource.src,
            currentTime: audioPlayer.currentTime,
            isPlaying: !audioPlayer.paused
        };

        localStorage.setItem('audioState', JSON.stringify(audioState));
    }

    // Save audio state whenever the user navigates away or closes the page
    window.addEventListener('beforeunload', function () {
        this.localStorage.setItem('tmpConsole', "beforeunload");
        saveAudioState();
    });
    
    // Load the audio state on page load
    loadAudioState();
    
    // Keep saving state as the audio progresses
    const audioPlayer = document.getElementById('audio-player');
    audioPlayer.addEventListener('timeupdate', saveAudioState());
});
