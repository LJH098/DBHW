const signupbtn = document.querySelector(".signupbtn");
const signinbtn = document.querySelector(".signinbtn");

signupbtn.addEventListener("click", () => {
  location.href = "/users/create";
});

signinbtn.addEventListener("click", () => {
  window.alert("로그인 성공");
  goMain;
});

function goMain(e) {
  e.preventDefault();

  const id = document.querySelector(".input-id").value;
  const inputpwd = document.querySelector(".input-pw").value;
  const memberDto = {
    identification: `${id}`,
    pwd: `${inputpwd}`,
  };

  fetch("/users/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(memberDto),
  }).then((response) => {
    if (response.ok) {
      // 서버 응답이 200인 경우
      console.log(response);
    } else {
      // 서버 응답이 200이 아닌 경우
      throw new Error("Error: " + response.status);
    }
  });
}


const inputId = document.querySelector(".input-id");
const inputPw = document.querySelector(".input-pw");

function checkInputs() {
  const idValue = inputId.value.trim();
  const pwValue = inputPw.value.trim();

  if (idValue !== "" && pwValue !== "") {
    signinbtn.disabled = false;
  } else {
    signinbtn.disabled = true;
  }
}

inputId.addEventListener("input", checkInputs);
inputPw.addEventListener("input", checkInputs);

