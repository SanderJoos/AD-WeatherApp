package model;

import java.time.LocalDateTime;

public class Forecast {

	private double temperature;
	private City city;
	private LocalDateTime timeStamp;
	
	public Forecast(){
		
	}
	
	public Forecast(double temperature, City city, LocalDateTime timeStamp){
		this.setCity(city);
		this.setTemperature(temperature);
		this.setTimeStamp(timeStamp);
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
}
