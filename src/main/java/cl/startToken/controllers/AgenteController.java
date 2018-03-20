package cl.startToken.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cl.startToken.dao.ClientesDao;
import cl.startToken.to.ClientesTO;
import cl.startToken.utils.Validaciones;

@Controller
@RequestMapping("/agentes")
public class AgenteController {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody String crearAgente( @RequestBody String jsonCliente) {
		
		ClientesTO cliente = new Gson().fromJson(jsonCliente, ClientesTO.class);
		String[] ruts = cliente.getRut().split("-");
		cliente.setRutDb(Integer.parseInt(ruts[0]));
		cliente.setDv_cliente(ruts[1]);
		ClientesDao.crearClientes(cliente);
		return "1";

	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String obtenerAgente() {

		List<ClientesTO> retorno = ClientesDao.obtenerClientes();
		return new Gson().toJson(retorno);

	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public  @ResponseBody String  actualizarAgente(@RequestBody String jsonCliente) {
		 ClientesTO cliente = Validaciones.validaCliente(jsonCliente);
		 if(cliente == null){
			 return "-1";	 
		 }
		 ClientesDao.actualizarClientes(cliente);
		return "1";
	}
	
	@RequestMapping(value = "/elimina/{id}", method = RequestMethod.GET , produces = "application/json")
	public @ResponseBody String eliminarAgente(@PathVariable("id") String id) {
		ClientesDao.eliminaCliente(Integer.parseInt(id));
		return "1";
	}

	@RequestMapping(value = "/agente", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String obtenerAgente(@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "rut") String rut) {

		List<ClientesTO> listaFiltrar = ClientesDao.obtenerClientes();
		if(!Validaciones.validarRut(rut)) {
			return "1";
		}
		String[] ruts = rut.split("-");
		int parteNumerica = Integer.parseInt(ruts[0]);
		List<ClientesTO> listaRetorno = new ArrayList<>();
		for (ClientesTO cliente : listaFiltrar) {
			if (cliente.getNombreCompleto().contains(nombre) && cliente.getRutDb() == parteNumerica) {
				listaRetorno.add(cliente);
			}
		}
		return new Gson().toJson(listaRetorno);

	}
	
	@RequestMapping(value = "/agente/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String obtenerAgentebyId(@PathVariable("id") String id) {

		List<ClientesTO> listaFiltrar = ClientesDao.obtenerClientes();
			ClientesTO clienteRetorno = null;
		
		for (ClientesTO cliente : listaFiltrar) {
			if (cliente.getIdClientes() == Integer.parseInt(id)) {
				clienteRetorno = cliente;
			}
		}
		return new Gson().toJson(clienteRetorno);
	}
}
