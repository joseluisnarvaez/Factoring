$(document).ready(function() {
    $('#some-menu').load('menu/menu.jsp');
    $('#idContenido').load('cheque/IngresoCheque.jsp');
//Menu Agentes
    $('a#IngresoAgente').click(function(evt) {
    	  $('#idContenido').load('agentes/IngresoAgentes.jsp');
    });
    $('a#BusquedaAgente').click(function(evt) {
  	  $('#idContenido').load('agentes/busquedaAgentes.jsp');
    });
  
//    Menu Clientes
    $('a#IngresoClientes').click(function(evt) {
    	$('#idContenido').load('clientes/IngresoClientes.jsp');
    });
    $('a#BusquedaClientes').click(function(evt) {
    	$('#idContenido').load('clientes/BusquedaClientes.jsp');
    });
//  Ingreso cheques
    $('a#IngresoCheque').click(function(evt) {
    	$('#idContenido').load('cheque/IngresoCheque.jsp');
    });
    
    // radio button
    $("input[name = optradio]").click(function () {
    	if( $("#form #montoEntregar").is(':checked')) {
    		alert('montoEntregar');
    	}
    	if( $("#form #montoCheque").is(':checked')) {
    		alert('montoCheque');
    	}
	});



});