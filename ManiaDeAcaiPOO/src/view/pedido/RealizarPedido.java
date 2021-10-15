package view.pedido;

import javafx.stage.Parent;
import javafx.stage.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

public class RealizarPedido extends Application{
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("RealizarPedido.fxml"));
		
		Scene cena = new Scene(root);
		
		arg0.setTitle("Mania de Açaí");
		arg0.setScene(cena);
		arg0.show();
	}
}
