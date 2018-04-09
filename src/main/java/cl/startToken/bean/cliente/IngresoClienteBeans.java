package cl.startToken.bean.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import cl.startToken.dao.ClientesDao;
import cl.startToken.to.ClientesTO;



@Named
@ViewScoped
public class IngresoClienteBeans implements Serializable {

	private static final long serialVersionUID = -5943861834526443610L;
	
	
	private transient ClientebeanTO to;
	private List<ClientesTO> listaClientes;
	private String rut;
	private String nombre;
	

	
	@PostConstruct
	public void init () {
		to = new ClientebeanTO();
		List<ClientesTO> lista = new ArrayList<>();
		for(int i = 0 ; i< 11 ; i++){
			
		
		ClientesTO cliente = new ClientesTO();
		
		cliente.setBanco("BBVAS");
		cliente.setC_corriente("13245674812");;
		cliente.setDv_cliente("3");
		cliente.setInteres_mensual(0.3);;
		
		cliente.setMonto_maximo_prestamo(500000);;
		cliente.setNombreCompleto("ASDFADSFA ASDFASDF aFDASD "+i);;
		cliente.setRut("17449355-3");
		cliente.setRutDb(17449355);
		
		lista.add(cliente);
		}
//		List<ClientesTO> lista = ClientesDao.obtenerClientes();
		
		to.setListaClientes(lista);
	}
	
	
	public void  buscar() {
		System.out.println("en la busqueda");
	}
	
	
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

	public ClientebeanTO getTo() {
		return to;
	}

}
