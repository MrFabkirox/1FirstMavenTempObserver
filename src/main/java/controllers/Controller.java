package controllers;

import views.View;
import models.Model;

public class Controller {

	Model m;
	View v;
	
	public Controller(Model m) {
		this.m = m;
		v = new View(m, this);
	}

	public void setInput() {
		double value = 0;
		
		try {
			value = Double.valueOf(v.getEntry());
			m.setTemperature(value);
		} catch(Exception e) {
			v.showError("Set number in the textfield");
		}
	}

	public void upValue() {
		m.upTemp();
	}

	public void downValue() {
		m.downTemp();
	}

}
