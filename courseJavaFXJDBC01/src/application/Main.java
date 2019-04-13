package application;

import java.io.IOException;

import com.sun.org.apache.bcel.internal.generic.FMUL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		//Agora est� instanciando ao inves de invocar o m�todo est�tico
		//permite manipular a tela antes de carregar
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			Parent parent = loader.load();//carrega a view
			Scene mainScene = new Scene(parent); //cria a cena principal (passando objeto principal
												 // da view - AnchorPane vazio
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
}
