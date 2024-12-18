document.addEventListener("DOMContentLoaded", () => {
    const themeCheckbox = document.getElementById("theme-checkbox");

    // Function to toggle themes
    function toggleTheme() {
        if (themeCheckbox.checked) {
            // Apply dark theme
            document.body.style.backgroundColor = "#1E1F23";
            document.body.style.color = "#fff";
            document.querySelector("header").style.backgroundColor = "#222";
        } else {
            // Apply light theme
            document.body.style.backgroundColor = "#f9f9f9";
            document.body.style.color = "#000";
            document.querySelector("header").style.backgroundColor = "#fff";
        }
    }

    // Event listener for theme switch
    themeCheckbox.addEventListener("change", toggleTheme);

    // Check saved theme on load (optional)
    const savedTheme = localStorage.getItem("theme") || "light";
    if (savedTheme === "dark") {
        themeCheckbox.checked = true;
        toggleTheme();
    } else {
        themeCheckbox.checked = false;
        toggleTheme();
    }

    // Save theme preference
    themeCheckbox.addEventListener("change", () => {
        const currentTheme = themeCheckbox.checked ? "dark" : "light";
        localStorage.setItem("theme", currentTheme);
    });
});
