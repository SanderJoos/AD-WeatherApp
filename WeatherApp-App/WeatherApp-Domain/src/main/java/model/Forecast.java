package model;

import java.time.LocalDateTime;

public class Forecast {

	private LocalDateTime timeStamp;
	private String descripton;
	
	public Forecast(){
		
	}
	
	public Forecast(LocalDateTime timeStamp, String description){
		this.setTimeStamp(timeStamp);
		this.setDescripton(description);
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	
	
	
}
