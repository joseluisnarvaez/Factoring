package cl.startToken.bean.cheques;

import java.util.Date;
import java.util.List;

import cl.startToken.to.ChequeTO;
import cl.startToken.to.EstadosCheques;

public class BusquedaChequeBeanTO {
	
	private List<EstadosCheques> listaEstados;
	private List<String> listaEstadosSeleccionados;
	private Date fechaInicio;
	private Date fechaVencimiento;
	private String nombre;
	private String agente;
	private String titular;
	private String nCheque;
	private String rut;
	
	private List<ChequeTO> listaCheque;
	
	
	public List<EstadosCheques> getListaEstados() {
		return listaEstados;
	}
	public void setListaEstados(List<EstadosCheques> listaEstados) {
		this.listaEstados = listaEstados;
	}
	public List<String> getListaEstadosSeleccionados() {
		return listaEstadosSeleccionados;	
	}
	public void setListaEstadosSeleccionados(List<String> listaEstadosSeleccionados) {
		this.listaEstadosSeleccionados = listaEstadosSeleccionados;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAgente() {
		return agente;
	}
	public void setAgente(String agente) {
		this.agente = agente;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getnCheque() {
		return nCheque;
	}
	public void setnCheque(String nCheque) {
		this.nCheque = nCheque;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public List<ChequeTO> getListaCheque() {
		return listaCheque;
	}
	public void setListaCheque(List<ChequeTO> listaCheque) {
		this.listaCheque = listaCheque;
	}
	

}
