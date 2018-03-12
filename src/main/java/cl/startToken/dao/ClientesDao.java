package cl.startToken.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.startToken.dao.conexion.Conexion;
import cl.startToken.to.ClientesTO;

/**
 * Clase de que implementa la logica para la tabla de clientes
 * 
 * @author jNarvaez
 *
 */
public class ClientesDao {

	
	
	/**
	 * Metodo que implementa la logica de obtener clientes de la base de datos
	 * 
	 * @return List<ClientesTO>
	 * @author Jnarvaez
	 */
	public static List<ClientesTO> obtenerClientes() {
		List<ClientesTO> listaClientes = new ArrayList<>();
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_lst_cliente");
			ResultSet rs = stmt.executeQuery()){
			while (rs.next()) {
				listaClientes.add(parseaCliente(rs));			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaClientes;
	}

	private static ClientesTO parseaCliente(ResultSet rs) throws SQLException {
		
		ClientesTO cliente = new ClientesTO();
		cliente.setaMaterno(rs.getString("aMaterno"));
		cliente.setaPaterno(rs.getString("aPaterno"));
		cliente.setBanco(rs.getString("banco"));
		cliente.setC_corriente(rs.getString("c_corriente"));
		cliente.setDv_cliente(rs.getString("dv_cliente"));
		cliente.setInteres_mensual(rs.getDouble("interes_mensual"));
		cliente.setMonto_maximo_prestamo(rs.getInt("monto_maximo_prestamo"));
		cliente.setNombre(rs.getString("nombre"));
		cliente.setRut(rs.getInt("rut"));
		return cliente;
	}
}
