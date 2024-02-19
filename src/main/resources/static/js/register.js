
$(document).ready(function(){
	
	$("#btn-login").on("click", function(){

	
	
	});//CIERRE #btn-login
	
	
	
	$("#register-form").on("submit", function(event){
		
		event.preventDefault(); // Evita que el formulario se envíe normalmente
		
		var formData = {
            usertag: $("#usertag").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            name: $("#name").val(),
            firstSurName: $("#firstSurName").val(),
            secondSurName: $("#secondSurName").val()
        }
        
		$.ajax({
			
			url:'/registerprocess',
			method: 'POST',
		    data: formData,
		    success: function (registroResult) {
				
				let resultHtml = "<p>Usuario registrado:</p>" +
                     "<p>Usertag: " + registroResult.usertag + "</p>" +
                     "<p>Email: " + registroResult.email + "</p>";

			    $("#form-charge").html(resultHtml);
				
			    console.log("objeto usuario: " + registroResult);
			    window.location.href = '/'; //reidireccion de ruta despues de enviar los datos
			    alert('Te has registrado con éxito.');
		    },
		    error: function () {
		        $("#form-charge").html('<p>Error al cargar la ventana</p>');
		    }
			
		});//CIERRE PETICION ASYNC REGISTRO DE USUARIO
		
	});//CIERRE #btn-register 
	
}) //CIERRE $(document).ready(function(){})