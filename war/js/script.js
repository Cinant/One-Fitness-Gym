$(document).ready(function() {
	$('#options').change(function(event) { 
		var list = document.getElementById("options");
		var value = list.options[list.selectedIndex].value;
		
// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get  
			$.post('ActionForm', { 
				nombre : value
			}, function(responseText) { 
			$('#registrar').html(responseText); 
		}); 
	});
});
$(document).ready(function() { 
	
	
	$('#reg').click(function(event) { 
		$.post('control', { 
			cont : "registro"},
			function(responseText) {
			$('#cuerpo').html(responseText);
		});
	});
	
}); 

