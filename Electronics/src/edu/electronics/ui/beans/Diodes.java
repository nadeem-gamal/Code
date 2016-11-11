package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.Diode;
import edu.electronics.dal.services.DiodeService;

@SuppressWarnings("serial")
@ManagedBean(name = "diodes")
@ViewScoped
public class Diodes extends BaseBean {
	private Diode diode;
	private List<Diode> diodeList;

	public Diodes() {
		super();
		init();
	}

	private void init() {
		diode = new Diode();
		diodeList = DiodeService.getAllDiodes();
	}

	public void save() {
		DiodeService.saveDiode(diode);
		diodeList.add(diode);
		diode = new Diode();
	}

	public Diode getDiode() {
		return diode;
	}

	public void setDiode(Diode diode) {
		this.diode = diode;
	}

	public List<Diode> getDiodeList() {
		return diodeList;
	}

	public void setDiodeList(List<Diode> diodeList) {
		this.diodeList = diodeList;
	}

}
