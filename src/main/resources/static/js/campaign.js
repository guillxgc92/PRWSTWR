$(document).ready(function() {
	
	ipt>
    function updatePlanets() {
        var regionId = document.getElementById("regionSelect").value;

        // Realizar una solicitud AJAX al servidor para obtener los planetas asociados a la región seleccionada
        // Aquí puedes usar bibliotecas como jQuery o la API Fetch de JavaScript

        // Ejemplo con jQuery
        $.get("/getPlanetsByRegion/" + regionId, function(data) {
            // Actualizar la lista de planetas en el HTML con la respuesta del servidor
            // Asegúrate de que la respuesta del servidor contenga la lista actualizada de planetas
            $("#planetSelect").html(data);
        });
    }
});//CIERRE DOMUENTE READY
