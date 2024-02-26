package prw.stwr.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
@SessionAttributes({"usuarioRegistrado"})
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
	public String index(Model model) {
		
		
		System.out.println(objUsuarioService);
		
		return "index";
	}
	
	
	@GetMapping(value = "/login")
	public String login() {
		
		return "subviews/login";
	}

	
	@GetMapping(value = "/register")
	public String register(RedirectAttributes redirectAttributes, Model model) {
		
		// Obtén los mensajes flash de redirectAttributes
	    String mensajeUserTag = (String) redirectAttributes.getFlashAttributes().get("mensajeuserTag");
	    String mensajePassword = (String) redirectAttributes.getFlashAttributes().get("mensajepassword");
	    String mensajeEmail = (String) redirectAttributes.getFlashAttributes().get("mensajeemail");
	    String mensajeName = (String) redirectAttributes.getFlashAttributes().get("mensajename");
	    String mensajeFirstSurName = (String) redirectAttributes.getFlashAttributes().get("mensajefirstSurName");
	    String mensajeSecondSurName = (String) redirectAttributes.getFlashAttributes().get("mensajesecondSurName");

	    // Agrega los mensajes al modelo
	    model.addAttribute("mensajeuserTag", mensajeUserTag);
	    model.addAttribute("mensajepassword", mensajePassword);
	    model.addAttribute("mensajeemail", mensajeEmail);
	    model.addAttribute("mensajename", mensajeName);
	    model.addAttribute("mensajefirstSurName", mensajeFirstSurName);
	    model.addAttribute("mensajesecondSurName", mensajeSecondSurName);
		
		return "subviews/register";
	}
	
	
	@GetMapping(value = "/campaign")
	public String campaign(Model model) {
		
		List<Galaxy> listaGalaxies = objGalaxyService.getAll();
		model.addAttribute("listaGalaxias", listaGalaxies);
		
		//List<Regions> listaRegion = objRegionsService.getAll();
		//model.addAttribute("listaRegiones", listaRegion); 
		
		List<Regions> listaRegiones = new ArrayList<>();
		
		for(Galaxy galaxy: listaGalaxies) {
			List<Regions> regionesDeLaGalaxia = objRegionsService.getRegionsByGalaxy(galaxy);
	        listaRegiones.addAll(regionesDeLaGalaxia);
		}
		model.addAttribute("listaRegiones", listaRegiones);
		
		//List<Planet> listaPlanet = objPlanetService.getAll();
		//model.addAttribute("listaPlanetas", listaPlanet); 
		
		List<Planet> listaPlanetas = new ArrayList<>();
		
		for(Regions region: listaRegiones) {
			List<Planet> planetasPorRegiones = objPlanetService.getPlanetsByRegion(region);
			listaPlanetas.addAll(planetasPorRegiones);
			//System.out.println("listaPlanetas" + listaPlanetas.toString());
		}
		model.addAttribute("listaPlanetas", listaPlanetas);
		
		List<Territory> listaTerritory = objTerritoryService.getAll();
		model.addAttribute("listaTerritorios", listaTerritory); 
		
		return "subviews/campaign";
	}
	
	@GetMapping("/getPlanetsByRegion/{regionId}")
	@ResponseBody
	public List<Planet> getPlanetsByRegion(@PathVariable @NonNull Long regionId) {
	    Regions selectedRegion = objRegionsService.getRegionById(regionId);
	    
	    if (selectedRegion != null) {
	        List<Planet> planets = objPlanetService.getPlanetsByRegion(selectedRegion);
	        return planets;
	    } else {
	        // Manejar el caso donde no se encuentra la región
	        return Collections.emptyList(); // o lanzar una excepción, según tus necesidades
	    }
	}

	
	@PostMapping(value = "/processFormCampaign", produces = "application/json")
	@ResponseBody
	public Campaign regCampaign(@RequestParam("campaignName") String campaignName) {

	    // Create and return the Campaign object using the received parameters
	    Campaign registroCampaign = new Campaign();
	    registroCampaign.setCampaignName(campaignName);
	    registroCampaign.setActiverow(true);
	    
	    return registroCampaign;
	}


	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<?> regUser(Usuario registroUsuario, RedirectAttributes redirectAttributes, Model model) {
		
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
			
			//redirectAttributes.addFlashAttribute los mensajes se almacenarán temporalmente en la sesión y se enviarán a la vista después de la redirección
			if (!matcherUserTag.matches()) {
				redirectAttributes.addFlashAttribute("mensajeuserTag", "Nombre de usuario no válido.");
			}else if(!matcherPassword.matches()) {
				redirectAttributes.addFlashAttribute("mensajepassword", "Contraseña no válida.");
			}else if(!matcherEmail.matches()) {
				redirectAttributes.addFlashAttribute("mensajeemail", "Email no válido.");
			}else if(!matcherName.matches()) {
				redirectAttributes.addFlashAttribute("mensajename", "Nombre no válido.");
			}else if(!matcherfirstSurName.matches()) {
				redirectAttributes.addFlashAttribute("mensajefirstSurName", "Primer apellido no válido.");
			}else if(!matcherSecondSurname.matches()) {
				redirectAttributes.addFlashAttribute("mensajesecondSurName", "Segundo apellido no válido.");
			}else {
				
				//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				//String encodedPassword = passwordEncoder.encode(registroUsuario.getPassword());
				
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
				model.addAttribute("usuarioRegistrado", nuevoUsuario);
				System.out.println("Nuevo usuario registrado: " + nuevoUsuario.getUsername());
	
				return ResponseEntity.ok(nuevoUsuario);
			}
		}catch(Exception e){
			redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": true, \"errorMessage\": \"" + e.getMessage() + "\"}");
		}return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": true, \"errorMessage\": \"Unexpected error\"}");
	}
}



/*
@PostMapping(value = "/register", produces = "application/json")
@ResponseBody
public Usuario regUser(Usuario registroUsuario, HttpSession session, RedirectAttributes redirectAttributes, Model model) {
	try {
		
		//REGEX
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
		    model.addAttribute("mensajeuserTag", "Nombre de usuario no válido.");
		}else if(!matcherPassword.matches()) {
		    model.addAttribute("mensajepassword", "Contraseña no válida.");
		}else if(!matcherEmail.matches()) {
		    model.addAttribute("mensajeemail", "Email no válido.");
		}else if(!matcherName.matches()) {
		    model.addAttribute("mensajename", "Nombre no válido.");
		}else if(!matcherfirstSurName.matches()) {
		    model.addAttribute("mensajefirstSurName", "Primer apellido no válido.");
		}else if(!matcherSecondSurname.matches()) {
		    model.addAttribute("mensajesecondSurName", "Segundo apellido no válido.");
		}else {
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
			
			//Datos almacenados en variable de sesión.
			model.addAttribute("usuarioRegistrado", nuevoUsuario);

			redirectAttributes.addFlashAttribute("redirect", true);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return registroUsuario;
}*/