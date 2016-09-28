package rest;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.json.JsonArray;


public class ForecastGatherer {
	
	
	
	Client client=ClientBuilder.newClient();
	//TODO ADD REST URL
	WebTarget target = client.target("enterurlhere");
		//.queryParam("paramname","value");
	JsonArray response=target.request(MediaType.APPLICATION_JSON)
			.get(JsonArray.class);
	// do stuff with results after this
	
}
