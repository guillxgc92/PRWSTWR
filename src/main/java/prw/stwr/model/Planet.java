package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planets_stwr")
public class Planet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PLANET_PST")
	private long idPlanet;
	
	@Column(name = "PLANET_NAME_PST")
	private String planetName;
	
	@Column(name = "PLANET_DESCRIPTION_PST")
	private String planetDescription;
	
	@Column(name = "ID_SYSTEM_PST")
	private long idPlanetRegion;
	
	@Column(name = "ACTIVEROW_PST")
	private boolean activerow;
	
	public Planet() {
		
	}
	
	public Planet(long idPlanet, String planetName, String planetDescription, 
			long idPlanetRegion, boolean activerow) {
		this.idPlanet = idPlanet;
		this.planetName = planetName;
		this.planetDescription = planetDescription;
		this.idPlanetRegion = idPlanetRegion;
		this.activerow = activerow;
	}

	public long getIdPlanet() {
		return idPlanet;
	}

	public void setIdPlanet(long idPlanet) {
		this.idPlanet = idPlanet;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	public String getPlanetDescription() {
		return planetDescription;
	}

	public void setPlanetDescription(String planetDescription) {
		this.planetDescription = planetDescription;
	}

	public long getIdPlanetRegion() {
		return idPlanetRegion;
	}

	public void setIdPlanetRegion(long idPlanetRegion) {
		this.idPlanetRegion = idPlanetRegion;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
