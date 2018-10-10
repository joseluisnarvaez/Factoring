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
import cl.startToken.dao.ClientesDao;
import cl.startToken.dao.TitularDao;
import cl.startToken.to.ChequeTO;
import cl.startToken.to.ClientesTO;
import cl.startToken.to.EstadosCheques;
import cl.startToken.to.TitularTO;
import cl.startToken.utils.SessionJsf;
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
		SessionJsf.validaSession();
		to = new BusquedaChequeBeanTO();
		
		List<EstadosCheques> estados = new ArrayList<>();
		
		for(EstadosCheques estado : EstadosCheques.values())
			estados.add(estado);
		
		to.setListaEstados(estados);
		to.setListaCheque(new ArrayList<>());
		
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
		limpiarVariables();
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
		if(!Validaciones.validacionSoloNumeros(to.getNombre())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El numero de cheque solo pueden ser numeros."));
			return;
		}
		long numCheque = 0;
		
		try {
		numCheque = Long.parseLong(to.getnCheque());
		}catch(NumberFormatException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El numero de cheque debe ser solo numeros."));
		}
		
		
		for(String estado : to.getListaEstadosSeleccionados()) {
			lista.addAll( ChequesDao.busquedaNumeroCheque(numCheque, EstadosCheques.obtenerPorCodigo(Integer.parseInt(estado))));
		}
		
		PrimeFaces.current().executeScript("$('#btnToggleFiltros').click()");
		limpiarVariables();
		to.setListaCheque(lista);
	}
	
	
	public void busquedaPorMontoCheque() {
		
		if(to.getListaEstadosSeleccionados().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Tiene que seleccionar un estado."));
			return ;
		}
		List<ChequeTO> lista = new ArrayList<>();

		if (to.getMontoCheque() == null) {
			FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Debe ingresar Monto para la busqueda."));
			return;
		}
		if (to.getMontoCheque().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Debe ingresar Monto para la busqueda."));
			return;
		}
		if (!Validaciones.validacionSoloNumeros(to.getMontoCheque())) {
			FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Debe Monto debe ser solo numeros."));
			return;
		}
		
		for(String estado : to.getListaEstadosSeleccionados()) {
			lista.addAll( ChequesDao.busquedaMontoCheque(to.getMontoCheque(), EstadosCheques.obtenerPorCodigo(Integer.parseInt(estado))));
		}
		
		PrimeFaces.current().executeScript("$('#btnToggleFiltros').click()");
		limpiarVariables();
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
		limpiarVariables();
		to.setListaCheque(lista);
	}
	

	public void busquedaPorNombreTitular() {
		
		if(to.getListaEstadosSeleccionados().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Tiene que seleccionar un estado."));
			return ;
		}
		if (to.getTitular().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Debe ingresar el nombre de un titular."));
			return;
		}
		if(!Validaciones.validacionSoloLetras(to.getTitular())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El nombre del Titular solo pueden ser Letras."));
			return;
		}
		
		List<ChequeTO> lista = new ArrayList<>();


		List<TitularTO> listaTitulares = TitularDao.obtenerNombre(to.getTitular());
		
		for (TitularTO titularTO : listaTitulares) {
			lista.addAll( ChequesDao.busquedaIdTitular(titularTO.getIdTitular()));
		}

		List<ChequeTO> listaSalida = new ArrayList<>();
		for(String estado : to.getListaEstadosSeleccionados()) {
			for(ChequeTO cheque : lista) {
				if(cheque.getEstado().getCodEstado()== Integer.parseInt(estado))
					listaSalida.add(cheque);
			}
			
		}
		
		PrimeFaces.current().executeScript("$('#btnToggleFiltros').click()");
		
		to.setListaCheque(listaSalida);
		limpiarVariables();
	}
	

	public void busquedaPorNombreCliente() {
		
		if(to.getListaEstadosSeleccionados().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Tiene que seleccionar un estado."));
			return ;
		}
		if (to.getNombre().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Debe ingresar el nombre de un titular."));
			return;
		}
		if(!Validaciones.validacionSoloLetras(to.getNombre())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El nombre del Cliente solo pueden ser letras."));
			return;
		}
		List<ClientesTO> listaClientes = ClientesDao.obtenerClientes();
		ClientesTO clienteSeleccionado = null;
		
		for (ClientesTO cliente : listaClientes) {
			if(cliente.getNombreCompleto().contains(to.getNombre())) {
				clienteSeleccionado = cliente;
				break;
			}
		}
		
		List<ChequeTO> listaSalida = new ArrayList<>();
		for(String estado : to.getListaEstadosSeleccionados()) {
			
			listaSalida.addAll(ChequesDao.busquedaRutCliente(clienteSeleccionado.getIdClientes(), EstadosCheques.obtenerPorCodigo(Integer.parseInt(estado))));
			
		}
		
		PrimeFaces.current().executeScript("$('#btnToggleFiltros').click()");
		
		to.setListaCheque(listaSalida);
		limpiarVariables();
	}
	
	public void actualizaEstados() {
		if(to.getListaCheque() == null || to.getListaCheque().isEmpty())
			return;
		
		for(ChequeTO cheque :to.getListaCheque()) {
			ChequesDao.actualizaEstados(cheque.getId(), cheque.getEstado());
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Estados Actualizados correctamente"));
		
	}
	
	private void limpiarVariables() {
		to.setAgente("");
		to.setMontoCheque("");
		to.setFechaVencimiento(null);;
		to.setListaEstadosSeleccionados(new ArrayList<>());;
		to.setnCheque("");
		to.setNombre("");
		to.setRut("");
		to.setTitular("");
	}

}
