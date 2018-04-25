package cl.startToken.bean.cheques;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import cl.startToken.dao.ClientesDao;
import cl.startToken.to.Bancos;
import cl.startToken.to.ChequeTO;
import cl.startToken.to.ClientesTO;

@ManagedBean
@ViewScoped
public class ChequeBean implements Serializable {

	private static final long serialVersionUID = -5943861834526443610L;

	@Inject
	private transient ChequebeanTO to;
	final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 

	@PostConstruct
	public void init() {
		to = new ChequebeanTO();
		//Fecha de ingreso
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		to.setHoy(new Date());
		to.setFechaIngreso(dateFormat.format(to.getHoy()));
		to.setSeleccionarTipoCheque(false);
		to.setCheque(new ChequeTO());
		
	}

	public ChequebeanTO getTo() {
	
		return to;
	}
	
	  public List<String> autoCompleteCliente(String query) {
			List<ClientesTO> lista = new ArrayList<>();
			for(int i = 0 ; i< 11 ; i++){
				
			
			ClientesTO cliente = new ClientesTO();
			
			cliente.setBanco(i+1);
			
			cliente.setGlosaBanco(Bancos.obtenerPorCodigo(cliente.getBanco()).getGlosa());
			cliente.setC_corriente("13245674812");;
			cliente.setDv_cliente("3");
			cliente.setInteres_mensual(0.3);;
			
			cliente.setMonto_maximo_prestamo(500000);;
			cliente.setNombreCompleto("ASDFADSFA ASDFASDF aFDASD");;
			cliente.setRut("17449355-3");
			cliente.setRutDb(17449355);
			
			lista.add(cliente);
			}
		  
//		  	List<ClientesTO> lista = ClientesDao.obtenerClientes();
	        List<String> results = new ArrayList<>();
	        for(ClientesTO cliente :  lista) {
	            if(cliente.getNombreCompleto().contains(query)){
	            	results.add(cliente.getNombreCompleto());
	            }
	        }
	        return results;
	    }
	  
	  
	  public void cliente(){
		  List<ClientesTO> lista = new ArrayList<>();
			for(int i = 0 ; i< 11 ; i++){
				
			
			ClientesTO cliente = new ClientesTO();
			
			cliente.setBanco(i+1);
			
			cliente.setGlosaBanco(Bancos.obtenerPorCodigo(cliente.getBanco()).getGlosa());
			cliente.setC_corriente("13245674812");;
			cliente.setDv_cliente("3");
			cliente.setInteres_mensual(0.3);;
			
			cliente.setMonto_maximo_prestamo(500000);;
			cliente.setNombreCompleto("ASDFADSFA ASDFASDF aFDASD");;
			cliente.setRut("17449355-3");
			cliente.setRutDb(17449355);
			
			lista.add(cliente);
			}
//		  
//		  	List<ClientesTO> lista = ClientesDao.obtenerClientes();
	        for(ClientesTO cliente :  lista) {
	            if(cliente.getNombreCompleto().equals(to.getNombreCliente())){
	            	cliente.setRut(cliente.getRutDb()+"-"+cliente.getDv_cliente());
	            	to.setCliente(cliente);
	            	to.setInteres(cliente.getInteres_mensual());
	            	to.setPintaDatos(true);
	            	break;
	            }
	        }
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
	  
	  public void tipoCheque(){
		  System.out.println("Cheque seleccionado : "+ to.getTipoCheque());
		  to.setListaCheque(new ArrayList<>());
		  to.setSeleccionarTipoCheque(true);
	  }
	  
	  public void  onkey() {
		  if( to.getTipoCheque().equals("2")) {
			  this.calculoChequeIngreso();
		  }
		  else if( to.getTipoCheque().equals("1")) {
			  this.calculoMontoDeCheque();
		  }
		  
		  
	  }
	  
	  
	  private void calculoChequeIngreso() {
		  
		  double interes = this.interes(to.getCheque().getDias());
		  
		  Long totalInteres = Math.round((to.getCheque().getMontoCheque() * interes)/100);
		  
		  to.getCheque().setTotalPrestamo(to.getCheque().getMontoCheque() + totalInteres);
		  
		  
		  
		  
		  
		  	
	  }
	  
	  private void calculoMontoDeCheque() {
		  
	  }
	  
	  public void cantidadDias() {
		
		SimpleDateFormat datedia = new SimpleDateFormat("dd");
		SimpleDateFormat datemes = new SimpleDateFormat("MM");
		
		int diahoy = Integer.parseInt(datedia.format(to.getHoy()));
		int meshoy = Integer.parseInt(datemes.format(to.getHoy()));
		
		int diavencimiento = Integer.parseInt(datedia.format(to.getVencimiento()));
		int mesvencimiento = Integer.parseInt(datemes.format(to.getVencimiento()));
		
		int difMeses= mesvencimiento - meshoy;
		int total = 0;
		
		if(difMeses > 0)
			total += difMeses * 30;
		
		int difDias = diavencimiento - diahoy;
		if(difDias > 0 )
			total += difDias;
		
		
		to.getCheque().setDias(total);
	  }
	  
	  
	  private double interes(int dias){
		  
		  double interes =((dias/30)*to.getInteres());
		  
		  return interes;
		  
	  }
	  
	  
}
