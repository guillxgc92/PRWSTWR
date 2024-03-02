package prw.stwr.service;

import java.util.List;
import java.util.Set;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import prw.stwr.model.Usuario;
import prw.stwr.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAll(){
		
		return usuarioRepository.findAll();
	}
	
	@SuppressWarnings("null")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Usuario insertUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}

	//Buscar usuarios en BBD para el login 
	@Override
	@Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        Usuario user = usuarioRepository.findByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getRolname()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(

        		username,
                user.getPassword(),
                authorities
        );
    }
	
	@SuppressWarnings("null")
	@Transactional
	public Usuario updateUsuario(Usuario usuario) {
			
			return usuarioRepository.save(usuario);
	}
	
	public Usuario getUsuarioByUsername(String username) {
		
		return usuarioRepository.findByUsername(username);
	}
	
	public Usuario getUsuarioById(Long idUser) {
		
		return usuarioRepository.findByIdUser(idUser);
	}
	
	@Transactional
	public void deleteUsuario(long idUser) {
		try {
			usuarioRepository.deleteByIdUser(idUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

