package cl.startToken.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import cl.startToken.dao.ClientesDao;
import cl.startToken.to.ClientesTO;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView crearCliente() {
		return null;
		
	}

	@RequestMapping(value = "/",method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody String obtenerCliente() {
		List<ClientesTO> retorno = ClientesDao.obtenerClientes();
		return new Gson().toJson(retorno);
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ModelAndView actualizarCliente() {
		return null;
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ModelAndView eliminarCliente() {
		return null;
		
	}
}
