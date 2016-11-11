package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.PushButton;
import edu.electronics.dal.services.PushButtonService;

@SuppressWarnings("serial")
@ManagedBean(name = "pushButtons")
@ViewScoped
public class PushButtons extends BaseBean {
	private PushButton pushButton;
	private List<PushButton> pushButtonList;

	public PushButtons() {
		super();
		init();
	}

	private void init() {
		pushButton = new PushButton();
		pushButtonList  = PushButtonService.getAllPushButtons();
	}

	public void save() {
		PushButtonService.savePushButton(pushButton);
		pushButtonList.add(pushButton);
		pushButton= new PushButton();
	}

	public PushButton getPushButton() {
		return pushButton;
	}

	public void setPushButton(PushButton pushButton) {
		this.pushButton = pushButton;
	}

	public List<PushButton> getPushButtonList() {
		return pushButtonList;
	}

	public void setPushButtonList(List<PushButton> pushButtonList) {
		this.pushButtonList = pushButtonList;
	}


}
