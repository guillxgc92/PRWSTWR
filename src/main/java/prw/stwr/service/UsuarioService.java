package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.Usuario;
import prw.stwr.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAll(){
		
		return usuarioRepository.findAll();
	}
	
	@SuppressWarnings("null")
	public Usuario insertUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}
}
