package cl.startToken.to;

import java.io.Serializable;

public class TitularTO implements Serializable {
	
	private static final long serialVersionUID = 5954053410827360988L;
	private int idTitular;
	private String nombre;
	private String rut;
	private String dv;
	private String banco;
	private String cuentaCorriente;
	private Long montoMaximo;
	private int idCliente;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getCuentaCorriente() {
		return cuentaCorriente;
	}
	public void setCuentaCorriente(String cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}
	public Long getMontoMaximo() {
		return montoMaximo;
	}
	public void setMontoMaximo(Long montoMaximo) {
		this.montoMaximo = montoMaximo;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDv() {
		return dv;
	}
	public void setDv(String dv) {
		this.dv = dv;
	}
	public int getIdTitular() {
		return idTitular;
	}
	public void setIdTitular(int idTitular) {
		this.idTitular = idTitular;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TitularTO [nombre=");
		builder.append(nombre);
		builder.append(", rut=");
		builder.append(rut);
		builder.append(", dv=");
		builder.append(dv);
		builder.append(", banco=");
		builder.append(banco);
		builder.append(", cuentaCorriente=");
		builder.append(cuentaCorriente);
		builder.append(", montoMaximo=");
		builder.append(montoMaximo);
		builder.append(", idCliente=");
		builder.append(idCliente);
		builder.append("]");
		return builder.toString();
	}
	public String obtenerBanco() {
		Bancos banco = Bancos.obtenerPorCodigo(Integer.parseInt(this.banco));
		return banco.getGlosa();
	}

}

