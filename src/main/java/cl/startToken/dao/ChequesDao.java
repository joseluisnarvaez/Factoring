package cl.startToken.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import cl.startToken.dao.conexion.Conexion;
import cl.startToken.to.ChequeTO;

public class ChequesDao {

	
	
	/**
	 * Crea un cheque
	 * 
	 * @author Jnarvaez
	 */
	public static void crearClientes(List<ChequeTO> lista) {
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_crea_cheque (?,?,?,?,?,?,?)");){
			for (ChequeTO cheque : lista) {
			stmt.setInt(1,  cheque.getRutCliente());
			stmt.setDouble(2,  cheque.getInteres());
			stmt.setString(3,  cheque.getFechaVencimiento());
			stmt.setString(4,  cheque.getFechaInicial());
			stmt.setLong(5,  cheque.getTotalPrestamo());
			stmt.setInt(6,  cheque.getDias());
			stmt.setLong(7,  cheque.getNumeroCheque());
			
			stmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
