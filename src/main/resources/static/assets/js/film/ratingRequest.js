/*
* Rating a film cell
* @param filmId: the id of the film
* @param userId: the id of the user
* @param rating: the rating of the film
*/
document.addEventListener('DOMContentLoaded', function () {
    ratingFilm();
    setRatedByUser();
});

function ratingFilm() {
    const userId = document.querySelector('.rating-box').getAttribute('data-user-id');
    const filmId = document.querySelector('.rating-box').getAttribute('data-film-id');
    const ratingButtons = document.querySelector('.rating-buttons');

    // Add an event listener to the container
    ratingButtons.addEventListener('change', (event) => {
      // Get the clicked input's value
      const selectedRating = event.target.value;
  
        // Send a POST request to the server with 3 parameters
        let url = '/user/film/film-cell/rating';
        url += '?filmId=' + filmId;
        url += '&userId=' + userId;
        url += '&rateNumber=' + selectedRating;

        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
        }).then(response => response.json())
        .then(data => {
            if (data) {
                alert('Add rating successful!');
            } else {
                alert('Add rating failed, please try again :(');
            }
        })
        .then(() => {
            location.reload();
        })
        .catch(error => console.error('Error:', error));
    });
}

function setRatedByUser() {
    const userId = document.querySelector('.rating-box').getAttribute('data-user-id');
    const filmId = document.querySelector('.rating-box').getAttribute('data-film-id');
    const ratingButtons = document.querySelector('.rating-buttons');
    const url = '/user/film/film-cell/rated?filmId=' + filmId + '&userId=' + userId;

    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    }).then(response => response.json())
    .then(data => {
        if (data) {
            const rating = data;
            const ratingButton = document.querySelector('.rating-buttons input[value="' + rating + '"]');
            if (ratingButton) {
                ratingButton.checked = true;
            }
        }
    })
    .catch(error => console.error('Error:', error));
}