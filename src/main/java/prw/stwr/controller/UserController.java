package prw.stwr.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import prw.stwr.model.ResultAccount;
import prw.stwr.model.Usuario;
import prw.stwr.service.RolUsuarioService;
import prw.stwr.service.UsuarioService;

@Controller
public class UserController {

	@SuppressWarnings("unused")
	@Autowired
	private RolUsuarioService objRolUsuarioService;
	
	@Autowired
	private UsuarioService objUsuarioService;
	
	@GetMapping(value = "/account")
	public String account( Model model) {
		
		Usuario usuario = null;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
	    	
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        String username = userDetails.getUsername();
	        usuario = objUsuarioService.getUsuarioByUsername(username);

	        model.addAttribute("usuario", usuario);

	    }
		return "subviews/account";
	}
	
	
	@PostMapping(value = "/register", produces = "application/json")
	@ResponseBody
	public ResultAccount regUser(@RequestBody Usuario registroUsuario, Model model) {
		
		ResultAccount resultAccount = new ResultAccount();
		try {
			Pattern userTagReg = Pattern.compile("[a-z0-9_-]{3,15}");
			Pattern passwordReg = Pattern.compile("[a-zA-Z0-9(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])]{8,32}");
			Pattern emailReg = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
			Pattern nameReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1 ]{0,32}|^$");
			Pattern firstSurNameReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1]{0,32}|^$");
			Pattern secondSurNameReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1]{0,32}|^$");
			
			String userTag = registroUsuario.getUsername();
			String password = registroUsuario.getPassword();
			String email = registroUsuario.getEmail();
			String name = registroUsuario.getName();
			String firstSurName = registroUsuario.getFirstSurName();
			String secondSurName = registroUsuario.getSecondSurName();
			
			Matcher matcherUserTag = userTagReg.matcher(userTag);
			Matcher matcherPassword = passwordReg.matcher(password);
			Matcher matcherEmail = emailReg.matcher(email);
			Matcher matcherName = nameReg.matcher(name);
			Matcher matcherfirstSurName = firstSurNameReg.matcher(firstSurName);
			Matcher matcherSecondSurname = secondSurNameReg.matcher(secondSurName);
			
			if (!matcherUserTag.matches()) {
				resultAccount.getErrores().add("Nombre de usuario no válido. \n");
			}
			if(!matcherPassword.matches()) {
				resultAccount.getErrores().add("Contraseña no válida. \n");
			}
			if(!matcherEmail.matches()) {
				resultAccount.getErrores().add("Email no válido. \n");
			}
			if(!matcherName.matches()) {
				resultAccount.getErrores().add("Nombre no válido. \n");
			}
			if(!matcherfirstSurName.matches()) {
				resultAccount.getErrores().add("Primer apellido no válido. \n");
			}
			if(!matcherSecondSurname.matches()) {
				resultAccount.getErrores().add("Segundo apellido no válido. \n");
			}
			if(resultAccount.getErrores().size() == 0){
				//Setear rol de nuevo usuario en 1 = Jugador como estandar en caso de que el jugador cree una campaña cambiar a idRol = 2[GM].
				registroUsuario.setIdRolUser(objRolUsuarioService.getAll().get(0));
				registroUsuario.setActiverow(true);
				registroUsuario.setUsertag(userTag.toLowerCase().trim());
				registroUsuario.setPassword(password.trim());
				registroUsuario.setEmail(email.toLowerCase().trim());
				registroUsuario.setName(name.toLowerCase().trim());
				registroUsuario.setFirstSurName(firstSurName.toLowerCase().trim());
				registroUsuario.setSecondSurName(secondSurName.toLowerCase().trim());
				
				//Insertar el registro de usuario en la tabla de usuarios.
				@SuppressWarnings("unused")
				Usuario nuevoUsuario = objUsuarioService.insertUsuario(registroUsuario);
				System.out.println("nuevo usuario registrado: " + nuevoUsuario);
				
				resultAccount.setUsuario(nuevoUsuario);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultAccount;
	}
	
	
	@PostMapping(value = "/updateuser", produces = "application/json")
	@ResponseBody
	public ResultAccount updateUser(@RequestBody Usuario updateUsuario, Model model) {
		
		ResultAccount resultAccount = new ResultAccount();
		try {
			Pattern userTagReg = Pattern.compile("[a-z0-9_-]{3,15}");
			Pattern passwordReg = Pattern.compile("[a-zA-Z0-9(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])]{8,32}");
			Pattern emailReg = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
			Pattern nameReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1 ]{0,32}|^$");
			Pattern firstSurNameReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1]{0,32}|^$");
			Pattern secondSurNameReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1]{0,32}|^$");
			
			String userTag = updateUsuario.getUsername();
			String password = updateUsuario.getPassword();
			String email = updateUsuario.getEmail();
			String name = updateUsuario.getName();
			String firstSurName = updateUsuario.getFirstSurName();
			String secondSurName = updateUsuario.getSecondSurName();
			
			Matcher matcherUserTag = userTagReg.matcher(userTag);
			Matcher matcherPassword = passwordReg.matcher(password);
			Matcher matcherEmail = emailReg.matcher(email);
			Matcher matcherName = nameReg.matcher(name);
			Matcher matcherfirstSurName = firstSurNameReg.matcher(firstSurName);
			Matcher matcherSecondSurname = secondSurNameReg.matcher(secondSurName);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			
			if (!matcherUserTag.matches()) {
				resultAccount.getErrores().add("Nombre de usuario no válido. \n");
			}
			if(!matcherPassword.matches()) {
				resultAccount.getErrores().add("Contraseña no válida. \n");
			}
			if(!matcherEmail.matches()) {
				resultAccount.getErrores().add("Email no válido. \n");
			}
			if(!matcherName.matches()) {
				resultAccount.getErrores().add("Nombre no válido. \n");
			}
			if(!matcherfirstSurName.matches()) {
				resultAccount.getErrores().add("Primer apellido no válido. \n");
			}
			if(!matcherSecondSurname.matches()) {
				resultAccount.getErrores().add("Segundo apellido no válido. \n");
			}
			if(resultAccount.getErrores().size() == 0){
				
				Usuario usuarioActual = objUsuarioService.getUsuarioByUsername(userDetails.getUsername());

				usuarioActual.setUsertag(userTag);
				usuarioActual.setEmail(email.trim());
				usuarioActual.setPassword(password.trim());
				usuarioActual.setName(name.trim());
				usuarioActual.setFirstSurName(firstSurName.trim());
				usuarioActual.setSecondSurName(secondSurName.trim());
				
				Usuario nuevoUsuario = objUsuarioService.updateUsuario(usuarioActual);
				System.out.println("Usuario modificado: " + nuevoUsuario.getUsername());
				
				resultAccount.setUsuario(usuarioActual);
				
				model.addAttribute("usuario", resultAccount);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultAccount;
	}
	
	@PostMapping("/deleteUser")
	public ResponseEntity<String> deleteuser(HttpServletRequest request) {
	    try {
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			Usuario usuarioActual = objUsuarioService.getUsuarioByUsername(userDetails.getUsername());

			if (userDetails.getUsername().equals(usuarioActual.getUsername())) {
	            objUsuarioService.deleteUsuario(usuarioActual.getIdUser());
	            request.getSession().invalidate();
	        }

	        return ResponseEntity.ok("Usuario eliminado con éxito.");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"" + e.getMessage() + "\"}");
	    }
	}
}
