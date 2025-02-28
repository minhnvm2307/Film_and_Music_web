document.addEventListener('DOMContentLoaded', () => {
    initializeCardSelect();
    initializeTopSongSelect();
});

function initializeCardSelect() {
    const cardSelect = document.querySelectorAll('.music-card');

    cardSelect.forEach(card => {
        card.addEventListener('click', () => {
            goToPlay(card);
        });
    });
}

function initializeTopSongSelect() {
    const topSongSelect = document.querySelectorAll('.playlist-item');

    topSongSelect.forEach(card => {
        card.addEventListener('click', () => {
            goToPlay(card);
        });
    });
}

function goToPlay(card) {
    const songId = card.getAttribute('data-song-id');
    localStorage.setItem('currentSongId', songId);
    const username = document.querySelector('.header-menu').getAttribute('data-username');
    window.location.href = `/music/music-cell?username=${username}&songId=${songId}`;
}