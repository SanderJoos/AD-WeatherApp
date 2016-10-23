package ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import service.WeatherService;

public class MainWindow {

    @Inject
    private WeatherService service;

    public MainWindow() {
    }

    public void launch() {

        //only local, in case of failure api on server should be called
        //try-catch should do it
        String URL="";
        URL = "http://localhost:15148/WeatherApp-Rest/API/weather/";
        String LeuvenURL = "http://localhost:15148/WeatherApp-Rest/API/weather/BE-Leuven";
        Client client = ClientBuilder.newClient();
        ObjectMapper objectMapper = new ObjectMapper();

        String country = JOptionPane.showInputDialog(null, "What country?");
        String city = JOptionPane.showInputDialog(null, "What city?");
        URL += country + "-" + city;
        System.out.println(URL);
        WebTarget target = client.target(URL);
        String forecast = target.request(MediaType.TEXT_PLAIN).get(String.class);
        JOptionPane.showMessageDialog(null, forecast);

    }

}
