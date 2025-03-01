package edu.gz.MiddleEarth;

import java.util.Arrays;

public class CharacterManager {
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[1];
	private int size = 0;
	
	private void insertCharacter(MiddleEarthCharacter c) {
		for (int i = size; i <= characters.length; i++) {
			if (characters[i] == null) {
				characters[i] = c;
				size++;
				break;
			}
		}
	}
	
	public boolean addCharacter(MiddleEarthCharacter c) {
		if (c == null) {
			return false;
		}
		
		if (size != characters.length) {
			insertCharacter(c);
			return true;
		}
		else {
			characters = Arrays.copyOf(characters, characters.length * 2);
			insertCharacter(c);
			return true;
		}
	}
	
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
	
	public boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		if (character == null || name == null) {
			return false;
		}
		
		boolean updated = false;
		
		if (!character.name.equals(name)) {
			character.name = name;
			updated = true;
		}
		
		if (character.health != (double)health) {
			character.health = health;
			updated = true;
		}
		
		if (character.power != (double)power) {
			character.power = power;
			updated = true;
		}
		
		return updated;
	}
	
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
	
	public void displayAllCharacters() {
		for (int i = 0; i <= size; i++) {
			System.out.println("Character " + (i + 1));
			characters[i].displayInfo();
			System.out.println("\n");
		}
	}
}
