package cl.startToken.to;

import java.io.Serializable;

public class AgentesTO implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2714000849729349225L;
	private int id;
	private String nombres;
	private double interes;
	private int estado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AgentesTO [id=");
		builder.append(id);
		builder.append(", nombres=");
		builder.append(nombres);
		builder.append(", interes=");
		builder.append(interes);
		builder.append(", estado=");
		builder.append(estado);
		builder.append("]");
		return builder.toString();
	}
	
}
