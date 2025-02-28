document.addEventListener('DOMContentLoaded', () => {
    const playlistPoster = document.querySelectorAll('.playlist-wrapper');

    playlistPoster.forEach((poster) => {
        const playlistId = poster.getAttribute('data-playlist-id');
        const numberOfSongs = poster.querySelector('.playlist-count');

        const image1 = poster.querySelector('.img1');
        const image2 = poster.querySelector('.img2');
        const image3 = poster.querySelector('.img3');
        const image4 = poster.querySelector('.img4');

        fetch(`/music/collection/get-4-poster?playlistId=${playlistId}`, {
            method: 'GET',
            headers: {
            'Content-Type': 'application/json',
            },
        })
            .then((response) => response.json())
            .then((data) => {
                let i = 0;
                data.forEach((poster) => {
                    if (i === 0) {
                        if (numberOfSongs) {
                            numberOfSongs.textContent = poster + ' songs';
                        }
                    }else if (i === 1) {
                        image1.src = poster;
                    } else if (i === 2) {
                        image2.src = poster;
                    } else if (i === 3) {
                        image3.src = poster;
                    } else if (i === 4) {
                        image4.src = poster;
                    }
                    i++;
                });
            })
            .catch((error) => {
                console.error('Error:', error);
            });

    });
});
