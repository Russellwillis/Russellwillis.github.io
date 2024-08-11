package grazioso;

public class Monkey extends RescueAnimal{

	//gets the information for the monkey
	public Monkey(String name, String animalType, String gender, String age, String weight, String acquisitionDate, String acquisitionLocation, String trainingStatus, boolean reserved, String inServiceCountry)
	{//constructor to set up the monkey
		super();
		setName(name);
		setAnimalType(animalType);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionLocation);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);
	}


}
