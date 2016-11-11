package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.DipSwitch;
import edu.electronics.dal.services.DipSwitchService;

@SuppressWarnings("serial")
@ManagedBean(name = "dipSwitches")
@ViewScoped
public class DipSwitches extends BaseBean {
	private DipSwitch dipSwitch;
	private List<DipSwitch> dipSwitchList;

	public DipSwitches() {
		super();
		init();
	}

	private void init() {
		dipSwitch = new DipSwitch();
		dipSwitchList = DipSwitchService.getAllDipSwitches();
	}

	public void save() {
		DipSwitchService.saveDipSwitch(dipSwitch);
		dipSwitchList.add(dipSwitch);
		dipSwitch = new DipSwitch();
	}

	public DipSwitch getDipSwitch() {
		return dipSwitch;
	}

	public void setDipSwitch(DipSwitch dipSwitch) {
		this.dipSwitch = dipSwitch;
	}

	public List<DipSwitch> getDipSwitchList() {
		return dipSwitchList;
	}

	public void setDipSwitchList(List<DipSwitch> dipSwitchList) {
		this.dipSwitchList = dipSwitchList;
	}

}
