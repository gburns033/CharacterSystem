package edu.gz.MiddleEarth;

public abstract class MiddleEarthCharacter {
    protected String name;
    protected double health;
    protected double power;

    /**
     * Constructor to initialize a MiddleEarthCharacter with the given attributes.
     * However, the current implementation incorrectly resets values to 0.
     * 
     * @param name   The name of the character.
     * @param health The health points of the character.
     * @param power  The attack power of the character.
     */
    public MiddleEarthCharacter(String name, double health, double power) {
        this.name = name;
        this.health = health;
        this.power = power;
    }

    /**
     * Abstract method that defines how the character attacks another character. The
     * attack is only successful if the target is not of the same race.
     * 
     * @param target The character being attacked.
     * @return true if the attack is successful, false otherwise.
     */
    protected abstract boolean attack(MiddleEarthCharacter target);

    /**
     * Abstract method to get the race of the character.
     * 
     * @return The race of the character as a string.
     */
    protected abstract String getRace();

    /**
     * Displays information about the character, including their name, health,
     * power, and race.
     */
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Power: " + power);
        System.out.println("Race: " + getRace());
    }
}