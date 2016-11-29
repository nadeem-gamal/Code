package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.Resistor;
import edu.electronics.dal.orm.Transistor;
import edu.electronics.dal.services.ResistorService;
import edu.electronics.dal.services.TransistorService;

@SuppressWarnings("serial")
@ManagedBean(name = "transistors")
@ViewScoped
public class Transistors extends BaseBean {
	private Transistor transistor;
	private List<Transistor> transistorList;

	public Transistors() {
		super();
		init();
	}

	private void init() {
		transistor = new Transistor();
		transistorList = TransistorService.getAllTransistors();
	}

	public void save() {
		TransistorService.saveTransistor(transistor);
		transistorList.add(transistor);
		transistor = new Transistor();
	}

	
	public void delete(Transistor transistor) {
		TransistorService.deleteTransistor(transistor);
		transistorList.remove(transistor);
	}
	public Transistor getTransistor() {
		return transistor;
	}

	public void setTransistor(Transistor transistor) {
		this.transistor = transistor;
	}

	public List<Transistor> getTransistorList() {
		return transistorList;
	}

	public void setTransistorList(List<Transistor> transistorList) {
		this.transistorList = transistorList;
	}

}
