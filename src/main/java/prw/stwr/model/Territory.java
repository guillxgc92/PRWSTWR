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
@Table(name = "territory_stwr")
public class Territory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TERRITORY_TST")
	private long idTerritory;
	
	@Column(name = "TERRITORY_NAME_TST")
	private String territoryName;
	
	@Column(name = "TERRITORY_DESCRIPTION_TST")
	private String territoryDescription;
	
	@ManyToOne
	@JoinColumn(name = "ID_PLANET_TST", referencedColumnName = "ID_PLANET_PST")
	private Planet objPlanet;
	
	@Column(name = "ACTIVEROW_TST")
	private boolean activerow;
	
	@Column(name = "TERRITORY_HISTORY_TST")
	private String territoryHistory;
	
	public Territory() {
		
	}

	public Territory(long idTerritory, String territoryName, String territoryDescription, Planet objPlanet,
			boolean activerow, String territoryHistory) {
		this.idTerritory = idTerritory;
		this.territoryName = territoryName;
		this.territoryDescription = territoryDescription;
		this.objPlanet = objPlanet;
		this.activerow = activerow;
		this.territoryHistory = territoryHistory;
	}

	public long getIdTerritory() {
		return idTerritory;
	}

	public void setIdTerritory(long idTerritory) {
		this.idTerritory = idTerritory;
	}

	public String getTerritoryName() {
		return territoryName;
	}

	public void setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
	}

	public String getTerritoryDescription() {
		return territoryDescription;
	}

	public void setTerritoryDescription(String territoryDescription) {
		this.territoryDescription = territoryDescription;
	}

	public Planet getIdTerritoryPlanet() {
		return objPlanet;
	}

	public void setIdTerritoryPlanet(Planet objPlanet) {
		this.objPlanet = objPlanet;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}

	public String getTerritoryHistory() {
		return territoryHistory;
	}

	public void setTerritoryHistory(String territoryHistory) {
		this.territoryHistory = territoryHistory;
	}
}
