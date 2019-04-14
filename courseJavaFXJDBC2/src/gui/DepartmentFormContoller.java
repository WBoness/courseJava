package gui;

/*
 * Classe que controla os componentes da tela de cadastro de Departamento
 * 		- Caixas de diálogo
 * 		- botões
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
import model.entities.Department;

public class DepartmentFormContoller implements Initializable {

	private Department entity; //criar dependência de Departamento (tem que implementar o método set)
							  // com isso o controlador terá uma instância do Department
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
	
	public void setDepartment (Department entity) {
		this.entity = entity;
	}
			
			
	//eventos para tratar os botões
	@FXML
	public void onBtSaveAction() {
		System.out.println("Botão Save pressionado");
	}
	@FXML
	public void onBtCancelAction() {
		System.out.println("Botão Cancel pressionado");
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// pode ser colocado algumas restrições: ID (inteiro), Nome (limite caracteres)...
		// criou método inicializaNodes()
		inictializaNodes();
	}
	
	private void inictializaNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 40);
		
	}
	
	//responsável por popular os campos do formulário com os dados do departamento (entity)
	public void updateFormData() {
		
		//testa se foi feita a injeção de dependência (entity)
		if (entity == null) {
			throw new IllegalStateException("Entity nulo!");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getNome());
	}

}
