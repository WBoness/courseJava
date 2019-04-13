package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {

	@FXML
	private Button btSoma;
	@FXML
	private TextField txtNumber01;
	@FXML
	private TextField txtNumber02;
	@FXML
	private Label labelResult;
	

	@FXML
	public void onBtSomaAction() {
		try {
			Locale.setDefault(Locale.US);
			Double	numero01 = Double.parseDouble(txtNumber01.getText());	
			Double	numero02 = Double.parseDouble(txtNumber02.getText());
			Double soma = numero01+numero02;
			labelResult.setText(String.format("%.2f", soma));
			
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Erro!", null, "CONTE�DO INV�LIDO! \n" 
					+ "Opera��o s� pode ser realizada entre n�meros reais!\n"
					+ "O separador de decimais � o '.'!"
					+ e.getMessage(), AlertType.ERROR);
		}
	}

	//m�todo � executado quando o controlador for criado 
	// por exemplo as constraints
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(txtNumber01); //s� aceita numeros; rejeita letras
		Constraints.setTextFieldDouble(txtNumber02);
		Constraints.setTextFieldMaxLength(txtNumber01, 5);// limita em 5 digitos
		Constraints.setTextFieldMaxLength(txtNumber02, 7);
		
	}
}
