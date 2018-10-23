package org.contactCars.beans;


public class BaseBean {

	private int tableRows = 10;

	public BaseBean() {
		init();
	}

	private void init(){
	}

	public int getTableRows() {
		return tableRows;
	}

	public void setTableRows(int tableRows) {
		this.tableRows = tableRows;
	}
	
}
