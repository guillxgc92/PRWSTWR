package prw.stwr.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chclasskill_stwr")
public class CharacterClassSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLSKILL_CSST")
	private long idChClassSkill;
	
	@Column(name = "CLSKILL_NAME_CSST")
	private String chClassSkillName;
	
	@Column(name = "CLSKILL_DESCRIPTION_CSST")
	private String chClassSkillDescription;
	
	@Column(name = "ACTIVEROW_CSST")
	private boolean activerow;

	
	
	public long getIdChClassSkill() {
		return idChClassSkill;
	}

	public void setIdChClassSkill(long idChClassSkill) {
		this.idChClassSkill = idChClassSkill;
	}

	public String getChClassSkillName() {
		return chClassSkillName;
	}

	public void setChClassSkillName(String chClassSkillName) {
		this.chClassSkillName = chClassSkillName;
	}

	public String getChClassSkillDescription() {
		return chClassSkillDescription;
	}

	public void setChClassSkillDescription(String chClassSkillDescription) {
		this.chClassSkillDescription = chClassSkillDescription;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
