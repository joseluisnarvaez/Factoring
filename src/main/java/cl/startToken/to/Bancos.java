package cl.startToken.to;


/**
 * Enum que implementa la lista de bancos.
 * @author jNarvaez
 *
 */
public enum Bancos {
	BBVA 			(1,"Banco BBVA"),
	BCI 			(2,"Banco Crédito e Inversiones BCI"),
	CHILE 			(3,"Banco Chile - Edwards-Citi"),
	DESARROLLO 		(4,"Banco del Desarrollo"),
	ESTADO 			(5,"Banco Estado"),
	FALABELLA 		(6,"Banco Falabella"),
	ITAU 			(7,"Banco Itaú"),
	INTERNACIONAL 	(8,"Banco Internacional"),
	RIPLEY 			(9,"Banco Ripley"),
	SANTANDER 		(10,"Banco Santander Santiago"),
	SECURITY 		(11,"Banco Security"),
	BICE 			(12,"Bice"),
	CONSORCIO 		(13,"Consorcio"),
	COOPEUCH 		(14,"Coopeuch"),
	CORPBANCA 		(15,"Corpbanca"),
	HSBC 			(16,"HSBC Bank (Chile)");
	
	
	private String glosa;
	
	private int codBanco;

	private Bancos( int codBanco,String glosa) {
		this.glosa = glosa;
		this.codBanco = codBanco;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public int getCodBanco() {
		return codBanco;
	}

	public void setCodBanco(int codBanco) {
		this.codBanco = codBanco;
	}
	
	
	public static  Bancos obtenerPorCodigo(int cod) {
		
		for (Bancos banco :  Bancos.values()) {
			if(banco.getCodBanco() == cod)
				return banco;
		}	
		
		return null;
		
	}
	
}
