package model;

import java.time.LocalDateTime;

public class Forecast {

	private double temperature;
	private LocalDateTime timeStamp;
	
	public Forecast(){
		
	}
	
	public Forecast(double temperature, LocalDateTime timeStamp){
		this.setTemperature(temperature);
		this.setTimeStamp(timeStamp);
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
}
