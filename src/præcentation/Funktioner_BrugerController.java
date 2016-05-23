package præcentation;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class Funktioner_BrugerController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	@FXML
	private void haandterBestilKnap(){
		System.out.println("Trykket");
	}

	@FXML
	private void haandterPerson(){
		System.out.println("1");
	}
	
	
}
