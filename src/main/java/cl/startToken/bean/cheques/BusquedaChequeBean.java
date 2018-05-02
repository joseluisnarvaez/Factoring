package cl.startToken.bean.cheques;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cl.startToken.to.EstadosCheques;

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
	
	
	
	
	
	
	


}
