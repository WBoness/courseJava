package gui;

/*
 * Classe que controla os componentes da tela de cadastro de Departamento
 * 		- Caixas de di�logo
 * 		- bot�es
 * 		- mensagem de erro no label oculto
 */
import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormContoller implements Initializable {

	private Department entity; //criar depend�ncia de Departamento (tem que implementar o m�todo set)
							  // com isso o controlador ter� uma inst�ncia do Department
	private DepartmentService service; //cria depend�ncia com DepartmentService e cria m�todo set
	
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
	
	public void setDepartmentService (DepartmentService service) {
		this.service = service;
	}
			
	//eventos para tratar os bot�es
	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if (entity ==null) {
			throw new IllegalStateException("Entity est� nulo!");
		}
		if (service == null) {
			throw new IllegalStateException("Service est� nulo!");
		}
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			// para fechar a janela
			Utils.currentSatage(event).close(); // pega a refer�ncia para a janela atual (formul�rio) --> precisa do evento (acrescenta ActionEvent como par�metro)
													   // Chama a opera��o close para fechar a janela 
			
		}
		catch (DbException e) {
			Alerts.showAlert("Erro salvando objeto", null, e.getMessage(), AlertType.ERROR);
		}

	}
	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentSatage(event).close();
	}
	
	private Department getFormData() {
		Department obj = new Department();
		obj.setId(Utils.tryParseToInt(txtId.getId()));
		obj.setNome(txtName.getText());
		
		return obj;
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
	
	//respons�vel por popular os campos do formul�rio com os dados do departamento (entity)
	public void updateFormData() {
		
		//testa se foi feita a inje��o de depend�ncia (entity)
		if (entity == null) {
			throw new IllegalStateException("Entity nulo!");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getNome());
	}
	
}
