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

document.addEventListener('DOMContentLoaded', () => {
    const currentLocation = location.href;
    const side_link = document.querySelectorAll('.sidebar a');

    // Loop through all side_link
    side_link.forEach(link => {
        if (link.href === currentLocation) {
            // Add 'active' class to the clicked link
            link.classList.add('active');
        } else {
            // Remove 'active' class from all side_link
            link.classList.remove('active');
        }
    });

    const top_link = document.querySelectorAll('.top-menu a');

    // Loop through all top_link
    top_link.forEach(link => {
        if (link.href === currentLocation) {
            // Add 'active' class to the clicked link
            link.classList.add('active');
        } else {
            // Remove 'active' class from all top_link
            link.classList.remove('active');
        }
    });

});




