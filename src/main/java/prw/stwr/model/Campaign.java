package prw.stwr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "campaign_stwr")
public class Campaign {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CAMPAIGN_CST")
	private long idCampaign;
	
	@Column(name = "CAMPAIGN_NAME_CST")
	private String campaignName;
	
	@Column(name = "CAMPAIGN_STORY_CST")
	private String campaignStory;
	
	@Column(name = "ACTIVEROW_CST")
	private boolean activerow;
	
	@Column(name = "ID_CAMPAIGNMASTER_CST") //ID USUARIO PROPIETARIO DE CAMPAÑA
	private long idCampaignMaster;
	
	@Column(name = "ID_TERRITORY_CST")
	private long idCampaignTerritory;
	
	public Campaign() {
		
	}
	
	public Campaign(long idCampaign, String campaignName, String campaignStory, boolean activerow,
			long idCampaignMaster, long idCampaignTerritory) {
		this.idCampaign = idCampaign;
		this.campaignName = campaignName;
		this.campaignStory = campaignStory;
		this.activerow = activerow;
		this.idCampaignMaster = idCampaignMaster;
		this.idCampaignTerritory = idCampaignTerritory;
	}

	public long getIdCampaign() {
		return idCampaign;
	}

	public void setIdCampaign(long idCampaign) {
		this.idCampaign = idCampaign;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getCampaignStory() {
		return campaignStory;
	}

	public void setCampaignStory(String campaignStory) {
		this.campaignStory = campaignStory;
	}

	public boolean isActiverow() {
		return activerow;
	}

	public void setActiverow(boolean activerow) {
		this.activerow = activerow;
	}

	public long getIdCampaignMaster() {
		return idCampaignMaster;
	}

	public void setIdCampaignMaster(long idCampaignMaster) {
		this.idCampaignMaster = idCampaignMaster;
	}

	public long getIdCampaignTerritory() {
		return idCampaignTerritory;
	}

	public void setIdCampaignTerritory(long idCampaignTerritory) {
		this.idCampaignTerritory = idCampaignTerritory;
	}
}
