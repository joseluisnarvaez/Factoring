package cl.startToken.bean.cheques;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		 else {
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Debe ingresar Rut.)"));
			 return ;
		 }
		
		
		for(String estado : to.getListaEstadosSeleccionados()) {
			
			lista.addAll( ChequesDao.busquedaRutCliente(rut, EstadosCheques.obtenerPorCodigo(Integer.parseInt(estado))));
		}
		
		to.setListaCheque(lista);
		
		PrimeFaces.current().executeScript("alert('$('#btnToggleFiltros').click()');");

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
		
		
		for(String estado : to.getListaEstadosSeleccionados()) {
			lista.addAll( ChequesDao.busquedaRutAgente(rut, EstadosCheques.obtenerPorCodigo(Integer.parseInt(estado))));
		}
		to.setListaCheque(lista);
		PrimeFaces.current().executeScript("$('#btnToggleFiltros').click()");
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
		
		
		for(String estado : to.getListaEstadosSeleccionados()) {
			lista.addAll( ChequesDao.busquedaNumeroCheque(numCheque, EstadosCheques.obtenerPorCodigo(Integer.parseInt(estado))));
		}
		
		PrimeFaces.current().executeScript("$('#btnToggleFiltros').click()");
		
		to.setListaCheque(lista);
	}
	
	
	public void busquedaPorFechaIngreso() {
		
		if(to.getListaEstadosSeleccionados().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Tiene que seleccionar un estado."));
			return ;
		}
		List<ChequeTO> lista = new ArrayList<>();

		if (to.getFechaInicio() == null) {
			FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Debe ingresar Una fecha de ingreso.)"));
			return;
		}
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fecha =  df.format(to.getFechaInicio());
		
		for(String estado : to.getListaEstadosSeleccionados()) {
			lista.addAll( ChequesDao.busquedaFIngreso(fecha, EstadosCheques.obtenerPorCodigo(Integer.parseInt(estado))));
		}
		
		PrimeFaces.current().executeScript("$('#btnToggleFiltros').click()");
		
		to.setListaCheque(lista);
	}
	
	

	public void busquedaPorFechaVencimiento() {
		
		if(to.getListaEstadosSeleccionados().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Tiene que seleccionar un estado."));
			return ;
		}
		List<ChequeTO> lista = new ArrayList<>();

		if (to.getFechaVencimiento() == null) {
			FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Debe ingresar Una fecha de Termino."));
			return;
		}
		
		DateFormat df = new SimpleDateFormat("dd MM yyyy");
		String fecha =  df.format(to.getFechaVencimiento());
		
		for(String estado : to.getListaEstadosSeleccionados()) {
			lista.addAll( ChequesDao.busquedaFVencimiento(fecha, EstadosCheques.obtenerPorCodigo(Integer.parseInt(estado))));
		}
		
		PrimeFaces.current().executeScript("$('#btnToggleFiltros').click()");
		
		to.setListaCheque(lista);
	}
	
	
	
	
	


}
