package service;
import java.util.List;

import db.cityForecastDB.*;
import model.City;
import model.Forecast;

public class WeatherService{
	
	private ICityForecastDB db;
	
	public WeatherService(){
		this.db = new InMemoryDB();
	}

	public List<Forecast> getForecastForCity(City city) {
		return db.getForecastForCity(city);
	}

	public void addForeCastToCity(City city, Forecast forecast) {
		db.addForeCastToCity(city, forecast);
	}

	public void addListOfForecastsToCity(City city, List<Forecast> forecasts) {
		db.addListOfForecastsToCity(city, forecasts);
	}

	public void addCityToDB(City city) {
		db.addCityToDB(city);
	}

	public List<Forecast> getForecastForCityStrings(String cityName, String country) {
		return db.getForecastForCityStrings(cityName, country);
	}
}
