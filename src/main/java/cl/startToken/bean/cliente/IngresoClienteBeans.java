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
	
	@PostConstruct
	public void init () {
		to = new ClientebeanTO();
	
		List<ClientesTO> lista = ClientesDao.obtenerClientes();
		
		to.setListaClientes(lista);
		
		to.setNuevoCliente(new ClientesTO());
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
	
	
	public void eliminaCliente(int idCliente) {
		
		ClientesDao.eliminaCliente(idCliente);
		List<ClientesTO> lista = ClientesDao.obtenerClientes();
		
		to.setListaClientes(lista);
		
		
	}
	
	
	public void buscarClienteID(int idCliente) {
		
		
		List<ClientesTO> lista = ClientesDao.obtenerClientes();
		
		for (ClientesTO clientesTO : lista) {
			if(clientesTO.getIdClientes() == idCliente) {
				clientesTO.setRut(clientesTO.getRutDb()+"-"+clientesTO.getDv_cliente());
				to.setClienteActualizar(clientesTO);
				
				break;
			}
		}
		
	}
	
	public void actualizarCliente() {
		ClientesDao.actualizarClientes(to.getClienteActualizar());
		List<ClientesTO> lista = ClientesDao.obtenerClientes();
		
		to.setListaClientes(lista);
	}
	
	
	public void guardarCliente() {
		String[] rut = to.getNuevoCliente().getRut().split("-");
		
		to.getNuevoCliente().setRutDb(Integer.parseInt(rut[0]));
		to.getNuevoCliente().setDv_cliente(rut[1]);
		ClientesDao.crearClientes(to.getNuevoCliente());
		
	}

	public ClientebeanTO getTo() {
		return to;
	}

}
