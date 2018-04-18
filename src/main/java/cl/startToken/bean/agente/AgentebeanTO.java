package cl.startToken.bean.agente;

import java.io.Serializable;
import java.util.List;

import cl.startToken.to.AgentesTO;
import cl.startToken.to.Bancos;

public class AgentebeanTO implements Serializable {

	private static final long serialVersionUID = 2637758829962441585L;

	private List<AgentesTO> listaAgente;
	private String rut;
	private String nombre;
	private AgentesTO agenteActualizar;
	private AgentesTO nuevoAgente;
	private List<Bancos> listaBancos;

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

	public List<AgentesTO> getListaAgente() {
		return listaAgente;
	}

	public void setListaAgente(List<AgentesTO> listaAgente) {
		this.listaAgente = listaAgente;
	}

	public AgentesTO getAgenteActualizar() {
		return agenteActualizar;
	}

	public void setAgenteActualizar(AgentesTO agenteActualizar) {
		this.agenteActualizar = agenteActualizar;
	}

	public AgentesTO getNuevoAgente() {
		return nuevoAgente;
	}

	public void setNuevoAgente(AgentesTO nuevoAgente) {
		this.nuevoAgente = nuevoAgente;
	}

	public List<Bancos> getListaBancos() {
		return listaBancos;
	}

	public void setListaBancos(List<Bancos> listaBancos) {
		this.listaBancos = listaBancos;
	}
	

}
