document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.main-poster').forEach(poster => {
        const rating = parseFloat(poster.dataset.rating) || 0;

        modifyPosterRating(poster, rating);
    });
});

/*
* This method will modify the rating of a poster
* @param poster: the poster element
* @param rating: the rating of the poster
*/
function modifyPosterRating(poster, rating) {
    const starIcons = poster.querySelectorAll('.poster-content .poster-rating .fa-star');

    starIcons.forEach((icon, index) => {
        if (index < rating) {
            icon.classList.add('fas');
            icon.classList.remove('fa-regular');
        } else {
            icon.classList.add('fa-regular');
            icon.classList.remove('fas');
        }
    });
}

/*
* This method will modify the rating of a film small cell
* @param card: the film small cell element
* @param rating: the rating of the film
*/
document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.film-overlay').forEach(card => {
        const rating = parseFloat(card.dataset.rating) || 0;

        modifyRating(card, rating);
    });
});

function modifyRating(card, rating) {
    const starIcons = card.querySelectorAll('.film-rating .fa-star');

    starIcons.forEach((icon, index) => {
        if (index < rating) {
            icon.classList.add('fas');
            icon.classList.remove('fa-regular');
        } else {
            icon.classList.add('fa-regular');
            icon.classList.remove('fas');
        }
    });
}