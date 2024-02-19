$(document).ready(function() {
    // Manejador de cambio en el selector de Región
    $("#region").change(function() {
        var idPlanetRegion = $(this).val();
    
        $.ajax({
            url: '/getPlanetsByRegion',
            type: 'GET', // Change to GET method
            data: { idPlanetRegion: idPlanetRegion }, // Use the correct field name
            success: function(planets) {
                $("#planet").empty();
                $.each(planets, function(index, planet) {
                    $("#planet").append('<option value="' + planet.idPlanet + '">' + planet.planetName + '</option>');
                });
            },
            error: function(error) {
                console.log("Error al obtener planetas: " + error);
            }
        });
    });
    

    // Manejar la presentación del formulario
    $("#campaignForm").submit(function(event) {
        event.preventDefault(); // Evitar que el formulario se envíe normalmente

        // Realizar otras acciones si es necesario

        // Enviar el formulario mediante AJAX o dejar que se envíe normalmente
        // Dependiendo de tus necesidades
        $.ajax({
            url: $(this).attr('action'),
            type: $(this).attr('method'),
            data: $(this).serialize(),
            success: function(response) {
                // Manejar la respuesta del servidor
            },
            error: function(error) {
                console.log("Error al enviar el formulario: " + error);
            }
        });
    });
});
