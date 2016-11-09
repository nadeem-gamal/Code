package edu.electronics.enums;

public enum CapacitorType {

	POLAR(0),
	CERAMIC(1);
	
	private int code;
	
	CapacitorType(int code){
		this.code = code;
	}
	public int getCode(){
		return code;
	}
}
