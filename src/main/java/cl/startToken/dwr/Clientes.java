package cl.startToken.dwr;

import java.util.List;

import cl.startToken.dao.ClientesDao;
import cl.startToken.to.ClientesTO;

/**
 * DWR para la pagina de clientes donde se tendra la logica de clientes
 * 
 * @author jNarvaez
 *
 */
public class Clientes {

	/**
	 * Obtiene la lista de clientes de la base de datos
	 * 
	 * @return
	 */
	public List<ClientesTO> obtenerClientes() {

		return ClientesDao.obtenerClientes();

	}
	
	
	public void gravarCliente() {
		
		
		
	}

}
