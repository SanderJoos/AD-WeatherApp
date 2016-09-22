package model;

public class City {
	
	private String country;
	private String cityName;
	
	public City(){
		
	}
	
	public City(String country, String cityName){
		this.setCityName(cityName);
		this.setCountry(country);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	//TODO equals
	//TODO hashCode

}
