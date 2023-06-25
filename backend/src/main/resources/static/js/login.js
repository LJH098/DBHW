const signupbtn = document.querySelector(".signupbtn");
const signinbtn = document.querySelector(".signinbtn");

signupbtn.addEventListener("click", () => {
  location.href = "/users/create";
});

signinbtn.addEventListener("click", (e) => {
goMain(e)
});
function goToMain() {
  window.location.href = '/main';
}
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
  })
      .then((response) => {
        if (response.ok) {
          return fetch('/checklogin'); // Adding this line to make a GET request to /checklogin if login was successful
        } else {
          throw new Error("Error: " + response.status);
        }
      })
      .then((response) => {
        if (response.ok) {
          // If checklogin is successful, redirect to main
          window.location.href = '/main';
        } else {
          // If checklogin fails, redirect back to login
          window.location.href = '/users/login';
        }
      })
      .catch((error) => {
        console.error('Error:', error);
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

