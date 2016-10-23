/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.weatherapp.rest;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import service.WeatherService;

/**
 * REST Web Service
 *
 * @author Sander_2
 */
@Path("/weather")
public class WeatherResource {
    
    @Inject
    private WeatherService service;

    /**
     * Creates a new instance of WeatherResource
     */
    public WeatherResource() {
    }

    @GET
    @Produces("text/plain")
    public String getMessage(){
        return "hallo";
    }
    
    @Path("{country}-{city}")
    @GET
    @Produces("text/plain")
    public String getForecastForCity(@PathParam("country")String country, @PathParam("city")String city) {
        return this.service.getForecastForCityStringsAsString(city, country);
    }
}
