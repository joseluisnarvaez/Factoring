package cl.startToken.utils;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import cl.startToken.to.Usuario;
/**
 * clase que valida si el usuario tiene session inicializada
 * @author JNarvaez
 *
 */
public class SessionJsf {
	
	
	public static void seteaSession(Usuario usuario) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		usuario.setContrasenia("");
		session.setAttribute("usuario", usuario);
	}
	
	
	public static void validaSession() {
		try {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null) {
			FacesContext contex = FacesContext.getCurrentInstance();
			try {
				contex.getExternalContext().redirect( "/Factoring" );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}catch (Exception e) {
			FacesContext contex = FacesContext.getCurrentInstance();
			try {
				contex.getExternalContext().redirect( "/Factoring" );
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
