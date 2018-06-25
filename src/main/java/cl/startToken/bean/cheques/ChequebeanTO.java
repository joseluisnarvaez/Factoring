package cl.startToken.bean.cheques;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cl.startToken.to.ChequeTO;
import cl.startToken.to.ClientesTO;
import cl.startToken.to.TitularTO;

public class ChequebeanTO implements Serializable {

	private static final long serialVersionUID = 4746449932137978887L;
	
	private String fechaIngreso;
	
	private ClientesTO clienteIngresado;
	
	private String nombreCliente;
	
	private ClientesTO cliente;
	
	private boolean pintaDatos;
	
	private List<ChequeTO> listaCheque;
	
	private boolean seleccionarTipoCheque;
	
	private boolean renderDatosUsuarios;
	
	private ChequeTO cheque;
	
	private String tipoCheque;
	
	private double interes;
	
	private Date vencimiento;
	
	private Date hoy;
	
	private List<TitularTO> titulares;
	
	private TitularTO titularSeleccionado;
	
	
	
	
	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public ClientesTO getClienteIngresado() {
		return clienteIngresado;
	}

	public void setClienteIngresado(ClientesTO clienteIngresado) {
		this.clienteIngresado = clienteIngresado;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public ClientesTO getCliente() {
		return cliente;
	}

	public void setCliente(ClientesTO cliente) {
		this.cliente = cliente;
	}

	public boolean isPintaDatos() {
		return pintaDatos;
	}

	public void setPintaDatos(boolean pintaDatos) {
		this.pintaDatos = pintaDatos;
	}

	public List<ChequeTO> getListaCheque() {
		return listaCheque;
	}

	public void setListaCheque(List<ChequeTO> listaCheque) {
		this.listaCheque = listaCheque;
	}

	public ChequeTO getCheque() {
		return cheque;
	}

	public void setCheque(ChequeTO cheque) {
		this.cheque = cheque;
	}

	public String getTipoCheque() {
		return tipoCheque;
	}

	public void setTipoCheque(String tipoCheque) {
		this.tipoCheque = tipoCheque;
	}

	public boolean isSeleccionarTipoCheque() {
		return seleccionarTipoCheque;
	}

	public void setSeleccionarTipoCheque(boolean seleccionarTipoCheque) {
		this.seleccionarTipoCheque = seleccionarTipoCheque;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public Date getHoy() {
		return hoy;
	}

	public void setHoy(Date hoy) {
		this.hoy = hoy;
	}

	public List<TitularTO> getTitulares() {
		return titulares;
	}

	public void setTitulares(List<TitularTO> titulares) {
		this.titulares = titulares;
	}

	public TitularTO getTitularSeleccionado() {
		return titularSeleccionado;
	}

	public void setTitularSeleccionado(TitularTO titularSeleccionado) {
		this.titularSeleccionado = titularSeleccionado;
	}

	public boolean isRenderDatosUsuarios() {
		return renderDatosUsuarios;
	}

	public void setRenderDatosUsuarios(boolean renderDatosUsuarios) {
		this.renderDatosUsuarios = renderDatosUsuarios;
	}
	
	
	
	
}
