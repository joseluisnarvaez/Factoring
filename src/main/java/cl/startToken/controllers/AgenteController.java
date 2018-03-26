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

import cl.startToken.dao.AgentesDao;
import cl.startToken.to.AgentesTO;
import cl.startToken.utils.Validaciones;

@Controller
@RequestMapping("/agentes")
public class AgenteController {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody String crearAgente(@RequestBody String jsonCliente) {

		AgentesTO agente = new Gson().fromJson(jsonCliente, AgentesTO.class);
		String[] ruts = agente.getRut().split("-");
		agente.setRutDb(Integer.parseInt(ruts[0]));
		agente.setDv(ruts[1]);
		AgentesDao.crearAgente(agente);
		
		return "1";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String obtenerAgente() {

		List<AgentesTO> retorno = AgentesDao.obtenerAgentes();
		return new Gson().toJson(retorno);

	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public @ResponseBody String actualizarAgente(@RequestBody String jsonCliente) {

		AgentesTO agente = new Gson().fromJson(jsonCliente, AgentesTO.class);
		String[] ruts = agente.getRut().split("-");
		agente.setRutDb(Integer.parseInt(ruts[0]));
		agente.setDv(ruts[1]);
		AgentesDao.actualizarAgentes(agente);
		return "1";
	}

	@RequestMapping(value = "/elimina/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String eliminarAgente(@PathVariable("id") String id) {
		AgentesDao.eliminaAgente(Integer.parseInt(id));
		return "1";
	}

	@RequestMapping(value = "/agente", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String obtenerAgente(@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "rut") String rut) {

		List<AgentesTO> listaFiltrar = AgentesDao.obtenerAgentes();
		if (!Validaciones.validarRut(rut)) {
			return "1";
		}
		String[] ruts = rut.split("-");
		int parteNumerica = Integer.parseInt(ruts[0]);
		List<AgentesTO> listaRetorno = new ArrayList<>();
		for (AgentesTO cliente : listaFiltrar) {
			if (cliente.getNombres().contains(nombre) && cliente.getRutDb() == parteNumerica) {
				listaRetorno.add(cliente);
			}
		}
		return new Gson().toJson(listaRetorno);

	}

	@RequestMapping(value = "/agente/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String obtenerAgentebyId(@PathVariable("id") String id) {

		List<AgentesTO> listaFiltrar = AgentesDao.obtenerAgentes();
		AgentesTO clienteRetorno = null;

		for (AgentesTO cliente : listaFiltrar) {
			if (cliente.getId() == Integer.parseInt(id)) {
				clienteRetorno = cliente;
			}
		}
		return new Gson().toJson(clienteRetorno);
	}
}
