package application;

/*
Thaddeus Albert Bartz
William Christian Leonard
Period 5
PSET6-0 SuperProject
February 12, 2018
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CellLayoutAnimalController implements Initializable{

    //Fields
	@FXML
	HBox animalLayout;
	@FXML
	VBox animalInfo;
	@FXML
	VBox vetInfo;
	@FXML
	VBox ownerInfo;
	@FXML
	ImageView imgviewAnimal;
	@FXML
	Label lblAnimalName;
	@FXML
	Label lblAnimalType;
	@FXML
	Label lblAnimalWeight;
	@FXML
	Label lblAnimalBreed;
	@FXML
	Label lblHospitalName;
	@FXML
	Label lblHospitalAddress;
	@FXML
	Label lblDoctorName;
	@FXML
	Label lblAnimalStatus;
	@FXML
	Label lblVetNotes;
	@FXML
	Label lblOwnerName;
	@FXML
	Label lblOwnerAge;
	@FXML
	Label lblDateOfAdoption;
	@FXML
	Label lblOwnerAddress;
	@FXML
	Label lblOwnerStateOfResidence;
	@FXML
	Label lblPhoneNumber;
	
	//Initialize FXML
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
