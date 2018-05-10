package cl.startToken.to;

import java.io.Serializable;

public class ChequeTO implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7834334865439972485L;
	private long montoAEntregar;
	private double interes;
	private String fechaVencimiento;
	private int dias;
	private long montoCheque;
	private String numeroCheque;
	private long totalPrestamo;
	private int rutCliente;
	private ClientesTO cliente;
	private int id;
	
	private String fechaInicial;
	
	
	public long getMontoAEntregar() {
		return montoAEntregar;
	}
	public void setMontoAEntregar(long montoAEntregar) {
		this.montoAEntregar = montoAEntregar;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public long getMontoCheque() {
		return montoCheque;
	}
	public void setMontoCheque(long montoCheque) {
		this.montoCheque = montoCheque;
	}
	public String getNumeroCheque() {
		return numeroCheque;
	}
	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}
	public long getTotalPrestamo() {
		return totalPrestamo;
	}
	public void setTotalPrestamo(long totalPrestamo) {
		this.totalPrestamo = totalPrestamo;
	}
	
	public int getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(int rutCliente) {
		this.rutCliente = rutCliente;
	}
	
	public String getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public ClientesTO getCliente() {
		return cliente;
	}
	public void setCliente(ClientesTO cliente) {
		this.cliente = cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChequeTO [montoAEntregar=");
		builder.append(montoAEntregar);
		builder.append(", interes=");
		builder.append(interes);
		builder.append(", fechaVencimiento=");
		builder.append(fechaVencimiento);
		builder.append(", dias=");
		builder.append(dias);
		builder.append(", montoCheque=");
		builder.append(montoCheque);
		builder.append(", numeroCheque=");
		builder.append(numeroCheque);
		builder.append(", totalPrestamo=");
		builder.append(totalPrestamo);
		builder.append(", rutCliente=");
		builder.append(rutCliente);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", id=");
		builder.append(id);
		builder.append(", fechaInicial=");
		builder.append(fechaInicial);
		builder.append("]");
		return builder.toString();
	}

}
