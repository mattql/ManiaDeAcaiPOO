package view.popups;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PopUpMenuFuncionario extends Application{
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("PopUpMenuFuncionario.fxml"));
		
		Scene cena = new Scene(root);
		
		arg0.setTitle("Mania de Açaí");
		arg0.setScene(cena);
		arg0.show();
	}
}
