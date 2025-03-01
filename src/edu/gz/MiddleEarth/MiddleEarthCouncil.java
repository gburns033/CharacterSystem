package edu.gz.MiddleEarth;

/**
 * Singleton class representing the Middle-earth Council.
 * Provides access to the character management system.
 */
public class MiddleEarthCouncil {
    private static MiddleEarthCouncil instance;
    private CharacterManager characterManager;

    /**
     * Private constructor to prevent instantiation from outside.
     */
    private MiddleEarthCouncil() {
        characterManager = new CharacterManager();
    }	

    /**
     * Returns the instance of MiddleEarthCouncil.
     * Ensures only one instance exists.
     *
     * @return The single instance of MiddleEarthCouncil.
     */
    public static MiddleEarthCouncil getInstance() {
        if (instance == null) {
            instance = new MiddleEarthCouncil();
        }
        
        return instance;
    }

    /**
     * Provides access to the CharacterManager.
     *
     * @return The CharacterManager instance.
     */
    public CharacterManager getCharacterManager() {
        return characterManager;
    }
}
