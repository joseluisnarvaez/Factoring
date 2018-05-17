package cl.startToken.bean.login;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cl.startToken.dao.LoginDao;
import cl.startToken.to.Usuario;

@ManagedBean
@SessionScoped
public class Login {
	
	private transient LoginTO to;
	
	public LoginTO getTo() {
		return to;
	}


	@PostConstruct
	public void init () {
		to = new LoginTO();
	}
	

	public void inicioSession(){
		
		Usuario usuario = LoginDao.busquedaRutCliente(this.to.getUsuario());
		
		if(usuario != null) {
				if(usuario.getUsuario().equals(to.getUsuario()) 
				&& usuario.getContrasenia().equals(to.getContrasenia())) {
					FacesContext contex = FacesContext.getCurrentInstance();
		            try {
						contex.getExternalContext().redirect( "cheque/BusquedaCheque.jsf" );
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Usuario o contraseña Invalida."));
					 return;
				}
			
		}
		else {
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Usuario o contraseña Invalida."));
			 return;
		}
		
	}
}
