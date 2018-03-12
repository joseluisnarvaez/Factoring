$( document ).ready(function() {
	
	var tbody = "";
	var index = 1;
	$.get("clientes/", function(data, status){
		$.each( data, function( key, value ) {
			tbody += "<tr>";
			tbody += "<td>";
			tbody += index;
			tbody += "</td>";
			tbody += "<td>";
			tbody += value.nombre;
			tbody += "</td>";
			tbody += "<td>";
			tbody += value.rut + "-"+ value.dv_cliente;
			tbody += "</td>";
			tbody += "<td>";
			tbody += value.banco;
			tbody += "</td>";
			tbody += "<td>";
			tbody += value.c_corriente;
			tbody += "</td>";
			tbody += "<td>";
			tbody += value.monto_maximo_prestamo;
			tbody += "</td>";
			tbody += "<td>";
			tbody += "<i class='fa fa-pencil'></i>";
			tbody += "</td>";
			tbody += "<td>";
			tbody += "<i class='fa fa-trash' aria-hidden='true'></i>";
			tbody += "</td>";	
			tbody += "</tr>";
			index++;
			});
		
		$( "#tablaClientes" ).html( tbody );
    });
	
   
});