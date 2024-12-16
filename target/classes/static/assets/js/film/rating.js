document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.main-poster').forEach(poster => {
        const rating = parseFloat(poster.dataset.rating) || 0;

        modifyRating(poster, rating);
    });
});

function modifyRating(poster, rating) {
    // Lấy tất cả các ngôi sao trong poster hiện tại
    const starIcons = poster.querySelectorAll('.poster-rating .fa-star');

    // Chuyen icon fas fa-star thành fa-regular fa-star nếu index > rating
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


document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.film-overlay').forEach(card => {
        const rating = parseFloat(card.dataset.rating) || 0;

        modifyRating(card, rating);
    });
});

function modifyRating(card, rating) {
    // Lấy tất cả các ngôi sao trong poster hiện tại
    const starIcons = card.querySelectorAll('.film-rating .fa-star');

    // Chuyen icon fas fa-star thành fa-regular fa-star nếu index > rating
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