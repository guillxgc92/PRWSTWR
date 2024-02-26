package prw.stwr.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name = "ID_GALAXY_SST", referencedColumnName = "ID_GALAXY_GST")
	private Galaxy objGalaxy;
	
	@Column(name = "ACTIVEROW_SST")
	private boolean activerow;
	
	@OneToMany(mappedBy = "objRegions")
    private List<Planet> planets;
	
	public Regions() {
		
	}

	public Regions(long idRegion, String regionName, String regionDescription, Galaxy objGalaxy, boolean activerow) {
		this.idRegion = idRegion;
		this.regionName = regionName;
		this.regionDescription = regionDescription;
		this.objGalaxy = objGalaxy;
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

	public Galaxy getIdGalaxyRegion() {
		return objGalaxy;
	}

	public void setIdGalaxyRegion(Galaxy objGalaxy) {
		this.objGalaxy = objGalaxy;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
}


