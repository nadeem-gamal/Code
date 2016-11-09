package edu.electronics.enums;

public enum TransistorType {

	;
	
	private int code;
	
	TransistorType(int code){
		this.code = code;
	}
	public int getCode(){
		return code;
	}
}
