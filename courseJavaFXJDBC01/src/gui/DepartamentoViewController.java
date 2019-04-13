package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
		inicializaNodes(); //inicia algum componente na tela
	}

	//vai iniciar o comportamento das colunas 
	private void inicializaNodes() {
		tableColumIdDepartamento.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumIdDepartamento.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		//configurar altura e largura do tableView
		Stage stage = (Stage) Main.getMainScene().getWindow(); //window é superclasse do stage (faz downcasting)
		tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());
		
	}

}
