package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

//b
public class Main extends Application {

	//Private fields to hold one state and a root layout of our main window
	private Stage primaryStage;

	//Start Method
	@Override
	public void start(Stage primaryStage) {
		try {

			//Set main application and provide title and icon
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Mayflower High School Media Center Book Issuance Tracking");

			//Set the application icon
			this.primaryStage.getIcons().add(new Image("/application/AppIcon.png"));

			//Initialize root layout
			initRootLayout();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//Launch Method to launch the application
	public static void main(String[] args) {
		launch(args);
	}

	//Initialize root layout of the application from the FXML file
	public void initRootLayout() {
		try {

			//Main initialization for the layout and application "commencement"
			TabPane rootLayout;
			
			//Create an FXML Loader
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("RootLayout.fxml"));

			//Set the root layout field, casting as appropriate, to inject the FXML
			rootLayout = (TabPane) loader.load();
			
			//Set the scene object to our rootLayout
			Scene editRecord = new Scene(rootLayout);

			//Give controller access to our application handle
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);

			//Set the primary stage to the scene object we just made
			primaryStage.setScene(editRecord);

			//Show the stage
			primaryStage.show();

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}