package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemVendedor;
	@FXML
	private MenuItem menuItemDepartamento;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemVendedorAction() {
		System.out.println("A��o do Item de menu Vendedor");
	}
	
	@FXML
	public void onMenuItemDepartamentoAction() {
		System.out.println("A��o do Item de menu Departamento");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		System.out.println("A��o do Item de menu About");
	}
	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}
}
