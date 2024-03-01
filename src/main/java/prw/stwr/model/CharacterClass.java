package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chclass_stwr")
public class CharacterClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CHCLASS_CLST")
	private long idChClass;
	
	@Column(name = "CHCLASS_NAME_CLST")
	private String chClassName;
	
	@Column(name = "CHCLASS_DESCRIPTION_CLST")
	private String chClassDescription;
	
	@Column(name = "ACTIVEROW_CLST")
	private String activerow;

	
	
	public long getIdChClass() {
		return idChClass;
	}

	public void setIdChClass(long idChClass) {
		this.idChClass = idChClass;
	}

	public String getChClassName() {
		return chClassName;
	}

	public void setChClassName(String chClassName) {
		this.chClassName = chClassName;
	}

	public String getChClassDescription() {
		return chClassDescription;
	}

	public void setChClassDescription(String chClassDescription) {
		this.chClassDescription = chClassDescription;
	}

	public String getActiverow() {
		return activerow;
	}

	public void setActiverow(String activerow) {
		this.activerow = activerow;
	}
}
