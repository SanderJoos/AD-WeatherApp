package db.cityForecastDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;

import model.City;
import model.Forecast;
import rest.ForecastGatherer;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Dependent
@Default
public class InMemoryDB implements ICityForecastDB {

    private HashMap<City, List<Forecast>> forecastsForCities;

    @Inject
    private ForecastGatherer gatherer;

    public InMemoryDB() {
        this.forecastsForCities = new HashMap<City, List<Forecast>>();
    }

    public HashMap<City, List<Forecast>> getForecastsForCities() {
        return forecastsForCities;
    }

    public void addForecastForCityInMemory(City city, List<Forecast> forecast) {
        if (this.forecastsForCities.containsKey(city)) {
            this.forecastsForCities.remove(city);
            this.forecastsForCities.put(city, forecast);
        } else {
            this.forecastsForCities.put(city, forecast);
        }
    }

    public List<Forecast> getForecastForCity(City city) {
        List<Forecast> forecasts = new ArrayList<Forecast>();
        if (this.forecastsForCities.containsKey(city)) {
            return this.getForecastsForCities().get(city);
        } else {
            forecasts = gatherer.getCityForecast(city).getForecasts();
            this.addForecastForCityInMemory(city, forecasts);
        }
        return forecasts;
    }

    public void addForeCastToCity(City city, Forecast forecast) {
        this.getForecastsForCities().remove(city);
        city.addForecast(forecast);
        this.addCityToDB(city);
    }

    public void addListOfForecastsToCity(City city, List<Forecast> forecasts) {
        this.getForecastsForCities().remove(city);
        for (Forecast f : forecasts) {
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

    public void storeForecastInDb(City city) {
        this.getForecastForCity(city);
    }
}
