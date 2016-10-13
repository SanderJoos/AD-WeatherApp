package rest;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import model.City;

import javax.json.JsonArray;
import javax.json.JsonObject;


public class ForecastGatherer {

    private final String URL = "http://api.wunderground.com/api/b2d97c37f90887e5/conditions/q/";
    private final String LeuvenURL = "http://api.wunderground.com/api/b2d97c37f90887e5/forecast10day/q/BE/Leuven.json";
    public City getCityForecast(){

    Client client=ClientBuilder.newClient();
    WebTarget target = client.target(LeuvenURL);
    JsonArray response=target.request(MediaType.APPLICATION_JSON)
            .get(JsonArray.class);
    JsonArray forecast = response.getJsonArray(1);
    JsonArray forecast_txt = forecast.getJsonArray(0);
    JsonArray forecastDay = forecast_txt.getJsonArray(1);
    City cityresp=new City("Belgium","Leuven");
    System.out.println(response);
    return cityresp;
    }
}
