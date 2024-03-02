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
@Table(name = "chrace_skill_relation_stwr")
public class CharacterRaceSkillRelation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RELATION")
	private Long idRelation;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CHRACE_CRST", referencedColumnName = "ID_CHRACE_CRST")
	private CharacterRace characterRace;
	
	@ManyToOne
	@JoinColumn(name = "ID_RASKILL_RSST", referencedColumnName = "ID_RASKILL_RSST")
	private CharacterRaceSkill characterRaceSkill;
	
	@Column(name = "ACTIVEROW_REL")
	private boolean activerow;

	
	public Long getIdRelation() {
		return idRelation;
	}

	public void setIdRelation(Long idRelation) {
		this.idRelation = idRelation;
	}

	public CharacterRace getCharacterRace() {
		return characterRace;
	}

	public void setCharacterRace(CharacterRace characterRace) {
		this.characterRace = characterRace;
	}

	public CharacterRaceSkill getCharacterRaceSkill() {
		return characterRaceSkill;
	}

	public void setCharacterRaceSkill(CharacterRaceSkill characterRaceSkill) {
		this.characterRaceSkill = characterRaceSkill;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
