package cl.startToken.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cl.startToken.dao.conexion.Conexion;
import cl.startToken.to.TitularTO;

public class TitularDao {
	/**
	 * Actualiza cliente con id
	 * 
	 * @return List<ClientesTO>
	 * @author Jnarvaez
	 */
	public static void crearTitular(TitularTO titular) {
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_crea_titular (?,?,?,?,?,?)");){
			stmt.setString(1, titular.getNombre());
			stmt.setString(2,titular.getRut());
			stmt.setString(3, titular.getDv());
			stmt.setString(4, titular.getCuentaCorriente());
			stmt.setString(5, titular.getBanco());
			stmt.setLong(6, titular.getIdCliente());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
