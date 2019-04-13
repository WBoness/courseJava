package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.entities.Departamento;

public class DepartamentoViewController implements Initializable {

	@FXML
	private TableView<Departamento> tableViewDepartamento;
	
	@FXML
	private TableColumn<Departamento, Integer> tableColumIdDepartamento;
	
	@FXML
	private TableColumn<Departamento, String> tableColumNomeDepartamento;
	
	@FXML
	private Button btNewDepartamento;
	
	//método de tratamento de evento Botão
	public void onBtNewDepartamentoAction() {
		System.out.println("Criar Novo Departamento!");
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
