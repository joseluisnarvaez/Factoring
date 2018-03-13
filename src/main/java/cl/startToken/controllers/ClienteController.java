package cl.startToken.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import cl.startToken.dao.ClientesDao;
import cl.startToken.to.ClientesTO;
import cl.startToken.utils.Validaciones;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView crearCliente() {
		return null;

	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String obtenerClientes() {

		List<ClientesTO> retorno = ClientesDao.obtenerClientes();
		return new Gson().toJson(retorno);

	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ModelAndView actualizarCliente() {
		return null;

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE ,produces = "application/json")
	public @ResponseBody String eliminarCliente(@PathVariable("id") long id) {
		return "1";

	}

	@RequestMapping(value = "/cliente", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String obtenerCliente(@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "rut") String rut) {

		List<ClientesTO> listaFiltrar = ClientesDao.obtenerClientes();
		
		if(!Validaciones.validarRut(rut)) {
			return "1";
		}
		String[] ruts = rut.split("-");
		int parteNumerica = Integer.parseInt(ruts[0]);
		List<ClientesTO> listaRetorno = new ArrayList<>();
		for (ClientesTO cliente : listaFiltrar) {
			if (cliente.getNombreCompleto().contains(nombre) && cliente.getRut() == parteNumerica) {
				listaRetorno.add(cliente);
			}
		}

		return new Gson().toJson(listaRetorno);

	}
}
