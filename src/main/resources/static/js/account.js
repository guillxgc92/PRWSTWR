document.addEventListener("DOMContentLoaded", function() {
	
    var csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
    var csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

    document.querySelector("#button-update").addEventListener("click", function() {
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
                if (registroResult.message && registroResult.message.startsWith("redirect:")) {
		            const redirectUrl = registroResult.message.substring("redirect:".length);
		            window.location.href = redirectUrl;
	        } else {
	            alert("Cambios realizados con éxito.");
	        }
	            }
        })
        .catch(error => {
            console.error("Error en la solicitud fetch:", error.message);
        });
    });
    
    
    document.getElementById("button-delete").addEventListener("click", function() {
    fetch("/deleteUser", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            [csrfHeader]: csrfToken 
        	},
	    })
	    .then(response => {
	        if (!response.ok) {
	           	return response.text().then(errorText => {
            	throw new Error("Error al borrar la cuenta. " + errorText);
        		});
	        }
	    })
	    .then(data => {
	        alert("Tu cuenta se ha borrado con éxito.")
	        window.location.href = "/";
	    })
	    .catch(error => {
	        console.error("Error:", error.message);
	        alert("Error al borrar la cuenta :(");
	    });
	});
});
