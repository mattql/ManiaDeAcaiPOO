package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.Telas;

public class MenuC {

    @FXML
    void abrirTelaClientes(ActionEvent event) throws Exception {
    	Telas.telaListaCliente();
    }

    @FXML
    void abrirTelaFuncionarios(ActionEvent event) throws Exception {
    	Telas.telaListaFuncionario();
    }

    @FXML
    void abrirTelaPedidos(ActionEvent event) throws Exception {
    	Telas.telaListaPedido();
    }

    @FXML
    void abrirTelaProdutos(ActionEvent event) throws Exception {
    	Telas.telaListaProdutos();
    }

    @FXML
    void abrirTelaRealizarPedidos(ActionEvent event) throws Exception {
    	Telas.telaRealizarPedido();
    }

    @FXML
    void abrirTelaRelatorio(ActionEvent event) throws Exception {
    	Telas.telaGerarRelatorio();
    }

    @FXML
    void logout(ActionEvent event) throws Exception {
    	Telas.telaLogin();
    }

}
