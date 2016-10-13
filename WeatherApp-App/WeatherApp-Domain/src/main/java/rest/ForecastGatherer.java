package rest;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import model.City;

import javax.json.JsonArray;


public class ForecastGatherer {

    private final String URL = "http://api.wunderground.com/api/b2d97c37f90887e5/conditions/q/";
    public City getCityForecast(){

    Client client=ClientBuilder.newClient();
    WebTarget target = client.target(URL+"BE"+"/"+"Leuven"+".jsp");
    JsonArray response=target.request(MediaType.APPLICATION_JSON)
            .get(JsonArray.class);
    // do stuff with results after this
    City cityresp=new City("Belgium","Leuven");
    System.out.println(response);
    return cityresp;
    }
}
