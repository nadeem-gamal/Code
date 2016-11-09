package edu.electronics.enums;

public enum LEDColor {

	RED(0),
	GREEN(1),
	WHITE(2),
	YELLOW(3);
	
	private int code;
	
	LEDColor(int code){
		this.code = code;
	}
	public int getCode(){
		return code;
	}
}
