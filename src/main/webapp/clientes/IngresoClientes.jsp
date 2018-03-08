<script type='text/javascript' src='/Factoring/dwr/interface/clientes.js'></script>
<script type='text/javascript' src='/Factoring/dwr/engine.js'></script>
<script type='text/javascript' src='/Factoring/js/validaciones.js'></script>



<div class ="titulo" >
  

<h3>Ingreso de Clientes</h3>
</div>
<div class="formulario tablaCentro">
	<form>
		<div class="form-group">
			<label for="exampleFormControlInput1">Nombre</label> <input
				type="text" class="form-control" id="Nombre"
				placeholder="Ingrese el nombre del Agente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">RUT</label> <input type="text"
				class="form-control" id="rut"
				onblur="formateaRut"
				placeholder="Ingrese el RUT del Agente">
		</div>
	    <div class="form-group">
			<label for="exampleFormControlInput1">Banco</label> <input type="text"
				class="form-control" id="banco"
				placeholder="Ingrese el Banco del Agente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">CTA. Corriente</label> <input type="text"
				class="form-control" id="ctacc"
				placeholder="Ingrese la cuenta corriente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Monto Max. por cliente</label>
			<input type="number" class="form-control" id="monto"
				placeholder="Ingrese el monto Maximo">
		</div>
		
		<div class="botones-derecha"> <button type="button" class="btn btn-primary">Aceptar</button>
		<button type="button" class="btn btn-primary">Cancelar</button> </div>
	
	</form>


</div>
