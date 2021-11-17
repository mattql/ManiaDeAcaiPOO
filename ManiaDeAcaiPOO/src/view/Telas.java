package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{
	private static Stage primaryStage;
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}

	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Mania de Açaí");
		primaryStage.show();
		telaLogin();
	}
		
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("Login.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastroCliente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("cliente/CadastroCliente.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaListaCliente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("cliente/ListaClientes.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastroProduto() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("produto/CadastroProduto.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaListaProdutosADM() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("produto/ListaProdutosAdm.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaListaProdutosFunc() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("produto/ListaProdFunc.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastroFuncionario() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("funcionario/CadastroFuncionario.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaListaFuncionario() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("funcionario/ListaFuncionario.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaListaPedido() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("pedido/ListaPedidos.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaRealizarPedido() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("pedido/RealizarPedido.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
		
	public static void main(String [] args) {
		launch();
	}
	
}
