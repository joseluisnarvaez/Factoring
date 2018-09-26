package cl.startToken.to;

import java.io.Serializable;

/**
 * Clase que representa la tabla de clientes de la base de datos
 * 
 * @author jNarvaez
 *
 */
public class ClientesTO implements Serializable {

	private static final long serialVersionUID = -4871164744088837917L;
	private int idClientes;
	private String nombreCompleto;
	private int banco;
	private String glosaBanco;
	private String c_corriente;
	private double interes_mensual;
	private long monto_maximo_prestamo;

	
	public int getIdClientes() {
		return idClientes;
	}


	public void setIdClientes(int idClientes) {
		this.idClientes = idClientes;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}

	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public int getBanco() {
		return banco;
	}

	public void setBanco(int banco) {
		this.banco = banco;
	}

	public String getC_corriente() {
		return c_corriente;
	}

	public void setC_corriente(String c_corriente) {
		this.c_corriente = c_corriente;
	}

	public double getInteres_mensual() {
		return interes_mensual;
	}

	public void setInteres_mensual(double interes_mensual) {
		this.interes_mensual = interes_mensual;
	}

	public long getMonto_maximo_prestamo() {
		return monto_maximo_prestamo;
	}

	public void setMonto_maximo_prestamo(long monto_maximo_prestamo) {
		this.monto_maximo_prestamo = monto_maximo_prestamo;
	}
	

	public String getGlosaBanco() {
		return glosaBanco;
	}


	public void setGlosaBanco(String glosaBanco) {
		this.glosaBanco = glosaBanco;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientesTO [nombreCompleto=");
		builder.append(nombreCompleto);
		builder.append(", banco=");
		builder.append(banco);
		builder.append(", c_corriente=");
		builder.append(c_corriente);
		builder.append(", interes_mensual=");
		builder.append(interes_mensual);
		builder.append(", monto_maximo_prestamo=");
		builder.append(monto_maximo_prestamo);
		builder.append("]");
		return builder.toString();
	}

}
