package db.cityForecastDB;

import java.util.List;

import model.City;
import model.Forecast;

public interface ICityForecastDB {
	
	List<Forecast> getForecastForCity(City city);
	void addForeCastToCity(City city, Forecast forecast);
	void addListOfForecastsToCity(City city, List<Forecast> forecasts);
	void addCityToDB(City city);
	List<Forecast> getForecastForCityStrings(String cityName, String country);
        void storeForecastInDb(City city);
}
