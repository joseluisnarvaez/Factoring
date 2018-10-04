package cl.startToken.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.startToken.dao.conexion.Conexion;
import cl.startToken.to.TitularTO;

public class TitularDao {
	/**
	 * Crea el titular
	 * 
	 * @return List<ClientesTO>
	 * @author Jnarvaez
	 */
	public static void crearTitular(TitularTO titular) {
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_crea_titular (?,?,?,?,?,?,?)");){
			stmt.setString(1, titular.getNombre());
			stmt.setString(2,titular.getRut());
			stmt.setString(3, titular.getDv());
			stmt.setString(4, titular.getCuentaCorriente());
			stmt.setString(5, titular.getBanco());
			stmt.setInt(6, titular.getIdCliente());
			stmt.setLong(7, titular.getMontoMaximo());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Obtiene los titulares para 1 cliente
	 * 
	 * @return List<TitularTO>
	 * @author Jnarvaez
	 */
	public static List<TitularTO> obtenerTitulares(int cliente) {
		List<TitularTO> listaTitular = new ArrayList<>();
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_lst_titular (?)");
			){
			stmt.setInt(1, cliente);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TitularTO titular = new TitularTO();
				titular.setBanco(rs.getString("banco"));
				titular.setNombre(rs.getString("nombres"));
				titular.setRut(rs.getString("rut"));
				titular.setDv(rs.getString("dv"));
				titular.setCuentaCorriente(rs.getString("c_corriente"));
				titular.setIdCliente(rs.getInt("Clientes_idClientes"));
				titular.setMontoMaximo(rs.getLong("montoMaximo"));
				titular.setIdTitular(rs.getInt("idcuentas_anexas"));
				listaTitular.add(titular);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTitular;
	}
	
	
	
	
	/**
	 * Obtiene los titulares para 1 cliente
	 * 
	 * @return List<TitularTO>
	 * @author Jnarvaez
	 */
	public static TitularTO obtenerTitular(int codTitular) {
		TitularTO titular = new TitularTO();
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_lst_titularID (?)");
			){
			stmt.setInt(1, codTitular);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			
				titular.setBanco(rs.getString("banco"));
				titular.setNombre(rs.getString("nombres"));
				titular.setRut(rs.getString("rut"));
				titular.setDv(rs.getString("dv"));
				titular.setCuentaCorriente(rs.getString("c_corriente"));
				titular.setIdCliente(rs.getInt("Clientes_idClientes"));
				titular.setMontoMaximo(rs.getLong("montoMaximo"));
				titular.setIdTitular(rs.getInt("idcuentas_anexas"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return titular;
	}
	
	
	/**
	 * Obtiene los titulares Por nombre
	 * 
	 * @return List<TitularTO>
	 * @author Jnarvaez
	 */
	public static List<TitularTO> obtenerNombre(String nombre) {
		List<TitularTO> lista = new ArrayList<>();
		
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_lst_titular_nombre (?)");
			){
			stmt.setString(1, "%"+nombre+"%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TitularTO titular = new TitularTO();
				titular.setBanco(rs.getString("banco"));
				titular.setNombre(rs.getString("nombres"));
				titular.setRut(rs.getString("rut"));
				titular.setDv(rs.getString("dv"));
				titular.setCuentaCorriente(rs.getString("c_corriente"));
				titular.setIdCliente(rs.getInt("Clientes_idClientes"));
				titular.setMontoMaximo(rs.getLong("montoMaximo"));
				titular.setIdTitular(rs.getInt("idcuentas_anexas"));
				lista.add(titular);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
}
