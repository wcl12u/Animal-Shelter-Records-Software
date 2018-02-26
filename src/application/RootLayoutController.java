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
import java.util.logging.Handler;
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

	ObservableList<CellLayoutPersonnel> employeeRecords = FXCollections.observableArrayList();
	ObservableList<CellLayoutAnimal> animalRecords = FXCollections.observableArrayList();

	private final String password = "person records!!";

	public void initialize() {

		personnelEdit.setDisable(true);
		//listviewPersonnel.setItems(employeeRecords);
		root.getChildren();

		if (animalRecords.size() == 0) {
			btnSaveEdit.setDisable(true);
			btnSave.setDisable(false);
			btnDelete.setDisable(true);
			Image defaultImage = new Image("/application/AddImageImage.png");
			imgAnimalImage.setImage(defaultImage);
			imgIDCard.setImage(defaultImage);
		}
	}
	
	@FXML
	public void handleBasicView() {
		if (basicView.isSelected() == true) {
			if (animalIndex != -1) {
				BasicAnimal animal = animalRecords.get(animalIndex);
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
			for(/*does not exist*/) {
				
			}
			
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

	

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

}
