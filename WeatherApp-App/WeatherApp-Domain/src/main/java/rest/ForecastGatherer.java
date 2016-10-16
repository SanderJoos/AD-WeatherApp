package rest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        ObjectMapper objectMapper=new ObjectMapper();
    	WebTarget target = client.target(LeuvenURL);
    	String response=target.request(MediaType.APPLICATION_JSON).get(String.class);
        City cityresp=new City(city.getCountry(),city.getCityName());
        try {
            JsonNode rootNode=objectMapper.readTree(response);
            JsonNode forecastNode=rootNode.path("forecast");
            JsonNode txt_forecastNode=forecastNode.path("txt_forecast");
            JsonNode forecastday=txt_forecastNode.path("forecastday");
            Iterator<JsonNode> elements=forecastday.elements();
            System.out.println("This still works");
            while(elements.hasNext()){
                JsonNode actualForecast=elements.next();
                JsonNode title=actualForecast.path("title");
                JsonNode fcttext_metric=actualForecast.path("fcttext_metric");
                cityresp.addForecast(new Forecast(title.textValue() +":" + fcttext_metric.textValue()));
                //System.out.println(title.textValue());
                //System.out.println(fcttext_metric.textValue());
            }
        } catch (IOException ex) {
            Logger.getLogger(ForecastGatherer.class.getName()).log(Level.SEVERE, null, ex);
        }
    	//this.addDailyForecastToCity(city, forecastDays);
    	//System.out.println(response);
    	return cityresp;
    }
    
//    private void addDailyForecastToCity(City city, JsonArray forecastDays){
//    	JsonObject day;
//    	for(int i=0; i < 20; i+=2){
//    		day = forecastDays.getJsonObject(i);
//    		String title = day.getString("title");
//    		String description = day.getString("fcttext_metric");
//    		Forecast forecast = new Forecast(title +":" + description);
//    		city.addForecast(forecast);
//    	}
//    	
//    }
}
