package cl.startToken.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import cl.startToken.dao.ClientesDao;
import cl.startToken.to.ClientesTO;

public class SubirArchivos {
	
	private static final String FILENAME = "C:\\test\\Listado-Clientes-Armus-_1_.csv";
	
	public static void main(String[] arg) {
		try (BufferedReader in = new BufferedReader(
		           new InputStreamReader(new FileInputStream(FILENAME), "UTF-8"));) {

			String sCurrentLine;
			boolean primeraLinea = true;
			while ((sCurrentLine = in.readLine()) != null) {
				System.out.println(sCurrentLine);
				if(primeraLinea) {
					primeraLinea= false;
					continue;
				}
				ClientesTO cliente = new ClientesTO();
				String[] data = sCurrentLine.split(";");
				cliente.setNombreCompleto(data[0]);
				if(data[1].equals("7.7"))
					System.out.println("AQUI");
				cliente.setInteres_mensual(Double.parseDouble(data[1]));
				ClientesDao.crearClientes(cliente);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
