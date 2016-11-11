package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.IC;
import edu.electronics.dal.services.ICService;

@SuppressWarnings("serial")
@ManagedBean(name = "ics")
@ViewScoped
public class ICs extends BaseBean {
	private IC ic;
	private List<IC> icList;

	public ICs() {
		super();
		init();
	}

	private void init() {
		ic = new IC();
		icList = ICService.getAllICs();
	}

	public void save() {
		ICService.saveIC(ic);
		icList.add(ic);
		ic = new IC();
	}

	public IC getIc() {
		return ic;
	}

	public void setIc(IC ic) {
		this.ic = ic;
	}

	public List<IC> getIcList() {
		return icList;
	}

	public void setIcList(List<IC> icList) {
		this.icList = icList;
	}

}
