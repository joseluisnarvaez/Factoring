$(document).ready(function() {
    $('#some-menu').load('menu/menu.jsp');
    $('#idContenido').load('cheque/IngresoCheque.jsp');
//Menu Agentes
    $('a#IngresoAgente').click(function(evt) {
    	 $(location).attr('href','agentes/IngresoAgentes.jsp');
    	  
    });
    $('a#BusquedaAgente').click(function(evt) {
    	$(location).attr('href','agentes/busquedaAgentes.jsp');
    });
  
//    Menu Clientes
    $('a#IngresoClientes').click(function(evt) {
    	$(location).attr('href','clientes/IngresoClientes.jsp');
    });
    $('a#BusquedaClientes').click(function(evt) {
    	$(location).attr('href','clientes/BusquedaClientes.jsp');
    });
//  Ingreso cheques
    $('a#IngresoCheque').click(function(evt) {
    	$(location).attr('href','cheque/IngresoCheque.jsp');
    });
    
//  Busqueda cheques
    $('a#BusquedaCheque').click(function(evt) {
    	$(location).attr('href','busqueda/BusquedaCheques.jsp');
    });
    
});