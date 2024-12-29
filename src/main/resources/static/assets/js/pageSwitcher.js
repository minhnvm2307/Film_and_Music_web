// Get the current user from top-menu
let curUser = document.querySelector('header').getAttribute('data-username');

// function to switch to film page
function switchToFilm() {
    window.location.href = "/film/film-page?username=" + curUser;
    console.log('Switched to film page');
}