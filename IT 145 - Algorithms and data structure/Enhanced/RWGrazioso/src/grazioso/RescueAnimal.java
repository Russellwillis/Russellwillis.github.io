package grazioso;



import java.lang.String;

public class RescueAnimal {

	// Instance variables
	private String name;
	private String animalType;
	private String gender;
	private String age;
	private String weight;
	private String acquisitionDate;
	private String acquisitionCountry;
	private String trainingStatus;
	private boolean reserved;
	private String inServiceCountry;


	// Constructor
	public RescueAnimal() {
	}

	//Gets the animals name
	public String getName() {
		return name;
	}

	//sets the animals name
	public void setName(String name) {
		this.name = name;
	}

	//gets the animals type
	public String getAnimalType() {
		return animalType;
	}

	//sets the animals type
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	//gets the animals gender
	public String getGender() {
		return gender;
	}

	//sets the animals gender
	public void setGender(String gender) {
		this.gender = gender;
	}

	//gets the animals age
	public String getAge() {
		return age;
	}

	//sets the animals age
	public void setAge(String age) {
		this.age = age;
	}

	//gets the animals weight
	public String getWeight() {
		return weight;
	}

	//sets the animals weight
	public void setWeight(String weight) {
		this.weight = weight;
	}

	//gets the animals acquisition date
	public String getAcquisitionDate() {
		return acquisitionDate;
	}

	//sets the animals acquisition date
	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	//gets the acquisition location
	public String getAcquisitionLocation() {
		return acquisitionCountry;
	}

	//sets the acquisition location
	public void setAcquisitionLocation(String acquisitionCountry) {
		this.acquisitionCountry = acquisitionCountry;
	}

	//gets whether the animal is reserved or not
	public boolean getReserved() {
		return reserved;
	}

	//sets whether the animal is reserved or not
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	//gets where the animal is in service at
	public String getInServiceLocation() {
		return inServiceCountry;
	}

	//sets where the animal is in service at
	public void setInServiceCountry(String inServiceCountry) {
		this.inServiceCountry = inServiceCountry;
	}



	//gets the training status of the animal
	public String getTrainingStatus() {
		return trainingStatus;
	}

	//sets the training status of the animal
	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}


	//Writes to the file all of the information on the animal
	@Override
	public String toString() {
		return name + ", Animal Type: " + animalType + ", Gender: " + gender + ", Age: " + age + ", Weight: " + weight + ", Acquisition Date: " + acquisitionDate + ", Acquisition Location: " + acquisitionCountry + ", Training Status: " + trainingStatus + ", Reserved: " + reserved + ", In Service Location: " + inServiceCountry;
	}
}
