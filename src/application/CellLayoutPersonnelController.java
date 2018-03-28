package application;

/*
Thaddeus Albert Bartz
William Christian Leonard
Period 5
PSET6 - 0 SuperProject
February 12, 2018
*/

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CellLayoutPersonnelController implements Initializable {
	
	//Fields
	@FXML
	HBox cellLayoutPersonnel;
	@FXML
	Label lblName;
	@FXML
	Label lblAge;
	@FXML
	Label lblAddress;
	@FXML
	Label lblDateOfBirth;
	@FXML
	Label lblDateOfEmployement;
	@FXML
	Label lblWage;
	@FXML
	Label lblIsEmployed;
	@FXML
	Label lblEmployeeNotes;
	
	//Initialize
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
}
