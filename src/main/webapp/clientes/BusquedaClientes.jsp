<script src="resources/js/clientes.js"></script>
<div class="contenido" >
<h3>Buscar Clientes</h3>

<div class="formulario tablaCentro">
	<form>
		<div class="form-group">
			<label for="exampleFormControlInput1">Nombre</label> <input
				type="text" class="form-control" id="Nombre"
				placeholder="Ingrese el nombre del Cliente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">RUT</label> <input type="text"
				class="form-control" id="rut"
				placeholder="Ingrese el RUT del Cliente">
		</div>
		<div class="botones-derecha">
			<button type="button" class="btn btn-primary">Buscar</button>
			<button type="button" class="btn btn-primary">Cancelar</button>
		</div>
	</form>

</div>






	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Rut</th>
				<th>Banco</th>
				<th>Cuenta Corriente</th>
				<th>Monto Max. Por Cliente</th>
				<th>Modificar</th>
				<th>Eliminar</th>
				
			</tr>
		</thead>
		<tbody id="tablaClientes">
			
		</tbody>
	</table>


</div>
