$(document).ready(function() {
    $('#some-menu').load('menu/menu.jsp');
    $('#idContenido').load('agentes/IngresoAgentes.jsp');
    
    $('a[href="#BusquedaAgente"]').click(function(){
    	 $('#idContenido').load('agentes/busquedaAgentes.jsp');
    }); 
    
});