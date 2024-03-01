package prw.stwr.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import prw.stwr.model.Campaign;
import prw.stwr.model.CharacterClass;
import prw.stwr.model.CharacterClassSkill;
import prw.stwr.model.CharacterRace;
import prw.stwr.model.CharacterRaceSkill;
import prw.stwr.model.Galaxy;
import prw.stwr.model.GameCharacter;
import prw.stwr.model.Planet;
import prw.stwr.model.Regions;
import prw.stwr.model.ResultAccount;
import prw.stwr.model.Territory;
import prw.stwr.model.Usuario;
import prw.stwr.service.CharacterClassService;
import prw.stwr.service.CharacterClassSkillService;
import prw.stwr.service.CharacterRaceService;
import prw.stwr.service.CharacterRaceSkillService;
import prw.stwr.service.CharacterService;
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
	
	@Autowired
	private CharacterService objCharacterService;
	
	@Autowired
	private CharacterRaceService objCharacterRaceService;
	
	@Autowired
	private CharacterRaceSkillService objCharacterRaceSkillService;
	
	@Autowired
	private CharacterClassService objCharacterClassService;
	
	@Autowired
	private CharacterClassSkillService objCharacterClassSkillService;
	
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
	public String register() {
		
		return "subviews/register";
	}
	
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
	
	@GetMapping(value = "/campaign")
	public String campaign(Model model) {
		
		List<Galaxy> listaGalaxies = objGalaxyService.getAll();
		model.addAttribute("listaGalaxias", listaGalaxies);
		
		List<Regions> listaRegiones = new ArrayList<>();
		
		for(Galaxy galaxy: listaGalaxies) {
			List<Regions> regionesDeLaGalaxia = objRegionsService.getRegionsByGalaxy(galaxy);
	        listaRegiones.addAll(regionesDeLaGalaxia);
		}
		model.addAttribute("listaRegiones", listaRegiones);

		List<Planet> listaPlanetas = new ArrayList<>();
		
		for(Regions region: listaRegiones) {
			List<Planet> planetasPorRegiones = objPlanetService.getPlanetsByRegion(region);
			listaPlanetas.addAll(planetasPorRegiones);
		}
		model.addAttribute("listaPlanetas", listaPlanetas);
		
		List<Territory> listaTerritory = objTerritoryService.getAll();
		model.addAttribute("listaTerritorios", listaTerritory); 
		
		return "subviews/campaign";
	}
	
	@PostMapping(value = "/processFormCampaign", produces = "application/json")
	@ResponseBody
	public Campaign regCampaign(@RequestBody Campaign campaign) {

	    Campaign registroCampaign = new Campaign();
	    
	    return registroCampaign;
	}

	
	@GetMapping(value = "/character-creator")
	public String characterview(Model model) {
		
		List<CharacterRace> listaRazas = objCharacterRaceService.getAll();
		model.addAttribute("listaRazas", listaRazas);
		
		List<CharacterRaceSkill> listaSkillsRaza = objCharacterRaceSkillService.getAll(); //Cambiar a que seleccione segun idCharacterRace
		model.addAttribute("listaSkillsRaza",listaSkillsRaza);
		
		List<CharacterClass> listaClases = objCharacterClassService.getAll();
		model.addAttribute("listaClases", listaClases);
		
		List<CharacterClassSkill> listaSkillsClase = objCharacterClassSkillService.getAll(); //Cambiar a que seleccione segun idCharacterClass
		model.addAttribute("listaSkillsClase", listaSkillsClase);
		
		return "subviews/character";
	}
	
	@PostMapping(value = "/processCharacterForm", produces = "application/json")
	@ResponseBody
	public GameCharacter regCharacter(@RequestBody GameCharacter gameCharacter) {
		
		return null;
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
				resultAccount.getErrores().add("Nombre de usuario no válido.");
			}
			if(!matcherPassword.matches()) {
				resultAccount.getErrores().add("Contraseña no válida.");
			}
			if(!matcherEmail.matches()) {
				resultAccount.getErrores().add("Email no válido.");
			}
			if(!matcherName.matches()) {
				resultAccount.getErrores().add("Nombre no válido.");
			}
			if(!matcherfirstSurName.matches()) {
				resultAccount.getErrores().add("Primer apellido no válido.");
			}
			if(!matcherSecondSurname.matches()) {
				resultAccount.getErrores().add("Segundo apellido no válido.");
			}
			if(resultAccount.getErrores().size() == 0){
				
				Usuario usuarioActual = objUsuarioService.getUsuarioByUsername(userDetails.getUsername());
				
				usuarioActual.setEmail(email);
				usuarioActual.setPassword(password);
				usuarioActual.setName(name);
				usuarioActual.setFirstSurName(firstSurName);
				usuarioActual.setSecondSurName(secondSurName);
				
				//Insertar el registro de usuario en la tabla de usuarios.
				@SuppressWarnings("unused")
				Usuario nuevoUsuario = objUsuarioService.updateUsuario(usuarioActual);
				System.out.println("usuario modificado: " + nuevoUsuario);
				
				resultAccount.setUsuario(usuarioActual);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultAccount;
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
				resultAccount.getErrores().add("Nombre de usuario no válido.");
			}
			if(!matcherPassword.matches()) {
				resultAccount.getErrores().add("Contraseña no válida.");
			}
			if(!matcherEmail.matches()) {
				resultAccount.getErrores().add("Email no válido.");
			}
			if(!matcherName.matches()) {
				resultAccount.getErrores().add("Nombre no válido.");
			}
			if(!matcherfirstSurName.matches()) {
				resultAccount.getErrores().add("Primer apellido no válido.");
			}
			if(!matcherSecondSurname.matches()) {
				resultAccount.getErrores().add("Segundo apellido no válido.");
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
}
