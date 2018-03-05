package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class CellLayoutAnimal extends Pane {

	private CellLayoutAnimalController controller;
	private BasicAnimal animal;
	private String animalName,animalType,animalBreed,hospitalName,hospitalAddress,doctorName,
	animalStatus,vetNotes,ownerName,ownerAddress,stateOfResidence,ownerPhoneNumber;
	private Image animalImage;
	private int ownerAge;
	private LocalDate dateOfAdoption;
	private double animalWeight;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
	
	public CellLayoutAnimal(BasicAnimal animal) {
		Node view = null;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AnimalInformation.fxml"));
		fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> param) {
				return controller = new CellLayoutAnimalController();
			}
		});
		try {
			view = (Node) fxmlLoader.load();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		getChildren().add(view);
		this.animal = animal;
		animalImage = animal.getAnimalImage();
		animalName = animal.getAnimalName();
		animalType = animal.getAnimalType();
		animalBreed = animal.getAnimalBreed();
		hospitalName = animal.getVetStatus().getVetName();
		hospitalAddress = animal.getVetStatus().getVetLocation();
		doctorName = animal.getVetStatus().getDoctorName();
		animalStatus = animal.getVetStatus().getAnimalStatus();
		vetNotes = animal.getVetStatus().getAnimalNotes();
		ownerName = animal.getOwner().getOwnerName();
		ownerAddress = animal.getOwner().getOwnerAddress();
		stateOfResidence = animal.getOwner().getOwnerStateOfResidence();
		ownerPhoneNumber = animal.getOwner().getOwnerPhoneNumber();
		ownerAge = animal.getOwner().getOwnerAge();
		dateOfAdoption = animal.getOwner().getDateOfAdoption();
		animalWeight = animal.getWeight();
	}

	public CellLayoutAnimal() {
		Node view = null;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AnimalInformation.fxml"));
		fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> param) {
				return controller = new CellLayoutAnimalController();
			}
		});
		try {
			view = (Node) fxmlLoader.load();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		getChildren().add(view);
	}

	public BasicAnimal getAnimal() {
		return animal;
	}

	public Image getImage() {
		return animalImage;
	}

	public String getAnimalName() {
		return animalName;
	}

	public String getAnimalType() {
		return animalType;
	}

	public String getAnimalBreed() {
		return animalBreed;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getAnimalStatus() {
		return animalStatus;
	}

	public String getVetNotes() {
		return vetNotes;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public String getStateOfResidence() {
		return stateOfResidence;
	}

	public String getOwnerPhoneNumber() {
		return ownerPhoneNumber;
	}

	public int getOwnerAge() {
		return ownerAge;
	}

	public LocalDate getDateOfAdoption() {
		return dateOfAdoption;
	}

	public double getAnimalWeight() {
		return animalWeight;
	}
	
	public void setView() {
		controller.imgviewAnimal.setImage(animalImage);
		controller.lblAnimalName.setText(animalName);
		controller.lblAnimalType.setText(animalType);
		controller.lblAnimalWeight.setText(String.valueOf(animalWeight));
		controller.lblAnimalBreed.setText(animalBreed);
		controller.lblHospitalName.setText(hospitalName);
		controller.lblOwnerAddress.setText(hospitalAddress);
		controller.lblDoctorName.setText(doctorName);
		controller.lblAnimalStatus.setText(animalStatus);
		controller.lblVetNotes.setText(vetNotes);
		controller.lblOwnerName.setText(ownerName);
		controller.lblOwnerAge.setText(String.valueOf(ownerAge));
		controller.lblDateOfAdoption.setText(String.valueOf(dateOfAdoption.format(formatter)));
		controller.lblOwnerAddress.setText(ownerAddress);
		controller.lblOwnerStateOfResidence.setText(stateOfResidence);
		controller.lblPhoneNumber.setText(ownerPhoneNumber);
	}

}






















