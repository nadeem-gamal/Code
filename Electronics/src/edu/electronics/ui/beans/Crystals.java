package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.Crystal;
import edu.electronics.dal.services.CrystalService;

@SuppressWarnings("serial")
@ManagedBean(name = "crystals")
@ViewScoped
public class Crystals extends BaseBean {
	private Crystal crystal;
	private List<Crystal> crystalList;

	public Crystals() {
		super();
		init();
	}

	private void init() {
		crystal = new Crystal();
		crystalList = CrystalService.getAllCrystals();
	}

	public void save() {
		CrystalService.saveCrystal(crystal);
		crystalList.add(crystal);
		crystal = new Crystal();
	}

	public Crystal getCrystal() {
		return crystal;
	}

	public void setCrystal(Crystal crystal) {
		this.crystal = crystal;
	}

	public List<Crystal> getCrystalList() {
		return crystalList;
	}

	public void setCrystalList(List<Crystal> crystalList) {
		this.crystalList = crystalList;
	}

}
