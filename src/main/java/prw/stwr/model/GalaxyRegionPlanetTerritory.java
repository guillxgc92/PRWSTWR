package prw.stwr.model;

public class GalaxyRegionPlanetTerritory {

	private String campaignNameString;
	
	private Galaxy galaxy;
	
	private Regions regions;
	
	private Planet planet;
	
	private Territory territory;

	public GalaxyRegionPlanetTerritory() {
	}

	public GalaxyRegionPlanetTerritory(String campaignNameString, Galaxy galaxy, Regions regions, Planet planet,
			Territory territory) {
		this.campaignNameString = campaignNameString;
		this.galaxy = galaxy;
		this.regions = regions;
		this.planet = planet;
		this.territory = territory;
	}

	public String getCampaignNameString() {
		return campaignNameString;
	}

	public void setCampaignNameString(String campaignNameString) {
		this.campaignNameString = campaignNameString;
	}

	public Galaxy getGalaxy() {
		return galaxy;
	}

	public void setGalaxy(Galaxy galaxy) {
		this.galaxy = galaxy;
	}

	public Regions getRegions() {
		return regions;
	}

	public void setRegions(Regions regions) {
		this.regions = regions;
	}

	public Planet getPlanet() {
		return planet;
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public Territory getTerritory() {
		return territory;
	}

	public void setTerritory(Territory territory) {
		this.territory = territory;
	}
	@Override
	public String toString() {
		
		return "";
	}
}
