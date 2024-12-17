document.addEventListener('DOMContentLoaded', function () {
    const replyButtons = document.querySelectorAll('.reply-button');

    replyButtons.forEach(replyButton => {
        replyButton.addEventListener('click', function () {
            console.log('Reply button clicked');
            toggleReplyBox(replyButton);
        });
    });

    function toggleReplyBox(replyButton) {
        // Find the nearest .text-box within the same comment card
        const replyBox = replyButton.closest('.comments').querySelector('.reply-box');

        // Toggle the display style of the reply box
        if (replyBox.style.display === 'block') {
            replyBox.style.display = 'none';
        } else {
            replyBox.style.display = 'block';
        }
    }

    // Add event listener to the send button
    const sendButton = document.getElementById('send-comment');

sendButton.addEventListener('click', function () {
    console.log('Send button clicked');
    sendComment();
});

function sendComment() {
    const commentHolder = document.querySelector('.text-box');
    // Get the comment text and user info
    const commentText = document.querySelector('textarea').value.trim();
    const userId = commentHolder.getAttribute('data-user-id');
    const filmId = commentHolder.getAttribute('data-film-id');

    if (!commentText) {
        alert('Please enter a comment.');
        return;
    }

    // Prepare the comment data
    const commentData = {
        userId: userId,
        filmId: filmId,
        commentText: commentText,
        type: 'film',
        timeRated: new Date().toISOString()
    };

    // Send the comment via POST request
    fetch('/user/film/film-cell/comment', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(commentData),
    }).then(response => response.json())
        .then(data => {
            if (data) {
                alert('Add comment successful!');
            } else {
                alert('Add comment failed, please try again :(');
            }
        })
        .catch(error => console.error('Error:', error));
        }

});
