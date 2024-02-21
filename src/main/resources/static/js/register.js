
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
                     
				$("#message-confirm").html('Te has registrado con éxito.');
				
				$("#message-redirect").html('Redirigiendo...');
			    		
			    console.log("objeto usuario: " + registroResult);
			    
			    setTimeout(function(){
					window.location.href = '/';
				}, 3000);
			    //window.location.href = '/'; //reidireccion de ruta despues de enviar los datos
			    //alert('Te has registrado con éxito.');
		    },
		    error: function () {
		        $("#form-charge").html('<p>Error al enviar los datos</p>');
		    }
			
		});//CIERRE PETICION ASYNC REGISTRO DE USUARIO
		
	});//CIERRE #btn-register 
	
}) //CIERRE $(document).ready(function(){})*/