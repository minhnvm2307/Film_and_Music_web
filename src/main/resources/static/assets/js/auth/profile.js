// The <p> contains the name of current User
let firstname = document.getElementById('first-name');
let lastname = document.getElementById('last-name');

const fullnameElement = document.querySelector(".info h2");

document.addEventListener('DOMContentLoaded', () => {
    if (fullnameElement) {
        const names = fullnameElement.textContent.split(' '); // Split fullname into an array of words
        firstname.textContent = names.pop() || ''; // Get the last word as firstname
        lastname.textContent = names.join(' ') || ''; // Join remaining words for lastname
    }
});

/*
* Edit the information of USER
*/
function editHeader() {
    const headerEdit_btn = document.querySelector("edit_btn");
}