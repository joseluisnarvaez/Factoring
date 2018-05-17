package cl.startToken.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.startToken.dao.conexion.Conexion;
import cl.startToken.to.Usuario;

public class LoginDao {
	
	public static Usuario busquedaRutCliente(String usuario){
		Usuario usuarioTO = null;
		try(Connection con = Conexion.getConnection(); 
			PreparedStatement stmt = con.prepareStatement("call sp_lst_usuario_nombre (?)");
			){
			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usuarioTO =  new Usuario();
				usuarioTO.setId(rs.getInt("idusuario"));
				usuarioTO.setUsuario(rs.getString("usuario"));
				usuarioTO.setContrasenia(rs.getString("contrasenia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioTO;
	}

}
