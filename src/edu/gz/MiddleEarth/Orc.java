package edu.gz.MiddleEarth;

/**
 * Represents a Orc in Middle-earth.
 */
public class Orc extends MiddleEarthCharacter {

    /**
     * Constructor to initialize a Orc character.
     * 
     * @param name   The name of the Orc.
     * @param health The Orc's health points.
     * @param power  The Orc's attack power.
     */
    public Orc(String name, double health, double power) {
        super(name, health, power);
    }
    
    /**
     * Attacks another character. Orcs cannot attack their own kind.
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
     * @return "Orc" as the race of this character.
     */
    @Override
    public String getRace() {
        return "Orc";
    }
}
