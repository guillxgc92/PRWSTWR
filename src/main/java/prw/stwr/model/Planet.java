package prw.stwr.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "ID_SYSTEM_PST", referencedColumnName = "ID_SYSTEM_SST")
	private Regions objRegions;
	
	@Column(name = "ACTIVEROW_PST")
	private boolean activerow;
	
	public Planet() {
		
	}
	
	public Planet(long idPlanet, String planetName, String planetDescription, 
			Regions objRegions, boolean activerow) {
		this.idPlanet = idPlanet;
		this.planetName = planetName;
		this.planetDescription = planetDescription;
		this.objRegions = objRegions;
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

	public Regions getIdPlanetRegion() {
		return objRegions;
	}

	public void setIdPlanetRegion(Regions objRegions) {
		this.objRegions = objRegions;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}

	public Regions getObjRegions() {
		return objRegions;
	}

	public void setObjRegions(Regions objRegions) {
		this.objRegions = objRegions;
	}
	
	@Override
	public String toString() {
		return "Planeta{"+
				"nombre= " + getPlanetName() +
				", descripcion= " + getPlanetDescription() +
				"}";
	}
}
