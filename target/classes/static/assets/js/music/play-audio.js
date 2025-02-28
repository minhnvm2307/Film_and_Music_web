document.addEventListener('DOMContentLoaded', function () {
    const playingCard = document.getElementById('playing-card');
    const closeButton = document.getElementById('close-button');
    const nextButton = document.getElementById('forward-button');
    const previousButton = document.getElementById('backward-button');
    const accessMusicCellButton = document.getElementById('expand-button');

    // Function to load the audio state from localStorage
    const savedState = JSON.parse(localStorage.getItem('audioState'));

    if (savedState) {
        playingCard.classList.add('show');
    }

    // Show the playing card when the play button is clicked
    document.querySelectorAll('.play-btn').forEach(button => {
        button.addEventListener('click', function () {
            console.log('clicked play button of music list');

            let currentSongId = this.getAttribute('data-song-id');
            const songName = this.getAttribute('data-song-name');
            const singers = this.getAttribute('data-singers');
            const posterSrc = this.getAttribute('data-song-poster');

            document.getElementById('playing-song-name').textContent = songName;
            document.getElementById('playing-singers').textContent = singers;
            document.getElementById('playing-poster').src = posterSrc;

            // Load the audio
            playAudio.call(this);

            // Change the CSS
            playingCard.classList.add('show');
            
            localStorage.setItem('currentSongId', currentSongId);
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

    // Play the next song
    nextButton.addEventListener('click', function () {
        const currentSongId = localStorage.getItem('currentSongId');
        fetch(`/user/music/next-play-song?songId=${currentSongId}`, {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' }
        }).then(response => response.json())
        .then(data => {
            if (data) {
                loadSongJson(data);                
            }
        })
        .catch(error => console.error('Error:', error))

    });

    // Play the previous song
    previousButton.addEventListener('click', function () {
        fetch(`/user/music/previous-play-song`, {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' }
        }).then(response => response.json())
        .then(data => {
            if (data) {
                loadSongJson(data);                
            }
        })
        .catch(error => console.error('Error:', error))
    });

    // Close the playing card
    closeButton.addEventListener('click', function () {
        playingCard.classList.remove('show');
        pauseAudio();
    });

    // Access the music cell page
    accessMusicCellButton.addEventListener('click', function () {
        const songId = localStorage.getItem('currentSongId');
        const username = document.querySelector('.header-menu').getAttribute('data-username');
        window.location.href = `/music/music-cell?username=${username}&songId=${songId}`;
    });

    // Play next song when the current song ends
    const audioPlayer = document.getElementById('audio-player');
    audioPlayer.addEventListener('ended', function () {
        const currentSongId = localStorage.getItem('currentSongId');
        fetch(`/user/music/next-play-song?songId=${currentSongId}`, {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' }
        }).then(response => response.json())
        .then(data => {
            if (data) {
                loadSongJson(data);                
            }
        })
        .catch(error => console.error('Error:', error))
    });

    // Play the playing card base on the data json received from the server
    function loadSongJson(songData) {
        const songName = songData.songName;
        const singers = songData.singers;
        const posterSrc = songData.posterImg;
        const audioSrc = '/assets/audio/' + songData.audioLink;

        const audioPlayer = document.getElementById('audio-player');
        const audioSource = document.getElementById('audio-source');
        let singerList = '';
        singers.forEach(singer => {
            singerList += singer.singerName + ', ';
        });
        document.getElementById('playing-song-name').textContent = songName;
        document.getElementById('playing-singers').textContent = singerList.slice(0, -2);
        document.getElementById('playing-poster').src = posterSrc;
        audioSource.src = audioSrc;
        audioPlayer.load();
        audioPlayer.play();

        localStorage.setItem('currentSongId', songData.songId);
    }
});