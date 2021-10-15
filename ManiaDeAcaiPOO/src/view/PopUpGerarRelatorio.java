package view;

import view.cliente.Parent;
import view.cliente.Scene;
import view.cliente.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

public class PopUpGerarRelatorio extends Application{
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("PopUpGerarRelatorio.fxml"));
		
		Scene cena = new Scene(root);
		
		arg0.setTitle("Mania de Açaí");
		arg0.setScene(cena);
		arg0.show();
	}
}
