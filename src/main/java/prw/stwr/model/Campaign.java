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
	
	@ManyToOne
	@JoinColumn(name = "ID_USER_UST", referencedColumnName = "ID_USER_UST")
	private Usuario idUserCampaign;
	
	public Campaign() {
		
	}

	public Campaign(long idCampaign, String campaignName, String campaignStory, boolean activerow,
			Usuario idUserCampaign) {
		this.idCampaign = idCampaign;
		this.campaignName = campaignName;
		this.campaignStory = campaignStory;
		this.activerow = activerow;
		this.idUserCampaign = idUserCampaign;
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

	public Usuario getIdUserCampaign() {
		return idUserCampaign;
	}

	public void setIdUserCampaign(Usuario idUserCampaign) {
		this.idUserCampaign = idUserCampaign;
	}
}
