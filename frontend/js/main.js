const mainNav = document.getElementById("mainNav");
const currentPage =
    window.location.pathname.split("/").pop() || "index.html";

const savedUser = JSON.parse(
    localStorage.getItem("programonUser")
);


// SEGÉDFÜGGVÉNY AZ AKTÍV MENÜPONTHOZ

function createNavItem(page, label) {
    if (currentPage === page) {
        return `<span class="nav-active">${label}</span>`;
    }

    return `<a href="${page}">${label}</a>`;
}


// NAVIGÁCIÓ

if (mainNav) {

    // PROGRAMKERESŐ
    if (
        savedUser &&
        savedUser.loggedIn &&
        savedUser.role === "PROGRAMKERESO"
    ) {

        mainNav.innerHTML = `

            ${createNavItem("index.html", "Programok")}

            ${createNavItem(
                "jelentkezeseim.html",
                "Jelentkezéseim"
            )}

            ${createNavItem(
                "kedvenceim.html",
                "Kedvenceim"
            )}

            ${createNavItem(
                "ertesitesek.html",
                "Értesítések"
            )}

            <div class="user-menu">

                <button class="user-menu-button
                    ${currentPage === "profilom.html"
                        ? "nav-active"
                        : ""}">
                    ${savedUser.name} ▼
                </button>

                <div class="user-dropdown">

                    ${currentPage === "profilom.html"
                        ? '<span class="dropdown-active">Profilom</span>'
                        : '<a href="profilom.html">Profilom</a>'}

                    <a href="#" class="logout-link">
                        Kijelentkezés
                    </a>

                </div>
            </div>
        `;
    }


    // PROGRAMSZERVEZŐ
    else if (
        savedUser &&
        savedUser.loggedIn &&
        savedUser.role === "PROGRAMSZERVEZO"
    ) {

        mainNav.innerHTML = `

            ${createNavItem("index.html", "Programok")}

            ${createNavItem(
                "sajat_programok.html",
                "Saját programok"
            )}

            ${createNavItem(
                "ertesitesek.html",
                "Értesítések"
            )}

            <div class="user-menu">

                <button class="user-menu-button
                    ${
                        currentPage === "profilom.html" ||
                        currentPage === "ertekeleseim.html"
                            ? "nav-active"
                            : ""
                    }">
                    ${savedUser.name} ▼
                </button>

                <div class="user-dropdown">

                    ${currentPage === "profilom.html"
                        ? '<span class="dropdown-active">Profilom</span>'
                        : '<a href="profilom.html">Profilom</a>'}

                    ${currentPage === "ertekeleseim.html"
                        ? '<span class="dropdown-active">Értékeléseim</span>'
                        : '<a href="ertekeleseim.html">Értékeléseim</a>'}

                    <a href="#" class="logout-link">
                        Kijelentkezés
                    </a>

                </div>
            </div>
        `;
    }


    // VENDÉG
    else {

        mainNav.innerHTML = `

            ${createNavItem(
                "index.html",
                "Programok"
            )}

            ${createNavItem(
                "bejelentkezes.html",
                "Bejelentkezés"
            )}

            ${createNavItem(
                "regisztracio.html",
                "Regisztráció"
            )}
        `;
    }
}


// KIJELENTKEZÉS

const logoutLinks =
    document.querySelectorAll(".logout-link");

logoutLinks.forEach(function (logoutLink) {

    logoutLink.addEventListener(
        "click",
        function (event) {

            event.preventDefault();

            localStorage.removeItem("programonUser");

            window.location.href = "index.html";
        }
    );
});


// IDEIGLENES TESZT-BEJELENTKEZÉS
// Ezt később a backend valódi bejelentkezése váltja fel.

const testLoginButton =
    document.getElementById("testLoginButton");

if (testLoginButton) {

    testLoginButton.addEventListener(
        "click",
        function () {

            const user = {
                loggedIn: true,
                role: "PROGRAMKERESO",
                name: "Felhasználónév"
            };

            localStorage.setItem(
                "programonUser",
                JSON.stringify(user)
            );

            window.location.href = "index.html";
        }
    );
}

const testOrganizerLoginButton =
    document.getElementById("testOrganizerLoginButton");

if (testOrganizerLoginButton) {

    testOrganizerLoginButton.addEventListener(
        "click",
        function () {

            const user = {
                loggedIn: true,
                role: "PROGRAMSZERVEZO",
                name: "Felhasználónév"
            };

            localStorage.setItem(
                "programonUser",
                JSON.stringify(user)
            );

            window.location.href = "index.html";
        }
    );
}

