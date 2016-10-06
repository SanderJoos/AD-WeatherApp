package ui;

import javax.swing.JOptionPane;

import service.WeatherService;

public class MainWindow {
	
	private WeatherService service;
	
	public MainWindow(){
		this.service = new WeatherService();
	}
	
	public void launch(){
		
		while(true){
			String country = JOptionPane.showInputDialog(null, "What country?");
			String city = JOptionPane.showInputDialog(null,"What city?");
			String forecast = service.getForecastForCityStringsAsString(city, country);		
			JOptionPane.showMessageDialog(null, forecast);
		}
	}

}
