package prw.stwr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prw.stwr.model.RolUsuario;
import prw.stwr.repository.RolUsuarioRepository;

@Service
public class RolUsuarioService {
	
	@Autowired
	private RolUsuarioRepository rolUsuarioRepository; //Nos habilita la funcionalidad del JPA
	
	//Construccion de métodos que se quieran
	
	public List<RolUsuario> getAll(){ //devuelve toda la lita de roles de usuario
		
		return rolUsuarioRepository.findAll();
	}
}
