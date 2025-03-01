package edu.gz.MiddleEarth;

import java.util.Arrays;

public class CharacterManager {
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[1];
	private int size = 0;

	/**
	 * Helper method to insert a character into the array when space is available.
	 * 
	 * @param c The character to be inserted.
	 */
	private void insertCharacter(MiddleEarthCharacter c) {
		for (int i = size; i <= characters.length; i++) {
			if (characters[i] == null) {
				characters[i] = c;
				size++;
				break;
			}
		}
	}

	/**
	 * Adds a character to the array. If the array is full, it will resize the array
	 * to double its current size.
	 * 
	 * @param c The character to be added.
	 * @return true if the character was added successfully, false if the character
	 *         is null.
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {
		if (c == null) {
			return false;
		}

		if (size != characters.length) {
			insertCharacter(c);
			return true;
		} else {
			characters = Arrays.copyOf(characters, characters.length * 2);
			insertCharacter(c);
			return true;
		}
	}

	/**
	 * Retrieves a character from the array by their name.
	 * 
	 * @param name The name of the character to be retrieved.
	 * @return The character with the specified name, or null if no character with
	 *         that name exists.
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		if (name == null) {
			return null;
		}

		for (int i = 0; i <= characters.length; i++) {
			if (characters[i].name.equals(name)) {
				return characters[i];
			}
		}

		return null;
	}

	/**
	 * Updates the attributes of a character.
	 * 
	 * @param character The character whose attributes are to be updated.
	 * @param name      The new name for the character.
	 * @param health    The new health value for the character.
	 * @param power     The new power value for the character.
	 * @return true if the character's attributes were updated, false otherwise.
	 */
	public boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		if (character == null || name == null) {
			return false;
		}

		boolean updated = false;

		if (name != null) {
			if (!character.name.equals(name)) {
				character.name = name;
				updated = true;
			}
		}

		if (character.health != (double) health) {
			character.health = health;
			updated = true;
		}

		if (character.power != (double) power) {
			character.power = power;
			updated = true;
		}

		return updated;
	}

	/**
	 * Deletes a character from the array.
	 * 
	 * @param character The character to be deleted.
	 * @return true if the character was successfully deleted, false otherwise.
	 */
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		if (character == null) {
			return false;
		}

		for (int i = 0; i <= size; i++) {
			if (characters[i] == character) {
				System.arraycopy(character, i + 1, character, i, size - i - 1);
				characters[size] = null;
				size--;
				return true;
			}
		}

		return false;
	}

	/**
	 * Displays information about all characters in the array.
	 */
	public void displayAllCharacters() {
		for (int i = 0; i <= size; i++) {
			System.out.println("Character " + (i + 1));
			characters[i].displayInfo();
			System.out.println("\n");
		}
	}
}
