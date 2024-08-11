package grazioso;

import java.util.Scanner;

public class Driver {
	// Instance variables (these initiate the two files that hold the animals information.)
	static FileHandler dogFileHandler = new FileHandler("dogs.txt");
	static FileHandler monkeyFileHandler = new FileHandler("monkeys.txt");

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		char menuSelection = ' ';
		//The following displays the menu and uses a case statement to make a simple menu for the program
		displayMenu();
		menuSelection = scnr.nextLine().charAt(0);
		while(menuSelection != 'q') {
			int i = Integer.parseInt(String.valueOf(menuSelection));
			switch(i) {
				case 1 -> intakeNewDog(scnr);
				case 2 -> intakeNewMonkey(scnr);
				case 3 -> printDogs();
				case 4 -> printMonkey();
				case 5 -> printAnimals();
			}
			displayMenu();
			menuSelection = scnr.nextLine().charAt(0);
		}
		//end of program message
		System.out.println("Have a great day!");

	}

	// This method prints the menu options
	public static void displayMenu() {
		System.out.println("\n\n");
		System.out.println("\t\t\t\tRescue Animal System Menu");
		System.out.println("[1] Intake a new dog");
		System.out.println("[2] Intake a new monkey");
		System.out.println("[3] Print a list of all dogs");
		System.out.println("[4] Print a list of all monkeys");
		System.out.println("[5] Print a list of all animals");
		System.out.println("[q] Quit application");
		System.out.println();
		System.out.println("Enter a menu selection");
	}
	//This method is all of the questions for the in-take of a dog
	public static void intakeNewDog(Scanner scanner) {
		boolean reserve;
		System.out.println("What is the dog's name?");
		String name = scanner.nextLine();
		System.out.println("What is the dog's breed?");
		String animalType = scanner.nextLine();
		System.out.println("What is the dog's gender?");
		String gender = scanner.nextLine();
		System.out.println("What is the dog's age?");
		String age = scanner.nextLine();
		System.out.println("What is the dog's weight?");
		String weight = scanner.nextLine();
		System.out.println("What is the dog's acquisition date?");
		String acqDate = scanner.nextLine();
		System.out.println("What is the dog's acquisition country?");
		String acqCountry = scanner.nextLine();
		System.out.println("What is the dog's training status?");
		String trainingStatus = scanner.nextLine();
		System.out.println("Is the dog reserved?");
		String reserveStatus = scanner.nextLine();
		if(reserveStatus.equalsIgnoreCase("yes"))
		{
			reserve = true;
		}
		else {
			reserve = false;
		}
		System.out.println("What is the dog's in service country?");
		String inServiceCountry = scanner.nextLine();
		Dog newdog = new Dog(name, animalType, gender, age, weight, acqDate, acqCountry, trainingStatus, reserve, inServiceCountry);
		dogFileHandler.addAnimal(newdog);

	}
	//This method is all of the questions for the in-take of a monkey
	public static void intakeNewMonkey(Scanner scanner) {
		System.out.println("What is the monkey's name?");
		String name = scanner.nextLine();
		System.out.println("What is the monkey's species?");
		String animalType = scanner.nextLine();
		while (!(animalType.equalsIgnoreCase("Capuchin")) && !(animalType.equalsIgnoreCase("Guenon")) && !(animalType.equalsIgnoreCase("Macaque")) && !(animalType.equalsIgnoreCase("Marmoset")) && !(animalType.equalsIgnoreCase("Squirrel Monkey")) && !(animalType.equalsIgnoreCase("Tamarin"))) {
			System.out.println("\n\nThis monkey's species is not allowed\n\n");
			return;
		}
		System.out.println("What is the monkey's gender?");
		String gender = scanner.nextLine();
		System.out.println("What is the monkey's age?");
		String age = scanner.nextLine();
		System.out.println("What is the monkey's weight?");
		String weight = scanner.nextLine();
		System.out.println("What is the monkey's acquisition date?");
		String acqDate = scanner.nextLine();
		System.out.println("What is the monkey's acquisition location?");
		String acqCountry = scanner.nextLine();
		System.out.println("What is the monkey's training status?");
		String trainingStatus = scanner.nextLine();
		System.out.println("Is the monkey reserved?");
		boolean reserve;
		String reserveStatus = scanner.nextLine();
		if(reserveStatus.equalsIgnoreCase("yes"))
		{
			reserve = true;
		}
		else {
			reserve = false;
		}
		System.out.println("What is the monkey's in service country?");
		String inServiceCountry = scanner.nextLine();
		Monkey newMonkey = new Monkey(name, animalType, gender, age, weight, acqDate, acqCountry, trainingStatus, reserve, inServiceCountry);
		monkeyFileHandler.addAnimal(newMonkey);
	}
	//This method prints all of the dogs in the file.
	public static void printDogs() {
		System.out.println("Dogs:");
		dogFileHandler.printAnimals();
	}
	//This method prints all of the monkeys in the file
	public static void printMonkey() {
		System.out.println("Monkey's: ");
		monkeyFileHandler.printAnimals();
	}
	//This method prints all of the animals in both files
	public static void printAnimals() {

		System.out.println("Dogs:");
		dogFileHandler.printAnimals();

		System.out.println("\nMonkey's: ");
		monkeyFileHandler.printAnimals();

	}
}


