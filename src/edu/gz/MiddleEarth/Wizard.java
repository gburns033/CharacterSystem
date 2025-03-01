package edu.gz.MiddleEarth;

/**
 * Represents a Wizard in Middle-earth.
 */
public class Wizard extends MiddleEarthCharacter {    

    /**
     * Constructor to initialize a Wizard character.
     * 
     * @param name   The name of the Wizard.
     * @param health The Wizard's health points.
     * @param power  The Wizard's attack power.
     */
    public Wizard(String name, double health, double power) {
        super(name, health, power);
    }
    
    /**
     * Attacks another character. Wizards cannot attack their own kind.
     * 
     * @param target The character being attacked.
     * @return true if the attack was successful, false otherwise.
     */
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target.getRace().equals(this.getRace())) {
            return false;
        }

        // Deal damage while ensuring health doesn't go negative
        target.health = target.health - power > 0 ? target.health - power : 0;

        return true;
    }

    /**
     * Returns the race of the character.
     * 
     * @return "Wizard" as the race of this character.
     */
    @Override
    public String getRace() {
        return "Wizard";
    }
}