package edu.electronics.enums;

public enum SevenSegmentType {

	COMMON_ANODE(0),
	COMMON_CATHODE(1);
	
	private int code;
	
	SevenSegmentType(int code){
		this.code = code;
	}
	public int getCode(){
		return code;
	}
}
