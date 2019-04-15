package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.listeners.DataChangeListner;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable, DataChangeListner {

	private DepartmentService service;// cria depend�ncia da classe
	// mas n�o cria a classe para n�o gerar forte acoplamento ->> cria m�todo
	// setDepartamentoService

	@FXML
	private TableView<Department> tableViewDepartamento;

	@FXML
	private TableColumn<Department, Integer> tableColumIdDepartamento;

	@FXML
	private TableColumn<Department, String> tableColumNomeDepartamento;

	@FXML
	private TableColumn<Department, Department> tableColumnEdit;

	@FXML
	private Button btNewDepartamento;

	private ObservableList<Department> obsList;// tem que carregar os deptos aqui (criar metodo updateTableView)

	// m�todo de tratamento de evento Bot�o
	public void onBtNewDepartamentoAction(ActionEvent event) { // parametro para acessar o evento
		Stage parentStage = Utils.currentStage(event);
		Department obj = new Department(); // para inicializa o formul�rio vazio --> tem que ser injetado no controlador
											// do formul�rio (criou novo par�metro))
		createDialogForm(obj, "/gui/DepartmentForm.fxml", parentStage);

	}

	// inje��o de depend�ncia da classe servi�o: depois carrega a lista de depto
	// para exibir na lista --> criar observableList
	public void setDepartamentoService(DepartmentService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		inicializaNodes(); // inicia algum componente na tela
	}

	// vai iniciar o comportamento das colunas
	private void inicializaNodes() {
		tableColumIdDepartamento.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumNomeDepartamento.setCellValueFactory(new PropertyValueFactory<>("nome"));

		// configurar altura e largura do tableView
		Stage stage = (Stage) Main.getMainScene().getWindow(); // window � superclasse do stage (faz downcasting)
		tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());

	}

	public void updateTableView() {
		if (service == null) {// garante a inje��o de dependencia
			throw new IllegalStateException("Lista Servi�o est� vazia");
		}
		List<Department> lista = service.findAll();
		obsList = FXCollections.observableArrayList(lista);// pega os dados originais da lista
		tableViewDepartamento.setItems(obsList);// carrega e exibe os dados
		initEditButtons();// vai acrescentar um novo bot�o em cada linha da tabela (que abrir� formul�rio
							// para edi��o)
	}

	private void createDialogForm(Department obj, String absoluteName, Stage parentStage) {// quando cria uma janela de
																							// di�logo, tem que informar
																							// o stage que a criou
		// tem que informar tamb�m o nome da view a ser carregada
		try {
			// l�gica para abrir a janela de formul�rio
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			// pegar uma refer�ncia para o controlador da tela que acabou de carregar
			DepartmentFormContoller controller = loader.getController();
			controller.setDepartment(obj);// injetar no controlador
			controller.setDepartmentService(new DepartmentService());// inje��o pelo bot�o salvar??
			controller.subscribleDataChangeListener(this);// inscreve o pr�prio objeto para escutar o listner
			controller.updateFormData(); // carrega os dados no formul�rio

			// Situa��o:carregar uma janela de di�logo modal na frente de uma existente
			// - � necess�rio criar um novo stage (um na frente do outro)
			Stage dialogStage = new Stage();
			// configurar o stage
			dialogStage.setTitle("Entre com os dados do Departamento");
			dialogStage.setScene(new Scene(pane));// elemento raiz � o pane
			dialogStage.setResizable(false);// janela n�o poder� ser redimensionada
			dialogStage.initOwner(parentStage);// pai da janela
			dialogStage.initModality(Modality.WINDOW_MODAL);// se n�o fechar a janela n�o acessa a anterior
			dialogStage.showAndWait();

		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro carregando View", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void onDataChanged() {
		// escuta o listener para atualizar a lista - tableView
		// tem que se inscrever ---> inje��o de depend�ncia
		updateTableView();
	}

	private void initEditButtons() {
		tableColumnEdit.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEdit.setCellFactory(param -> new TableCell<Department, Department>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(Department obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/DepartmentForm.fxml", Utils.currentStage(event)));
			}
		});
	}

}
