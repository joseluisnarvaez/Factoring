package cl.startToken.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.startToken.dao.conexion.Conexion;
import cl.startToken.to.AgentesTO;

/**
 * Clase de que implementa la logica para la tabla de Agentes
 * 
 * @author jNarvaez
 *
 */
public class AgentesDao {

	
	
	/**
	 * Metodo que implementa la logica de obtener agentes de la base de datos
	 * 
	 * @return List<AgentesTO>
	 * @author Jnarvaez
	 */
	public static List<AgentesTO> obtenerAgentes() {
		List<AgentesTO> listaAgentes = new ArrayList<>();
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_lst_agente");
			ResultSet rs = stmt.executeQuery()){
			while (rs.next()) {
				listaAgentes.add(parseaAgente(rs));			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAgentes;
	}
	
	

	/**
	 * Actualiza Agente con id
	 * 
	 * @return List<agentesTO>
	 * @author Jnarvaez
	 */
	public static void actualizarAgentes(AgentesTO agente) {
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_upd_agente (?,?,?,?,?,?,?)");){
			stmt.setInt(1, agente.getId());
			stmt.setString(2, agente.getNombres());
			stmt.setInt(3,agente.getRutDb());
			stmt.setString(4, agente.getDv());
			stmt.setString(5, agente.getBanco());
			stmt.setString(6, agente.getcCorriente());
			stmt.setDouble(7, agente.getMonto());
			
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
	public static void eliminaAgente(int id) {
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
	public static void crearAgente(AgentesTO agente) {
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_crea_agente (?,?,?,?,?,?)");){
			stmt.setString(1, agente.getNombres());
			stmt.setInt(2,agente.getRutDb());
			stmt.setString(3, agente.getDv());
			stmt.setString(4, agente.getBanco());
			stmt.setString(5, agente.getcCorriente());
			stmt.setDouble(6, agente.getMonto());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	private static AgentesTO parseaAgente(ResultSet rs) throws SQLException {
		
		AgentesTO agente = new AgentesTO();
		agente.setNombres(rs.getString("nombre"));
		agente.setRutDb(rs.getInt("rut"));
		agente.setDv(rs.getString("dv_agente"));
		agente.setBanco(rs.getString("banco"));
		agente.setcCorriente(rs.getString("cCorriente"));
		agente.setMonto(rs.getLong("monto"));
		agente.setEstado(rs.getInt("estado"));
		agente.setId(rs.getInt("idagentes"));
		return agente;
	}
	
	
	
}
