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