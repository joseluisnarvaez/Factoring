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
import cl.startToken.utils.SessionJsf;
import cl.startToken.utils.Validaciones;

/**
 * Clase bean de agente
 * 
 * @author JNarvaez
 *
 */

@ManagedBean
@ViewScoped
public class AgenteBean implements Serializable {

	private static final long serialVersionUID = -5943861834526443610L;

	@Inject
	private transient AgentebeanTO to;

	@PostConstruct
	public void init() {
		SessionJsf.validaSession();
		to = new AgentebeanTO();
	
		List<Bancos> listaBancos = new ArrayList<>();
		
		for (Bancos bancos : Bancos.values()) {
			listaBancos.add(bancos);
		}
		
		to.setListaBancos(listaBancos);
		llenarTabla();
		to.setNuevoAgente(new AgentesTO());
	}

	public void buscar() {
		List<AgentesTO> listaFiltro = new ArrayList<>();
		if (to.getNombre() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error",
					"Favor ingresar algun valor en las busquedas."));
			return;
		}
		if(!Validaciones.validacionSoloLetras(to.getNombre())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El nombre solo pueden ser letras."));
			return;
		}
		if (!to.getNombre().isEmpty()) {
			for (AgentesTO agente : to.getListaAgente()) {
				if (agente.getNombres().toUpperCase().contains(to.getNombre().toUpperCase())) {
					listaFiltro.add(agente);
				}
			}
		}
		
		to.setListaAgente(listaFiltro);

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
		if(!Validaciones.validacionSoloLetras(to.getNuevoAgente().getNombres())){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "En el campo nombre debe ingresar solo letras"));
			return;
		}
		
		if(!Validaciones.validacionSoloNumeros(to.getNuevoAgente().getInteresIngresado())){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "En el campo interés debe ingresar solo Numeros"));
			return;
		}
		
		to.getNuevoAgente().setInteres(Double.valueOf(to.getNuevoAgente().getInteresIngresado()));
		
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
