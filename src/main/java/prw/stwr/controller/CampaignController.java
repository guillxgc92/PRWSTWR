package prw.stwr.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import prw.stwr.model.CampaignTerritories;
import prw.stwr.model.CharacterClass;
import prw.stwr.model.CharacterClassSkill;
import prw.stwr.model.CharacterRace;
import prw.stwr.model.CharacterRaceSkill;
import prw.stwr.model.CharacterRaceSkillRelation;
import prw.stwr.model.Galaxy;
import prw.stwr.model.GameCharacter;
import prw.stwr.model.Planet;
import prw.stwr.model.Regions;
import prw.stwr.model.Territory;
import prw.stwr.service.CharacterClassService;
import prw.stwr.service.CharacterClassSkillService;
import prw.stwr.service.CharacterRaceService;
import prw.stwr.service.CharacterRaceSkillRelationService;
import prw.stwr.service.CharacterRaceSkillService;
import prw.stwr.service.CharacterService;
import prw.stwr.service.GalaxyService;
import prw.stwr.service.PlanetService;
import prw.stwr.service.RegionsService;
import prw.stwr.service.TerritoryService;

@Controller
public class CampaignController {

	@Autowired
	private GalaxyService objGalaxyService;
	
	@Autowired
	private RegionsService objRegionsService;
	
	@Autowired
	private PlanetService objPlanetService;
	
	@Autowired
	private TerritoryService objTerritoryService;
	
	@SuppressWarnings("unused")
	@Autowired
	private CharacterService objCharacterService;
	
	@Autowired
	private CharacterRaceService objCharacterRaceService;
	
	@SuppressWarnings("unused")
	@Autowired
	private CharacterRaceSkillService objCharacterRaceSkillService;
	
	@Autowired
	private CharacterClassService objCharacterClassService;
	
	@Autowired
	private CharacterClassSkillService objCharacterClassSkillService;
	
	@Autowired
	private CharacterRaceSkillRelationService objcharacterRaceSkillRelationService;
	
	@GetMapping(value = "/campaign")
	public String campaign(Model model) {
		
		List<Galaxy> listaGalaxies = objGalaxyService.getAll();
		model.addAttribute("listaGalaxias", listaGalaxies);
		
		List<Regions> listaRegiones = objRegionsService.getAll();
		model.addAttribute("listaRegiones", listaRegiones);

		List<Planet> listaPlanetas = objPlanetService.getAll();
		model.addAttribute("listaPlanetas", listaPlanetas);
		
		List<Territory> listaTerritory = objTerritoryService.getAll();
		model.addAttribute("listaTerritorios", listaTerritory); 
		
		return "subviews/campaign";
	}
	
	@GetMapping(value = "/character-creator")
	public String characterview(Model model) {
		
		List<CharacterRace> listaRazas = objCharacterRaceService.getAll();
		model.addAttribute("listaRazas", listaRazas);
		
		List<CharacterRaceSkill> listaSkillRaza = objCharacterRaceSkillService.getAll();
		model.addAttribute("listaSkillRaza", listaSkillRaza);
		
		List<CharacterRaceSkillRelation> listaSkillsRazaRel = objcharacterRaceSkillRelationService.getAll(); //Cambiar a que seleccione segun idCharacterRace
		model.addAttribute("listaSkillsRazaRel", listaSkillsRazaRel);

		List<CharacterClass> listaClases = objCharacterClassService.getAll();
		model.addAttribute("listaClases", listaClases);
		
		List<CharacterClassSkill> listaSkillsClase = objCharacterClassSkillService.getAll(); //Cambiar a que seleccione segun idCharacterClass
		model.addAttribute("listaSkillsClase", listaSkillsClase);
		
		return "subviews/character";
	}
	
	@PostMapping(value = "/processCharacterForm", produces = "application/json")
	@ResponseBody
	public GameCharacter charCreate(@RequestParam(name = "charName") String charName,
									@RequestParam(name = "charRace") CharacterRace charRace,
									@RequestParam(name = "charRaceSkill") CharacterRaceSkill charRaceSkill,
									@RequestParam(name = "charClass") CharacterClass charClass,
									@RequestParam(name = "charClassSkill") CharacterClassSkill charClassSkill) {
		
		GameCharacter gameCharacter = new GameCharacter();
		try {
			Pattern characterNameReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1 ]{3,16}|^$");
			String characterName = charName;
			Matcher matcherCharacterName = characterNameReg.matcher(characterName);
			
			if(!matcherCharacterName.matches()) {
				System.out.println("Nombre de personaje no válido."); //Hay que cambiarlo
			}
			else {
				gameCharacter.setActiverow(true);
				gameCharacter.setCharacterName(characterName.trim());
				gameCharacter.setCharacterRace(charRace);
				gameCharacter.setCharacterRaceSkill(charRaceSkill);
				gameCharacter.setCharacterClass(charClass);
				gameCharacter.setCharacterClassSkill(charClassSkill);

				//Aquí iría el registro del personaje en la bdd
				System.out.println(gameCharacter.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return gameCharacter;
	}
	
	@PostMapping(value = "/processFormCampaign", produces = "application/json")
	@ResponseBody
	public CampaignTerritories campCreate(@RequestParam(name = "campaignName") String campaignName,
										  @RequestParam(name = "galaxy") Galaxy galaxy,
									      @RequestParam(name = "region") Regions regions,
									      @RequestParam(name = "planet") Planet planet,
									      @RequestParam(name = "territory") Territory territory) {
		
		CampaignTerritories campaignInfo = new CampaignTerritories();
		try {
			Pattern campaignInfoReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1 ]{3,16}|^$");
			String campaignInfoName = campaignName;
			Matcher matcherCampaignInfo = campaignInfoReg.matcher(campaignInfoName);
			
			if (!matcherCampaignInfo.matches()) {
				System.out.println("Nombre de campaña no válido.");
			}
			else {
				campaignInfo.setActiverow(true);
				campaignInfo.setIdCampaignAsign(null);
				campaignInfo.setCampaignName(campaignName);
				campaignInfo.setIdGalaxy(galaxy);
				campaignInfo.setIdRegions(regions);
				campaignInfo.setIdPlanet(planet);
				campaignInfo.setIdTerritory(territory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Al no hacer una insercion en la tabla no hay nada que leer por lo tanto peta
		return campaignInfo;
	}
}
