
<script src="resources/js/clientes.js"></script>
<div class="contenido">
<div class="titulo">


	<h3>Ingreso de Clientes</h3>
</div>
<div class="formulario tablaCentro">

	<form id="creaCliente">

		<div class="form-group">
			<label for="exampleFormControlInput1">Nombre</label>
				 <input type="text" name="nombreCompleto" class="form-control" id="Nombre" placeholder="Ingrese el nombre del Agente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">RUT</label>
			<input type="text"  name="rut" class="form-control" id="rut"  placeholder="Ingrese el RUT del Agente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Banco</label> <input
				type="text" name="banco" class="form-control" id="banco"	placeholder="Ingrese el Banco del Agente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">CTA. Corriente</label> <input
				type="text" name="c_corriente" class="form-control" id="ctacc"	placeholder="Ingrese la cuenta corriente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Monto Max. por cliente</label>
			<input type="number"  name="monto_maximo_prestamo"  class="form-control" id="monto" placeholder="Ingrese el monto Maximo">
		</div>

		<div class="botones-derecha">
			<button type="submit" class="btn btn-primary">Aceptar</button>
			<button type="button" class="btn btn-primary">Cancelar</button>
		</div>

	</form>


</div>
</div>