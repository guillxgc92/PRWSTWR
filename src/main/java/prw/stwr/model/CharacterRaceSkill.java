package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chraceskill_stwr")
public class CharacterRaceSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RASKILL_RSST")
	private long idChRaceSkill;
	
	@Column(name = "RASKILL_NAME_RSST")
	private String chRaceSkillName;
	
	@Column(name = "RASKILL_DESCRIPTION_RSST")
	private String chRaceSkillDescription;
	
	@Column(name = "ACTIVEROW_RSST")
	private boolean activerow;
	
	public long getIdChRaceSkill() {
		return idChRaceSkill;
	}

	public void setIdChRaceSkill(long idChRaceSkill) {
		this.idChRaceSkill = idChRaceSkill;
	}

	public String getChRaceSkillName() {
		return chRaceSkillName;
	}

	public void setChRaceSkillName(String chRaceSkillName) {
		this.chRaceSkillName = chRaceSkillName;
	}

	public String getChRaceSkillDescription() {
		return chRaceSkillDescription;
	}

	public void setChRaceSkillDescription(String chRaceSkillDescription) {
		this.chRaceSkillDescription = chRaceSkillDescription;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
