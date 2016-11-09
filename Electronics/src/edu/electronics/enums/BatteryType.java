package edu.electronics.enums;

public enum BatteryType {

	AAA(0),
	AA(0)
	;
	
	private int code;
	
	BatteryType(int code){
		this.code = code;
	}
	public int getCode(){
		return code;
	}
}
