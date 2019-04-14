package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService servico;//cria dependência da classe 
	// mas não cria a classe para não gerar forte acoplamento ->> cria método
	//setDepartamentoService
	
	
	@FXML
	private TableView<Department> tableViewDepartamento;
	
	@FXML
	private TableColumn<Department, Integer> tableColumIdDepartamento;
	
	@FXML
	private TableColumn<Department, String> tableColumNomeDepartamento;
	
	@FXML
	private Button btNewDepartamento;
	
	private ObservableList<Department> obsList;// tem que carregar os deptos aqui (criar metodo updateTableView)
	
	//método de tratamento de evento Botão
	public void onBtNewDepartamentoAction() {
		System.out.println("Criar Novo Departamento!");
	}

	//injeção de dependência da classe serviço: depois carrega a lista de depto
	// para exibir na lista --> criar observableList
	public void setDepartamentoService(DepartmentService servico) {
		this.servico=servico;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		inicializaNodes(); //inicia algum componente na tela
	}

	//vai iniciar o comportamento das colunas 
	private void inicializaNodes() {
		tableColumIdDepartamento.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumNomeDepartamento.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		//configurar altura e largura do tableView
		Stage stage = (Stage) Main.getMainScene().getWindow(); //window é superclasse do stage (faz downcasting)
		tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());
		
	}
	
	public void updateTableView() {
		if (servico==null) {//garante a injeção de dependencia
			throw new IllegalStateException("Lista Serviço está vazia");
		}else {
			List<Department> lista = servico.findAll();
			obsList = FXCollections.observableArrayList(lista);//pega os dados originais da lista
			tableViewDepartamento.setItems(obsList);// carrega e exibe os dados
		}
		}

}
