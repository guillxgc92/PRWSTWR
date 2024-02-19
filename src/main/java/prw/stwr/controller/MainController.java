package prw.stwr.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		// Obtiene el objeto Usuario de la variable de sesión
	    Usuario usuarioRegistrado = (Usuario) session.getAttribute("usuarioRegistrado");

	    model.addAttribute("usuarioRegistrado", usuarioRegistrado);
	    
	    // Comprobar que llegan correctamente los registros de las tablas
	    //List<RolUsuario> listaRolesUsuarios = objRolUsuarioService.getAll();
	    //List<Usuario> listaUsuarios = objUsuarioService.getAll();
	    //List<Galaxy> listaGalaxies = objGalaxyService.getAll();
	    //List<Regions> listaRegion = objRegionsService.getAll();
	    //List<Planet> listaPlanet = objPlanetService.getAll();
	    //List<Territory> listaTerritory = objTerritoryService.getAll();
		
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
	
	
	@PostMapping(value = "/processFormCampaign")
	public Campaign regCampaign() {
		
		Campaign newCampaign = new Campaign();
		
		return newCampaign;
	}
	
	@PostMapping(value = "/registerprocess", produces = "application/json")
	@ResponseBody
	public Usuario regUser(Usuario registroUsuario, HttpSession session) {
		
		//Setear rol de usuario en 1 = Jugador como estandar en caso de que el jugador cree una campaña cambiar a idRol = 2(GM).
		registroUsuario.setIdRolUser(1);
		registroUsuario.setActiverow(true);
		
		//Datos almacenados en variable de sesión.
		session.setAttribute("usuarioRegistrado", registroUsuario);
		
		//Insertar el registro de usuario en la tabla de usuarios.
		@SuppressWarnings("unused")
		Usuario nuevoUsuario = objUsuarioService.insertUsuario(registroUsuario);
		
		return registroUsuario;
	}	
}
