package application;

/*
Thaddeus Albert Bartz
William Christian Leonard
Period 5
PSET6-0 SuperProject
February 12, 2018
 */

//Imported Classes
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.Format;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.imageio.ImageIO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

//The controller for the RootLayout
public class RootLayoutController {

	//Fields
	private Main mainApp;

	private int animalIndex = -1;
	private int personnelIndex = -1;
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
	private HBox manageBar;
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

	//Downloaded from https://thenounproject.com/term/add-image/934572/
	final Image defaultImage = new Image("/application/AddImageImage.png");

	final ObservableList<String> status = FXCollections.observableArrayList("Healthy", "Stable", "Critical");

	private final String password = "person records!!";

	private String fileAnimalName = "src/application/Animals";

	private String filePersonnelName = "src/application/Personnel";

	private boolean locked = true;

	//Method called on launch of application
	public void initialize() {

		readFileAnimal();
		readFilePersonnel();

		personnelEdit.setDisable(locked);

		listviewPersonnel.setItems(employeeRecords);
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
		else {
			animalIndex = 0;
			handleBasicView();
		}

		if(employeeRecords.size() != 0) {
			personnelIndex = 0;
		}	
	}

	//Handles Next Button
	@FXML
	public void handleNext() {
		animalIndex++;
		handleBasicView();
	}

	//Handles Previous Button
	@FXML
	public void handlePrevious() {
		animalIndex--;
		handleBasicView();
	}

	//Handles Next Button for Employees
	@FXML
	public void handleNextEmployee() {
		personnelIndex++;
		handleManageView();
	}

	//Handles Previous Button for Employees
	@FXML
	public void handlePreviousEmployee() {
		personnelIndex--;
		handleManageView();
	}

	//Handles Basic View Selection
	@FXML
	public void handleBasicView() {
		if (basicView.isSelected()) {
			if (animalIndex != -1) {
				BasicAnimal animal = animalRecords.get(animalIndex).getAnimal();
				imgAnimalImage.setImage(animal.getAnimalImage());
				centerImage(imgAnimalImage);
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
				handleNewAnimal();
			}
		}
		handleIncrementDisable();
	}

