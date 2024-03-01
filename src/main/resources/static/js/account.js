document.addEventListener("DOMContentLoaded", function() {
    var csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
    var csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

    document.querySelector("#button-register").addEventListener("click", function() {
        var formData = {
            usertag: document.querySelector("#username").value,
            password: document.querySelector("#password").value,
            email: document.querySelector("#email").value,
            name: document.querySelector("#name").value,
            firstSurName: document.querySelector("#firstSurName").value,
            secondSurName: document.querySelector("#secondSurName").value
        };

		const requestOptions = {
           method: 'POST', 
           headers: {
               'Content-Type': 'application/json',
               [csrfHeader]: csrfToken 
           },
           body: JSON.stringify(formData) 
       };


        fetch('/updateuser', 
			requestOptions
        )
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(registroResult => {
            if (registroResult.errores.length > 0) {
				let errores = "";
				
				for(let i = 0; i< registroResult.errores.length; i++){
					errores += registroResult.errores[i] + '. ';
				}
				
                alert("Error en el servidor: "+ errores);
            } else {
                alert("Cambios realizados con éxito.");
            }
        })
        .catch(error => {
            console.error("Error en la solicitud fetch:", error.message);
        });
    });
});
