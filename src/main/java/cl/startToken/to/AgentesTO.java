package cl.startToken.to;

import java.io.Serializable;

public class AgentesTO implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2714000849729349225L;
	private int id;
	private String nombres;
	private int rutDb;
	private String dv;
	private String rut;
	private int banco;
	private String glosaBanco;
	private String cCorriente;
	private long monto;
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
	public int getRutDb() {
		return rutDb;
	}
	public void setRutDb(int rutDb) {
		this.rutDb = rutDb;
	}
	public String getDv() {
		return dv;
	}
	public void setDv(String dv) {
		this.dv = dv;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public int getBanco() {
		return banco;
	}
	public void setBanco(int banco) {
		this.banco = banco;
	}
	public String getcCorriente() {
		return cCorriente;
	}
	public void setcCorriente(String cCorriente) {
		this.cCorriente = cCorriente;
	}
	public long getMonto() {
		return monto;
	}
	public void setMonto(long monto) {
		this.monto = monto;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getGlosaBanco() {
		return glosaBanco;
	}
	public void setGlosaBanco(String glosaBanco) {
		this.glosaBanco = glosaBanco;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AgentesTO [id=");
		builder.append(id);
		builder.append(", nombres=");
		builder.append(nombres);
		builder.append(", rutDb=");
		builder.append(rutDb);
		builder.append(", dv=");
		builder.append(dv);
		builder.append(", rut=");
		builder.append(rut);
		builder.append(", banco=");
		builder.append(banco);
		builder.append(", cCorriente=");
		builder.append(cCorriente);
		builder.append(", monto=");
		builder.append(monto);
		builder.append(", estado=");
		builder.append(estado);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
