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
	private int rut;
	private String dv_cliente;
	private String banco;
	private String c_corriente;
	private double interes_mensual;
	private int monto_maximo_prestamo;

	
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

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getDv_cliente() {
		return dv_cliente;
	}

	public void setDv_cliente(String dv_cliente) {
		this.dv_cliente = dv_cliente;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
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

	public int getMonto_maximo_prestamo() {
		return monto_maximo_prestamo;
	}

	public void setMonto_maximo_prestamo(int monto_maximo_prestamo) {
		this.monto_maximo_prestamo = monto_maximo_prestamo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientesTO [nombreCompleto=");
		builder.append(nombreCompleto);
		builder.append(", rut=");
		builder.append(rut);
		builder.append(", dv_cliente=");
		builder.append(dv_cliente);
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
