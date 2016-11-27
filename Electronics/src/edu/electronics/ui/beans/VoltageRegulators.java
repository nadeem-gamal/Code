package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.Resistor;
import edu.electronics.dal.orm.VoltageRegulator;
import edu.electronics.dal.services.ResistorService;
import edu.electronics.dal.services.VoltageRegulatorService;

@SuppressWarnings("serial")
@ManagedBean(name = "voltageRegulators")
@ViewScoped
public class VoltageRegulators extends BaseBean {
	private VoltageRegulator voltageRegulator;
	private List<VoltageRegulator> voltageRegulatorList;

	public VoltageRegulators() {
		super();
		init();
	}

	private void init() {
		voltageRegulator = new VoltageRegulator();
		voltageRegulatorList = VoltageRegulatorService.getAllVoltageRegulators();
	}

	public void save() {
		VoltageRegulatorService.saveVoltageRegulator(voltageRegulator);
		voltageRegulatorList.add(voltageRegulator);
		voltageRegulator = new VoltageRegulator();
	}
	
	public void delete(VoltageRegulator voltageRegulator) {
		VoltageRegulatorService.deleteVoltageRegulator(voltageRegulator);
		voltageRegulatorList.remove(voltageRegulator);
	}

	public VoltageRegulator getVoltageRegulator() {
		return voltageRegulator;
	}

	public void setVoltageRegulator(VoltageRegulator voltageRegulator) {
		this.voltageRegulator = voltageRegulator;
	}

	public List<VoltageRegulator> getVoltageRegulatorList() {
		return voltageRegulatorList;
	}

	public void setVoltageRegulatorList(List<VoltageRegulator> voltageRegulatorList) {
		this.voltageRegulatorList = voltageRegulatorList;
	}
}
