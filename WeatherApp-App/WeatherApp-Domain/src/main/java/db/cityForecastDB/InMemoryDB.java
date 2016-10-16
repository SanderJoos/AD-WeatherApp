package db.cityForecastDB;

import java.util.HashMap;
import java.util.List;

import model.City;
import model.Forecast;
import rest.ForecastGatherer;


public class InMemoryDB implements ICityForecastDB{
	
	private HashMap<City, List<Forecast>> forecastsForCities;
	
	private ForecastGatherer gatherer;
	
	public InMemoryDB(){
		this.forecastsForCities = new HashMap<City, List<Forecast>>();
		this.gatherer = new ForecastGatherer();
	}	

	public HashMap<City, List<Forecast>> getForecastsForCities() {
		return forecastsForCities;
	}

	public List<Forecast> getForecastForCity(City city) {
		if(this.forecastsForCities.containsKey(city)){
			return this.getForecastsForCities().get(city);
		}
		return gatherer.getCityForecast(city).getForecasts();
	}

	public void addForeCastToCity(City city, Forecast forecast) {
		this.getForecastsForCities().remove(city);
		city.addForecast(forecast);
		this.addCityToDB(city);
	}

	public void addListOfForecastsToCity(City city, List<Forecast> forecasts) {
		this.getForecastsForCities().remove(city);
		for(Forecast f : forecasts){
			city.addForecast(f);
		}
		this.addCityToDB(city);
	}

	public void addCityToDB(City city) {
		this.getForecastsForCities().put(city, city.getForecasts());
	}

	public List<Forecast> getForecastForCityStrings(String cityName, String country) {
		City city = new City(country, cityName);
		return this.getForecastForCity(city);
	}
}
