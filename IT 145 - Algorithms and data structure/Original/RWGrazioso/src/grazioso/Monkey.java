package grazioso;

public class Monkey extends RescueAnimal{
	// Instance variables
	private String tailLength; 
	private String height; 
	private String bodyLength;
	private String species;

	public Monkey(String name, String Species, String tailLength, String height, String bodyLength, String gender, String age, String weight, String acquisitionDate, String acquisitionLocation, String trainingStatus, boolean reserved, String inServiceCountry)
	{//constructor to set up the monkey
		setName(name);
		setSpecies(species);
		setTailLength(tailLength);
		setHeight(height);
		setBodyLength(bodyLength);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionLocation);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);
	}

	public String getTailLength() { //Accessor for the tail length
		return tailLength;
	}


	public String getBodyLength() { //Accessor for the body length
		return bodyLength;
	}

	public String getSpecies() { //Accessor for the monkey species
		return species;
	}

	public String getHeight() { //Accessor for the monkey height
		return height;	
	}


	public void setBodyLength(String bodyLength) { //mutator for setting the body length of the monkey
		this.bodyLength = bodyLength;

	}

	public void setHeight(String height) { // mutator to set the monkey height
		this.height = height;

	}

	public void setTailLength(String tailLength) { // mutator to set the tail length
		this.tailLength = tailLength;

	}

	public void setSpecies(String species) { // mutator to set up the monkey species
		this.species = species;
	}

	@Override // Overriding the toString method
	public String toString() {
		return getName() + "       " + getTrainingStatus() + "       " + getAcquisitionLocation() + "       " + getReserved() + "\n";
	}

}