	//Handles Vet View Selection
	@FXML
	public void handleVetView() {
		if(vetView.isSelected()) {
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
	}

	//Handles Owner View Selection
	@FXML
	public void handleOwnerView() {
		if(ownerView.isSelected()) {
			if(animalRecords.size() != 0) {
				Owner animalOwner = animalRecords.get(animalIndex).getAnimal().getOwner();
				if(animalOwner.getOwnerName().equals("No Data Entered")) {
					imgIDCard.setImage(defaultImage);
				}
				else {
					imgIDCard.setImage(animalOwner.getOwnerID());
				}
				centerImage(imgIDCard);
				txtOwnerName.setText(animalOwner.getOwnerName());
				if(animalOwner.getOwnerAge() != -1) {
					txtOwnerAge.setText(String.valueOf(animalOwner.getOwnerAge()));
				}
				else {
					txtOwnerAge.setText("No Data Entered");
				}
				dateAdoptionDate.setValue(animalOwner.getDateOfAdoption());
				txtAddress.setText(animalOwner.getOwnerAddress());
				txtStateOfResidence.setText(animalOwner.getOwnerStateOfResidence());
				txtPhoneNum.setText(animalOwner.getOwnerPhoneNumber());
			}
		}
	}

	//Handles New Employee Button
	@FXML
	public void handleNewEmployee() {
		btnDeleteEmployee.setDisable(true);
		btnSaveEditEmployee.setDisable(true);
		btnSaveEmployee.setDisable(false);
		txtNameEmployee.clear();
		txtAgeEmployee.clear();
		txtAddressEmployee.clear();
		dateBirthday.setValue(null);
		dateEmployementDate.setValue(null);
		txtWage.clear();
		chkbxIsEmployed.setSelected(false);
		txtareaEmployeeNotes.clear();
	}

	//Handles Personnel Edit Password Field
	@FXML
	public void handlePersonnelLock() {
		if (pswdPersonnelEdit.getText().equals(password)) {
			pswdPersonnelEdit.setPromptText("");
			pswdPersonnelEdit.clear();
			locked = false;
			handleManageView();
		}
		else {
			pswdPersonnelEdit.setStyle("-fx-prompt-text-fill: red;");
			pswdPersonnelEdit.clear();
			pswdPersonnelEdit.setPromptText("Invaild Password");
			manageBar.requestFocus();
		}
	}

	//Handles Manage View Selection
	@FXML
	public void handleManageView() {
		if (manageView.isSelected()) {
			if(locked == false) {
				personnelEdit.setDisable(locked);
				if(personnelIndex != -1) {
					btnNewEmployee.setDisable(locked);
					btnDeleteEmployee.setDisable(locked);
					btnSaveEditEmployee.setDisable(locked);
					Personnel employee = employeeRecords.get(personnelIndex).getPersonnel();
					txtNameEmployee.setText(employee.getPersonnelName());
					txtAgeEmployee.setText(String.valueOf(employee.getPersonnelAge()));
					txtAddressEmployee.setText(employee.getPersonnelAddress());
					dateBirthday.setValue(employee.getPersonnelDOB());
					dateEmployementDate.setValue(employee.getPersonnelDOE());
					txtWage.setText(String.valueOf(employee.getWage()));
					chkbxIsEmployed.setSelected(employee.getEmployed());
					txtareaEmployeeNotes.setText(employee.getEmployeeNotes());
				}
				else {
					handleNewEmployee();
				}
				handleIncrementDisable();
			}
			else {
				personnelEdit.setDisable(locked);
				btnNewEmployee.setDisable(locked);
				btnDeleteEmployee.setDisable(locked);
				btnSaveEmployee.setDisable(locked);
				btnSaveEditEmployee.setDisable(locked);
				btnNextEmployee.setDisable(locked);
				btnPreviousEmployee.setDisable(locked);
			}
		}
	}

	//Handles Personnel Information View Selection
	@FXML
	public void handlePersonnelInformationView() {
		if (viewEmployeeRecords.isSelected()) {
			for(CellLayoutPersonnel element: employeeRecords) {
				element.setView();
			}
			handleIncrementDisable();
			listviewPersonnel.scrollTo(personnelIndex);
			double foodCost = 34.75 * animalRecords.size();
			double maintenanceCost = 53.50 * animalRecords.size();
			double personnelCost = 0.00;
			for(CellLayoutPersonnel element: employeeRecords) {
				personnelCost += (element.getPersonnel().getWage() * 40);
			}
			double revenue = 0.00;
			for (CellLayoutAnimal element: animalRecords) {
				if (!element.getAnimal().getOwner().getOwnerName().equals("No Data Entered")) {
					revenue += 175.25;
				}
			}
			double profit = revenue - (personnelCost + foodCost + maintenanceCost);
			lblFoodCost.setText(NumberFormat.getCurrencyInstance(Locale.US).format(foodCost));
			lblMaintenanceCost.setText(NumberFormat.getCurrencyInstance(Locale.US).format(maintenanceCost));
			lblPersonnelCost.setText(NumberFormat.getCurrencyInstance(Locale.US).format(personnelCost));
			lblRevenue.setText(NumberFormat.getCurrencyInstance(Locale.US).format(revenue));
			lblProfit.setText(NumberFormat.getCurrencyInstance(Locale.US).format(profit));
		}
	}

	//Handles Animal Report View Selection
	@FXML
	public void handleAnimalReportView() {
		if (viewAnimalRecords.isSelected()) {
			for(CellLayoutAnimal element: animalRecords) {
				element.setView(listviewAnimal);
			}
			handleIncrementDisable();
			listviewAnimal.scrollTo(animalIndex);
		}
	}

	//Handles Save Button for Basic View
	@FXML
	public void handleSaveBasic() {

		boolean filled = true;
		BasicAnimal animal = new BasicAnimal();

		animal.setAnimalImage(imgAnimalImage.getImage());

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
			writeFileAnimal(fileAnimalName);
			btnSave.setDisable(true);
			btnSaveEdit.setDisable(false);
			btnDelete.setDisable(false);
			vetView.setDisable(false);
			ownerView.setDisable(false);
			animalIndex = animalRecords.size() - 1;
			handleIncrementDisable();
		}
	}

