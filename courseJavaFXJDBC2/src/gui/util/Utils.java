package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {

	//para acessar (obter) o stage onde o controller que recebeu o evento (envent) est�
	//ex. se clicar em um bot�o, pega o stage daquele bot�o
	
	public static Stage currentSatage(ActionEvent event) {
		return (Stage)((Node)event.getSource()).getScene().getWindow();
		
	}
}
