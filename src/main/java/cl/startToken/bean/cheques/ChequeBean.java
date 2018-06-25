package cl.startToken.bean.cheques;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import cl.startToken.dao.ChequesDao;
import cl.startToken.dao.ClientesDao;
import cl.startToken.dao.TitularDao;
import cl.startToken.to.ChequeTO;
import cl.startToken.to.ClientesTO;
import cl.startToken.to.TitularTO;
import cl.startToken.utils.SessionJsf;

@ManagedBean
@ViewScoped
public class ChequeBean implements Serializable {

	private static final long serialVersionUID = -5943861834526443610L;

	@Inject
	private transient ChequebeanTO to;

	@PostConstruct
	public void init() {
		SessionJsf.validaSession();
		to = new ChequebeanTO();
		//Fecha de ingreso
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		to.setHoy(new Date());
		to.setFechaIngreso(dateFormat.format(to.getHoy()));
		to.setSeleccionarTipoCheque(false);
		to.setCheque(new ChequeTO());
		to.setRenderDatosUsuarios(true);
	}

	public ChequebeanTO getTo() {
	
		return to;
	}
	
	  public List<String> autoCompleteCliente(String query) {
		  
		  	List<ClientesTO> lista = ClientesDao.obtenerClientes();
	        List<String> results = new ArrayList<>();
	        for(ClientesTO cliente :  lista) {
	            if(cliente.getNombreCompleto().contains(query)){
	            	results.add(cliente.getNombreCompleto());
	            }
	        }
	        return results;
	    }
	  
	  
	  public void cliente(){

		  	List<ClientesTO> lista = ClientesDao.obtenerClientes();
	        for(ClientesTO cliente :  lista) {
	            if(cliente.getNombreCompleto().equals(to.getNombreCliente())){
	            	cliente.setRut(cliente.getRutDb()+"-"+cliente.getDv_cliente());
	            	to.setCliente(cliente);
	            	to.setInteres(cliente.getInteres_mensual());
	            	to.setPintaDatos(true);
	            	break;
	            }
	        }
	        
	        List<TitularTO> titular = TitularDao.obtenerTitulares(to.getCliente().getIdClientes());
	        to.setTitulares(titular);
	        
	  }
	  
	  
	  public void chequeCliente() {
		  ChequeTO cheque = new ChequeTO();
		  cheque.setInteres(to.getCliente().getInteres_mensual());
		  to.setCheque(cheque);
	  }
	  
	  public void guardarCheque() {
		  List<ChequeTO> lista = new ArrayList<>();
		  
		  lista.add(to.getCheque());	
		  
		  to.getListaCheque().addAll(lista);
	  }
	  
	  @SuppressWarnings("deprecation")
	public void tipoCheque(){
		  System.out.println("Cheque seleccionado : "+ to.getTipoCheque());
		  to.setListaCheque(new ArrayList<>());
		  to.setSeleccionarTipoCheque(true);
		  
		  RequestContext.getCurrentInstance().execute("$('.acordion > div').click()");
	  }
	  
	  public void  onkey() {
		  if( to.getTipoCheque().equals("2")) {
			  this.calculoMontoDeCheque();
		  }
		  else if( to.getTipoCheque().equals("1")) {
			  
			  this.calculoChequeIngreso();
		  }
		  
		  
	  }
	  
	  
	  private void calculoChequeIngreso() {
		  
		  double interes = this.interes(to.getCheque().getDias());
		  
		  double interesTotal = (1- interes);
		  
		  Long totalInteres = Math.round((to.getCheque().getMontoCheque() * interesTotal));
		  
		  to.getCheque().setTotalPrestamo(totalInteres);
		  
	  }
	  
	  private void calculoMontoDeCheque() {
		  
		  double interes = this.interes(to.getCheque().getDias());
		  
		  double interesTotal = (1- interes);
		  
		  Long totalInteres = Math.round((to.getCheque().getMontoCheque() / interesTotal));
		  
		  to.getCheque().setTotalPrestamo(totalInteres);
		  
		  
	  }
	  
	  public void cantidadDias() {
		  int difDias = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(to.getHoy());
		
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		String inputString1 = myFormat.format(to.getHoy());
		String inputString2 = myFormat.format(to.getVencimiento());

		try {
		    Date date1 = myFormat.parse(inputString1);
		    Date date2 = myFormat.parse(inputString2);
		    long diff = date2.getTime() - date1.getTime();
		    difDias = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		to.getCheque().setFechaVencimiento(inputString2);
		to.getCheque().setDias(difDias);
		onkey();
	  }
	  
	  
	  private double interes(int dias){
		 
		  double interesDecimal =to.getInteres()/100; 
		  double interes =((interesDecimal/30)*dias);
		  to.getCheque().setInteres(to.getInteres());
		  return interes;
		  
	  }
	  
	  public void agregarCheque() {
		  if(to.getCheque().getCodTitular() == null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Tiene que seleccionar un Titular."));
				return ;
		  }
		  if(to.getCheque().getNumeroCheque() == null || to.getCheque().getNumeroCheque().isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Tiene que ingresar un Numero de Cheque."));
				return ;
		  }
		  to.getCheque().setRutCliente(to.getCliente().getRutDb());
		  to.getCheque().setFechaInicial(to.getFechaIngreso());
		  to.getListaCheque().add(to.getCheque());
		  to.setCheque(new ChequeTO());
		  to.setVencimiento(null);
	  }
	  
	  
	  public void guardarProceso() {
		  ChequesDao.crearCheque(to.getListaCheque());
		  to.setListaCheque(new ArrayList<>());
		  to.setCliente(new ClientesTO());
		  to.setPintaDatos(false);
		  to.setNombreCliente("");;
		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Los Cheques se ingresaron correctamente."));
	  }
	  
	  public void eliminaCheque(String numCheque) {
		  List<ChequeTO> listaSalida = new ArrayList<>();
		  for(ChequeTO item : to.getListaCheque()) {
			  if(!item.getNumeroCheque().equals(numCheque)) {
				  listaSalida.add(item);
			  }
		  }
		  
		  to.setListaCheque(listaSalida);
		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cheque eliminado."));
	  }
	  
}
