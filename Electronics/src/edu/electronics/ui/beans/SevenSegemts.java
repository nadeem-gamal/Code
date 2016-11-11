package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.SevenSegment;
import edu.electronics.dal.services.SevenSegmentService;

@SuppressWarnings("serial")
@ManagedBean(name = "sevenSegments")
@ViewScoped
public class SevenSegemts extends BaseBean {
	private SevenSegment sevenSegment;
	private List<SevenSegment> sevenSegmentList;

	public SevenSegemts() {
		super();
		init();
	}

	private void init() {
		sevenSegment = new SevenSegment();
		sevenSegmentList = SevenSegmentService.getAllSevenSegments();
	}

	public void save() {
		SevenSegmentService.saveSevenSegment(sevenSegment);
		sevenSegmentList.add(sevenSegment);
		sevenSegment = new SevenSegment();
	}

	public SevenSegment getSevenSegment() {
		return sevenSegment;
	}

	public void setSevenSegment(SevenSegment sevenSegment) {
		this.sevenSegment = sevenSegment;
	}

	public List<SevenSegment> getSevenSegmentList() {
		return sevenSegmentList;
	}

	public void setSevenSegmentList(List<SevenSegment> sevenSegmentList) {
		this.sevenSegmentList = sevenSegmentList;
	}

}
