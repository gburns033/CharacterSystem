package edu.gz.MiddleEarth;

/**
 * Represents a Human in Middle-earth.
 */
public class Human extends MiddleEarthCharacter {

    /**
     * Constructor to initialize a Human character.
     * 
     * @param name   The name of the Human.
     * @param health The Human's health points.
     * @param power  The Human's attack power.
     */
    public Human(String name, double health, double power) {
        super(name, health, power);
    }
    
    /**
     * Attacks another character. Humans cannot attack their own kind.
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
     * @return "Human" as the race of this character.
     */
    @Override
    public String getRace() {
        return "Human";
    }
}
