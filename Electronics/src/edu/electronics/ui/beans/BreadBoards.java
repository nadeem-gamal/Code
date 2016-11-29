package edu.electronics.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.electronics.dal.orm.BreadBoard;
import edu.electronics.dal.orm.Resistor;
import edu.electronics.dal.services.BreadBoardService;
import edu.electronics.dal.services.ResistorService;

@SuppressWarnings("serial")
@ManagedBean(name = "breadBoards")
@ViewScoped
public class BreadBoards extends BaseBean {
	private BreadBoard breadBoard;
	private List<BreadBoard> breadBoardList;

	public BreadBoards() {
		super();
		init();
	}

	private void init() {
		breadBoard = new BreadBoard();
		breadBoardList= BreadBoardService.getAllBreadBoards();
	}

	public void save() {
		BreadBoardService.saveBreadBoard(breadBoard);
		breadBoardList.add(breadBoard);
		breadBoard = new BreadBoard();
	}

	
	public void delete(BreadBoard breadBoard) {
		BreadBoardService.deleteBreadBoard(breadBoard);
		breadBoardList.remove(breadBoard);
	}

	public BreadBoard getBreadBoard() {
		return breadBoard;
	}

	public void setBreadBoard(BreadBoard breadBoard) {
		this.breadBoard = breadBoard;
	}

	public List<BreadBoard> getBreadBoardList() {
		return breadBoardList;
	}

	public void setBreadBoardList(List<BreadBoard> breadBoardList) {
		this.breadBoardList = breadBoardList;
	}




}
