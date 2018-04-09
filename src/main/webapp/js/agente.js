$(document).ready(function() {
	
	$.get("agentes/", function(data, status) {
		armaTabla(data);
	});

	$("#buscar").click(function() {
		var nombre =$("#nombre").val();
		var rut = $("#rut").val();
		var url = "agentes/agente?nombre="+nombre+"&&rut="+rut;  
		$.get(url, function(data, status) {
			if(data == 1 ){
				alert("Rut Invalido")
			}
			else {
				armaTabla(data);	
			}
			
		});

	});

						
	$("#creaAgente").submit(function(e) {
		var form = objectifyForm($(this).serializeArray());
		var url = "agentes/";
		$.ajax({
			  method: "POST",
			  url: url,
			  contentType: "application/json",
			  data: form,
			  async: false,
			  success: function(msg){
	        	  if(msg == 1 ){
	        		  alert('Actualizado con exito');
	        		  location.reload();
	        	  }
	          },
			  
		});
	});
	

	
	 $('#actualizaCliente').submit(function(e) {
		  var form = objectifyForm($( this ).serializeArray() );
		  $.ajax({
	          type: 'PUT',
	          url: 'agentes/',
	          contentType: "application/json",
	          data :form ,
	          async: false,
	          success: function(msg){
	        	  if(msg == 1 ){
	        		  alert('Actualizado con exito');
	        		  location.reload();
	        	  }
	        	  else if (msg == -1 ){
	        		  alert('Datos ingresados se encuentran con errores.');
	        	  }
	          },
	          error: function(){
	          }
	        });
		 
	        
	    });

	function objectifyForm(formArray) {

		  var returnArray="{";
		  var primeraVuelta = true;
		  for (var i = 0; i < formArray.length; i++){
			  if(!primeraVuelta){
				  
				  returnArray+= ',';
			  }
			  else {primeraVuelta = false;}
			  
		    returnArray+=  "'"+[formArray[i]['name']]+"':'"+formArray[i]['value']+"'";
		  }
		  return returnArray+"}";
		}

});


function checkRut(rut) {
    // Despejar Puntos
    var valor = rut.value.replace('.','');
    // Despejar Guión
    valor = valor.replace('-','');
    
    // Aislar Cuerpo y Dígito Verificador
    cuerpo = valor.slice(0,-1);
    dv = valor.slice(-1).toUpperCase();
    
    // Formatear RUN
    rut.value = cuerpo + '-'+ dv
    
    // Si no cumple con el mínimo ej. (n.nnn.nnn)
    if(cuerpo.length < 7) { rut.setCustomValidity("RUT Incompleto"); return false;}
    
    // Calcular Dígito Verificador
    suma = 0;
    multiplo = 2;
    
    // Para cada dígito del Cuerpo
    for(i=1;i<=cuerpo.length;i++) {
    
        // Obtener su Producto con el Múltiplo Correspondiente
        index = multiplo * valor.charAt(cuerpo.length - i);
        
        // Sumar al Contador General
        suma = suma + index;
        
        // Consolidar Múltiplo dentro del rango [2,7]
        if(multiplo < 7) { multiplo = multiplo + 1; } else { multiplo = 2; }
  
    }
    
    // Calcular Dígito Verificador en base al Módulo 11
    dvEsperado = 11 - (suma % 11);
    
    // Casos Especiales (0 y K)
    dv = (dv == 'K')?10:dv;
    dv = (dv == 0)?11:dv;
    
    // Validar que el Cuerpo coincide con su Dígito Verificador
    if(dvEsperado != dv) { rut.setCustomValidity("RUT Inválido"); return false; }
    
    // Si todo sale bien, eliminar errores (decretar que es válido)
    rut.setCustomValidity('');
}

function armaTabla(data) {

	var tbody = "";
	var index = 1;
	$.each(data, function(key, value) {
		tbody += "<tr>";
		tbody += "<td>";
		tbody += index;
		tbody += "</td>";
		tbody += "<td>";
		tbody += value.nombres;
		tbody += "</td>";
		tbody += "<td>";
		tbody += value.rutDb + "-" + value.dv;
		tbody += "</td>";
		tbody += "<td>";
		tbody += value.monto;
		tbody += "</td>";
		tbody += "<td>";
		tbody += "<a href='#'> <i class='fa fa-pencil' data-toggle='modal' data-target='#myModal' onclick='cargaUsuario("+value.id+")'  value = '"+value.id+"'  id='editaCliente' aria-hidden='true'></i></a>";
		tbody += "</td>";
		tbody += "<td>";
		tbody += "<a href='#'> <i class='fa fa-trash'  onclick='elimina("+value.id+")'  aria-hidden='true'></i></a>";
		tbody += "</td>";
		tbody += "</tr>";
		index++;
	});

	$("#tablaAgentes").html(tbody);
}



	function elimina(id){
	 if (confirm('Desea eliminarlo?')) {
		
		var url = "agentes/elimina/"+ id;	 
		$.get(url, function(data, status) {
			if(data == 1 ){
				alert("Eliminado");
				location.reload();
			}
		});
	  }
}
	

	function cargaUsuario(id) {
		var url = "agentes/agente/" + id;
		$.get(url, function(data) {
			$("#fnombre").val(data.nombres);
			$("#frut").val(data.rutDb +"-"+data.dv);
			$("#fbanco").val(data.banco);
			$("#fctacc").val(data.cCorriente);
			$("#fmonto").val(data.monto);
			$("#id").val(data.id);
		});
	}


