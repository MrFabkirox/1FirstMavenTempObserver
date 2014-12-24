package models;

import java.util.ArrayList;
import java.util.List;

import views.View;

public class Model {
	
	double temperature = 0;
	List<Observer> observers = new ArrayList<>();
	
	public Model() {		
	}

	public void registerObserver(Observer obs) {
		observers.add(obs);
	}

	private void updateObserver() {
		for(Observer obs: observers) {
			obs.update();
		}
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double value) {
		this.temperature = value;
		updateObserver();
	}

	public void upTemp() {
		setTemperature(++temperature);
	}

	public void downTemp() {
		setTemperature(--temperature);
	}
}
