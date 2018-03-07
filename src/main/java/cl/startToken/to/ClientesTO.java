package cl.startToken.to;

/**
 * Clase que representa la tabla de clientes de la base de datos
 * 
 * @author jNarvaez
 *
 */
public class ClientesTO {

	private String nombre;
	private String aPaterno;
	private String aMaterno;
	private int rut;
	private String dv_cliente;
	private String banco;
	private String c_corriente;
	private double interes_mensual;
	private int monto_maximo_prestamo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getaPaterno() {
		return aPaterno;
	}

	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	public String getaMaterno() {
		return aMaterno;
	}

	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientesTO [nombre=");
		builder.append(nombre);
		builder.append(", aPaterno=");
		builder.append(aPaterno);
		builder.append(", aMaterno=");
		builder.append(aMaterno);
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
