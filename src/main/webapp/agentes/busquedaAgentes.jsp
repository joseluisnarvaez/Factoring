<script src="resources/js/agente.js"></script>
<h3>Buscar Agente</h3>

<div class="formulario tablaCentro">
	<form>
		<div class="form-group">
			<label for="exampleFormControlInput1">Nombre</label> <input
				type="text" class="form-control" id="nombre"
				placeholder="Ingrese el nombre del Agente">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">RUT</label> <input type="text"
				class="form-control" id="rut"
				placeholder="Ingrese el RUT del Agente">
		</div>
		<div class="botones-derecha">
			<button type="button" id="buscar" class="btn btn-primary">Buscar</button>
			<button type="button" class="btn btn-primary">Cancelar</button>
		</div>
	</form>

</div>

<div >

	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Rut</th>
				<th>Monto Max. Por Cliente</th>
				<th>Modificar</th>
				<th>Eliminar</th>
				
			</tr>
		</thead>
		<tbody id="tablaAgentes">
		
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
				 <h4 class="modal-title">Actualizacion Agente</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<form method="post" id="actualizaCliente" action="#">
					<input type="hidden" name="id" id="id" value="">
					<div class="form-group">
						<label for="exampleFormControlInput1">Nombre</label> <input
							type="text" class="form-control" id="fnombre" name="nombres"
							placeholder="Ingrese el nombre del Agente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">RUT</label> <input type="text"
							class="form-control" id="frut" name= "rut"
							placeholder="Ingrese el RUT del Agente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">Banco</label> <input type="text"
							class="form-control" id="fbanco" name="banco"
							placeholder="Ingrese el banco del Agente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">Cuenta Corriente</label> <input type="text"
							class="form-control" id="fctacc" name="cCorriente"
							placeholder="Ingrese la cuenta corriente">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1"> Monto máximo de préstamo</label>
						<input type="number" class="form-control" id="fmonto" name="monto"
							placeholder="Ingrese el monto Maximo">
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
