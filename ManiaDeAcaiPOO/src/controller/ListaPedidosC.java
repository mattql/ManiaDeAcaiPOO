package controller;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modelVO.ClienteVO;
import modelVO.PedidoProdutoVO;
import modelVO.PedidoVO;
import view.Telas;

public class ListaPedidosC implements Initializable{

    @FXML private TextField campoPesquisar;
    @FXML private TableView<PedidoVO> tabela;
    @FXML private TableColumn<PedidoVO, ClienteVO> cliente;
    @FXML private TableColumn<PedidoVO, Calendar> data;
    @FXML private TableColumn<PedidoVO, String> formaDePagamento;
    @FXML private TableColumn<PedidoVO, Integer> id;
    @FXML private TableColumn<PedidoVO, PedidoProdutoVO> info;
    @FXML private TableColumn<PedidoVO, Integer> quantidade;
    @FXML private TableColumn<PedidoVO, String> status;
    @FXML private TableColumn<PedidoVO, Double> valorTotal;
    @FXML private Pane paneEditar;
    @FXML private ComboBox<String> comboboxStatus;

    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	preencherCombobox();
	}
    
    @FXML
    void botaoRealizarPedido(ActionEvent event) throws Exception {
    	Telas.telaRealizarPedido();
    }
    
    public void preencherCombobox() {
		ObservableList<String> status = FXCollections.observableArrayList("Confirmado", "Saiu para entrega", "Entregue", "");
		comboboxStatus.setItems(status);	
	}

    @FXML
    void botaoEditar(ActionEvent event) {
    	paneEditar.setVisible(true);
    }
    
    @FXML
    void cancelarPopup(ActionEvent event) {
    	paneEditar.setVisible(false);
    }

    @FXML
    void confirmarPopup(ActionEvent event) {
    	paneEditar.setVisible(false);
    }

    @FXML
    void menu(ActionEvent event) throws Exception {
    	Telas.telaMenu();
    }
}
