package view;


import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class TelaDeLogin extends Application{
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("TelaDeLogin.fxml"));
		
		Scene cena = new Scene(root);
		
		arg0.setTitle("Mania de A�a�");
		arg0.setScene(cena);
		arg0.show();
	}
}