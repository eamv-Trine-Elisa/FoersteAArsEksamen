package præcentation;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Funktioner_BrugerController implements Initializable{


	@FXML
	private Label navn;
	@FXML
	private Label kundenr;
	
	@FXML
	private TextField dagDato;
	@FXML
	private TextField månedDato;
	
	@FXML
	private RadioButton afgang;
	@FXML
	private RadioButton ankomst;
	@FXML
	private TextField tid;
	
	@FXML
	private TextField startVejOgNr;
	@FXML
	private TextField startBy;
	@FXML
	private TextField startPostnr;
	@FXML
	private SplitMenuButton startKommune;
	
	@FXML
	private TextField slutVejOgNr;
	@FXML
	private TextField slutBy;
	@FXML
	private TextField slutPostnr;
	@FXML
	private SplitMenuButton slutKommune;
	
	
	@FXML
	private TextField antalPersoner;
	@FXML
	private TextArea hjælpemidler;

	@FXML
	private TextField beregnetPris;
	@FXML
	private Button bestil;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
		
	}


	@FXML
	public void håndterBestilKnap(){
		
		kundenr.getText();
		
	}

}
