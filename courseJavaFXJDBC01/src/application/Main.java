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
		//Agora est� instanciando ao inves de invocar o m�todo est�tico
		//permite manipular a tela antes de carregar
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane scrollPane = loader.load();//carrega a view --> criar ScrollPane
			
			scrollPane.setFitToHeight(true);//ajusta o scrollpane � altura
			scrollPane.setFitToWidth(true);//ajusta � largura
			
			/* Altera��o ap�s cria vari�vel est�tica mainScene
			Scene mainScene = new Scene(scrollPane); //cria a cena principal (passando objeto principal
												 // da view - AnchorPane vazio
   		  */
			mainScene = new Scene(scrollPane);
			
			primaryStage.setScene(mainScene);// palco da sena, seta o palco
			primaryStage.setTitle("Exemplo de Aplica��o JavaFX");// coloca t�tulo
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
