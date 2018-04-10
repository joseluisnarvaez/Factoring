package cl.startToken.bean.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import cl.startToken.dao.ClientesDao;
import cl.startToken.to.ClientesTO;
import cl.startToken.utils.Validaciones;



@ManagedBean
@ViewScoped
public class IngresoClienteBeans implements Serializable {

	private static final long serialVersionUID = -5943861834526443610L;
	
	@Inject
	private transient ClientebeanTO to;
	private List<ClientesTO> listaClientes;
	private String rut;
	private String nombre;
	

	
	@PostConstruct
	public void init () {
		to = new ClientebeanTO();
	
		List<ClientesTO> lista = ClientesDao.obtenerClientes();
		
		to.setListaClientes(lista);
	}
	
	
	public void  buscar() {
		List<ClientesTO> listaFiltro = new ArrayList<>();
		if(to.getNombre() == null || to.getRut() == null) {
			  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Favor ingresar algun valor en las busquedas"));
				return;
		}
		if(!to.getRut().contains("-") || to.getRut().contains(".")) {
			  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Formato Rut invalido (solo lleva Guines ejm: 1-9)"));
			return;
		}

		int rut = 0 ;
		 if(!to.getRut().isEmpty()) {
				String[] rutValido = to.getRut().split("-");
				boolean validacionRut = Validaciones.validarRut(rutValido[0]);
				
				if(!validacionRut) {
					
				}
				rut = Integer.parseInt(rutValido[0]);
		 }
		if(!to.getNombre().isEmpty()) {
			for(ClientesTO cliente : to.getListaClientes()) {
				if(cliente.getNombreCompleto().contains(to.getNombre())) {
					listaFiltro.add(cliente);
				}
			}
		}
		else if(!to.getRut().isEmpty()) {
			for(ClientesTO cliente : to.getListaClientes()) {
				if(cliente.getRutDb() == rut) {
					listaFiltro.add(cliente);
				}
			}
		}
		else {
			
		}
		

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
