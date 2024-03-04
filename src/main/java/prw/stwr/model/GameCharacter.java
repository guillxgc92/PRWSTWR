package prw.stwr.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "character_stwr")
public class GameCharacter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CHARACTER_CHST")
	private long idCharacter;
	
	@Column(name = "CHARACTE_RNAME_CHST")
	private String characterName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CHARACTER_CLASS_CHST", referencedColumnName = "ID_CHCLASS_CLST")
	private CharacterClass characterClass;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CHARACTER_RACE_CHST", referencedColumnName = "ID_CHRACE_CRST")
	private CharacterRace characterRace;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CAMPAIGN_CHST", referencedColumnName = "ID_CAMPAIGN_CST")
	private Campaign idCampaign;
	
	@Column(name = "ACTIVEROW_CHST")
	private boolean activerow;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RASKILL_RSST", referencedColumnName = "ID_RASKILL_RSST")
	private CharacterRaceSkill characterRaceSkill;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLSKILL_CSST", referencedColumnName = "ID_CLSKILL_CSST")
	private CharacterClassSkill characterClassSkill;

	public GameCharacter() {}

	public GameCharacter(long idCharacter, String characterName, CharacterClass characterClass,
			CharacterRace characterRace, Campaign idCampaign, boolean activerow, CharacterRaceSkill characterRaceSkill,
			CharacterClassSkill characterClassSkill) {
		this.idCharacter = idCharacter;
		this.characterName = characterName;
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.idCampaign = idCampaign;
		this.activerow = activerow;
		this.characterRaceSkill = characterRaceSkill;
		this.characterClassSkill = characterClassSkill;
	}

	public long getIdCharacter() {
		return idCharacter;
	}

	public void setIdCharacter(long idCharacter) {
		this.idCharacter = idCharacter;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public CharacterClass getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(CharacterClass characterClass) {
		this.characterClass = characterClass;
	}

	public CharacterRace getCharacterRace() {
		return characterRace;
	}

	public void setCharacterRace(CharacterRace characterRace) {
		this.characterRace = characterRace;
	}

	public Campaign getIdCampaign() {
		return idCampaign;
	}

	public void setIdCampaign(Campaign idCampaign) {
		this.idCampaign = idCampaign;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}

	public CharacterRaceSkill getCharacterRaceSkill() {
		return characterRaceSkill;
	}

	public void setCharacterRaceSkill(CharacterRaceSkill characterRaceSkill) {
		this.characterRaceSkill = characterRaceSkill;
	}

	public CharacterClassSkill getCharacterClassSkill() {
		return characterClassSkill;
	}

	public void setCharacterClassSkill(CharacterClassSkill characterClassSkill) {
		this.characterClassSkill = characterClassSkill;
	}
	
	@Override
	public String toString() {
		String string = "{ Nombre de personaje: " + getCharacterName() +
				"\nRaza: " + getCharacterRace().getCharacterRaceName() + 
				"\nDescripción de raza: "+ getCharacterRace().getCharacterRaceDescription() +
				"\nSkill de raza: " + getCharacterRaceSkill().getChRaceSkillName() + 
				"\nDescripción skill de raza: " + getCharacterRaceSkill().getChRaceSkillDescription() +
				"\nClase: " + getCharacterClassSkill().getChClassSkillName() + 
				"\nDescripción de clase: " + getCharacterClass().getChClassDescription() +
				"\nSkill de clase: " + getCharacterClassSkill().getChClassSkillName() +
				"\nDescripción skill de clase: " + getCharacterClassSkill().getChClassSkillDescription() +
				"\n}";
		return string;
	}
}
