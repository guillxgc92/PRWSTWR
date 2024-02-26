package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Gauardar información de las campañas y usuario segun identificadores

@Entity
@Table(name = "campaignterritory_stwr")
public class CampaignInfoSave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CAMPAIGNTERRITORY_CST")
	private long idCampaignSave;
	
	@ManyToOne
	@JoinColumn(name = "ID_CAMPAIGNASIGN_CST", referencedColumnName = "ID_CAMPAIGNASIGN_CST")
	private CampaignAsign idCampaignAsigned; //campaignasign_stwr ID_CAMPAIGNASIGN_CST
	
	@ManyToOne
	@JoinColumn(name = "ID_TERRITORY_TST", referencedColumnName = "ID_TERRITORY_TST")
	private Territory idTerritorySave;
	
	@ManyToOne
	@JoinColumn(name = "ID_PLANET_PST", referencedColumnName = "ID_PLANET_PST")
	private Planet idPlanetSave;
	
	@ManyToOne
	@JoinColumn(name = "ID_SYSTEM_SST", referencedColumnName = "ID_SYSTEM_SST")
	private Regions idRegionSave;
	
	@ManyToOne
	@JoinColumn(name = "ID_GALAXY_GST", referencedColumnName = "ID_GALAXY_GST")
	private Galaxy idGalaxySave;
	
	@Column(name = "ACTIVEROW_CAMPAIGNTERRITORY_CST")
	private boolean activerow;
	
	public CampaignInfoSave() {
		
	}

	public CampaignInfoSave(long idCampaignSave, CampaignAsign idCampaignAsigned, Territory idTerritorySave, Planet idPlanetSave,
			Regions idRegionSave, Galaxy idGalaxySave, boolean activerow) {
		this.idCampaignSave = idCampaignSave;
		this.idCampaignAsigned = idCampaignAsigned;
		this.idTerritorySave = idTerritorySave;
		this.idPlanetSave = idPlanetSave;
		this.idRegionSave = idRegionSave;
		this.idGalaxySave = idGalaxySave;
		this.activerow = activerow;
	}

	public long getIdCampaignSave() {
		return idCampaignSave;
	}

	public void setIdCampaignSave(long idCampaignSave) {
		this.idCampaignSave = idCampaignSave;
	}

	public CampaignAsign getIdCampaignAsigned() {
		return idCampaignAsigned;
	}

	public void setIdCampaignAsigned(CampaignAsign idCampaignAsigned) {
		this.idCampaignAsigned = idCampaignAsigned;
	}

	public Territory getIdTerritorySave() {
		return idTerritorySave;
	}

	public void setIdTerritorySave(Territory idTerritorySave) {
		this.idTerritorySave = idTerritorySave;
	}

	public Planet getIdPlanetSave() {
		return idPlanetSave;
	}

	public void setIdPlanetSave(Planet idPlanetSave) {
		this.idPlanetSave = idPlanetSave;
	}

	public Regions getIdRegionSave() {
		return idRegionSave;
	}

	public void setIdRegionSave(Regions idRegionSave) {
		this.idRegionSave = idRegionSave;
	}

	public Galaxy getIdGalaxySave() {
		return idGalaxySave;
	}

	public void setIdGalaxySave(Galaxy idGalaxySave) {
		this.idGalaxySave = idGalaxySave;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
