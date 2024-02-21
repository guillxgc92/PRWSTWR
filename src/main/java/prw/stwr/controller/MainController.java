package prw.stwr.controller;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import prw.stwr.model.Campaign;
import prw.stwr.model.Galaxy;
import prw.stwr.model.Planet;
import prw.stwr.model.Regions;
import prw.stwr.model.Territory;
import prw.stwr.model.Usuario;
import prw.stwr.service.GalaxyService;
import prw.stwr.service.PlanetService;
import prw.stwr.service.RegionsService;
import prw.stwr.service.RolUsuarioService;
import prw.stwr.service.TerritoryService;
import prw.stwr.service.UsuarioService;

@Controller
@SessionAttributes({"mensaje"})
public class MainController {
	
	@SuppressWarnings("unused")
	@Autowired
	private RolUsuarioService objRolUsuarioService;
	
	@Autowired
	private UsuarioService objUsuarioService;
	
	@Autowired
	private GalaxyService objGalaxyService;
	
	@Autowired
	private RegionsService objRegionsService;
	
	@Autowired
	private PlanetService objPlanetService;
	
	@Autowired
	private TerritoryService objTerritoryService;
	
	
	@GetMapping(value = {"/", "/index"})
	public String index(HttpSession session, Model model) {
		
		@SuppressWarnings("unused")
		List<Usuario> listaUsuarios = objUsuarioService.getAll();
		
		// Obtiene el objeto Usuario de la variable de sesión
	    Usuario usuarioRegistrado = (Usuario) session.getAttribute("usuarioRegistrado");

	    model.addAttribute("usuarioRegistrado", usuarioRegistrado);
		
		return "index";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		
		return "subviews/login";
	}

	@GetMapping(value = "/register")
	public String register(Model model) {
		
		String mensaje = (String) model.getAttribute("mensaje");
		model.addAttribute("mensaje", mensaje);
		
		return "subviews/register";
	}
	
	@GetMapping(value = "/campaign")
	public String campaign(Model model) {
		
		List<Galaxy> listaGalaxies = objGalaxyService.getAll();
		model.addAttribute("listaGalaxias", listaGalaxies);
		
		List<Regions> listaRegion = objRegionsService.getAll();
		model.addAttribute("listaRegiones", listaRegion); 
		
		List<Planet> listaPlanet = objPlanetService.getAll();
		model.addAttribute("listaPlanetas", listaPlanet); 
		
		List<Territory> listaTerritory = objTerritoryService.getAll();
		model.addAttribute("listaTerritorios", listaTerritory); 
		
		return "subviews/campaign";
	}
	
	
	@PostMapping(value = "/processFormCampaign", produces = "application/json")
	@ResponseBody
	public Campaign regCampaign(Campaign registroCampaign) {
		
		
		
		return registroCampaign;
	}

	
	@PostMapping(value = "/registerprocess", produces = "application/json")
	@ResponseBody
	public Usuario regUser(Usuario registroUsuario, HttpSession session, RedirectAttributes redirectAttributes, Model model) {
		
		String mensajeuserTag = "";
		String mensajepassword = "";
		String mensajeemail = "";
		String mensajename = "";
		String mensajefirstSurName = "";
		String mensajesecondSurName = "";
		
		//REGEX
		Pattern userTagReg = Pattern.compile("[a-z0-9_-]{3,15}");
		Pattern passwordReg = Pattern.compile("[a-zA-Z0-9(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])]{8,32}");
		Pattern emailReg = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
		Pattern nameReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1 ]{0,32}|^$");
		Pattern firstSurNameReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1]{0,32}|^$");
		Pattern secondSurNameReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1]{0,32}|^$");
		
		String userTag = registroUsuario.getUsertag().trim();
		String password = registroUsuario.getPassword();
		String email = registroUsuario.getEmail().trim();
		String name = registroUsuario.getName().trim();
		String firstSurName = registroUsuario.getFirstSurName().trim();
		String secondSurName = registroUsuario.getSecondSurName().trim();
		
		Matcher matcherUserTag = userTagReg.matcher(userTag);
		Matcher matcherPassword = passwordReg.matcher(password);
		Matcher matcherEmail = emailReg.matcher(email);
		Matcher matcherName = nameReg.matcher(name);
		Matcher matcherfirstSurName = firstSurNameReg.matcher(firstSurName);
		Matcher matcherSecondSurname = secondSurNameReg.matcher(secondSurName);
		
		if (!matcherUserTag.matches()) {
			mensajeuserTag = "Nombre de usuario no válido.";
		    model.addAttribute("mensajeuserTag", mensajeuserTag);
		}else if(!matcherPassword.matches()) {
			mensajepassword = "Contraseña no válida.";
		    model.addAttribute("mensajepassword", mensajepassword);
		}else if(!matcherEmail.matches()) {
			mensajeemail = "Email no válido.";
		    model.addAttribute("mensajeemail", mensajeemail);
		}else if(!matcherName.matches()) {
			mensajename = "Nombre no válido.";
		    model.addAttribute("mensajename", mensajename);
		}else if(!matcherfirstSurName.matches()) {
			mensajefirstSurName = "Primer apellido no válido.";
		    model.addAttribute("mensajefirstSurName", mensajefirstSurName);
		}else if(!matcherSecondSurname.matches()) {
			mensajesecondSurName = "Segundo apellido no válido.";
		    model.addAttribute("mensajesecondSurName", mensajesecondSurName);
		}else {
			//Setear rol de nuevo usuario en 1 = Jugador como estandar en caso de que el jugador cree una campaña cambiar a idRol = 2[GM].
			registroUsuario.setIdRolUser(objRolUsuarioService.getAll().get(0));
			registroUsuario.setActiverow(true);
			registroUsuario.setUsertag(userTag.toLowerCase());
			registroUsuario.setPassword(password);
			registroUsuario.setEmail(email.toLowerCase());
			registroUsuario.setName(name.toLowerCase());
			registroUsuario.setFirstSurName(firstSurName.toLowerCase());
			registroUsuario.setSecondSurName(secondSurName.toLowerCase());
			
			//Insertar el registro de usuario en la tabla de usuarios.
			@SuppressWarnings("unused")
			Usuario nuevoUsuario = objUsuarioService.insertUsuario(registroUsuario);
			
			//Datos almacenados en variable de sesión.
			session.setAttribute("usuarioRegistrado", registroUsuario);

			redirectAttributes.addFlashAttribute("redirect", true);
		}

		return registroUsuario;
	}
}
