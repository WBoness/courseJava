package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

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
		loadView("/gui/AboutView.fxml");
	}
	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}
	
	private void loadView (String absoluteName) {//carrega uma view
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			/*
			 * 0.View carregada;  
			 * 1.Tem que mostrar a view dentro da janela principal;
			 * 		-para trabalhar com a janela principal:
			 * 			1. Tem que ter uma refer�ncia da cena em que a janela principal est� (Main.java)
			 * 			2. Ela est� dentro do primaryStage (palco)
			 * 			3. tem que guardar e referenciar a cena (vari�vel Scene est�tica mainScene)
			 * 				- cria um getMainScene() para obter a cena principal
			 * 		- precisa da refer�ncia porque precisa preservara cena padr�o e montar outra para ser exposta
			 * 			1. armazena a cena
			 * 			2. localiza o ponto do VBox da janela principal
			 * 			3. limpa o conte�do (com o original j� preservado)
			 * 			4. limpa o conte�do
			 * 			5. insere o conte�do + o conte�do do VBox do About
			 * 
			 */
			
			Scene mainScene = Main.getMainScene();//armazena a cena
			/*ScrollPane mainScrollPane = new ScrollPane(mainScene.getRoot());//obtem o primeiro conte�do da Janela principal
			VBox mainVbox = (VBox) mainScrollPane.getContent();//obtem a refer�ncia para o VBox dentro do ScrollPane (com casting)
			*/
			//pode ser substituido por: 
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
						
			// preservar o menuBar > limbar o VBox > incluir todo o conte�do novamente
			Node mainMenu = mainVBox.getChildren().get(0);//preserva o menuBar
			mainVBox.getChildren().clear(); //Exclui os filhos do mainVBox
			mainVBox.getChildren().add(mainMenu); //incluir o menubar +
			mainVBox.getChildren().addAll(newVBox.getChildren()); // filhos do VBox da janela About
		}
		catch (IOException e) {
			Alerts.showAlert("Erro carregando a p�gina", null,e.getMessage() , AlertType.ERROR);
		}
	}
}
