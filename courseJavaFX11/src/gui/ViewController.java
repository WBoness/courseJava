package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Pessoa;

public class ViewController implements Initializable {

	@FXML
	private ComboBox<Pessoa> comboBoxPessoa;
	@FXML
	private Button btListAll;
	
	private ObservableList<Pessoa> obsList;
	
	@FXML
	public void onBtLisAllAction() {
		//percorre o observablelist (combobox)
		for(Pessoa pessoa: comboBoxPessoa.getItems()) {
			System.out.println(pessoa);
		}
	}
	
	@FXML
	public void onComboBoxPessoaAction() {
		try {
			Pessoa pessoa = comboBoxPessoa.getSelectionModel().getSelectedItem();
			System.out.println("A pessoa selecionada foi: "+ pessoa);
		} 
		catch (NumberFormatException e) {

		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Pessoa> list = new ArrayList<>();
		list.add(new Pessoa(1, "Maria", "maria@gmail.com"));
		list.add(new Pessoa(2, "João", "joão@gmail.com"));
		list.add(new Pessoa(3, "Pedro", "pedro@gmail.com"));
		list.add(new Pessoa(4, "Ana", "ana@gmail.com"));
	
		obsList = FXCollections.observableArrayList(list);
		comboBoxPessoa.setItems(obsList);
		
		// código para personalizar o combobox
		
		Callback<ListView<Pessoa>, ListCell<Pessoa>> factory = lv -> new ListCell<Pessoa>() {
			@Override
			protected void updateItem(Pessoa item, boolean empty) {
			super.updateItem(item, empty);
			setText(empty ? "" : item.getNome());
			}
			};
			comboBoxPessoa.setCellFactory(factory);
			comboBoxPessoa.setButtonCell(factory.call(null));
	}
	
}
