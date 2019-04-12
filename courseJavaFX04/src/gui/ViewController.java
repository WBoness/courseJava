package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {

	@FXML
	private Button botao;

	@FXML
	public void onBotaoAction() {
		Alerts.showAlert("Informação de Confirmação", "Parabéns!!!!!!", 
				"Você acabou de clicar no primeiro botão JavaFX"
				, AlertType.INFORMATION);
		System.out.println("Click!");
	}
}
