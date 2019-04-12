package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {

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
			Alerts.showAlert("Erro!", null, "CONTEÚDO INVÁLIDO! \n" 
					+ "Operação só pode ser realizada entre números reais!\n"
					+ "O separador de decimais é o '.'!", AlertType.ERROR);
		}
	}
}
