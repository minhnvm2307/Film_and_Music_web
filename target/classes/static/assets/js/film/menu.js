const side_link = document.querySelectorAll('.sidebar a');

// Loop through all side_link
side_link.forEach(link => {
    link.addEventListener('click', () => {
        // Remove 'active' class from all side_link
        side_link.forEach(link => link.classList.remove('active'));

        // Add 'active' class to the clicked link
        link.classList.add('active');
    });
});

const top_link = document.querySelectorAll('.top-menu a');

// Loop through all top_link
top_link.forEach(link => {
    link.addEventListener('click', () => {
        // Remove 'active' class from all top_link
        top_link.forEach(topLink => topLink.classList.remove('active'));

        // Add 'active' class to the clicked link
        link.classList.add('active');
    });
});

// Binding the page with the menu buttons
const menuButtons = document.querySelectorAll('.top-menu a');

menuButtons.forEach(button => {
    button.addEventListener('click', (event) => {
        event.preventDefault();

        // Get the href attribute
        const href = button.getAttribute('href');

        // Check if href starts with '#' (indicating an in-page link)
        if (href.startsWith('#')) {
            const target = document.querySelector(href); // Find the target section
            if (target) {
                // Scroll to the target smoothly
                target.scrollIntoView({ behavior: 'smooth' });
            }
        } else {
            // Handle full URL or relative paths
            const currentPath = window.location.pathname;

            // Check if the href matches the current path
            if (href === currentPath || href.includes(currentPath)) {
                console.log("Navigating to:", href);

                // Make the clicked button active
                menuButtons.forEach(b => b.classList.remove('active'));
                button.classList.add('active');
            }

            // Optionally, navigate to the URL
            window.location.href = href;
        }
    });
});




