package edu.gz.MiddleEarth;

/**
 * Represents a Elf in Middle-earth.
 */
public class Elf extends MiddleEarthCharacter {    

    /**
     * Constructor to initialize a Elf character.
     * 
     * @param name   The name of the Elf.
     * @param health The Elf's health points.
     * @param power  The Elf's attack power.
     */
    public Elf(String name, double health, double power) {
        super(name, health, power);
    }
    
    /**
     * Attacks another character. Elves cannot attack their own kind.
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
     * @return "Elf" as the race of this character.
     */
    @Override
    public String getRace() {
        return "Elf";
    }
}