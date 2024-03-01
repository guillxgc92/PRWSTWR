package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chrace_stwr")
public class CharacterRace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CHRACE_CRST")
	private long idCharacterRace;
	
	@Column(name = "CHRACE_NAME_CRST")
	private String characterRaceName;
	
	@Column(name = "CHRACE_DESCRIPTION_CRST")
	private String characterRaceDescription;
	
	@Column(name = "ACTIVEROW_CRST")
	private boolean activerow;

	
	
	public long getIdCharacterRace() {
		return idCharacterRace;
	}

	public void setIdCharacterRace(long idCharacterRace) {
		this.idCharacterRace = idCharacterRace;
	}

	public String getCharacterRaceName() {
		return characterRaceName;
	}

	public void setCharacterRaceName(String characterRaceName) {
		this.characterRaceName = characterRaceName;
	}

	public String getCharacterRaceDescription() {
		return characterRaceDescription;
	}

	public void setCharacterRaceDescription(String characterRaceDescription) {
		this.characterRaceDescription = characterRaceDescription;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
