package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.Capacitor;
import edu.electronics.dal.orm.Resistor;
import edu.electronics.dal.services.CapacitorService;
import edu.electronics.dal.services.ResistorService;

@SuppressWarnings("serial")
@ManagedBean(name = "capacitors")
@ViewScoped
public class Capacitors extends BaseBean {
	private Capacitor capacitor;
	private List<Capacitor> capacitorList;

	public Capacitors() {
		super();
		init();
	}

	private void init() {
		capacitor = new Capacitor();
		capacitorList = CapacitorService.getAllCapacitors();
	}

	public void save() {
		CapacitorService.saveCapacitor(capacitor);
		capacitorList.add(capacitor);
		capacitor = new Capacitor();
	}

	
	public void delete(Capacitor capacitor) {
		CapacitorService.deleteCapacitor(capacitor);
		capacitorList.remove(capacitor);
	}

	public Capacitor getCapacitor() {
		return capacitor;
	}

	public void setCapacitor(Capacitor capacitor) {
		this.capacitor = capacitor;
	}

	public List<Capacitor> getCapacitorList() {
		return capacitorList;
	}

	public void setCapacitorList(List<Capacitor> capacitorList) {
		this.capacitorList = capacitorList;
	}

}
