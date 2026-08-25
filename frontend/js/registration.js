const registrationForm = document.getElementById("registrationForm");
const registrationButton = document.querySelector(".registration-button");

const email = document.getElementById("email");
const emailError = document.getElementById("emailError");

const password = document.getElementById("password");
const passwordAgain = document.getElementById("passwordAgain");
const passwordError = document.getElementById("passwordError");
const passwordFormatError = document.getElementById("passwordFormatError");

const nameInput = document.getElementById("name");
const nameError = document.getElementById("nameError");

const role = document.getElementById("role");
const privacy = document.getElementById("privacy");

const username = document.getElementById("username");
const usernameError = document.getElementById("usernameError");

function checkForm() {

    const trimmedName = nameInput.value.trim();

    if (
        nameInput.value !== "" &&
        trimmedName.length < 2
    ) {
        nameInput.setCustomValidity(
        "A névnek legalább 2 karakterből kell állnia."
        );

        nameError.textContent =
        "A névnek legalább 2 karakterből kell állnia.";
    } else {
        nameInput.setCustomValidity("");
        nameError.textContent = "";
    }

    // Ellenőrizzük a felhasználónevet
    if (
        username.value !== "" &&
        username.value.length < 3
    ) {
        username.setCustomValidity(
        "A felhasználónévnek legalább 3 karakterből kell állnia."
        );

        usernameError.textContent =
        "A felhasználónévnek legalább 3 karakterből kell állnia.";

    } else if (
        username.value !== "" &&
        username.value.includes(" ")
        ) {
        username.setCustomValidity(
        "A felhasználónév nem tartalmazhat szóközt."
        );

        usernameError.textContent =
        "A felhasználónév nem tartalmazhat szóközt.";

    } else {
        username.setCustomValidity("");
        usernameError.textContent = "";
    }

    // Meghatározzuk az e-mail cím formátumát
    const emailPattern =
        /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/;

    // Ellenőrizzük az e-mail cím formátumát
    if (
        email.value !== "" &&
        !emailPattern.test(email.value)
    ) {
        email.setCustomValidity(
        "Kérlek, adj meg érvényes e-mail címet."
        );

        emailError.textContent =
        "Kérlek, adj meg érvényes e-mail címet.";
    } else {
        email.setCustomValidity("");
        emailError.textContent = "";
}

    // Meghatározzuk a jelszó követelményeit
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;

    // Ellenőrizzük a jelszó formátumát
    if (password.value !== "" && !passwordPattern.test(password.value)) {
        password.setCustomValidity(
            "A jelszó nem felel meg a követelményeknek."
        );

        passwordFormatError.textContent =
            "A jelszónak legalább 8 karakterből kell állnia, és tartalmaznia kell kisbetűt, nagybetűt és számot.";
    } else {
        password.setCustomValidity("");
        passwordFormatError.textContent = "";
    }

    // Ellenőrizzük, hogy a két jelszó megegyezik-e
    if (
        passwordAgain.value !== "" &&
        password.value !== passwordAgain.value
        ) {
        passwordAgain.setCustomValidity(
        "A két jelszó nem egyezik."
        );

        passwordError.textContent =
        "A két jelszó nem egyezik.";
    } else {
        passwordAgain.setCustomValidity("");
        passwordError.textContent = "";
    }

    // Ellenőrizzük az egész űrlapot
    const formIsValid = registrationForm.checkValidity();

    // Ha az űrlap érvényes, a gomb aktív lesz
    registrationButton.disabled = !formIsValid;
}

registrationForm.addEventListener("input", checkForm);
registrationForm.addEventListener("change", checkForm);

registrationForm.addEventListener("submit", function (event) {

    event.preventDefault();

    const registrationData = {
        name: nameInput.value.trim(),
        username: username.value,
        email: email.value.trim(),
        password: password.value,
        role: role.value,
        privacyAccepted: privacy.checked
    };

});