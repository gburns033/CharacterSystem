package edu.gz.MiddleEarth;

public abstract class MiddleEarthCharacter {
	String name;
	double health;
	double power;
	
	public MiddleEarthCharacter () {
		name = "";
		health = 0;
		power = 0;
	}

	protected abstract boolean attack(MiddleEarthCharacter target);
	protected abstract void displayInfo();
}