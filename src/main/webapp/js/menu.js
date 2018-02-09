$(document).ready(function() {
    $('#some-menu').load('menu/menu.jsp');
    $('#idContenido').load('agentes/busquedaAgentes.jsp');
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
    

});