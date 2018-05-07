package cl.startToken.bean.cheques;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import cl.startToken.dao.ChequesDao;
import cl.startToken.to.ChequeTO;
import cl.startToken.to.EstadosCheques;
import cl.startToken.utils.Validaciones;

@ManagedBean
@ViewScoped
public class BusquedaChequeBean implements Serializable {

	private static final long serialVersionUID = 581352965405659315L;
	
	private transient BusquedaChequeBeanTO to;

	public BusquedaChequeBeanTO getTo() {
		return to;
	}

	@PostConstruct
	public void init() {
		to = new BusquedaChequeBeanTO();
		
		List<EstadosCheques> estados = new ArrayList<>();
		
		for(EstadosCheques estado : EstadosCheques.values())
			estados.add(estado);
		
		to.setListaEstados(estados);
		
		
	}
	
	public void busquedaRutCliente() {
		
		if(to.getListaEstadosSeleccionados().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Tiene que seleccionar un estado."));
			return ;
		}
		List<ChequeTO> lista = new ArrayList<>();

		int rut = 0 ;
		 if(!to.getRut().isEmpty()) {
				String[] rutValido = to.getRut().split("-");
				boolean validacionRut = Validaciones.validarRut(to.getRut());
				
				if(!validacionRut) {
					  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Rut Invalido.)"));
						return;
				}
				rut = Integer.parseInt(rutValido[0]);
		 }
		
		
		for(EstadosCheques estado : to.getListaEstados()) {
			lista.addAll( ChequesDao.busquedaRutCliente(rut, estado));
		}
		
		PrimeFaces.current().executeScript("$('#btnToggleFiltros').click()");
		System.out.println("Sali");
	}
	
	public void busquedaRutAgente() {
		
		if(to.getListaEstadosSeleccionados().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Tiene que seleccionar un estado."));
			return ;
		}
		List<ChequeTO> lista = new ArrayList<>();

		int rut = 0 ;
		 if(!to.getAgente().isEmpty()) {
				String[] rutValido = to.getRut().split("-");
				boolean validacionRut = Validaciones.validarRut(to.getAgente());
				
				if(!validacionRut) {
					  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Rut Invalido.)"));
						return;
				}
				rut = Integer.parseInt(rutValido[0]);
		 }
		
		
		for(EstadosCheques estado : to.getListaEstados()) {
			lista.addAll( ChequesDao.busquedaRutAgente(rut, estado));
		}
		
		PrimeFaces.current().executeScript("$('#btnToggleFiltros').click()");
		System.out.println("Sali");
	}
	
	public void busquedaNCheque() {
		
		if(to.getListaEstadosSeleccionados().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Tiene que seleccionar un estado."));
			return ;
		}
		List<ChequeTO> lista = new ArrayList<>();

		if (to.getnCheque().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Debe ingresar un numero de cheque.)"));
			return;
		}
		int numCheque = 0;
		
		try {
		numCheque = Integer.parseInt(to.getnCheque());
		}catch(NumberFormatException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El numero de cheque debe ser solo numeros.)"));
		}
		
		
		for(EstadosCheques estado : to.getListaEstados()) {
			lista.addAll( ChequesDao.busquedaNumeroCheque(numCheque, estado));
		}
		
		PrimeFaces.current().executeScript("$('#btnToggleFiltros').click()");
		System.out.println("Sali");
	}
	
	
	
	
	
	
	


}