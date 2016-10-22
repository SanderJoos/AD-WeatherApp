package ui;

import javax.inject.Inject;
import javax.swing.JOptionPane;

import service.WeatherService;

public class MainWindow {

    @Inject
    private WeatherService service;

    public MainWindow() {
    }

    public void launch() {

        while (true) {
            String country = JOptionPane.showInputDialog(null, "What country?");
            String city = JOptionPane.showInputDialog(null, "What city?");
            String forecast = service.getForecastForCityStringsAsString(city, country);
            JOptionPane.showMessageDialog(null, forecast);
        }
    }

}
