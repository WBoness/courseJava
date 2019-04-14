package gui;

/*
 * Classe que controla os componentes da tela de cadastro de Departamento
 * 		- Caixas de di�logo
 * 		- bot�es
 * 		- mensagem de erro no label oculto
 */
import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormContoller implements Initializable {

	@FXML
	private TextField txtId;
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	//eventos para tratar os bot�es
	@FXML
	public void onBtSaveAction() {
		System.out.println("Bot�o Save pressionado");
	}
	@FXML
	public void onBtCancelAction() {
		System.out.println("Bot�o Cancel pressionado");
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// pode ser colocado algumas restri��es: ID (inteiro), Nome (limite caracteres)...
		// criou m�todo inicializaNodes()
		inictializaNodes();
	}
	
	private void inictializaNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 40);
		
	}

}
