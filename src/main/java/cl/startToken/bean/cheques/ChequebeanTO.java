package cl.startToken.bean.cheques;

import java.io.Serializable;
import java.util.List;

import cl.startToken.to.AgentesTO;

public class ChequebeanTO implements Serializable {

	private static final long serialVersionUID = 2637758829962441585L;

	private List<AgentesTO> listaAgente;
	private String rut;
	private String nombre;
	private AgentesTO agenteActualizar;
	private AgentesTO nuevoAgente;

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

}
