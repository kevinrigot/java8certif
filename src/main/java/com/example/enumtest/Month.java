package com.example.enumtest;

public enum Month {
	MARCH(31),
	APRIL(30);
	private int DAYS;

	private Month(int dAYS) {
		DAYS = dAYS;
	}

	public int getDAYS() {
		return DAYS;
	}

	
	
}
