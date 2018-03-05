package application;

/*
Thaddeus Albert Bartz
William Christian Leonard
Period 5
PSET6-0 SuperProject
February 12, 2018
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class RootLayoutController {

	private Main mainApp;

	private int animalIndex = -1;
	@FXML
	private AnchorPane root;
	@FXML
	private Tab basicView;
	@FXML
	private Tab vetView;
	@FXML
	private Tab ownerView;
	@FXML
	private Tab manageView;
	@FXML
	private Tab viewEmployeeRecords;
	@FXML
	private Tab viewAnimalRecords;
	@FXML
	private ImageView imgAnimalImage;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtAnimalType;
	@FXML
	private TextField txtWeight;
	@FXML
	private TextField txtBreed;
	@FXML
	private Button btnNew;
	@FXML
	private Button btnSave;
	@FXML
	private Button btnSaveEdit;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnPrevious;
	@FXML
	private Button btnNext;
	@FXML
	private Label lblDogName;
	@FXML
	private TextField txtVetName;
	@FXML
	private TextField txtVetAddress;
	@FXML
	private TextField txtDoctorName;
	@FXML
	private Label lblStatus;
	@FXML
	private ChoiceBox<String> chbxAnimalStatus;
	@FXML
	private TextArea txtareaNotes;
	@FXML
	private Button btnSaveNotes;
	@FXML
	private ImageView imgIDCard;
	@FXML
	private TextField txtOwnerName;
	@FXML
	private TextField txtOwnerAge;
	@FXML
	private DatePicker dateAdoptionDate;
	@FXML
	private TextField txtAddress;
	@FXML
	private TextField txtStateOfResidence;
	@FXML
	private TextField txtPhoneNum;
	@FXML
	private Button btnSaveOwner;
	@FXML
	private Label lblFoodCost;
	@FXML
	private Label lblMaintenanceCost;
	@FXML
	private Label lblPersonnelCost;
	@FXML
	private Label lblProfit;
	@FXML
	private Label lblRevenue;
	@FXML
	private PasswordField pswdPersonnelEdit;
	@FXML
	private VBox personnelEdit;
	@FXML
	private TextField txtNameEmployee;
	@FXML
	private TextField txtAgeEmployee;
	@FXML
	private TextField txtAddressEmployee;
	@FXML
	private DatePicker dateBirthday;
	@FXML
	private DatePicker dateEmployementDate;
	@FXML
	private TextField txtWage;
	@FXML
	private CheckBox chkbxIsEmployed;
	@FXML
	private TextArea txtareaEmployeeNotes;
	@FXML
	private Button btnNewEmployee;
	@FXML
	private Button btnDeleteEmployee;
	@FXML
	private Button btnSaveEmployee;
	@FXML
	private Button btnSaveEditEmployee;
	@FXML
	private Button btnPreviousEmployee;
	@FXML
	private Button btnNextEmployee;
	@FXML
	private ListView<CellLayoutPersonnel> listviewPersonnel;
	@FXML
	private Button btnPreviousEmployeeView;
	@FXML
	private Button btnNextEmployeeView;
	@FXML
	private ListView<CellLayoutAnimal> listviewAnimal;
	@FXML
	private Button btnPreviousAnimalView;
	@FXML
	private Button btnNextAnimalView;

	ObservableList<CellLayoutPersonnel> employeeRecords = FXCollections.observableArrayList();
	
	ObservableList<CellLayoutAnimal> animalRecords = FXCollections.observableArrayList();
	
	final Image defaultImage = new Image("/application/AddImageImage.png");
	
	final ObservableList<String> status = FXCollections.observableArrayList("Healthy", "Stable", "Critical");
	
	private final String password = "person records!!";
	
	private String fileAnimalName = "Animals";
	
	private String filePersonnelName = "Personnel";

	public void initialize() {

		personnelEdit.setDisable(true);
		//listviewPersonnel.setItems(employeeRecords);
		listviewAnimal.setItems(animalRecords);
		root.getChildren();
		
		chbxAnimalStatus.setItems(status);

		if (animalRecords.size() == 0) {
			btnSaveEdit.setDisable(true);
			btnSave.setDisable(false);
			btnDelete.setDisable(true);
			vetView.setDisable(true);
			ownerView.setDisable(true);
			imgAnimalImage.setImage(defaultImage);
			imgIDCard.setImage(defaultImage);
		}
	}
	
	@FXML
	public void handleBasicView() {
		if (basicView.isSelected() == true) {
			if (animalRecords.size() != 0) {
				BasicAnimal animal = animalRecords.get(animalIndex).getAnimal();
				imgAnimalImage.setImage(new Image(animal.getAnimalImage()));
				txtName.setText(animal.getAnimalName());
				txtAnimalType.setText(animal.getAnimalType());
				txtWeight.setText(String.valueOf(animal.getWeight()));
				txtBreed.setText(animal.getAnimalBreed());
				btnSaveEdit.setDisable(false);
				btnSave.setDisable(true);
				btnDelete.setDisable(false);
				vetView.setDisable(false);
				ownerView.setDisable(false);
			}
			else {
				animalIndex = 0;
				handleNewAnimal();
			}
		}
		else if (vetView.isSelected() == true) {
			handleVetView();
		}
		else if (ownerView.isSelected() == true) {
			handleOwnerView();
		}
		else if (viewAnimalRecords.isSelected() == true) {
			handleAnimalReportView();
		}
		handleIncrementDisable();
	}
	
	@FXML
	public void handleVetView() {
		if(vetView.isSelected() == true) {
			if(animalRecords.size() != 0) {
				BasicAnimal animal = animalRecords.get(animalIndex).getAnimal();			
				lblDogName.setText(animal.getAnimalName());
				txtVetName.setText(animal.getVetStatus().getVetName());
				txtVetAddress.setText(animal.getVetStatus().getVetLocation());
				txtDoctorName.setText(animal.getVetStatus().getDoctorName());
				chbxAnimalStatus.setValue(animal.getVetStatus().getAnimalStatus());
				txtareaNotes.setText(animal.getVetStatus().getAnimalNotes());
			}
		}
		else if (basicView.isSelected() == true) {
			handleBasicView();
		}
		else if (ownerView.isSelected() == true) {
			handleOwnerView();
		}
		else if (viewAnimalRecords.isSelected() == true) {
			handleAnimalReportView();
		}
	}
	
	@FXML
	public void handleOwnerView() {
		if(ownerView.isSelected() == true) {
			if(animalRecords.size() != 0) {
				Owner animalOwner = animalRecords.get(animalIndex).getAnimal().getOwner();
				imgIDCard.setImage(animalOwner.getOwnerID());
				txtOwnerName.setText(animalOwner.getOwnerName());
				txtOwnerAge.setText(String.valueOf(animalOwner.getOwnerAge()));
				dateAdoptionDate.setValue(animalOwner.getDateOfAdoption());
				txtAddress.setText(animalOwner.getOwnerAddress());
				txtStateOfResidence.setText(animalOwner.getOwnerStateOfResidence());
				txtPhoneNum.setText(animalOwner.getOwnerPhoneNumber());
			}
		}
		else if(basicView.isSelected() == true) {
			handleBasicView();
		}
		else if(vetView.isSelected() == true) {
			handleVetView();
		}
		else if(viewAnimalRecords.isSelected() == true) {
			handleAnimalReportView();
		}
	}
	
	@FXML
	public void handleAnimalReportView() {
		if (viewAnimalRecords.isSelected() == true) {
			for(CellLayoutAnimal element: animalRecords) {
				element.setView();
			}
			handleIncrementDisable();
			listviewAnimal.scrollTo(animalIndex);
		}
		else if(basicView.isSelected() == true){
			handleBasicView();
		}
		else if(vetView.isSelected() == true) {
			handleVetView();
		}
		else if(ownerView.isSelected() == true) {
			handleOwnerView();
		}
	}
	
	@FXML
	public void handleSaveBasic() {
		
		boolean filled = true;
		BasicAnimal animal = new BasicAnimal();
		
		if(!imgAnimalImage.getImage().equals(defaultImage)) {
			animal.setAnimalImage(imgAnimalImage.getImage().getUrl());
		}
		
		if(stringSafetyCheck(txtName) == true) {
			animal.setAnimalName(txtName.getText());
			txtName.setPromptText("");
		}
		else {
			filled = false;
		}
		
		if (stringSafetyCheck(txtAnimalType) == true) {
			animal.setAnimalType(txtAnimalType.getText());
			txtAnimalType.setPromptText("");
		}
		else {
			filled = false;
		}
		
		if(doubleSafteyCheck(txtWeight) == true) {
			animal.setWeight(Double.valueOf(txtWeight.getText()));
			txtWeight.setPromptText("");
		}
		else {
			filled = false;
		}
		
		if(stringSafetyCheck(txtBreed) == true) {
			animal.setAnimalBreed(txtBreed.getText());
			txtBreed.setPromptText("");
		}
		else {
			filled = false;
		}
		
		if (filled != false) {
			CellLayoutAnimal cellAnimal = new CellLayoutAnimal(animal);
			animalRecords.add(cellAnimal);
			//writeFileAnimal(fileAnimalName);
			btnSave.setDisable(true);
			btnSaveEdit.setDisable(false);
			btnDelete.setDisable(false);
			vetView.setDisable(false);
			ownerView.setDisable(false);
			animalIndex = animalRecords.size() - 1;
		}
		
	}
	
	@FXML
	public void handleNewAnimal() {
		btnDelete.setDisable(true);
		btnSaveEdit.setDisable(true);
		btnSave.setDisable(false);
		imgAnimalImage.setImage(defaultImage);
		txtName.clear();
		txtAnimalType.clear();
		txtWeight.clear();
		txtBreed.clear();
	}
	
	
	@FXML
	public void handleIncrementDisable() {
		if (basicView.isSelected() == true) {
			if (animalIndex-1 <= -1) {
				btnPrevious.setDisable(true);
			}
			else {
				btnPrevious.setDisable(false);
			}
			if (animalIndex+1 >= animalRecords.size()) {
				btnNext.setDisable(true);
			}
			else {
				btnNext.setDisable(false);
			}
		}
		else if (viewAnimalRecords.isSelected() == true) {
			if (animalIndex+1 >= animalRecords.size()) {
				btnNextAnimalView.setDisable(true);
			}
			else {
				btnNextAnimalView.setDisable(false);
			}
			if (animalIndex-1 <= -1) {
				btnPreviousAnimalView.setDisable(true);
			}
			else {
				btnPreviousAnimalView.setDisable(false);
			}
		}
	}

	@FXML
	public void handleIDDrapOver(DragEvent dragEvent) {
		Dragboard board = dragEvent.getDragboard();
		if (board.hasFiles()) {
			dragEvent.acceptTransferModes(TransferMode.ANY);
		}
	}

	@FXML
	public void handleIDDrop(DragEvent de) {
		try {
			Dragboard board = de.getDragboard();
			List<File> phil = board.getFiles();
			FileInputStream fileInputStream;
			fileInputStream = new FileInputStream(phil.get(0));
			Image image = new Image(fileInputStream);
			imgIDCard.setImage(image);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void handlePetDrapOver(DragEvent dragEvent) {
		Dragboard board = dragEvent.getDragboard();
		if (board.hasFiles()) {
			dragEvent.acceptTransferModes(TransferMode.ANY);
		}
	}

	@FXML
	public void handlePetDrop(DragEvent de) {
		try {
			Dragboard board = de.getDragboard();
			List<File> phil = board.getFiles();
			FileInputStream fileInputStream;
			fileInputStream = new FileInputStream(phil.get(0));
			Image image = new Image(fileInputStream);
			imgAnimalImage.setImage(image);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void writeFileAnimal(String name) {
		FileOutputStream fileOutputStream;
		ObjectOutputStream objectOutputStream;
		try {
			fileOutputStream = new FileOutputStream(name);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for(CellLayoutAnimal element: animalRecords) {
				objectOutputStream.writeObject(element.getAnimal());
			}
			FileOutputStream fileperson = new FileOutputStream(new File("Animal_Length"));
			fileperson.write(animalRecords.size());
			fileperson.close();
			fileOutputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeFilePersonnel(String name) {
		FileOutputStream fileOutputStream;
		ObjectOutputStream objectOutputStream;
		try {
			fileOutputStream = new FileOutputStream(name);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for(CellLayoutPersonnel element: employeeRecords) {
				objectOutputStream.writeObject(element.getPersonnel());
			}
			FileOutputStream fileperson = new FileOutputStream(new File("Personnel_Length"));
			fileperson.write(employeeRecords.size());
			fileperson.close();
			fileOutputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//Safety check for string fields
		public boolean stringSafetyCheck(TextField txtField) {
			boolean safe;
			if (txtField.getText().isEmpty() == false) {
				safe = true;
				return safe;
			} 
			else {
				txtField.clear();
				txtField.setPromptText("Enter a value");
				safe = false;
				return safe;
			} 
		}

		//Safety check for double fields
		public boolean doubleSafteyCheck(TextField txtField) {
			boolean safe;
			double temp;
			try {
				temp = Double.valueOf(txtField.getText());
				safe = true;
				return safe;
			} catch (Exception e) {
				txtField.clear();
				txtField.setPromptText("Enter a value");
				safe = false;
				return safe;
			}
		}

		//Safety check for integer fields
		public boolean integerSafetyCheck(TextField txtField) {
			boolean safe;
			Integer temp;
			try {
				temp = Integer.valueOf(txtField.getText());
				safe = true;
				return safe;
			} catch (Exception e) {
				txtField.clear();
				txtField.setPromptText("Enter a value");
				safe = false;
				return safe;
			} 
		}

		//Safety check for local date fields
		public boolean dateSafetyCheck(DatePicker datePicker) {
			boolean safe;
			String temp;
			try {
				temp = datePicker.getValue().toString();
				safe = true;
				return safe;
			} catch (Exception e) {
				datePicker.setValue(null);
				datePicker.setPromptText("Enter Date");
				safe = false;
				return safe;
			}
		}

		public boolean choiceSafetyCheck(ChoiceBox<String> choiceBox) {
			boolean safe;
			boolean temp;
			try {
				temp = choiceBox.getValue().isEmpty();
				safe = true;
				return safe;
			} catch (Exception e) {
				lblStatus.setText("Animal Status: Please Select a Status");
				safe = false;
				return safe;
			}
		}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

}
