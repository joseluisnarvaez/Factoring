<h3>Busqueda de cheques</h3>
<div class="formulario tablaCentro">
	<form id="form">
		<div class="form-group">
			<table>
				<tr>
					<td><label for="exampleFormControlInput1">Fecha de
							Ingreso</label> <input type="text" class="form-control" id="Nombre"
						placeholder="Fecha de Ingreso"></td>
					<td><label for="exampleFormControlInput1">Fecha
							vencimiento </label> <input type="text" class="form-control"
						id="interesCliente" placeholder="Fecha vencimiento"></td>
				</tr>
				<tr>
					<td><label for="exampleFormControlInput1">Nombre
							Cliente</label> <input type="text" class="form-control"
						id="interesCliente" placeholder="Nombre Cliente"></td>
					<td><label for="exampleFormControlInput1">Rut Cliente</label>
						<input type="text" class="form-control" id="interesCliente"
						placeholder="Rut Cliente"></td>
				</tr>
				<tr>
					<td><label for="exampleFormControlInput1">Id Cheque</label> <input
						type="text" class="form-control" id="rut" placeholder="Id Cheque">
					</td>
					<td><label for="exampleFormControlInput1">Entregado a
							agente</label> <input type="text" class="form-control" id="rut"
						placeholder=""></td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td></td>
					<td>
						<div class="botones-derecha">
							<button type="button" class="btn btn-primary">Buscar</button>
						</div>
					</td>
				</tr>
			</table>

		</div>
	</form>
</div>
</br>
			</br>
	
	
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
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>Juan</td>
				<td>17.440.344-3</td>
				<td>BBVA</td>
				<td>4344234-234234-123423</td>
				<td>50.000</td>
				<td><i class="fa fa-pencil"></i></td>
				<td><i class="fa fa-trash" aria-hidden="true"></i></td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>Juan</td>
				<td>17.440.344-3</td>
				<td>BBVA</td>
				<td>4344234-234234-123423</td>
				<td>50.000</td>
				<td><i class="fa fa-pencil"></i></td>
				<td><i class="fa fa-trash" aria-hidden="true"></i></td>
			</tr>
			<tr>
				<th scope="row">3</th>
				<td>Juan</td>
				<td>17.440.344-3</td>
				<td>BBVA</td>
				<td>4344234-234234-123423</td>
				<td>50.000</td>
				<td><i class="fa fa-pencil"></i></td>
				<td><i class="fa fa-trash" aria-hidden="true"></i></td>
			</tr>
		</tbody>
	</table>

	
	<script>
	
	$(document).ready(function() {
    
		   $("#tabla0").css('display', 'none');
		   $("#tabla1").css('display', 'none');
		
	    // radio button
	    $("input[name = optradio]").click(function () {
	    	if( $("#form #montoEntregar").is(':checked')) {
	    		 $("#tabla1").css('display', 'none');
	    		 $("#tabla0").css('display', '');
	    		
	    	}
	    	if( $("#form #montoCheque").is(':checked')) {
	    		   $("#tabla0").css('display', 'none');
	    		   $("#tabla1").css('display', '');
    		   }
		});

	});
	
	</script>