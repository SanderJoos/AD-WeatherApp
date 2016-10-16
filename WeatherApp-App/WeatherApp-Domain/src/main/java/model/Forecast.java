package model;

public class Forecast {

	private String descripton;
	
	public Forecast(){
		
	}
	
	public Forecast(String description){
		this.setDescripton(description);
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	
	
	
}
