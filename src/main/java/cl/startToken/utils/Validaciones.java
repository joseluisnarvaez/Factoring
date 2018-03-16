package cl.startToken.utils;

import java.util.HashMap;
import java.util.Map;

import cl.startToken.to.ClientesTO;

public class Validaciones {

	public static boolean validarRut(String rut) {

		boolean validacion = false;
		try {
			rut = rut.toUpperCase();
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

			char dv = rut.charAt(rut.length() - 1);

			int m = 0, s = 1;
			for (; rutAux != 0; rutAux /= 10) {
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
			}
			if (dv == (char) (s != 0 ? s + 47 : 75)) {
				validacion = true;
			}

		} catch (java.lang.NumberFormatException e) {
		} catch (Exception e) {
		}
		return validacion;
	}
	
	
	public static ClientesTO validaCliente (String entrada){

		Map<String, String> mapValores = new HashMap<>(); 
		for(String item : entrada.split("&")){
			
			String[] datos = item.split("=");
			mapValores.put(datos[0],datos[1]);
		}
		
		ClientesTO cliente = new ClientesTO();
		cliente.setIdClientes(Integer.parseInt(mapValores.get("id")));
		cliente.setNombreCompleto(mapValores.get("nombreCompleto").replace("+"," "));
		cliente.setBanco(mapValores.get("banco"));
		cliente.setC_corriente(mapValores.get("c_corriente"));
		cliente.setMonto_maximo_prestamo(Long.parseLong(mapValores.get("monto_maximo_prestamo")));
		boolean rutValido = validarRut(mapValores.get("rut"));
		if(!rutValido){
			return null;
		}
		String[] rut = mapValores.get("rut").split("-");
		cliente.setRutDb(Integer.parseInt(rut[0]));
		cliente.setDv_cliente(rut[1]);
		
		return cliente;
			
		
		
		
	}

}
