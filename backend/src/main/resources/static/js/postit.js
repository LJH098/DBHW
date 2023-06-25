const plusbtn = document.querySelector(".plusbtn");
plusbtn.addEventListener("click", showInput);
const hidden = document.querySelector(".hidden");
function showInput() {
  hidden.style.display = "block";
  plusbtn.style.display = "none";
}

const confirm = document.querySelector(".confirm");
confirm.addEventListener("click", completeWrite);
const postit = document.querySelector(".postit-3");
const opinion = document.querySelector(".opinion");
const nickname = document.querySelector(".nickname");
const content = document.querySelector(".inputContent");

function completeWrite(e) {
  e.preventDefault();
  hidden.style.display = "none";
  plusbtn.style.display = "none";
  postit.style.display = "block";
  content.innerHTML = opinion.value;
}

const title = document.querySelector(".title");
title.innerHTML = localStorage.getItem("title");
