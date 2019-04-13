package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {
	
	@FXML
	private Button botao;
	
	@FXML
	public void onBotaoAction() {
		System.out.println("Click");
	}
}
