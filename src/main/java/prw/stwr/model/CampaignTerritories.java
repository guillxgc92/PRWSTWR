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
@Table(name = "campaignterritory_stwr")
public class CampaignTerritories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_campaignterritory_cst")
	private long idCampaignTerritories;
	
	@Column(name = "CAMPAIGNNAME_CST")
	private String campaignName;
	
	@ManyToOne
	@JoinColumn(name = "ID_CAMPAIGNASIGN_CST", referencedColumnName = "ID_CAMPAIGNASIGN_CST")
	private CampaignAsign idCampaignAsign;
	
	@ManyToOne
	@JoinColumn(name = "ID_TERRITORY_TST", referencedColumnName = "ID_TERRITORY_TST")
	private Territory idTerritory;
	
	@ManyToOne
	@JoinColumn(name = "ID_PLANET_PST", referencedColumnName = "ID_PLANET_PST")
	private Planet idPlanet;
	
	@ManyToOne
	@JoinColumn(name = "ID_SYSTEM_SST", referencedColumnName = "ID_SYSTEM_SST")
	private Regions idRegions;
	
	@ManyToOne
	@JoinColumn(name = "ID_GALAXY_GST", referencedColumnName = "ID_GALAXY_GST")
	private Galaxy idGalaxy;
	
	@Column(name = "ACTIVEROW_CAMPAIGNTERRITORY_CST")
	private boolean activerow;

	public CampaignTerritories() {
	}

	public CampaignTerritories(long idCampaignTerritories, String campaignName, CampaignAsign idCampaignAsign,
			Territory idTerritory, Planet idPlanet, Regions idRegions, Galaxy idGalaxy, boolean activerow) {
		this.idCampaignTerritories = idCampaignTerritories;
		this.campaignName = campaignName;
		this.idCampaignAsign = idCampaignAsign;
		this.idTerritory = idTerritory;
		this.idPlanet = idPlanet;
		this.idRegions = idRegions;
		this.idGalaxy = idGalaxy;
		this.activerow = activerow;
	}

	public long getIdCampaignTerritories() {
		return idCampaignTerritories;
	}

	public void setIdCampaignTerritories(long idCampaignTerritories) {
		this.idCampaignTerritories = idCampaignTerritories;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public CampaignAsign getIdCampaignAsign() {
		return idCampaignAsign;
	}

	public void setIdCampaignAsign(CampaignAsign idCampaignAsign) {
		this.idCampaignAsign = idCampaignAsign;
	}

	public Territory getIdTerritory() {
		return idTerritory;
	}

	public void setIdTerritory(Territory idTerritory) {
		this.idTerritory = idTerritory;
	}

	public Planet getIdPlanet() {
		return idPlanet;
	}

	public void setIdPlanet(Planet idPlanet) {
		this.idPlanet = idPlanet;
	}

	public Regions getIdRegions() {
		return idRegions;
	}

	public void setIdRegions(Regions idRegions) {
		this.idRegions = idRegions;
	}

	public Galaxy getIdGalaxy() {
		return idGalaxy;
	}

	public void setIdGalaxy(Galaxy idGalaxy) {
		this.idGalaxy = idGalaxy;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
