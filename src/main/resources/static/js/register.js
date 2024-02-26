
$(document).ready(function(){
	
	var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
	
	$("#register-form").on("submit", function(event){
		
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