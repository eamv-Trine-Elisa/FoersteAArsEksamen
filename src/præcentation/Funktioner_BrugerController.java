package præcentation;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Funktioner_BrugerController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	@FXML
	private void haandterBestilKnap(ActionEvent event) {
		
	}

	@FXML
	private void haandterPerson() {
		System.out.println("1");
	}

	@FXML
	private void startKommune() {
//		ChoiceBox = countChoiceBox;
//		countChoiceBox.setItems(FXCollections.observableArrayList("One","Two","Three"));
		//FXCollections.observableArrayList("First", "Second", "Third");
	}
	
	@FXML
	private void dag(){
		TextField dag = null;
		dag.getText();
	}

}
