package grazioso;


public class Dog extends RescueAnimal {

	// Constructor that gets the information for the dog
	public Dog(String name, String animalType, String gender, String age,
			String weight, String acquisitionDate, String acquisitionCountry,
			String trainingStatus, boolean reserved, String inServiceCountry) {
		super();
		setName(name);
		setAnimalType(animalType);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);

	}
}
