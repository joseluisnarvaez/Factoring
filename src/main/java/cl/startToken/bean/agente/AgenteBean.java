package cl.startToken.bean.agente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import cl.startToken.dao.AgentesDao;
import cl.startToken.to.AgentesTO;
import cl.startToken.to.Bancos;
import cl.startToken.utils.Validaciones;

@ManagedBean
@ViewScoped
public class AgenteBean implements Serializable {

	private static final long serialVersionUID = -5943861834526443610L;

	@Inject
	private transient AgentebeanTO to;

	@PostConstruct
	public void init() {
		to = new AgentebeanTO();
		//
		// List<ClientesTO> lista = new ArrayList<>();
		// for(int i = 0 ; i< 11 ; i++){
		//
		//
		// ClientesTO cliente = new ClientesTO();
		//
		// cliente.setBanco("BBVAS");
		// cliente.setC_corriente("13245674812");;
		// cliente.setDv_cliente("3");
		// cliente.setInteres_mensual(0.3);;
		//
		// cliente.setMonto_maximo_prestamo(500000);;
		// cliente.setNombreCompleto("ASDFADSFA ASDFASDF aFDASD");;
		// cliente.setRut("17449355-3");
		// cliente.setRutDb(17449355);
		//
		// lista.add(cliente);
		// }
		//
		List<Bancos> listaBancos = new ArrayList<>();
		
		for (Bancos bancos : Bancos.values()) {
			listaBancos.add(bancos);
		}
		
		to.setListaBancos(listaBancos);
//		llenarTabla();
		to.setNuevoAgente(new AgentesTO());
	}

	public void buscar() {
		List<AgentesTO> listaFiltro = new ArrayList<>();
		if (to.getNombre() == null || to.getRut() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error",
					"Favor ingresar algun valor en las busquedas."));
			return;
		}
		if (!to.getRut().contains("-") || to.getRut().contains(".")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error",
					"Formato Rut invalido (solo lleva Guion ejm: 1-9)."));
			return;
		}

		int rut = 0;
		if (!to.getRut().isEmpty()) {
			String[] rutValido = to.getRut().split("-");
			boolean validacionRut = Validaciones.validarRut(to.getRut());

			if (!validacionRut) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Rut Invalido.)"));
				return;
			}
			rut = Integer.parseInt(rutValido[0]);
		}
		if (!to.getNombre().isEmpty()) {
			for (AgentesTO agente : to.getListaAgente()) {
				if (agente.getNombres().contains(to.getNombre())) {
					listaFiltro.add(agente);
				}
			}
		}
		if (!to.getRut().isEmpty()) {
			for (AgentesTO agente : to.getListaAgente()) {
				if (agente.getRutDb() == rut) {
					listaFiltro.add(agente);
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error en los criterios de busqueda."));
			return;
		}

	}

	public void eliminaAgente(int idAgente) {

		AgentesDao.eliminaAgente(idAgente);
		llenarTabla();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Agente eliminado Exitosamente"));

	}

	public void buscarAgenteID(int idCliente) {

		List<AgentesTO> lista = AgentesDao.obtenerAgentes();

		for (AgentesTO agente : lista) {
			if (agente.getId() == idCliente) {
				agente.setRut(agente.getRutDb() + "-" + agente.getDv());
				to.setAgenteActualizar(agente);
				break;
			}
		}

	}

	public void actualizarAgente() {
		AgentesDao.actualizarAgentes(to.getAgenteActualizar());
		llenarTabla();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Agente Actualizado Exitosamente"));
	}

	public void guardarAgente() {
		String[] rut = to.getNuevoAgente().getRut().split("-");
		
		if (!to.getNuevoAgente().getRut().contains("-") || to.getNuevoAgente().getRut().contains(".")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error",
					"Formato Rut invalido (solo lleva Guion ejm: 1-9)."));
			return;
		}
		try {
			to.getNuevoAgente().setRutDb(Integer.parseInt(rut[0]));
			to.getNuevoAgente().setDv(rut[1]);
			if(!Validaciones.validarRut(to.getNuevoAgente().getRut())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Rut Invalido"));	
				return;
			}	
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al ingresar el Rut"));
		}
		AgentesDao.crearAgente(to.getNuevoAgente());
		to.setNuevoAgente(new AgentesTO());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Agente Creado Exitosamente"));

	}

	public AgentebeanTO getTo() {
		return to;
	}

	private void llenarTabla() {
		List<AgentesTO> lista = AgentesDao.obtenerAgentes();

		to.setListaAgente(lista);
	}

}
