package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.Battery;
import edu.electronics.dal.services.BatteryService;

@SuppressWarnings("serial")
@ManagedBean(name = "batteries")
@ViewScoped
public class Batteries extends BaseBean {
	private Battery battery;
	private List<Battery> batteryList;

	public Batteries() {
		super();
		init();
	}

	private void init() {
		battery = new Battery();
		batteryList = BatteryService.getAllBatteries();
	}

	public void save() {
		BatteryService.saveBattery(battery);
		batteryList.add(battery);
		battery = new Battery();
	}

	public Battery getBattery() {
		return battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	public List<Battery> getBatteryList() {
		return batteryList;
	}

	public void setBatteryList(List<Battery> batteryList) {
		this.batteryList = batteryList;
	}

}
