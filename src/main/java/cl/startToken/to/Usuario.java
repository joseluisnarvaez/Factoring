package cl.startToken.to;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 4779177569198631537L;
	private int id;
	private String usuario;
	private String contrasenia;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id=").append(id).append(", usuario=").append(usuario).append(", contrasenia=")
				.append(contrasenia).append("]");
		return builder.toString();
	}
	
	
}
