package prw.stwr.model;

import java.util.ArrayList;
import java.util.List;

public class ResultAccount {
	
	private Usuario usuario = null;
	
	private List<String> errores = new ArrayList<String>();

	public ResultAccount() {}
	
	public ResultAccount(String string) {
		// TODO Auto-generated constructor stub
	}

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
