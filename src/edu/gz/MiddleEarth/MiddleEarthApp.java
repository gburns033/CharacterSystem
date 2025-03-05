package edu.gz.MiddleEarth;

import java.util.Scanner;

public class MiddleEarthApp {
	private Scanner scanner;
	private MiddleEarthCouncil council;

	public static void main(String[] args) {
		MiddleEarthApp app = new MiddleEarthApp();
		app.Menu();
		app.open();
	}

	public void Menu() {
		this.scanner = new Scanner(System.in);
		council = MiddleEarthCouncil.getInstance();
	}

	private void showMenu() {
		System.out.println("\n===== Middle-Earth Menu =====");
		System.out.println("1. Add a new character");
		System.out.println("2. View all characters");
		System.out.println("3. Update a character");
		System.out.println("4. Delete a character");
		System.out.println("5. Execute all characters’ attack actions");
		System.out.println("6. Exit");
		System.out.print("Enter your choice: ");
	}

	public void open() {
		while (true) {
			showMenu();

			String input = scanner.nextLine();

			try {
				int choice = Integer.parseInt(input);

				switch (choice) {
				case 1:
					openAddCharacterMenu();
					break;
				case 2:
					System.out.println("\\n===== Displaying All Characters =====");
					council.getCharacterManager().displayAllCharacters();
				case 3:
					openUpdateCharacterMenu();
					break;
				case 4:
					openDeleteCharacterMenu();
				case 5:
					openAttackMenu();
				}
			} finally {
				System.out.println("Invalid Input!");
			}
		}
	}

	private void showAddCharacterMenu() {
		System.out.println("\n===== Add Character Menu =====");
		System.out.println("First, choose a character class.");
		System.out.println("1. Dwarf");
		System.out.println("2. Elf");
		System.out.println("3. Human");
		System.out.println("4. Orc");
		System.out.println("5. Wizard");
		System.out.println("6. Exit");
		System.out.print("Enter your choice: ");
	}

	private void openAddCharacterMenu() {
		showAddCharacterMenu();

		try {
			int characterClass = scanner.nextInt();

			System.out.println("Enter character name:");
			String name = scanner.nextLine();
			System.out.println("Enter character health:");
			double health = scanner.nextDouble();
			System.out.println("Enter character power:");
			double power = scanner.nextDouble();
			scanner.nextLine();

			MiddleEarthCharacter character = null;

			switch (characterClass) {
			case 1:
				character = new Dwarf(name, health, power);
				break;
			case 2:
				character = new Elf(name, health, power);
				break;
			case 3:
				character = new Human(name, health, power);
				break;
			case 4:
				character = new Orc(name, health, power);
				break;
			case 5:
				character = new Wizard(name, health, power);
				break;
			case 6:
				System.out.println("Exiting character creation.");
				return;
			default:
				System.out.println("Invalid character class. Exiting character creation.");
				return;
			}

			council.getCharacterManager().addCharacter(character);
			System.out.println("Character added successfully.");
		} finally {
			System.out.println("Invalid input. Exiting character creation.");
		}
	}

	private void showUpdateCharacterMenu() {
		System.out.println("\n===== Update Character Menu =====");
	}

	private void openUpdateCharacterMenu() {
		showUpdateCharacterMenu();

		try {
			System.out.println("Enter the character name to edit:");
			String nameToFind = scanner.nextLine();

			CharacterManager CM = council.getCharacterManager();

			MiddleEarthCharacter character = CM.getCharacter(nameToFind);

			if (character == null) {
				System.out.println("That character does not exist. Exiting character editing.");
				return;
			}

			System.out.println("Enter character name:");
			String name = scanner.nextLine();
			System.out.println("Enter character health:");
			int health = scanner.nextInt();
			System.out.println("Enter character power:");
			int power = scanner.nextInt();
			scanner.nextLine();

			if (health < 0) {
				System.out.println("Invalid health given. Health must be non-negative. Exiting character editing.");
				return;
			}

			String finalizedName = name.isBlank() ? character.name : name;

			CM.updateCharacter(character, finalizedName, health, power);
			System.out.println("Successfully edited character.");
		} finally {
			System.out.println("Invalid input. Exiting character editing.");
		}
	}

	private void showDeleteCharacterMenu() {
		System.out.println("\n===== Delete Character Menu =====");
	}

	private void openDeleteCharacterMenu() {
		showDeleteCharacterMenu();

		try {
			System.out.println("Enter the character name to delete:");
			String nameToFind = scanner.nextLine();

			CharacterManager CM = council.getCharacterManager();

			MiddleEarthCharacter character = CM.getCharacter(nameToFind);

			if (character == null) {
				System.out.println("That character does not exist. Exiting character deletion.");
				return;
			}

			CM.deleteCharacter(character);
			System.out.println("Successfully deleted character.");
		} finally {
			System.out.println("Invalid input. Exiting character deletion.");
		}
	}

	private void showAttackMenu() {
		System.out.println("\n===== Attacking Menu =====");
	}

	private void openAttackMenu() {
		showAttackMenu();

		System.out.println("Enter the character name of the attacker:");
		String nameToFind1 = scanner.nextLine();

		CharacterManager CM = council.getCharacterManager();

		MiddleEarthCharacter attacker = CM.getCharacter(nameToFind1);

		if (attacker == null) {
			System.out.println("That character does not exist. Exiting battle sequence.");
			return;
		}

		System.out.println("Enter the character name of the target:");
		String nameToFind2 = scanner.nextLine();

		if (nameToFind1.equals(nameToFind2)) {
			System.out.println("A character cannot fight itself. Exiting battle sequence.");
			return;
		}

		MiddleEarthCharacter target = CM.getCharacter(nameToFind2);

		if (target == null) {
			System.out.println("That character does not exist. Exiting battle sequence.");
			return;
		}

		System.out.println("\n===== Battle Sequence =====");
		System.out.println("Attacker:");
		attacker.displayInfo();

		System.out.println("\nTarget:");
		target.displayInfo();

		if (attacker.attack(target)) {
			System.out.println("\nAttack was successful!");
			System.out.println("Target's updated info:");
			target.displayInfo();
			return;
		} else {
			System.out.println("Attack failed!");
			return;
		}
	}
}
