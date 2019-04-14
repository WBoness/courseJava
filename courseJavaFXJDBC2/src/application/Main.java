package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		//Agora está instanciando ao inves de invocar o método estático
		//permite manipular a tela antes de carregar
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane scrollPane = loader.load();//carrega a view --> criar ScrollPane
			
			scrollPane.setFitToHeight(true);//ajusta o scrollpane à altura
			scrollPane.setFitToWidth(true);//ajusta à largura
			
			/* Alteração após cria variável estática mainScene
			Scene mainScene = new Scene(scrollPane); //cria a cena principal (passando objeto principal
												 // da view - AnchorPane vazio
   		  */
			mainScene = new Scene(scrollPane);
			
			primaryStage.setScene(mainScene);// palco da sena, seta o palco
			primaryStage.setTitle("Exemplo de Aplicação JavaFX");// coloca título
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
}
