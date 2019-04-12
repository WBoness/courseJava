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
		Alerts.showAlert("Informa��o de Confirma��o", "Parab�ns!!!!!!", 
				"Voc� acabou de clicar no primeiro bot�o JavaFX"
				, AlertType.INFORMATION);
		System.out.println("Click!");
	}
}
