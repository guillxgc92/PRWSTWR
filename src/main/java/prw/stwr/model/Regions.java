package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "system_stwr")
public class Regions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SYSTEM_SST")
	private long idRegion; //SISTEMA
	
	@Column(name = "SYSTEM_NAME_SST")
	private String regionName;
	
	@Column(name = "SYSTEM_DESCRIPTION_SST")
	private String regionDescription;
	
	@Column(name = "ID_GALAXY_SST")
	private long idGalaxyRegion;
	
	@Column(name = "ACTIVEROW_SST")
	private boolean activerow;
	
	public Regions() {
		
	}

	public Regions(long idRegion, String regionName, String regionDescription, long idGalaxyRegion, boolean activerow) {
		this.idRegion = idRegion;
		this.regionName = regionName;
		this.regionDescription = regionDescription;
		this.idGalaxyRegion = idGalaxyRegion;
		this.activerow = activerow;
	}

	public long getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(long idRegion) {
		this.idRegion = idRegion;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionDescription() {
		return regionDescription;
	}

	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
	}

	public long getIdGalaxyRegion() {
		return idGalaxyRegion;
	}

	public void setIdGalaxyRegion(long idGalaxyRegion) {
		this.idGalaxyRegion = idGalaxyRegion;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}


