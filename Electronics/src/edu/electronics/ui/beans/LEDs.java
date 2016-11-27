package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.LED;
import edu.electronics.dal.orm.Resistor;
import edu.electronics.dal.services.LEDService;
import edu.electronics.dal.services.ResistorService;

@SuppressWarnings("serial")
@ManagedBean(name = "leds")
@ViewScoped
public class LEDs extends BaseBean {
	private LED led;
	private List<LED> ledList;

	public LEDs() {
		super();
		init();
	}

	private void init() {
		led = new LED();
		ledList = LEDService.getAllLEDs();
	}

	public void save() {
		LEDService.saveLED(led);
		ledList.add(led);
		led = new LED();
	}

	
	public void delete(LED led) {
		LEDService.deleteLED(led);
		ledList.remove(led);
	}
	public LED getLed() {
		return led;
	}

	public void setLed(LED led) {
		this.led = led;
	}

	public List<LED> getLedList() {
		return ledList;
	}

	public void setLedList(List<LED> ledList) {
		this.ledList = ledList;
	}

}
