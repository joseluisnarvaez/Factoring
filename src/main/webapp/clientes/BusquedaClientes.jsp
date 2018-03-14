<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src="resources/js/clientes.js"></script>
<div class="contenido">
	<h3>Buscar Clientes</h3>

	<div class="formulario tablaCentro">
		<form>
			<div class="form-group">
				<label for="exampleFormControlInput1">Nombre</label> <input
					type="text" class="form-control" id="nombre"
					placeholder="Ingrese el nombre del Cliente">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">RUT</label> <input type="text"
					class="form-control" id="rut" required oninput="checkRut(this)"
					placeholder="Ingrese el RUT del Cliente">
			</div>
			<div class="botones-derecha">
				<button type="button" class="btn btn-info btn-lg"
					data-toggle="modal" data-target="#myModal">Open Modal</button>
				<button type="button" class="btn btn-primary" id="editar">Editar</button>
				<button type="button" class="btn btn-primary" id="buscar">Buscar</button>
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

<!-- Modal  -->

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				 <h4 class="modal-title">Actualizacion Cliente</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<form method="post" id="actualizaCliente" action="#">

					<div class="form-group">
						<label for="exampleFormControlInput1">Nombre</label>
						<input	type="text" name="nombreCompleto" class="form-control" id="Nombre"	placeholder="Ingrese el nombre del Agente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">RUT</label> 
						<input	type="text" name="rut" required oninput="checkRut(this)" class="form-control" id="rut"	placeholder="Ingrese el RUT del Agente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">Banco</label>
						 <input type="text" name="banco" class="form-control" id="banco"	placeholder="Ingrese el Banco del Agente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">CTA. Corriente</label>
						 <input	type="text" name="c_corriente" class="form-control" id="ctacc"		placeholder="Ingrese la cuenta corriente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">Monto Max. por cliente</label>
							 <input type="number" name="monto_maximo_prestamo" class="form-control" id="monto"		placeholder="Ingrese el monto Maximo">
					</div>

					<div class="botones-derecha">
						<button type="submit" class="btn btn-primary">Aceptar</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>
					</div>

				</form>
			</div>
			<div class="modal-footer">
				
			</div>
		</div>

	</div>
</div>


