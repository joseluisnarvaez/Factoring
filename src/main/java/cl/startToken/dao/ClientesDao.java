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
	
	

	/**
	 * Actualiza cliente con id
	 * 
	 * @return List<ClientesTO>
	 * @author Jnarvaez
	 */
	public static void actualizarClientes(ClientesTO cliente) {
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_upd_cliente (?,?,?)");){
			stmt.setInt(1, cliente.getIdClientes());
			stmt.setString(2, cliente.getNombreCompleto());
			stmt.setDouble(3, cliente.getInteres_mensual());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Elimina un cliente
	 * 
	 * @return List<ClientesTO>
	 * @author Jnarvaez
	 */
	public static void eliminaCliente(int id) {
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_del_cliente(?)");){
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Actualiza cliente con id
	 * 
	 * @return List<ClientesTO>
	 * @author Jnarvaez
	 */
	public static void crearClientes(ClientesTO cliente) {
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_crea_cliente (?,?,?,?,?)");){
			stmt.setString(1, cliente.getNombreCompleto());
			stmt.setInt(2, cliente.getBanco());
			stmt.setString(3, cliente.getC_corriente());
			stmt.setDouble(4, cliente.getInteres_mensual());
			stmt.setLong(5, cliente.getMonto_maximo_prestamo());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	private static ClientesTO parseaCliente(ResultSet rs) throws SQLException {
		
		ClientesTO cliente = new ClientesTO();
		StringBuilder nombre = new StringBuilder();
		nombre.append(rs.getString("nombres"));
		cliente.setIdClientes(rs.getInt("idClientes"));
		cliente.setNombreCompleto(nombre.toString());
		cliente.setBanco(rs.getInt("banco"));
		cliente.setC_corriente(rs.getString("c_corriente"));
		cliente.setInteres_mensual(rs.getDouble("interes_mensual"));
		cliente.setMonto_maximo_prestamo(rs.getLong("monto_maximo_prestamo"));
		return cliente;
	}
	
	
	
}
