package cl.startToken.to;

public enum EstadosCheques {
	
	PENDIENTE 			(1,"Pendiente"),
	PAGADO				(2,"Pagado"),
	RECHAZADO 			(3,"Rechazado");
	
	
	private String glosa;
	
	private int codEstado;

	private EstadosCheques( int codEstado,String glosa) {
		this.glosa = glosa;
		this.codEstado = codEstado;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public int getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}

	public static  EstadosCheques obtenerPorCodigo(int cod) {
		
		for (EstadosCheques estado :  EstadosCheques.values()) {
			if(estado.getCodEstado() == cod)
				return estado;
		}	
		
		return null;
		
	}

}
