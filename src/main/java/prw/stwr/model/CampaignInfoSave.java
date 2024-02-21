package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Gauardar información de las campañas y usuario segun identificadores

@Entity
@Table(name = "campaignterritory_stwr")
public class CampaignInfoSave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CAMPAIGNTERRITORY_CST")
	private long idCampaignSave;
	
	@Column(name = "ID_CAMPAIGNASIGN_CST")
	private long idCampaignAsigned; //campaignasign_stwr ID_CAMPAIGNASIGN_CST
	
	@Column(name = "ID_TERRITORY_TST")
	private long idTerritorySave;
	
	@Column(name = "ID_PLANET_PST")
	private long idPlanetSave;
	
	@Column(name = "ID_SYSTEM_SST")
	private long idRegionSave;
	
	@Column(name = "ID_GALAXY_GST")
	private long idGalaxySave;
	
	@Column(name = "ACTIVEROW_CAMPAIGNTERRITORY_CST")
	private boolean activerow;
	
	public CampaignInfoSave() {}

	public CampaignInfoSave(long idCampaignSave, long idCampaignAsigned, long idTerritorySave, long idPlanetSave,
			long idRegionSave, long idGalaxySave, boolean activerow) {
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

	public long getIdCampaignAsigned() {
		return idCampaignAsigned;
	}

	public void setIdCampaignAsigned(long idCampaignAsigned) {
		this.idCampaignAsigned = idCampaignAsigned;
	}

	public long getIdTerritorySave() {
		return idTerritorySave;
	}

	public void setIdTerritorySave(long idTerritorySave) {
		this.idTerritorySave = idTerritorySave;
	}

	public long getIdPlanetSave() {
		return idPlanetSave;
	}

	public void setIdPlanetSave(long idPlanetSave) {
		this.idPlanetSave = idPlanetSave;
	}

	public long getIdRegionSave() {
		return idRegionSave;
	}

	public void setIdRegionSave(long idRegionSave) {
		this.idRegionSave = idRegionSave;
	}

	public long getIdGalaxySave() {
		return idGalaxySave;
	}

	public void setIdGalaxySave(long idGalaxySave) {
		this.idGalaxySave = idGalaxySave;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}
}
