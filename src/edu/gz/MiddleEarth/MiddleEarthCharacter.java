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
	protected abstract String getRace();
	public void displayInfo() {
		System.out.println("Name: " + name + "\nHealth: " + health + "\nPower: " + power + "\nRace: " + getRace());
	}
}