let lastBoardId = "";
const limit = 10; // number of posts to fetch at one time
const boardsContainer = document.querySelector('#boardsContainer');

$(document).ready(function() {
    // login button click event
    $('#login').click(function() {
        window.location.href = '/users/login';
    });

    // Register button click event
    $('#signup').click(function() {
        window.location.href = '/users/create';
    });

    // logout button click event
    $('#logout').click(function() {
        fetch('/users/logout', {
            method: 'POST'
        }).then((response) => {
            if (response.ok) {
                // if successfully logged out
                window.location.href = '/main';
            } else {
                alert('Logout failed');
            }
        });
    });

    // Check user login status
    fetch('/checklogin', {
        method: 'GET'
    }).then((response) => {
        if (response.ok) {
            // if session exists
            $('#login').text('logout').attr('id', 'logout');
        } else {
            $('#logout').text('login').attr('id', 'login');
        }
    });

    getBoards(); // first request when page loads
});

function getBoards() {
    fetch(`/api/main?lastBoardId=${lastBoardId}&limit=${limit}`)
        .then(response => response.json())
        .then(data => {
            data.content.forEach(board => {
                let boardItem = document.createElement('div');
                boardItem.className = 'boardItem';

                let title = document.createElement('div');
                title.className = 'title';
                title.textContent = board.title;
                boardItem.appendChild(title);

                let content = document.createElement('div');
                content.className = 'content';
                content.textContent = board.content;
                boardItem.appendChild(content);

                let createdAt = document.createElement('div');
                createdAt.className = 'createdAt';
                let date = new Date(board.createdAt * 1000); // convert a UNIX timestamp in seconds to milliseconds
                createdAt.textContent = date.toLocaleDateString();
                boardItem.appendChild(createdAt);

                boardsContainer.appendChild(boardItem);

                lastBoardId = board.boardId;
            });

            if (data.hasNext) {
                getBoards();
            }
        });
}

window.onscroll = function() {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
        getBoards();
    }
};
