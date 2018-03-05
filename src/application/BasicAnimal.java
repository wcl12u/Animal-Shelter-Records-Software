package application;

/*
Thaddeus Albert Bartz
William Christian Leonard
Period 5
PSET6-0 SuperProject
February 12, 2018
*/

import java.io.Serializable;
import javafx.scene.image.Image;

public class BasicAnimal implements Serializable{

	private static final long serialVersionUID = 1L;
	private String animalName, animalType, animalBreed;
	private Image animalImage;
	private double weight;
	private Owner owner;
	private VetStatus vetStatus;
	
	//Default
	public BasicAnimal() {
		this.animalType = "No Entry";
		this.animalBreed = "No Entry";
		this.animalImage = new Image("/application/AddImageImage.png");
		this.weight = 0.00;
		owner = new Owner();
		vetStatus = new VetStatus();
	}

	//Full
	public BasicAnimal(String animalType, String breed, Image pictureLink, int weight) {
		this.animalType = animalType;
		this.animalBreed = breed;
		this.animalImage = pictureLink;
		this.weight = weight;
		owner = new Owner();
		vetStatus = new VetStatus();
	}
	
	//No Weight
	public BasicAnimal(String animalType, String animalBreed, Image pictureLink) {
		this.animalType = animalType;
		this.animalBreed = animalBreed;
		this.animalImage = pictureLink;
		this.weight = 0.00;
		owner = new Owner();
		vetStatus = new VetStatus();
	}

	
	//No Picture Link
	public BasicAnimal(String animalType, String animalBreed, int weight) {
		this.animalType = animalType;
		this.animalBreed = animalBreed;
		this.animalImage = new Image("/application/AddImageImage.png");
		this.weight = weight;
		owner = new Owner();
		vetStatus = new VetStatus();
	}
	
	//No Weight or Picture
	public BasicAnimal(String animalType, String animalBreed) {
		this.animalType = animalType;
		this.animalBreed = animalBreed;
		this.animalImage = new Image("/application/AddImageImage.png");
		this.weight = 0.00;
		owner = new Owner();
		vetStatus = new VetStatus();
	}

	//No Breed or Picture
	public BasicAnimal(String animalType, int weight) {
		this.animalType = animalType;
		this.animalBreed = "No Entry";
		this.animalImage = new Image("/application/AddImageImage.png");
		this.weight = weight;
		owner = new Owner();
		vetStatus = new VetStatus();
	}

	//No Breed, Picture, or Weight
	public BasicAnimal(String animalType) {
		this.animalType = animalType;
		this.animalBreed = "No Entry";
		this.animalImage = new Image("/application/AddImageImage.png");
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

	public Image getAnimalImage() {
		return animalImage;
	}

	public void setAnimalImage(Image pictureLink) {
		this.animalImage = pictureLink;
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
