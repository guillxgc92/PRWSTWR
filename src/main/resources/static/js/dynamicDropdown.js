$(document).ready(function() {
	
   $("#register-campaign").on("submit", function(event){
		
		event.preventDefault(); // Evita que el formulario se envíe normalmente
		
		var formData = {
            namecampaign: $("#namecampaign").val(),
            galaxy: $("#galaxy").val(),
            region: $("#region").val(),
            planet: $("#planet").val(),
            territory: $("#territory").val()
        }
        
		$.ajax({
			
			url:'/processFormCampaign',
			method: 'POST',
		    data: formData,
		    success: function (registroResult) {
				
				let resultHtml = "<p>Usuario registrado:</p>" +
                     "<p>Camapaña: " + registroResult.namecampaign + "</p>" +
                     "<p>Territorio: " + registroResult.territory + "</p>";

			    $("#form-charge").html(resultHtml);
				
			    console.log("objeto usuario: " + registroResult);
			    window.location.href = '/'; //reidireccion de ruta despues de enviar los datos
			    alert('Nueva campaña registrada con éxito.');
		    },
		    error: function () {
		        $("#form-charge").html('<p>Error al guardar la campaña.</p>');
		    }
			
		});//CIERRE PETICION ASYNC REGISTRO DE USUARIO
		
	});//CIERRE #register-campaign
});//CIERRE DOMUENTE READY
