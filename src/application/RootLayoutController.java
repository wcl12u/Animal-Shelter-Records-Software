package application;

import java.awt.Button;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class RootLayoutController {
	
	private Main mainApp;
	
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
	private ImageView imgAnimalImage;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtAge;
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
	private TextArea txtareaNotes;
	@FXML
	private Button btnSaveNotes;
	@FXML
	private ImageView imgIDCard;
	@FXML
	private TextField txtOwnerName;
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
	private Label lblMaintenance;
	@FXML
	private Label lblPersonnelCost;
	@FXML
	private Label lblProfit;
	@FXML
	private Label lblRevenue;
	@FXML
	private PasswordField pswdPersonnelEdit;
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
	
	ObservableList<CellLayoutPersonnel> employeeRecords = FXCollections.observableArrayList();
	
	ObservableList<BasicAnimal> animalRecords = FXCollections.observableArrayList();
	
	public void initialize() {
		
	}
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
}
