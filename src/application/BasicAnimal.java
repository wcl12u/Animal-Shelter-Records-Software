package application;

public class BasicAnimal {

	private String animalType, animalBreed, pictureLink;
	private double weight;
	
	//default
	public BasicAnimal() {
		this.animalType = "No Entry";
		this.animalBreed = "No Entry";
		this.pictureLink = "";// some default oops clipart
		this.weight = 0.00;
	}

	//full
	public BasicAnimal(String animalType, String breed, String pictureLink, int weight) {
		
		this.animalType = animalType;
		this.animalBreed = breed;
		this.pictureLink = pictureLink;
		this.weight = weight;
	}
	
	//no weight

	public BasicAnimal(String animalType, String animalBreed, String pictureLink) {
		this.animalType = animalType;
		this.animalBreed = animalBreed;
		this.pictureLink = pictureLink;
		this.weight = 0.00;
	}

	
	//no picture link
	public BasicAnimal(String animalType, String animalBreed, int weight) {
		this.animalType = animalType;
		this.animalBreed = animalBreed;
		this.pictureLink = "";// some default oops clipart
		this.weight = weight;
	}
	
	//no weight or picture

	public BasicAnimal(String animalType, String animalBreed) {
		this.animalType = animalType;
		this.animalBreed = animalBreed;
		this.pictureLink = "";// some default oops clipart
		this.weight = 0.00;
	}

	//no breed or picture
	public BasicAnimal(String animalType, int weight) {
		this.animalType = animalType;
		this.animalBreed = "No Entry";
		this.pictureLink = "";// some default oops clipart
		this.weight = weight;
	}

	
	//no breed, picture, or weight
	public BasicAnimal(String animalType) {
		this.animalType = animalType;
		this.animalBreed = "No Entry";
		this.pictureLink = "";// some default oops clipart
		this.weight = 0.00;
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
