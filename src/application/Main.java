package application;
/*
Thaddeus Albert Bartz
William Christian Leonard
Period 5
PSET6-0 SuperProject
Febuary 12, 2018
*/
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
			this.primaryStage.setTitle("Animal Information");
			
			//set the application icon, can be of type jpg or png
			this.primaryStage.getIcons().add(new Image("file:resources/AppIcon.png"));
			
			initRootLayout();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	//main
	public static void main(String[] args) {
		launch(args);
	}
	
	public void initRootLayout() {
		try {
			
		
			//create FXML Loader
			FXMLLoader loader = new FXMLLoader();
			
			//Point loader at FXML File
			loader.setLocation(Main.class.getResource("/application/RootLayout.FXML"));
			
			//Set the root layout field, casting as appropriate to inject the FXML
			rootLayout = (BorderPane) loader.load();
			
			//scene object = root layout
			Scene scene = new Scene(rootLayout);
			
			
			//give controller access
			//RootLayoutController controller = loader.getController();
			//controller.setMainApp(this);
			
			//set primary scene
			primaryStage.setScene(scene);
			
			//show stage
			primaryStage.show();
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
