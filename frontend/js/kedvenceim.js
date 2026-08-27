const sampleFavorites = [

    {

        id: 1,

        title: "Kerámia workshop",

        description: "Készítsd el saját kerámia alkotásodat egy kreatív foglalkozáson.",

        category: "Kreatív",

        location: "Budapest",

        dateTime: "2026. szeptember 12. 14:00",

        organizer: "Kovács Anna",

        rating: 4.8,

        full: false

    },

    {

        id: 2,

        title: "Túra a Pilisben",

        description: "Egész napos túra a Pilis egyik szép útvonalán.",

        category: "Kirándulás",

        location: "Pilis",

        dateTime: "2026. szeptember 20. 09:00",

        organizer: "Nagy Péter",

        rating: 4.6,

        full: true

    }

];


const favoritesList = document.getElementById("favoritesList");

const favoritesEmpty = document.getElementById("favoritesEmpty");


function renderFavorites(favorites) {


    if (!favoritesList || !favoritesEmpty) {

        return;

    }


    favoritesList.innerHTML = "";


    if (favorites.length === 0) {

        favoritesEmpty.hidden = false;

        return;

    }


    favoritesEmpty.hidden = true;


    favorites.forEach(function (program) {


        const card = document.createElement("article");

        card.className = "favorite-card";


        card.innerHTML = `

            <div class="favorite-image" aria-hidden="true">

                X

            </div>


            <div class="favorite-content">


                <div class="favorite-card-header">

                    <h2>${program.title}</h2>


                    <button

                        type="button"

                        class="favorite-button"

                        data-program-id="${program.id}"

                        aria-label="${program.title} eltávolítása a kedvencek közül">

                        ♥ Kedvenc

                    </button>

                </div>


                <p class="favorite-description">

                    ${program.description}

                </p>


                <div class="favorite-details">

                    <p><strong>Kategória:</strong> ${program.category}</p>

                    <p><strong>Helyszín:</strong> ${program.location}</p>

                    <p><strong>Dátum / idő:</strong> ${program.dateTime}</p>

                    <p><strong>Programszervező:</strong> ${program.organizer}</p>

                    <p><strong>☆ Átlagértékelés:</strong> ${program.rating}</p>

                </div>


                <div class="favorite-card-actions">

                    ${program.full

                        ? '<span class="program-full">Betelt</span>'

                        : '<span></span>'}


                    <a

                        href="program_reszletei.html"

                        class="favorite-details-button">

                        Részletek

                    </a>

                </div>


            </div>

        `;


        favoritesList.appendChild(card);

    });


    addFavoriteButtonEvents();

}


function addFavoriteButtonEvents() {


    const favoriteButtons = document.querySelectorAll(".favorite-button");


    favoriteButtons.forEach(function (button) {


        button.addEventListener("click", function () {


            const programId = Number(button.dataset.programId);


            const programIndex = sampleFavorites.findIndex(

                function (program) {

                    return program.id === programId;

                }

            );


            if (programIndex === -1) {

                return;

            }


            sampleFavorites.splice(programIndex, 1);

            renderFavorites(sampleFavorites);


            /*

             * Később itt történik majd a kedvenc törlése

             * a backend/API segítségével.

             */

        });

    });

}


renderFavorites(sampleFavorites);