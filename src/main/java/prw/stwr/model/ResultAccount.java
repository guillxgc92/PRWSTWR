package prw.stwr.model;

import java.util.ArrayList;
import java.util.List;

public class ResultAccount {
	
	private Usuario usuario = null;
	
	private List<String> errores = new ArrayList<String>();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<String> getErrores() {
		return errores;
	}
}
