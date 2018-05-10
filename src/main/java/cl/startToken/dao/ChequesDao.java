package cl.startToken.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.startToken.dao.conexion.Conexion;
import cl.startToken.to.ChequeTO;
import cl.startToken.to.ClientesTO;
import cl.startToken.to.EstadosCheques;

public class ChequesDao {

	
	
	/**
	 * Crea un cheque
	 * 
	 * @author Jnarvaez
	 */
	public static void crearCheque(List<ChequeTO> lista) {
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_crea_cheque (?,?,?,?,?,?,?)");){
			for (ChequeTO cheque : lista) {
			stmt.setInt(1,  cheque.getRutCliente());
			stmt.setDouble(2,  cheque.getInteres());
			stmt.setString(3,  cheque.getFechaVencimiento());
			stmt.setString(4,  cheque.getFechaInicial());
			stmt.setLong(5,  cheque.getTotalPrestamo());
			stmt.setInt(6,  cheque.getDias());
			stmt.setString(7,  cheque.getNumeroCheque());
			
			stmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<ChequeTO> busquedaRutCliente(int rut,EstadosCheques estado){
		List<ChequeTO> listaCheques = new ArrayList<>();
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_lst_cheque_rcliente (?,?)");
			){
			stmt.setInt(1, rut);
			stmt.setInt(2, estado.getCodEstado());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				listaCheques.add(parceaCheque(rs));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCheques;
	}
	
	public static List<ChequeTO> busquedaRutAgente(int rut,EstadosCheques estado){
		List<ChequeTO> listaCheques = new ArrayList<>();
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_lst_cheque_ragente (?,?)");
			ResultSet rs = stmt.executeQuery()){
			stmt.setInt(1, rut);
			stmt.setInt(2, estado.getCodEstado());
			while (rs.next()) {
				listaCheques.add(parceaCheque(rs));			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCheques;
		
	}
	
	public static List<ChequeTO> busquedaFVencimiento(String fechaVencimiento,EstadosCheques estado){
		List<ChequeTO> listaCheques = new ArrayList<>();
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_lst_cheque_fvencimiento (?,?)");
			ResultSet rs = stmt.executeQuery()){
			stmt.setString(1, fechaVencimiento);
			stmt.setInt(2, estado.getCodEstado());
			while (rs.next()) {
				listaCheques.add(parceaCheque(rs));			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCheques;
		
	}
	
	
	public static List<ChequeTO> busquedaFIngreso(String fechaIngreso,EstadosCheques estado){
		List<ChequeTO> listaCheques = new ArrayList<>();
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_lst_cheque_fingreso (?,?)");
			ResultSet rs = stmt.executeQuery()){
			stmt.setString(1, fechaIngreso);
			stmt.setInt(2, estado.getCodEstado());
			while (rs.next()) {
				listaCheques.add(parceaCheque(rs));			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCheques;
	}
	
	public static List<ChequeTO> busquedaNumeroCheque(int numero,EstadosCheques estado){
		List<ChequeTO> listaCheques = new ArrayList<>();
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_lst_cheque_nCheque (?,?)");
			){
			stmt.setInt(1, numero);
			stmt.setInt(2, estado.getCodEstado());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				listaCheques.add(parceaCheque(rs));			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCheques;
	}
	
	
	
	private static ChequeTO parceaCheque(ResultSet rs) throws SQLException {
		
		ChequeTO cheque = new ChequeTO();
		
		cheque.setDias(rs.getInt("diasCheque"));
		cheque.setFechaInicial(rs.getString("fechaInicial"));
		cheque.setFechaVencimiento(rs.getString("fechaVencimiento").replace(" ","/"));
		cheque.setInteres(rs.getDouble("interes"));		
		cheque.setNumeroCheque(rs.getString("numCheque"));
		cheque.setRutCliente(rs.getInt("rutCliente"));
		cheque.setTotalPrestamo(rs.getInt("totalPrestamo"));
		cheque.setId(rs.getInt("idCheque"));
		for(ClientesTO cliente : ClientesDao.obtenerClientes()) {
			if(cliente.getRutDb() == cheque.getRutCliente()) {
				cheque.setCliente(cliente);
				break;
			}
		}
		return cheque;
	}
}
