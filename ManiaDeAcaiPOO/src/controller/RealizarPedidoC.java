package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import view.Telas;

public class RealizarPedidoC implements Initializable{

    @FXML private Pane paneRealizado;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
    
    @FXML
    void botaoCancelar(ActionEvent event) throws Exception {
    	Telas.telaListaPedido();
    }

    @FXML
    void botaoConfirmar(ActionEvent event) {
    	paneRealizado.setVisible(true);
    }

    @FXML
    void botaoVoltarPopup(ActionEvent event) throws Exception {
    	paneRealizado.setVisible(false);
    }
}
