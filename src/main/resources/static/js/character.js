document.addEventListener("DOMContentLoaded", function() {
    var csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
    var csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
    
    document.querySelector("#register-character").addEventListener("submit", function(event){

		event.preventDefault(event);

        var formData = {
            characterName: document.querySelector("#characterName").value,
            characterRace: document.querySelector("#charRaceSelect").value,
            characterRaceSkill: document.querySelector("#charRaceSkillSelect").value,
            characterClass: document.querySelector("#charClassSelect").value,
            characterClassSkill: document.querySelector("#charClassSkillSelect").value
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
            setTimeout(function() {
                window.location.href = "/campaign";
            }, 5000);
        })
        .catch(error => {
            console.error("Error en la solicitud fetch:", error);
        });
    });
});
