package application;

/*
Thaddeus Albert Bartz
William Christian Leonard
Period 5
PSET6-0 SuperProject
February 12, 2018
*/

public class BasicAnimal {

	private String animalName, animalType, animalBreed, pictureLink;
	private double weight;
	private Owner owner;
	private VetStatus vetStatus;
	
	//Default
	public BasicAnimal() {
		this.animalType = "No Entry";
		this.animalBreed = "No Entry";
		this.pictureLink = ""; //some default oops clipart
		this.weight = 0.00;
		owner = new Owner();
		vetStatus = new VetStatus();
	}

	//Full
	public BasicAnimal(String animalType, String breed, String pictureLink, int weight) {
		this.animalType = animalType;
		this.animalBreed = breed;
		this.pictureLink = pictureLink;
		this.weight = weight;
		owner = new Owner();
		vetStatus = new VetStatus();
	}
	
	//No Weight
	public BasicAnimal(String animalType, String animalBreed, String pictureLink) {
		this.animalType = animalType;
		this.animalBreed = animalBreed;
		this.pictureLink = pictureLink;
		this.weight = 0.00;
		owner = new Owner();
		vetStatus = new VetStatus();
	}

	
	//No Picture Link
	public BasicAnimal(String animalType, String animalBreed, int weight) {
		this.animalType = animalType;
		this.animalBreed = animalBreed;
		this.pictureLink = "";// some default oops clipart
		this.weight = weight;
		owner = new Owner();
		vetStatus = new VetStatus();
	}
	
	//No Weight or Picture
	public BasicAnimal(String animalType, String animalBreed) {
		this.animalType = animalType;
		this.animalBreed = animalBreed;
		this.pictureLink = "";// some default oops clipart
		this.weight = 0.00;
		owner = new Owner();
		vetStatus = new VetStatus();
	}

	//No Breed or Picture
	public BasicAnimal(String animalType, int weight) {
		this.animalType = animalType;
		this.animalBreed = "No Entry";
		this.pictureLink = "";// some default oops clipart
		this.weight = weight;
		owner = new Owner();
		vetStatus = new VetStatus();
	}

	//No Breed, Picture, or Weight
	public BasicAnimal(String animalType) {
		this.animalType = animalType;
		this.animalBreed = "No Entry";
		this.pictureLink = "";// some default oops clipart
		this.weight = 0.00;
		owner = new Owner();
		vetStatus = new VetStatus();
	}
	
	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getAnimalBreed() {
		return animalBreed;
	}

	public void setAnimalBreed(String animalBreed) {
		this.animalBreed = animalBreed;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public VetStatus getVetStatus() {
		return vetStatus;
	}

	public void setVetStatus(VetStatus vetStatus) {
		this.vetStatus = vetStatus;
	}
	
	
}
