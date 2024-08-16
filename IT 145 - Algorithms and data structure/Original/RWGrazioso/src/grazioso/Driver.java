package grazioso;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	private static ArrayList<Dog> dogList = new ArrayList<Dog>();
	private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
	// Instance variables (if needed)

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		initializeDogList();
		initializeMonkeyList();

		char menuSelection = ' ';

		displayMenu();
		menuSelection = scnr.nextLine().charAt(0);
		while(menuSelection != 'q') {
			int i = Integer.parseInt(String.valueOf(menuSelection));
			switch(i) {
			case 1 -> intakeNewDog(scnr);
			case 2 -> intakeNewMonkey(scnr);
			case 3 -> reserveAnimal(scnr);
			case 4 -> printDogs();
			case 5 -> printMonkey();
			case 6 -> printAnimals();
			}
			displayMenu();
			menuSelection = scnr.nextLine().charAt(0);
		}
		System.out.println("Have a great day!");

	}

	private static void initializeMonkeyList() {
		Monkey monkey1 = new Monkey("Timmy", "Capuchin", "4.2", "6.9", "25.6", "female", "2", "16.3", "06-05-2016", "Mexico", "Phase I", false, "United States");
		Monkey monkey2 = new Monkey("Russ", "Marmoset", "5.6", "9.2", "20.4", "male", "3", "17.1", "07-06-2023", "Canada", "in service", true, "Canada");
		Monkey monkey3 = new Monkey("Mike", "Guenon", "6.2", "8.5", "18.6", "female", "1", "17.2", "10-05-2022", "United States", "intake", false, "United States");

		monkeyList.add(monkey1);
		monkeyList.add(monkey2);
		monkeyList.add(monkey3);

	}

	// This method prints the menu options
	public static void displayMenu() {
		System.out.println("\n\n");
		System.out.println("\t\t\t\tRescue Animal System Menu");
		System.out.println("[1] Intake a new dog");
		System.out.println("[2] Intake a new monkey");
		System.out.println("[3] Reserve an animal");
		System.out.println("[4] Print a list of all dogs");
		System.out.println("[5] Print a list of all monkeys");
		System.out.println("[6] Print a list of all animals that are not reserved");
		System.out.println("[q] Quit application");
		System.out.println();
		System.out.println("Enter a menu selection");
	}


	// Adds dogs to a list for testing
	public static void initializeDogList() {
		Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
		Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
		Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
	}

	public static void intakeNewDog(Scanner scanner) {
		System.out.println("What is the dog's name?");
		String name = scanner.nextLine();
		for(Dog dog: dogList) {
			if(dog.getName().equalsIgnoreCase(name)) {
				System.out.println("\n\nThis dog is already in our system\n\n");
				return; //returns to menu
			}
		}
		System.out.println("What is the dog's breed?");
		String breed = scanner.nextLine();
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
		boolean reserve = scanner.nextBoolean();
		scanner.nextLine();
		System.out.println("What is the dog's in service country?");
		String inServiceCountry = scanner.nextLine();
		Dog newdog = new Dog(name, breed, gender, age, weight, acqDate, acqCountry, trainingStatus, reserve, inServiceCountry);
		dogList.add(newdog);

	}

	public static void intakeNewMonkey(Scanner scanner) {
		System.out.println("What is the monkey's name?");
		String name = scanner.nextLine();
		for (Monkey monkey: monkeyList) {
			if (monkey.getName().equalsIgnoreCase(name)) {
				System.out.println("\n\nThis monkey is already in our system\n\n");
				return; //returns to menu
			}
		}
		System.out.println("What is the monkey's species?");
		String species = scanner.nextLine();

		while (!(species.equalsIgnoreCase("Capuchin")) && !(species.equalsIgnoreCase("Guenon")) && !(species.equalsIgnoreCase("Macaque")) && !(species.equalsIgnoreCase("Marmoset")) && !(species.equalsIgnoreCase("Squirrel Monkey")) && !(species.equalsIgnoreCase("Tamarin"))) {
			System.out.println("\n\nThis monkey's species is not allowed\n\n");
			return;
		}
		System.out.println("What is the monkey's tail length?");
		String tailLength = scanner.nextLine();
		System.out.println("What is the monkey's height?");
		String height = scanner.nextLine();
		System.out.println("What is the monkey's body length?");
		String bodyLength = scanner.nextLine();
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
		boolean reserve = scanner.nextBoolean();
		scanner.nextLine();
		System.out.println("What is the monkey's in service country?");
		String inServiceCountry = scanner.nextLine();
		Monkey newMonkey = new Monkey(name, species, tailLength, height, bodyLength, gender, age, weight, acqDate, acqCountry, trainingStatus, reserve, inServiceCountry);
		monkeyList.add(newMonkey);
	}

	// Complete reserveAnimal
	// You will need to find the animal by animal type and in service country
	public static void reserveAnimal(Scanner scanner) {
		boolean isValidSelection = true;

		do {

			try {
				System.out.println("Enter animal type: Monkey or Dog");
				String type = scanner.nextLine();
				isValidSelection = true;

				if (type.equals("Monkey") || type.equals("monkey")) {
					System.out.println("Name - " + "Training Status - " + "Acquisition Country - " + " Reservation Status");

					for (int i = 0; i < monkeyList.size(); i++) {
						if (!monkeyList.get(i).getReserved())
							System.out.println(monkeyList.get(i));
					}
					System.out.println("Enter name: ");
					String name = scanner.nextLine();
					for (Monkey obj: monkeyList) {
						if (obj.getName().equals(name)) {
							obj.setReserved(true);
							System.out.println("Name - " + "Training Status - " + "Acquisition Country - " + " Reservation Status");
							System.out.println(obj);
							return;
						} else
							throw new Exception("Invalid Entry. Please try again");
					}
				} else if (type.equals("Dog") || type.equals("dog")) {
					System.out.println("Name - " + "Training Status - " + "Acquisition Country - " + " Reservation Status");
					for (int i = 0; i < dogList.size(); ++i) {
						if (!dogList.get(i).getReserved())
							System.out.println(dogList.get(i));
					}
					System.out.println("Enter name: ");
					String name = scanner.nextLine();
					for (Dog obj: dogList) {
						if (obj.getName().equals(name)) {
							obj.setReserved(true);
							System.out.println("Name - " + "Training Status - " + "Acquisition Country - " + " Reservation Status");
							System.out.println(obj);
							return;
						} else
							throw new Exception("Invalid Entry. Please try again");
					}
				} else
					throw new Exception("Invalid Entry. Please try again");
			} catch (Exception excpt) {
				System.out.println(excpt.getMessage());
				isValidSelection = false;

			}
		} while (!isValidSelection);

	}

	public static void printDogs() {
		System.out.println("Dogs: ");
		System.out.println("Name - " + "Training Status - " + "Acquisition Country - " + " Reservation Status");
		for (Dog name: dogList) {
			System.out.print(name);
		}
	}
	public static void printMonkey() {
		System.out.println("Monkey's: ");
		System.out.println("Name - " + "Training Status - " + "Acquisition Country - " + " Reservation Status");
		for (Monkey name: monkeyList) {
			System.out.print(name);
		}
	}

	public static void printAnimals() {

		System.out.println("Name - " + "Training Status - " + "Acquisition Country - " + " Reservation Status");
		System.out.println("Dogs: ");
		for (Dog name: dogList) {
			System.out.print(name);
		}
		System.out.println("");
		System.out.println("Monkey's: ");
		for (Monkey name: monkeyList) {
			System.out.print(name);
		}

	}
}


