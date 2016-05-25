package præcentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	BorderPane sceneTILwindow;
	Stage primaryStage;
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Midttrafik Flextrafik");
		
		sceneLoader();
		funktionerBrugerLoader();
		
	}
	
	private void sceneLoader(){
		FXMLLoader loader = new FXMLLoader();		
		try {
			loader.setLocation(Main.class.getResource("Window.fxml"));
			sceneTILwindow = (BorderPane) loader.load();
			Scene scene = new Scene(sceneTILwindow);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void funktionerBrugerLoader(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Funktioner_Bruger.fxml"));
		
		try {
			AnchorPane sceneTilBruger = (AnchorPane)loader.load();
			VBox boxIcenter = new VBox();
			boxIcenter.getChildren().add(sceneTilBruger);
			sceneTILwindow.setCenter(boxIcenter);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
