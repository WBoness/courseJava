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
		System.out.println("Ação do Item de menu Vendedor");
	}
	
	@FXML
	public void onMenuItemDepartamentoAction() {
		System.out.println("Ação do Item de menu Departamento");
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
			 * 			1. Tem que ter uma referência da cena em que a janela principal está (Main.java)
			 * 			2. Ela está dentro do primaryStage (palco)
			 * 			3. tem que guardar e referenciar a cena (variável Scene estática mainScene)
			 * 				- cria um getMainScene() para obter a cena principal
			 * 		- precisa da referência porque precisa preservara cena padrão e montar outra para ser exposta
			 * 			1. armazena a cena
			 * 			2. localiza o ponto do VBox da janela principal
			 * 			3. limpa o conteúdo (com o original já preservado)
			 * 			4. limpa o conteúdo
			 * 			5. insere o conteúdo + o conteúdo do VBox do About
			 * 
			 */
			
			Scene mainScene = Main.getMainScene();//armazena a cena
			/*ScrollPane mainScrollPane = new ScrollPane(mainScene.getRoot());//obtem o primeiro conteúdo da Janela principal
			VBox mainVbox = (VBox) mainScrollPane.getContent();//obtem a referência para o VBox dentro do ScrollPane (com casting)
			*/
			//pode ser substituido por: 
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
						
			// preservar o menuBar > limbar o VBox > incluir todo o conteúdo novamente
			Node mainMenu = mainVBox.getChildren().get(0);//preserva o menuBar
			mainVBox.getChildren().clear(); //Exclui os filhos do mainVBox
			mainVBox.getChildren().add(mainMenu); //incluir o menubar +
			mainVBox.getChildren().addAll(newVBox.getChildren()); // filhos do VBox da janela About
		}
		catch (IOException e) {
			Alerts.showAlert("Erro carregando a página", null,e.getMessage() , AlertType.ERROR);
		}
	}
}