	//Handles Save Edit Button for Basic View
	@FXML
	public void handleSaveEditAnimal() {

		boolean filled = true;
		BasicAnimal animal = new BasicAnimal();

		animal.setAnimalImage(imgAnimalImage.getImage());

		if(stringSafetyCheck(txtName) == true) {
			animal.setAnimalName(txtName.getText());
			txtName.setPromptText("");
			new File("src/application/" + animalRecords.get(animalIndex).getAnimal().getAnimalName()).delete();
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

		animal.setVetStatus(animalRecords.get(animalIndex).getAnimal().getVetStatus());
		animal.setOwner(animalRecords.get(animalIndex).getAnimal().getOwner());

		if (filled != false) {
			CellLayoutAnimal cellAnimal = new CellLayoutAnimal(animal);
			animalRecords.set(animalIndex, cellAnimal);
			writeFileAnimal(fileAnimalName);
			btnSave.setDisable(true);
			btnSaveEdit.setDisable(false);
			btnDelete.setDisable(false);
			vetView.setDisable(false);
			ownerView.setDisable(false);
			animalIndex = animalRecords.size() - 1;
		}
	}

	//Handles Save Button for Owner View
	@FXML
	public void handleOwnerSave() {

		boolean filled = true;
		BasicAnimal animal = animalRecords.get(animalIndex).getAnimal();
		Owner ownerInfo = new Owner();

		ownerInfo.setOwnerID(imgIDCard.getImage());

		if(stringSafetyCheck(txtOwnerName) == true) {
			ownerInfo.setOwnerName(txtOwnerName.getText());
			txtOwnerName.setPromptText("");
			if(!animal.getOwner().getOwnerName().equals("No Data Entered")) {
				new File("src/application/" + animal.getOwner().getOwnerName()).delete();
			}
		}
		else {
			filled = false;
		}

		if(integerSafetyCheck(txtOwnerAge) == true) {
			ownerInfo.setOwnerAge(Integer.valueOf(txtOwnerAge.getText()));
			txtOwnerAge.setPromptText("");
		}
		else {
			filled = false;
		}

		if(dateSafetyCheck(dateAdoptionDate) == true) {
			ownerInfo.setDateOfAdoption(dateAdoptionDate.getValue());
			dateAdoptionDate.setPromptText("");
		}
		else {
			filled = false;
		}

		if(stringSafetyCheck(txtAddress) == true) {
			ownerInfo.setOwnerAddress(txtAddress.getText());
			txtAddress.setPromptText("");
		}
		else {
			filled = false;
		}

		if(stringSafetyCheck(txtStateOfResidence) == true) {
			ownerInfo.setOwnerStateOfResidence(txtStateOfResidence.getText());
			txtStateOfResidence.setPromptText("");
		}
		else {
			filled = false;
		}

		if(stringSafetyCheck(txtPhoneNum) == true) {
			ownerInfo.setOwnerPhoneNumber(txtPhoneNum.getText());
			txtPhoneNum.setPromptText("");
		}
		else {
			filled = false;
		}

		if(filled != false) {
			animal.setOwner(ownerInfo);
			CellLayoutAnimal cellLayoutAnimal = new CellLayoutAnimal(animal);
			animalRecords.set(animalIndex, cellLayoutAnimal);
			writeFileAnimal(fileAnimalName);
		}
	}

	//Handles Save Button for Vet View
	@FXML
	public void handleVetSave() {

		boolean filled = true;
		BasicAnimal animal = animalRecords.get(animalIndex).getAnimal();
		VetStatus vetInfo = new VetStatus();

		if(stringSafetyCheck(txtVetName) == true) {
			vetInfo.setVetName(txtVetName.getText());
			txtVetName.setPromptText("");
		}
		else {
			filled = false;
		}

		if(stringSafetyCheck(txtVetAddress) == true) {
			vetInfo.setVetLocation(txtVetAddress.getText());
			txtVetAddress.setPromptText("");
		}
		else {
			filled = false;
		}

		if(stringSafetyCheck(txtDoctorName) == true) {
			vetInfo.setDoctorName(txtDoctorName.getText());
			txtDoctorName.setPromptText("");
		}
		else {
			filled = false;
		}

		if(choiceSafetyCheck(chbxAnimalStatus) == true) {
			vetInfo.setAnimalStatus(chbxAnimalStatus.getValue());
			lblStatus.setText("Animal Status");
		}
		else {
			filled = false;
		}

		if(stringSafetyCheck(txtareaNotes) == true) {
			vetInfo.setAnimalNotes(txtareaNotes.getText());
			txtareaNotes.setPromptText("");
		}
		else {
			filled = false;
		}

		if(filled != false) {
			animal.setVetStatus(vetInfo);
			CellLayoutAnimal cellLayoutAnimal = new CellLayoutAnimal(animal);
			animalRecords.set(animalIndex, cellLayoutAnimal);
			writeFileAnimal(fileAnimalName);
		}

	}

	//Handles Save Button for Employee Edit View
	@FXML
	public void handleSaveEmployee() {

		boolean filled = true;
		Personnel employee = new Personnel();

		if(stringSafetyCheck(txtNameEmployee) == true) {
			employee.setPersonnelName(txtNameEmployee.getText());
			txtNameEmployee.setPromptText("");
		}
		else {
			filled = false;
		}

		if(integerSafetyCheck(txtAgeEmployee) == true) {
			employee.setPersonnelAge(Integer.valueOf(txtAgeEmployee.getText()));
			txtAgeEmployee.setPromptText("");
		}
		else {
			filled = false;
		}

		if(stringSafetyCheck(txtAddressEmployee) == true) {
			employee.setPersonnelAddress(txtAddressEmployee.getText());
			txtAddressEmployee.setPromptText("");
		}
		else {
			filled = false;
		}

		if(dateSafetyCheck(dateBirthday) == true) {
			employee.setPersonnelDOB(dateBirthday.getValue());
			dateBirthday.setPromptText("");
		}
		else {
			filled = false;
		}

		if(dateSafetyCheck(dateEmployementDate) == true) {
			employee.setPersonnelDOE(dateEmployementDate.getValue());
			dateEmployementDate.setPromptText("");
		}
		else {
			filled = false;
		}

		if(doubleSafteyCheck(txtWage) == true) {
			employee.setWage(Double.valueOf(txtWage.getText()));
			txtWage.setPromptText("");
		}
		else {
			filled = false;
		}

		employee.setEmployed(chkbxIsEmployed.isSelected());

		if(stringSafetyCheck(txtareaEmployeeNotes) == true) {
			employee.setEmployeeNotes(txtareaEmployeeNotes.getText());
			txtareaEmployeeNotes.setPromptText("");
		}
		else {
			filled = false;
		}

		if(filled != false) {
			CellLayoutPersonnel cellLayoutPersonnel = new CellLayoutPersonnel(employee);
			employeeRecords.add(cellLayoutPersonnel);
			writeFilePersonnel(filePersonnelName);
			btnNewEmployee.setDisable(false);
			btnSaveEmployee.setDisable(true);
			btnSaveEditEmployee.setDisable(false);
			btnDeleteEmployee.setDisable(false);
			personnelIndex = employeeRecords.size()-1;
			handleIncrementDisable();
		}
	}

	//Handles Save Edit Button for Employee Edit View
	@FXML
	public void handleSaveEditEmployee() {

		boolean filled = true;
		Personnel employee = new Personnel();

		if(stringSafetyCheck(txtNameEmployee) == true) {
			employee.setPersonnelName(txtNameEmployee.getText());
			txtNameEmployee.setPromptText("");
		}
		else {
			filled = false;
		}

		if(integerSafetyCheck(txtAgeEmployee) == true) {
			employee.setPersonnelAge(Integer.valueOf(txtAgeEmployee.getText()));
			txtAgeEmployee.setPromptText("");
		}
		else {
			filled = false;
		}

		if(stringSafetyCheck(txtAddressEmployee) == true) {
			employee.setPersonnelAddress(txtAddressEmployee.getText());
			txtAddressEmployee.setPromptText("");
		}
		else {
			filled = false;
		}

		if(dateSafetyCheck(dateBirthday) == true) {
			employee.setPersonnelDOB(dateBirthday.getValue());
			dateBirthday.setPromptText("");
		}
		else {
			filled = false;
		}

		if(dateSafetyCheck(dateEmployementDate) == true) {
			employee.setPersonnelDOE(dateEmployementDate.getValue());
			dateEmployementDate.setPromptText("");
		}
		else {
			filled = false;
		}

		if(doubleSafteyCheck(txtWage) == true) {
			employee.setWage(Double.valueOf(txtWage.getText()));
			txtWage.setPromptText("");
		}
		else {
			filled = false;
		}

		employee.setEmployed(chkbxIsEmployed.isSelected());

		if(stringSafetyCheck(txtareaEmployeeNotes) == true) {
			employee.setEmployeeNotes(txtareaEmployeeNotes.getText());
			txtareaEmployeeNotes.setPromptText("");
		}
		else {
			filled = false;
		}

		if(filled != false) {
			CellLayoutPersonnel cellLayoutPersonnel = new CellLayoutPersonnel(employee);
			employeeRecords.set(personnelIndex, cellLayoutPersonnel);
			writeFilePersonnel(filePersonnelName);
			btnNewEmployee.setDisable(false);
			btnSaveEmployee.setDisable(true);
			btnSaveEditEmployee.setDisable(false);
			btnDeleteEmployee.setDisable(false);
			personnelIndex = employeeRecords.size()-1;
			handleIncrementDisable();
		}

	}

	//Handles Delete Button for Employee Edit View
	@FXML
	public void handleDeleteEmployee() {
		employeeRecords.remove(personnelIndex);
		writeFilePersonnel(filePersonnelName);
		if(employeeRecords.size() !=0 && personnelIndex-1 == -1) {
			personnelIndex = 0;
		}
		else {
			personnelIndex--;
		}
		handleManageView();
	}

	//Handles New Button for Basic View
	@FXML
	public void handleNewAnimal() {
		btnDelete.setDisable(true);
		btnSaveEdit.setDisable(true);
		btnSave.setDisable(false);
		imgAnimalImage.setImage(defaultImage);
		centerImage(imgAnimalImage);
		txtName.clear();
		txtAnimalType.clear();
		txtWeight.clear();
		txtBreed.clear();
	}

	//Handles Delete Button for Basic View
	@FXML
	public void handleDeleteAnimal() {
		new File("src/application/" + animalRecords.get(animalIndex).getAnimal().getAnimalName()).delete();
		if (new File("src/application/" + animalRecords.get(animalIndex).getAnimal().getOwner().getOwnerName()).exists() == true) {
			new File("src/application/" + animalRecords.get(animalIndex).getAnimal().getOwner().getOwnerName()).delete();
		}
		animalRecords.remove(animalIndex);
		writeFileAnimal(fileAnimalName);
		if(animalRecords.size() != 0 && animalIndex-1 == -1) {
			animalIndex = 0;
		}
		else {
			animalIndex--;
		}
		handleBasicView();
	}

	//Method for checking increment button disabling
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
		else if(manageView.isSelected() == true) {
			if(personnelIndex-1 <= -1) {
				btnPreviousEmployee.setDisable(true);
			}
			else {
				btnPreviousEmployee.setDisable(false);
			}
			if(personnelIndex+1 >= employeeRecords.size()) {
				btnNextEmployee.setDisable(true);
			}
			else {
				btnNextEmployee.setDisable(false);
			}
		}
		else if(viewEmployeeRecords.isSelected() == true) {
			if(personnelIndex+1 >= employeeRecords.size()) {
				btnNextEmployeeView.setDisable(true);
			}
			else {
				btnNextEmployeeView.setDisable(false);
			}
			if(personnelIndex-1 <= -1) {
				btnPreviousEmployeeView.setDisable(true);
			}
			else {
				btnPreviousEmployeeView.setDisable(false);
			}
		}
	}

