package cl.startToken.bean.cliente;

import java.io.Serializable;
import java.util.List;

import cl.startToken.to.Bancos;
import cl.startToken.to.ClientesTO;

public class ClientebeanTO implements Serializable {

	private static final long serialVersionUID = 2637758829962441585L;

	private List<ClientesTO> listaClientes;
	private String rut;
	private String nombre;
	private ClientesTO clienteActualizar;
	private ClientesTO nuevoCliente;
	private List<Bancos> listaBancos;

	public List<ClientesTO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<ClientesTO> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ClientesTO getClienteActualizar() {
		return clienteActualizar;
	}

	public void setClienteActualizar(ClientesTO clienteActualizar) {
		this.clienteActualizar = clienteActualizar;
	}

	public ClientesTO getNuevoCliente() {
		return nuevoCliente;
	}

	public void setNuevoCliente(ClientesTO nuevoCliente) {
		this.nuevoCliente = nuevoCliente;
	}

	public List<Bancos> getListaBancos() {
		return listaBancos;
	}

	public void setListaBancos(List<Bancos> listaBancos) {
		this.listaBancos = listaBancos;
	}
	
	
	
}
