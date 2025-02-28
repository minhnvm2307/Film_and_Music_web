document.addEventListener('DOMContentLoaded', function () {
    const searchInput = document.getElementById('search-input');
    const searchButton = document.getElementById('menu-search-button');

    // Handle Search button click
    searchButton.addEventListener('click', function (event) {
        event.preventDefault();

        const searchQuery = searchInput.value.trim().toLowerCase();
        console.log('Search query:', searchQuery);

        // Update header title
        updateTitleSection(searchQuery, true);

        // Filter film cards based on search query
        const cards = document.querySelectorAll('.film-card');
        cards.forEach(card => {
            const filmTitle = card.querySelector('.film-title').textContent.toLowerCase();
            card.style.display = filmTitle.includes(searchQuery) ? 'block' : 'none';
        });
    });

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

});