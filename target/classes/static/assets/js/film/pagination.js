document.addEventListener("DOMContentLoaded", () => {
    const posters = document.querySelectorAll(".main-poster");
    const prevBtn = document.getElementById("prev-btn");
    const nextBtn = document.getElementById("next-btn");
    const posterContainer = document.querySelector(".main-poster-container");
    const totalPosters = posters.length;
    let currentIndex = 0;

    // Function to update poster positions
    function updatePagination() {
        // Scroll the poster container
        const offset = currentIndex * 1000; // Calculate the offset in pixels
        posterContainer.scrollTo({
            left: offset,
            behavior: 'smooth',
            transition: 'transform 3s ease-in-out'
        });
    }

    // Event listener for the "Previous" button
    prevBtn.addEventListener("click", () => {
        if (currentIndex > 0) {
            currentIndex--;
        } else {
            currentIndex = totalPosters - 1; // Loop back to the last poster
        }
        updatePagination();
    });

    // Event listener for the "Next" button
    nextBtn.addEventListener("click", () => {
        if (currentIndex < totalPosters - 1) {
            currentIndex++;
        } else {
            currentIndex = 0; // Loop back to the first poster
        }
        updatePagination();
    });

    // Slide every 4 seconds
    setInterval(() => {
        if (currentIndex < totalPosters - 1) {
            currentIndex++;
        } else {
            currentIndex = 0; // Loop back to the first poster
        }
        updatePagination();
    }, 4000);

    // Initialize the slider
    updatePagination();
});
