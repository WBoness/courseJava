package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {

	//para acessar (obter) o stage onde o controller que recebeu o evento (envent) está
	//ex. se clicar em um botão, pega o stage daquele botão
	
	public static Stage currentSatage(ActionEvent event) {
		return (Stage)((Node)event.getSource()).getScene().getWindow();
		
	}
}
