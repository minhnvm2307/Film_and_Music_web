/*
* This script is used to handle the comment section of the film page.
* It allows users to add comments and reply to comments.
* */
document.addEventListener('DOMContentLoaded', function () {
    const replyButtons = document.querySelectorAll('.reply-button');

    replyButtons.forEach(replyButton => {
        replyButton.addEventListener('click', function () {
            console.log('Reply button clicked');
            toggleReplyBox(replyButton);
        });
    });
    /*
    * This function toggles the display style of the reply box.
    *
    * If the reply box is hidden, it will be displayed.
    * If the reply box is displayed, it will be hidden.
    * 
    * @param {Element} replyButton - The reply button that was clicked
    * @param {Element} filledGrid - Since the the comment container is a grid, the filled    
    * grid is used to fill the blank space
    * */
    function toggleReplyBox(replyButton) {
        // Find the nearest .text-box within the same comment card
        const commentCard = replyButton.closest('.comments');
        const replyBox = commentCard.querySelector('.reply-box');
        const fillGrid = commentCard.querySelector('#filled-to-grid');

        // Toggle the display style of the reply box
        if (replyBox.style.display === 'block') {
            replyBox.style.display = 'none';
            fillGrid.style.display = 'none';
        } else {
            replyBox.style.display = 'block';
            fillGrid.style.display = 'block';
        }
    }

    /*
    * This function sends the comment to the server.
    * */
    const sendButton = document.getElementById('send-comment');
    const sendReplyButton = document.querySelectorAll('.send-reply-comment');

    sendButton.addEventListener('click', function () {
        console.log('Send button clicked');
        sendComment();
    });

    sendReplyButton.forEach(replyButton => {
        replyButton.addEventListener('click', function () {
            console.log('Send reply button clicked');
            sendReplyComment(replyButton);
        });
    });

    /*
    * This function sends the comment to the server.
    * 
    * @param {Element} commentHolder - The comment holder element
    * @param {Element} commentText - The comment text
    * @param {Element} userId - The user ID
    * @param {Element} filmId - The film ID
    * @Param {Element} type - The type of the comment
    * @param {Element} timeRated - The time the comment was made
    * @param {Element} parentCommentId - The parent comment ID
    * 
    * @param {Element} commentData: (CommentRequestDTO)
    *      - userId: The user ID
    *      - filmId: The film ID
    *      - commentText: The comment text
    *      - type: The type of the comment
    *      - timeRated: The time the comment was made
    * */
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
        timeRated: new Date().toISOString(),
        parentCommentId: null
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
        .then(() => {
            location.reload();
        })
        .catch(error => console.error('Error:', error));
    }


    /*
    * This function sends the reply comment to the server.
    *
    * @param {Element} replyButton - The reply button that was clicked
    * @param {Element} commentHolder - The comment holder element
    * @param {Element} commentText - The comment text
    * @param {Element} userId - The user ID
    * @param {Element} filmId - The film ID
    * @Param {Element} type - The type of the comment
    * @param {Element} timeRated - The time the comment was made
    * @param {Element} parentCommentId - The parent comment ID
    *   
    * @param {Element} commentData: (CommentRequestDTO)
    *       - userId: The user ID
    *       - filmId: The film ID
    *       - commentReplyText: The comment text
    *       - type: The type of the comment
    *       - timeRated: The time the comment was made
    *       - parentCommentId: The parent comment ID
    * */
   function sendReplyComment(replyButton) {
        const commentHolder = document.querySelector('.text-box');
        const replyHolder = replyButton.closest('.reply-box');
        const commentReplyText = replyHolder.querySelector('textarea').value.trim();
        const userId = commentHolder.getAttribute('data-user-id');
        const filmId = commentHolder.getAttribute('data-film-id');
        const parentCommentId = replyHolder.getAttribute('data-parentcomment-id');

        if (!commentReplyText) {
            alert('Please enter a reply.');
            return;
        }

        // Prepare the comment data
        const commentData = {
            userId: userId,
            filmId: filmId,
            commentText: commentReplyText,
            type: 'film',
            timeRated: new Date().toISOString(),
            parentCommentId: parentCommentId
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
            .then(() => {
                location.reload();
            })
            .catch(error => console.error('Error:', error));
    }

});
