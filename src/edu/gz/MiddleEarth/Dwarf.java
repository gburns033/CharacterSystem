package edu.gz.MiddleEarth;

/**
 * Represents a Dwarf in Middle-earth.
 */
public class Dwarf extends MiddleEarthCharacter {    

    /**
     * Constructor to initialize a Dwarf character.
     * 
     * @param name   The name of the Dwarf.
     * @param health The Dwarf's health points.
     * @param power  The Dwarf's attack power.
     */
    public Dwarf(String name, double health, double power) {
        super(name, health, power);
    }
    
    /**
     * Attacks another character. Dwarfs cannot attack their own kind.
     * 
     * @param target The character being attacked.
     * @return true if the attack was successful, false otherwise.
     */
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target != null && (target.getRace().equals(this.getRace()) || target.getRace().equals("Wizard"))) {
            return false;
        }

        if (target.getRace().equals("Elf")) {
        	double truePower = power * 1.5;
        	target.health = target.health - truePower > 0 ? target.health - truePower : 0;

            return true;
        }
        
        // Deal damage while ensuring health doesn't go negative
        target.health = target.health - power > 0 ? target.health - power : 0;

        return true;
    }

    /**
     * Returns the race of the character.
     * 
     * @return "Dwarf" as the race of this character.
     */
    @Override
    public String getRace() {
        return "Dwarf";
    }
}