package cl.startToken.to;

public class ChequeTO {
	
	private long montoAEntregar;
	private double interes;
	private String fechaVencimiento;
	private int dias;
	private long montoCheque;
	private long numeroCheque;
	
	
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
	public long getNumeroCheque() {
		return numeroCheque;
	}
	public void setNumeroCheque(long numeroCheque) {
		this.numeroCheque = numeroCheque;
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
		builder.append("]");
		return builder.toString();
	}
}
