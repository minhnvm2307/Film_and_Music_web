document.addEventListener("DOMContentLoaded", () => {
    const posterContainer = document.querySelector(".main-poster-container");
    const posters = document.querySelectorAll(".main-poster");
    const prevBtn = document.getElementById("prev-btn");
    const nextBtn = document.getElementById("next-btn");
    let currentIndex = 0;

    // Function to update the position of the container
    function updatePosition() {
        const posterWidth = posters[0].offsetWidth;
        const offset = posterWidth * currentIndex;
        posterContainer.scrollTo({
            left: offset,
            behavior: 'smooth',
        });
    }

    // Event listener for the "Previous" button
    prevBtn.addEventListener("click", () => {
        currentIndex = (currentIndex - 1 + posters.length) % posters.length;
        updatePosition();
    });

    // Event listener for the "Next" button
    nextBtn.addEventListener("click", () => {
        currentIndex = (currentIndex + 1) % posters.length;
        updatePosition();
    });

    // Auto-slide every 4 seconds
    setInterval(() => {
        currentIndex = (currentIndex + 1) % posters.length;
        updatePosition();
    }, 4000);

    // Initialize the position
    updatePosition();
});
