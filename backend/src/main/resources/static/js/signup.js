const inputId = document.querySelector(".input-id");
const inputPw = document.querySelector(".input-pw");
const inputNick = document.querySelector(".nickname");
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

inputForm.addEventListener("submit",goLogin);

function goLogin(e) {
    e.preventDefault();

    const identification = document.querySelector(".input-id").value;
    const pwd = document.querySelector(".input-pw").value;
    const nickname = document.querySelector(".nickname").value;

    const payload = `{"identification":"${identification}","pwd":"${pwd}","nickname":"${nickname}"}`;

    fetch("/users/create", {
        method: 'POST',
        headers: {
            'Content-Type': 'text/plain;charset=UTF-8'
        },
        body: payload
    })
        .then(res => res.json())
        .then(result => {
            console.log(result);
        });
}

// function goLogin(e){
//     e.preventDefault();
//     // const data={
//     //   identification:'ddori',
//     //   pwd:'0299',
//     //   nickname:'nicknick'
//     // }
//
//     const formData = new FormData();
//     formData.append('identification', document.querySelector(".input-id").value);
//     formData.append('pwd', document.querySelector(".input-pw").value);
//     formData.append('nickname', document.querySelector(".nickname").value)
//
//     // const id= document.querySelector(".input-id").value;
//     // const inputpwd= document.querySelector(".input-pw").value;
//     // const nickname= document.querySelector(".nickname").value;
//     // const memberDto = {
//     //   identification: id,
//     //   pwd: inputpwd,
//     //   nickname: nickname
//     // };
//
//     // const formData = new FormData(memberDto);
//
//     // console.log(memberDto);
//
//     fetch("/users/create", {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'text/plain;charset=UTF-8'
//         },
//         body: formData
//     })
//         .then(res => res.json())
//         .then((result)=>{
//             console.log(result);
//         })
//
// }