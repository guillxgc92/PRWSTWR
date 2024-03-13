package prw.stwr.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//?
	
	@PostMapping(value = "/processCharacterForm", produces = "application/json")
	@ResponseBody
	public GameCharacter charCreate(@RequestParam(name = "characterName") String characterName,
									@RequestParam(name = "charRace") CharacterRace characterRace,
									@RequestParam(name = "charRaceSkill") CharacterRaceSkill characterRaceSkill,
									@RequestParam(name = "charClass") CharacterClass characterClass,
									@RequestParam(name = "charClassSkill") CharacterClassSkill characterClassSkill) {
		
		GameCharacter gameCharacter = new GameCharacter();
		try {
			Pattern characterNameReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1 ]{3,16}|^$");
			String characterNamed = characterName;
			Matcher matcherCharacterName = characterNameReg.matcher(characterName);
			
			if(!matcherCharacterName.matches()) {
				System.out.println("Nombre de personaje no válido."); //Hay que cambiarlo
			}
			if(matcherCharacterName.matches()) {
				gameCharacter.setActiverow(true);
				gameCharacter.setCharacterName(characterNamed.trim());
				gameCharacter.setCharacterRace(characterRace);
				gameCharacter.setCharacterRaceSkill(characterRaceSkill);
				gameCharacter.setCharacterClass(characterClass);
				gameCharacter.setCharacterClassSkill(characterClassSkill);

				//Aquí iría el registro del personaje en la bdd
				System.out.println(gameCharacter.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gameCharacter;
	}
	
	//NO VA
	
	@PostMapping(value = "/processFormCampaign", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public CampaignTerritories campCreate(@RequestBody CampaignTerritories campaignRequest) {
		
		CampaignTerritories campaignInfo = new CampaignTerritories();
		try {
			Pattern campaignInfoReg = Pattern.compile("[a-zA-ZÀ-ÿ\\u00f1\\u00d1 ]{3,16}|^$");
			String campaignInfoName = campaignRequest.getCampaignName();
			Matcher matcherCampaignInfo = campaignInfoReg.matcher(campaignInfoName);
			
			if (!matcherCampaignInfo.matches()) {
				System.out.println("Nombre de campaña no válido.");
			}
			if (matcherCampaignInfo.matches()) {
				campaignInfo.setActiverow(true);
				campaignInfo.setIdCampaignAsign(null);
				campaignInfo.setCampaignName(campaignInfoName);
				campaignInfo.setIdGalaxy(campaignRequest.getIdGalaxy());
				campaignInfo.setIdRegions(campaignRequest.getIdRegions());
				campaignInfo.setIdPlanet(campaignRequest.getIdPlanet());
				campaignInfo.setIdTerritory(campaignRequest.getIdTerritory());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return campaignInfo;
	}
}
