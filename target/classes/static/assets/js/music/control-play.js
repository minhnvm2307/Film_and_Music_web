document.addEventListener('DOMContentLoaded', () => {
    const nextButton = document.getElementById('forward-button');
    const previousButton = document.getElementById('backward-button');

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
        const songId = songData.songId;
        const audioPlayer = document.getElementById('audio-player');
        const username = document.querySelector('.header-menu').getAttribute('data-username');
        window.location.href = `/music/music-cell?username=${username}&songId=${songId}`;

        localStorage.setItem('currentSongId', songData.songId);
    }

});