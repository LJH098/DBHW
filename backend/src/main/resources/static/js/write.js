const cancelbtn = document.querySelector(".cancelbtn");
const confirmbtn = document.querySelector(".confirmbtn");


cancelbtn.addEventListener("click", () => {
    location.href = "/main";
});

confirmbtn.addEventListener("click", (ev) => {
    goMain(ev)
});
function goToMain1() {
    window.location.href = '/main';
}
function goMain1(ev) {
    ev.preventDefault();

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
