document.addEventListener("DOMContentLoaded", function() {

    var csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
    var csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
	
    document.querySelector("#register-character").addEventListener("submit", function(){

        var formData = {
            charName: document.querySelector("#charName").value,
            charRace: document.querySelector("#charRaceSelect").value,
            charRaceSkill: document.querySelector("#charRaceSkillSelect").value,
            charClass: document.querySelector("#charClassSelect").value,
            charClassSkill: document.querySelector("#charClassSkillSelect").value
        }

        const requestOptions = {
            method: 'POST', 
            headers: {
                'Content-Type': 'application/json',
                [csrfHeader]: csrfToken 
            },
            body: JSON.stringify(formData) 
        };

        fetch('/processCharacterForm',
            requestOptions
        )
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(character => {
            console.log(character);
            window.location.href = "/campaign";
        })
        .catch(error => {
            console.error("Error en la solicitud fetch:", error.message);
        });
    });
});