	//Handles Drag Over Event for ID Photo
	@FXML
	public void handleIDDrapOver(DragEvent dragEvent) {
		Dragboard board = dragEvent.getDragboard();
		if (board.hasFiles()) {
			dragEvent.acceptTransferModes(TransferMode.ANY);
		}
	}

	//Handles Drop Event for ID Photo
	@FXML
	public void handleIDDrop(DragEvent de) {
		try {
			Dragboard board = de.getDragboard();
			List<File> phil = board.getFiles();
			FileInputStream fileInputStream;
			fileInputStream = new FileInputStream(phil.get(0));
			Image image = new Image(fileInputStream);
			imgIDCard.setImage(image);
			centerImage(imgIDCard);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//Handles Drag Over Event for Animal Photo
	@FXML
	public void handlePetDrapOver(DragEvent dragEvent) {
		Dragboard board = dragEvent.getDragboard();
		if (board.hasFiles()) {
			dragEvent.acceptTransferModes(TransferMode.ANY);
		}
	}

	//Handles Drop Event for Animal Photo
	@FXML
	public void handlePetDrop(DragEvent de) {
		try {
			Dragboard board = de.getDragboard();
			List<File> phil = board.getFiles();
			FileInputStream fileInputStream;
			fileInputStream = new FileInputStream(phil.get(0));
			Image image = new Image(fileInputStream);
			imgAnimalImage.setImage(image);
			centerImage(imgAnimalImage);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//Method for Centering an Image in an Image View
	public void centerImage(ImageView imageView) {
		Image img = imageView.getImage();
		if (img != null) {
			double w = 0;
			double h = 0;

			double ratioX = imageView.getFitWidth() / img.getWidth();
			double ratioY = imageView.getFitHeight() / img.getHeight();

			double reducCoeff = 0;
			if(ratioX >= ratioY) {
				reducCoeff = ratioY;
			} else {
				reducCoeff = ratioX;
			}

			w = img.getWidth() * reducCoeff;
			h = img.getHeight() * reducCoeff;

			imageView.setX((imageView.getFitWidth() - w) / 2);
			imageView.setY((imageView.getFitHeight() - h) / 2);

		}
	}

	//Method for writing animal information to a file
	public void writeFileAnimal(String name) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(name);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for(CellLayoutAnimal element: animalRecords) {
				objectOutputStream.writeObject(element.getAnimal());
				BufferedImage bImage = SwingFXUtils.fromFXImage(element.getAnimal().getAnimalImage(), null);
				if (new File("src/application/" + element.getAnimal().getAnimalName()).exists() != true) {
					new File("src/application/" + element.getAnimal().getAnimalName()).createNewFile();
				}
				if (new File("src/application/" + element.getAnimal().getOwner().getOwnerName()).exists() != true && !element.getAnimal().getOwner().getOwnerName().equals("No Data Entered")) {
					new File("src/application/" + element.getAnimal().getOwner().getOwnerName()).createNewFile();
				}
				if (!element.getAnimal().getOwner().getOwnerName().equals("No Data Entered")) {
					File image2 = new File("src/application/" + element.getAnimal().getOwner().getOwnerName());
					BufferedImage bImage2 = SwingFXUtils.fromFXImage(element.getAnimal().getOwner().getOwnerID(), null);
					ImageIO.write(bImage2, "png", image2);
				}
				File image = new File("src/application/" + element.getAnimal().getAnimalName());
				ImageIO.write(bImage, "png", image);
			}
			FileOutputStream fileperson = new FileOutputStream(new File("src/application/Animal_Length"));
			fileperson.write(animalRecords.size());
			fileperson.close();
			fileOutputStream.close();
			objectOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Method for writing personnel information to a file
	public void writeFilePersonnel(String name) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(name);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for(CellLayoutPersonnel element: employeeRecords) {
				objectOutputStream.writeObject(element.getPersonnel());
			}
			FileOutputStream fileperson = new FileOutputStream(new File("src/application/Personnel_Length"));
			fileperson.write(employeeRecords.size());
			fileperson.close();
			fileOutputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Method for reading animal information from a file
	public void readFileAnimal() {
		try {
			FileInputStream fileInputStream = new FileInputStream("src/application/Animals");
			if (fileInputStream.available() > 0) {
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				FileInputStream fileInputStream3 = new FileInputStream("src/application/Animal_Length");
				int len = fileInputStream3.read();
				fileInputStream3.close();
				for(int x = 0; x < len; x++) {
					BasicAnimal temp = (BasicAnimal) objectInputStream.readObject();
					BufferedImage bImage = ImageIO.read(new File("src/application/" + temp.getAnimalName()));
					Image image = SwingFXUtils.toFXImage(bImage, null);
					temp.setAnimalImage(image);
					if(!temp.getOwner().getOwnerName().equals("No Data Entered")) {
						BufferedImage bImage2 = ImageIO.read(new File("src/application/" + temp.getOwner().getOwnerName()));
						Image image2 = SwingFXUtils.toFXImage(bImage2, null);
						temp.getOwner().setOwnerID(image2);
					}
					else {
						temp.getOwner().setOwnerID(defaultImage);
					}
					CellLayoutAnimal layoutAnimal = new CellLayoutAnimal(temp);
					animalRecords.add(layoutAnimal);
				}
				fileInputStream.close();
				objectInputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Method for reading personnel information from a file
	public void readFilePersonnel() {
		try {
			FileInputStream fileInputStream = new FileInputStream("src/application/Personnel");
			if (fileInputStream.available() > 0) {
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				FileInputStream fileInputStream2 = new FileInputStream("src/application/Personnel_Length");
				int len = fileInputStream2.read();
				fileInputStream2.close();
				for(int x = 0; x < len; x++) {
					Personnel temp = (Personnel) objectInputStream.readObject();
					CellLayoutPersonnel layoutAnimal = new CellLayoutPersonnel(temp);
					employeeRecords.add(layoutAnimal);
				}
				fileInputStream.close();
				objectInputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//Safety check for string fields of a text field
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

	//Safety check for string fields of a text area
	public boolean stringSafetyCheck(TextArea textArea) {
		boolean safe;
		if (textArea.getText().isEmpty() == false) {
			safe = true;
			return safe;
		} 
		else {
			textArea.clear();
			textArea.setPromptText("Enter Notes");
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

	//Safety check for a choice box field
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

	//MainApp Setter
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
}
