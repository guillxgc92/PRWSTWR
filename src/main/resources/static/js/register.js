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


        fetch('/register', 
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
                alert("Te has registrado con éxito.");
            }
        })
        .catch(error => {
            console.error("Error en la solicitud fetch:", error.message);
        });
    });
});


/*
$(document).ready(function(){
	
	var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
	
	$("#register-form").on("click", "#button-register", function(event){
		
		event.preventDefault(); 

		var formData = {
            usertag: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            name: $("#name").val(),
            firstSurName: $("#firstSurName").val(),
            secondSurName: $("#secondSurName").val()
        }

		$.ajax({
			url:'/register',
			method: 'POST',
			beforeSend: function(xhr) {
            	xhr.setRequestHeader(csrfHeader, csrfToken);
            	console.log(csrfHeader, csrfToken);
        	},
		    data: formData,
		    success: function (registroResult) {
			    if (registroResult.error) {
                    console.error("Error en el servidor:", registroResult.errorMessage);
                } else {
                    alert("Te has registrado con éxito.");
                }
            },
		    error: function (xhr, status, error) {
			   console.error("Error en la solicitud AJAX:", xhr.responseText);
			   $("#form-charge").html('<p>Error al enviar los datos</p>');
			}
			
		});//CIERRE PETICION ASYNC REGISTRO DE USUARIO
		
	});//CIERRE #btn-register 
	
}) //CIERRE $(document).ready(function(){})*/