package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import model.entities.Pessoa;

public class ViewController implements Initializable {

	@FXML
	private ComboBox<Pessoa> comboBoxPessoa;
	
	private ObservableList<Pessoa> obsList;
	
	@FXML
	public void onBtSomaAction() {
		try {
		} catch (NumberFormatException e) {

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
	}
	
}
