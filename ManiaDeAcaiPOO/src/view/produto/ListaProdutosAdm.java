package view.produto;

import javafx.stage.Parent;
import javafx.stage.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

public class ListaProdutosAdm extends Application{
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ListaProdutosAdm.fxml"));
		
		Scene cena = new Scene(root);
		
		arg0.setTitle("Mania de A�a�");
		arg0.setScene(cena);
		arg0.show();
	}
}
