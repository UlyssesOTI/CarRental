package com.ulyssess.carrental.enums;

public enum GearBox {
	
	AUTOMATIC(1),
	MECHANIC(2);
	
	public final int id;
	
	GearBox(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	


}
