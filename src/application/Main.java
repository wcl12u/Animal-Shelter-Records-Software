package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	//private fields to hold one stage and a root layout of our main window
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//set main application and provide title + icon
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Bad Calculator");
			
			//set the application icon, can be of type jpg or png
			this.primaryStage.getIcons().add(new Image("file:resources/AppIcon.png"));
			
			initRootLayout();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	//the most basic main ever
	public static void main(String[] args) {
		launch(args);
	}
	
	public void initRootLayout() {
		try {
			
		
			//create and FXML Loader
			FXMLLoader loader = new FXMLLoader();
			
			//Point the loader at FXML File
			loader.setLocation(Main.class.getResource("/application/RootLayout.FXML"));
			
			//Set the root layout field, casting as appropriate to inject the FXML
			rootLayout = (BorderPane) loader.load();
			
			//scene object = root layout
			Scene scene = new Scene(rootLayout);
			
			
			//give controller access to our application handle
			//RootLayoutController controller = loader.getController();
			//controller.setMainApp(this);
			
			//set the primary scene
			primaryStage.setScene(scene);
			
			//show the stage
			primaryStage.show();
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
