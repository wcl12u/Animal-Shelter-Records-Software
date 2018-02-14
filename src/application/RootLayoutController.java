package application;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
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
	private ImageView imgAnimalImage;
	
	
	public void initialize() {
		
	}
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
}
