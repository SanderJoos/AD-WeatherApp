package model;

import java.util.ArrayList;
import java.util.List;

public class City {
	
	private String country;
	private String cityName;
	private List<Forecast> forecasts;
	
	public City(){
		this.forecasts = new ArrayList<Forecast>();
	}
	
	public City(String country, String cityName){
		this.setCityName(cityName);
		this.setCountry(country);
		this.forecasts = new ArrayList<Forecast>();
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
	
	public List<Forecast> getForecasts(){
		return this.forecasts;
	}
	
	public void addForecast(Forecast forecast){
		this.getForecasts().add(forecast);
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof City){
			City c = (City) o;
			return this.getCityName().equals(c.getCityName()) && this.getCountry().equals(c.getCountry());
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return (this.getCityName().hashCode() + this.getCountry().hashCode()) % 32;
	}

}