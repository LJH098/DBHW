const cancelbtn = document.querySelector(".cancelbtn");
const confirmbtn = document.querySelector(".confirmbtn");

cancelbtn.addEventListener("click", () => {
  location.href = "/main";
});

// 프론트 코드
confirmbtn.addEventListener("click", (e) => {
  e.preventDefault();
  showBoard(e);
  goMain1(e);
});
const boardTitle = document.querySelector(".board-title");
const boardContent = document.querySelector(".board-content");

// 화면상의 출력
function showBoard(e) {
  const title = document.querySelector(".title");
  const content = document.querySelector(".content");
  const clearfix = document.querySelector(".clearfix");
  const hidden = document.querySelector(".hidden");

  const inputTitle = document.querySelector(".input-title");
  const inputContent = document.querySelector(".input-content");
  hidden.classList.remove("hidden");
  title.classList.add("hidden");
  content.classList.add("hidden");
  clearfix.classList.add("hidden");
  boardTitle.innerHTML = inputTitle.value;
  boardContent.innerHTML = inputContent.value;
  localStorage.setItem("title", inputTitle.value);
}

// 백엔드 통신
function goMain1(e) {
  const title = document.querySelector(".input-title").value;
  const inputcontent = document.querySelector(".input-content").value;
  const boardCreateDto = {
    title: `${title}`,
    content: `${inputcontent}`,
  };

  fetch("/board/create", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(boardCreateDto),
  }).then((response) => {
    console.log(boardCreateDto);
    if (response.ok) {
      // 서버 응답이 200인 경우
      window.alert("글쓰기 성공");
      location.href = "/board/view";
      console.log(response.json());
    } else {
      // 서버 응답이 200이 아닌 경우
      throw new Error("Error: " + response.status);
    }
  });
}

const writebtn = document.querySelector(".board-writebtn");
writebtn.addEventListener("click", (e) => {
  e.preventDefault();
  location.href = "/postit";
});

//
// const inputId = document.querySelector(".input-title");
// const inputPw = document.querySelector(".input-content");
//
// function checkInputs1() {
//     const idValue = inputId.value.trim();
//     const pwValue = inputPw.value.trim();
//
//     if (idValue !== "" && pwValue !== "") {
//         signinbtn.disabled = false;
//     } else {
//         signinbtn.disabled = true;
//     }
// }
//
// inputId.addEventListener("input", checkInputs1);
// inputPw.addEventListener("input", checkInputs1);
//
