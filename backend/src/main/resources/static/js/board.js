let lastBoardId = null;
const limit = 8; // 한 번에 가져올 게시글 수
const boardsContainer = document.querySelector('#boardsContainer');

function getBoards() {
    fetch(`/api/boards?lastBoardId=${lastBoardId}&limit=${limit}`)
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
                let date = new Date(board.createdAt * 1000);  // 초 단위 UNIX 타임스탬프를 밀리초 단위로 변환
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

window.onscroll = function () {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
        getBoards();
    }
};

getBoards(); // 페이지가 로드될 때 첫 번째 요청
