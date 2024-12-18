document.addEventListener('DOMContentLoaded', function () {
    const categorySelect = document.getElementById('category');
    const filterButton = document.getElementById('filterButton');
    const resetButton = document.getElementById('resetButton');
    const sortSelect = document.getElementById('sortingType');
    const sortButton = document.getElementById('sortButton');
    const ALL_CATEGORY = '';

    // Initialize category filter to "All" and hide reset button
    if (categorySelect) categorySelect.value = ALL_CATEGORY;
    if (resetButton) resetButton.style.display = 'none';

    // Handle Filter button click
    filterButton.addEventListener('click', async function () {
        const categoryText = categorySelect.options[categorySelect.selectedIndex]?.text || '';
        const categoryId = categorySelect.value;

        // Update header title
        updateTitleSection(categoryText, false);

        // Show reset button if category is selected
        if (categoryId !== '') resetButton.style.display = 'block';

        // Build URL for API call
        let url = '/user/film/filter';
        if (categoryId) url += `?categoryId=${categoryId}`;

        try {
            const response = await fetch(url);
            if (response.ok) {
                const films = await response.json();
                console.log('Films by category:', categoryId, films);
                updateFilmCards(films);
            } else {
                console.error('Error fetching films:', response.status);
            }
        } catch (error) {
            console.error('Error:', error);
        }
    });

    // Handle Reset button click
    resetButton.addEventListener('click', function () {
        updateTitleSection('', false);
        categorySelect.value = ALL_CATEGORY;
        filterButton.click();
        resetButton.style.display = 'none';
    });

    // Handle Sort by Rating button click
    sortButton.addEventListener('click', function () {
        if (sortSelect.value === 'rating') sortFilmByRating();
        else if (sortSelect.value === 'oldest') sortFilmByDateAsc();
        else if (sortSelect.value === 'newest') sortFilmByDateDesc();
        else sortFilmByDefault();
    });

    // Update Film Cards Display
    function updateFilmCards(films) {
        const filmIds = films.map(film => film.film_id); // API provides film IDs
        const cards = document.querySelectorAll('.film-card');

        cards.forEach(card => {
            const filmId = parseInt(card.getAttribute('data-film-id'));
            card.style.display = filmIds.includes(filmId) ? 'block' : 'none';
        });
    }

    // Update Header Title
    function updateTitleSection(content, isSearch) {
        const titleSection = document.getElementById('title-section');
        if (isSearch) {
            titleSection.textContent = content
                ? `Search results for "${content}"`
                : 'Recommended Films';
        } else {
            titleSection.textContent = content 
                ? `Search results for "${content}"`
                : 'Recommended Films';
        }
    }

    function sortFilmByRating() {
        const cards = document.querySelectorAll('.film-card');
        const sortedCards = Array.from(cards).sort((a, b) => {
            const ratingA = a.querySelector('.rated-detail').textContent;
            const ratingB = b.querySelector('.rated-detail').textContent;
            return ratingB.localeCompare(ratingA);
        });

        const filmContainer = document.getElementById('film-container');
        if (filmContainer) {
            sortedCards.forEach(card => filmContainer.appendChild(card));
        } else {
            console.error('Film container element not found');
        }
    }

    function sortFilmByDateAsc() {
        const cards = document.querySelectorAll('.film-card');
        const sortedCards = Array.from(cards).sort((a, b) => {
            const dateA = a.querySelector('.film-year').textContent;
            const dateB = b.querySelector('.film-year').textContent;
            return dateA.localeCompare(dateB);
        });

        const filmContainer = document.getElementById('film-container');
        sortedCards.forEach(card => filmContainer.appendChild(card));
    }

    function sortFilmByDateDesc() {
        const cards = document.querySelectorAll('.film-card');
        const sortedCards = Array.from(cards).sort((a, b) => {
            const dateA = a.querySelector('.film-year').textContent;
            const dateB = b.querySelector('.film-year').textContent;
            return dateB.localeCompare(dateA);
        });

        const filmContainer = document.getElementById('film-container');
        sortedCards.forEach(card => filmContainer.appendChild(card));
    }

    function sortFilmByDefault() {
        const cards = document.querySelectorAll('.film-card');
        const sortedCards = Array.from(cards).sort((a, b) => {
            const idA = parseInt(a.getAttribute('data-film-id'), 10); 
            const idB = parseInt(b.getAttribute('data-film-id'), 10); 
            return idA - idB; 
        });

        const filmContainer = document.getElementById('film-container');
        sortedCards.forEach(card => filmContainer.appendChild(card));
    }
});
