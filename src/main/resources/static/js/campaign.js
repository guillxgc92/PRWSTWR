document.addEventListener("DOMContentLoaded", function() {

    var csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
    var csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
	
    document.querySelector("#register-campaign").addEventListener("submit", function(event){

		event.preventDefault();

        var formData = {
            campaignName: document.querySelector("#campaignName").value,
            idGalaxy: document.querySelector("#galaxySelect").value,
            idRegions: document.querySelector("#regionSelect").value,
            idPlanet: document.querySelector("#planetSelect").value,
            idTerritory: document.querySelector("#territorySelect").value
        }

        const requestOptions = {
            method: 'POST', 
            headers: {
                'Content-Type': 'application/json',
                [csrfHeader]: csrfToken 
            },
            body: JSON.stringify(formData) 
        };

        fetch('/processFormCampaign',
            requestOptions
        )
        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(campaignRequest => {
            console.log(campaignRequest);
            //window.location.href = "/";
        })
        .catch(error => {
            console.error("Error en la solicitud fetch:", error);
        });
    });
});