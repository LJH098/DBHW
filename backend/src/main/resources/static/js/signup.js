const inputId = document.querySelector(".input-id");
const inputPw = document.querySelector(".input-pw");
const inputNick = document.querySelector(".inputnick");
const inputForm = document.querySelector(".input-form");
//공백검사
function inputIsEmpty(inputElement, invalideCheckElement) {
  if (inputElement.value == "") {
    document.preventDefault();
    inputElement.classList.add("input-alert");
    invalideCheckElement.classList.add("invalid-visible");
  } else if (inputElement.value !== "") {
    inputElement.classList.remove("input-alert");
    invalideCheckElement.classList.remove("invalid-visible");
  }
}

function inputIdAlert(event) {
  const idInvalidCheck = document.querySelector(".id-invalid-check");
  inputIsEmpty(inputId, idInvalidCheck, () => inputId.value === "");
}

function inputPwAlert(event) {
  const pwInvalidCheck = document.querySelector(".pw-invalid-check");
  inputIsEmpty(inputPw, pwInvalidCheck, () => inputPw.value === "");
}

function inputNickAlert(event) {
  const pwrInvalidCheck = document.querySelector(".pwr-invalid-check");
  inputIsEmpty(inputNick, pwrInvalidCheck, () => inputNick.value === "");
}

// inputForm.addEventListener("submit", inputIdAlert);
// inputForm.addEventListener("submit", inputPwAlert);
// inputForm.addEventListener("submit", inputNickAlert);

function goNewPage(newHref = "") {
  window.location.href = newHref;
}

inputForm.addEventListener("submit", goLogin);

function goLogin(e) {
  e.preventDefault();

  const id = document.querySelector(".input-id").value;
  const inputpwd = document.querySelector(".input-pw").value;
  const nickname = document.querySelector(".inputnick").value;
  const memberDto = {
    identification: `${id}`,
    pwd: `${inputpwd}`,
    nickname: `${nickname}`,
  };

  fetch("/users/create", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(memberDto),
  }).then((response) => {
    if (response.ok) {
      // 서버 응답이 200인 경우
      window.alert("회원가입 성공");
      location.href = "/users/login";
    } else {
      // 서버 응답이 200이 아닌 경우
      throw new Error("Error: " + response.status);
    }
  });
}
