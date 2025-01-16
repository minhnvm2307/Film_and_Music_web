document.addEventListener('DOMContentLoaded', () => {
    // Save audio player from music-cell page state to localStorage
    const audioPlayer = document.getElementById('audio-player');
    const audioSource = document.getElementById('audio-source');

    function saveAudioState() {    
        const audioState = {
            songName: document.getElementById('playing-song-name').textContent,
            singers: document.getElementById('playing-singers').textContent,
            posterSrc: document.getElementById('playing-poster').src,
            audioSrc: audioPlayer.src,
            currentTime: audioPlayer.currentTime,
            isPlaying: !audioPlayer.paused
        };
    
        // Save the state in localStorage
        localStorage.setItem('audioState', JSON.stringify(audioState));
    }
    
    // Save audio state whenever the user navigates away or closes the page
    window.addEventListener('beforeunload', saveAudioState);

    // Load the audio state from localStorage if the song is playing is exactly the same as the song in the music-cell page
    const savedState = JSON.parse(localStorage.getItem('audioState'));
    if (savedState && savedState.audioSrc === audioPlayer.src) {
        audioPlayer.currentTime = savedState.currentTime;
        if (savedState.isPlaying) {
            audioPlayer.play();
        }
    }

});