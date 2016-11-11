package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.Resistor;
import edu.electronics.dal.services.ResistorService;

@SuppressWarnings("serial")
@ManagedBean(name = "resistors")
@ViewScoped
public class Resistors extends BaseBean {
	private Resistor resistor;
	private List<Resistor> resistorList;

	public Resistors() {
		super();
		init();
	}

	private void init() {
		resistor = new Resistor();
		resistorList = ResistorService.getAllResistors();
	}

	public void save() {
		ResistorService.saveResistor(resistor);
		resistorList.add(resistor);
		resistor = new Resistor();
	}

	public Resistor getResistor() {
		return resistor;
	}

	public void setResistor(Resistor resistor) {
		this.resistor = resistor;
	}

	public List<Resistor> getResistorList() {
		return resistorList;
	}

	public void setResistorList(List<Resistor> resistorList) {
		this.resistorList = resistorList;
	}

	
}
