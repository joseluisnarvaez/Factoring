package cl.startToken.bean.cheques;

import java.io.Serializable;

import cl.startToken.to.ClientesTO;

public class ChequebeanTO implements Serializable {

	private static final long serialVersionUID = 4746449932137978887L;
	
	private String fechaIngreso;
	
	private ClientesTO clienteIngresado;
	
	private String nombreCliente;
	
	private ClientesTO cliente;
	
	private boolean pintaDatos;

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public ClientesTO getClienteIngresado() {
		return clienteIngresado;
	}

	public void setClienteIngresado(ClientesTO clienteIngresado) {
		this.clienteIngresado = clienteIngresado;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public ClientesTO getCliente() {
		return cliente;
	}

	public void setCliente(ClientesTO cliente) {
		this.cliente = cliente;
	}

	public boolean isPintaDatos() {
		return pintaDatos;
	}

	public void setPintaDatos(boolean pintaDatos) {
		this.pintaDatos = pintaDatos;
	}
	
	
	
	
}
