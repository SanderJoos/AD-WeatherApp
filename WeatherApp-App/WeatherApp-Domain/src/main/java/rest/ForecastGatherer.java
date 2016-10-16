package rest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import model.City;
import model.Forecast;

import javax.json.JsonArray;
import javax.json.JsonObject;


public class ForecastGatherer {

    private final String URL = "http://api.wunderground.com/api/b2d97c37f90887e5/conditions/q/";
    private final String LeuvenURL = "http://api.wunderground.com/api/b2d97c37f90887e5/forecast10day/q/BE/Leuven.json";
    
    public City getCityForecast(City city){

    	Client client=ClientBuilder.newClient();
    	WebTarget target = client.target(LeuvenURL);
    	JsonArray response=target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
    	JsonArray forecast = response.getJsonArray(1);
    	JsonArray forecast_txt = forecast.getJsonArray(0);
    	JsonArray forecastDays = forecast_txt.getJsonArray(1);
    	this.addDailyForecastToCity(city, forecastDays);
    	City cityresp=new City(city.getCountry(),city.getCityName());
    	System.out.println(response);
    	return cityresp;
    }
    
    private void addDailyForecastToCity(City city, JsonArray forecastDays){
    	JsonObject day;
    	for(int i=0; i < 20; i+=2){
    		day = forecastDays.getJsonObject(i);
    		String title = day.getString("title");
    		String description = day.getString("fcttext_metric");
    		Forecast forecast = new Forecast(title +":" + description);
    		city.addForecast(forecast);
    	}
    	
    }
}
