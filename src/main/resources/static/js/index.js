const form = document.querySelector("form");

form.addEventListener("submit", (event) => {
  event.preventDefault();
  const username = document.querySelector("#username").value;
  const password = document.querySelector("#password").value;
  const confirm_password = document.querySelector("#confirm_password").value;

  if (password !== confirm_password) {
    alert("Пароли не совпадают!");
  } else if (username === "" || password === "") {
    alert("Заполните все поля!");
  } else {
    alert("Спасибо за регистрацию!");
    form.reset();
  }
});