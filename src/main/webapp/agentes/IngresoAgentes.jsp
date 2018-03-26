<script src="resources/js/agente.js"></script>
<div class ="titulo" >
<h3>Ingreso de Agentes</h3>
</div>
<div class="formulario tablaCentro">
	<form id="creaAgente">
		<div class="form-group">
						<label for="exampleFormControlInput1">Nombre</label> <input
							type="text" class="form-control" id="nombre" name="nombres"
							placeholder="Ingrese el nombre del Agente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">RUT</label> <input type="text"
							class="form-control" id="rut" name= "rut"
							placeholder="Ingrese el RUT del Agente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">Banco</label> <input type="text"
							class="form-control" id="banco" name="banco"
							placeholder="Ingrese el banco del Agente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">Cuenta Corriente</label> <input type="text"
							class="form-control" id="ctacc" name="cCorriente"
							placeholder="Ingrese la cuenta corriente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1"> Monto máximo de préstamo</label>
						<input type="number" class="form-control" id="monto" name="monto"
							placeholder="Ingrese el monto Maximo">
					</div>
		<div class="botones-derecha">
			<button type="submit" class="btn btn-primary">Aceptar</button>
			<button type="button" id="botonAceptar" class="btn btn-primary">Cancelar</button>
		</div>
	
	</form>


</div>