// PROGRAM RÉSZLETEI - SZEREPKÖR SZERINTI MŰVELETEK

const programActions = document.getElementById("programActions");

if (programActions) {

    // VENDÉG
    if (!savedUser || !savedUser.loggedIn) {

        programActions.innerHTML = `
            <a href="bejelentkezes.html" class="action-link">
                Jelentkezés
            </a>

            <a href="bejelentkezes.html" class="action-link">
                Kedvencekhez adás
            </a>
        `;
    }

    // PROGRAMKERESŐ
    else if (savedUser.role === "PROGRAMKERESO") {

        programActions.innerHTML = `
            <button type="button" class="action-link">
                Jelentkezés
            </button>

            <button type="button" class="action-link">
                Kedvencekhez adás
            </button>
        `;
    }

    // PROGRAMSZERVEZŐ
    else if (savedUser.role === "PROGRAMSZERVEZO") {

        programActions.innerHTML = `
            <a href="program_szerkesztese.html" class="action-link">
                Szerkesztés
            </a>

            <a href="program_jelentkezoi.html" class="action-link">
                Jelentkezők
            </a>
        `;
    }
}

// PROGRAM RÉSZLETEI - VISSZA LINK

const programBackLink = document.getElementById("programBackLink");

if (programBackLink) {

    if (
        savedUser &&
        savedUser.loggedIn &&
        savedUser.role === "PROGRAMSZERVEZO"
    ) {
        programBackLink.innerHTML = `
            <a href="sajat_programok.html" class="back-link">
                ← Vissza a saját programokhoz
            </a>
        `;
    } else {
        programBackLink.innerHTML = `
            <a href="index.html" class="back-link">
                ← Vissza a programokhoz
            </a>
        `;
    }
}

// ===== KÖZÖS LÁBLÉC =====

const mainFooter = document.getElementById("mainFooter");

if (mainFooter) {
    mainFooter.innerHTML = `
        <footer class="main-footer">

            <div class="footer-brand">
                ProgramON
            </div>

            <nav class="footer-nav">
                <button type="button" data-modal="privacyModal">
                    Adatkezelési tájékoztató
                </button>

                <button type="button" data-modal="termsModal">
                    Felhasználási feltételek
                </button>

                <button type="button" data-modal="contactModal">
                    Kapcsolat
                </button>
            </nav>

            <p class="footer-copyright">
                © 2026 ProgramON
            </p>

        </footer>

        <div class="modal-overlay" id="footerModal">

            <div class="modal-box">

                <button type="button"
                        class="modal-close"
                        id="modalClose"
                        aria-label="Bezárás">
                    ×
                </button>

                <h2 id="modalTitle"></h2>

                <div id="modalContent"></div>

            </div>

        </div>
    `;
}

// ===== LÁBLÉC MODAL =====

const footerModal = document.getElementById("footerModal");
const modalTitle = document.getElementById("modalTitle");
const modalContent = document.getElementById("modalContent");
const modalClose = document.getElementById("modalClose");

const footerModalButtons = document.querySelectorAll(
    "[data-modal]"
);

const footerModalData = {
    privacyModal: {
        title: "Adatkezelési tájékoztató",
        content: `
            <p>
                Az adatkezelési tájékoztató tartalma később
                kerül véglegesítésre.
            </p>
        `
    },

    termsModal: {
        title: "Felhasználási feltételek",
        content: `
            <p>
                A felhasználási feltételek tartalma később
                kerül véglegesítésre.
            </p>
        `
    },

    contactModal: {
        title: "Kapcsolat",
        content: `
            <p>
                A ProgramON kapcsolatfelvételi adatai
                később kerülnek véglegesítésre.
            </p>
        `
    }
};

footerModalButtons.forEach(function (button) {
    button.addEventListener("click", function () {

        const modalType = button.dataset.modal;
        const data = footerModalData[modalType];

        if (!footerModal || !data) {
            return;
        }

        modalTitle.textContent = data.title;
        modalContent.innerHTML = data.content;

        footerModal.classList.add("is-open");
    });
});

function closeFooterModal() {
    if (footerModal) {
        footerModal.classList.remove("is-open");
    }
}

if (modalClose) {
    modalClose.addEventListener("click", closeFooterModal);
}

if (footerModal) {
    footerModal.addEventListener("click", function (event) {

        if (event.target === footerModal) {
            closeFooterModal();
        }
    });
}

document.addEventListener("keydown", function (event) {

    if (event.key === "Escape") {
        closeFooterModal();
    }
});