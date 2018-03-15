
<head>
	<title>Factoring</title>
	<script src="../resources/js/jquery-3.1.1.js"></script>
	<script src="../resources/js/jquery-3.1.1.min.js"></script>
	<script src="../resources/js/menu.js"></script>
	<link href="../resources/css/style.css" rel="stylesheet" >
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  
</head>

<%@include file="../menu.jsp" %>

<div class="titulo">


	<h3>Ingreso de Clientes</h3>
</div>
<div class="formulario tablaCentro">

	<form>

		<div class="form-group">
			<label for="exampleFormControlInput1">Nombre</label>
				 <input type="text" class="form-control" id="Nombre" placeholder="Ingrese el nombre del Agente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">RUT</label>
			<input type="text" class="form-control" id="rut" onblur="formateaRut" placeholder="Ingrese el RUT del Agente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Banco</label> <input
				type="text" class="form-control" id="banco"	placeholder="Ingrese el Banco del Agente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">CTA. Corriente</label> <input
				type="text" class="form-control" id="ctacc"	placeholder="Ingrese la cuenta corriente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Monto Max. por cliente</label>
			<input type="number" class="form-control" id="monto" placeholder="Ingrese el monto Maximo">
		</div>

		<div class="botones-derecha">
			<button type="button" class="btn btn-primary">Aceptar</button>
			<button type="button" class="btn btn-primary">Cancelar</button>
		</div>

	</form>


</div>
