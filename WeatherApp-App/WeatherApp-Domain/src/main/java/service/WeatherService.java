package service;

import java.util.List;

import db.cityForecastDB.*;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import model.City;
import model.Forecast;

@Dependent
@Stateless
public class WeatherService {

    @Inject
    private ICityForecastDB db;

    public WeatherService() {
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

    public String getForecastForCityStringsAsString(String city, String country) {
        List<Forecast> forecasts = db.getForecastForCityStrings(city, country);
        String toReturn = city + ", " + country + "\n";
        if (forecasts.isEmpty()) {
            toReturn += "No match found, did you try using english city names (Like Antwerp and Brussels) \n also the correct city abreviation, like BE? \n "
                    + "Nederlands kan ook werken, de API biedt steden aan zoals ook Gent en Zaventem, \n inclusief ook Antwerpen, Brussel en Leuven";
        } else {
            for (Forecast f : forecasts) {
                toReturn += f.getDescripton() + "\n";
            }
        }
        return toReturn;
    }

    @Schedule(hour="*", minute="*/10", persistent = false)
    public void getSomeForecasts() {
        Map<String, String> citiesInCountries = new HashMap<String, String>();
        citiesInCountries.put("Brussels", "BE");
        citiesInCountries.put("Leuven", "BE");
        citiesInCountries.put("Antwerp", "BE");
        citiesInCountries.put("Zaventem", "BE");
        citiesInCountries.put("Gent", "BE");

        System.out.println("now querying for cities");
        City city;
        for (Map.Entry<String, String> entry : citiesInCountries.entrySet()) {
            city = new City(entry.getValue(), entry.getKey());
            db.storeForecastInDb(city);
        }
    }
}
