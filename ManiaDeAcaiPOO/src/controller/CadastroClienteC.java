package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modelBO.ClienteBO;
import modelVO.ClienteVO;
import view.Telas;

public class CadastroClienteC {
	ClienteBO c = new ClienteBO();
	ClienteVO cvo = new ClienteVO();
	
    @FXML private TextField nomeCliente;
    @FXML private TextField enderecoCliente;
    @FXML private TextField telefoneCliente;
    @FXML private TextField email;
    @FXML private Pane confirmacaoCadastro;

    @FXML
    void botaoCancelar(ActionEvent event) throws Exception {
    	Telas.telaListaCliente();
    }

    @FXML
    void botaoConfirmar(ActionEvent event) throws Exception {
    	confirmacaoCadastro.setVisible(true);
    	
    }
    
    @FXML
    void cancelarPopup(ActionEvent event) {
    	confirmacaoCadastro.setVisible(false);
    }

    @FXML
    void confirmarPopup(ActionEvent event) throws Exception {
    	cvo.setNome(nomeCliente.getText());
    	cvo.setEndereco(enderecoCliente.getText());
    	cvo.setTelefone(telefoneCliente.getText());
    	cvo.setEmail(email.getText());
    	c.cadastrar(cvo);
    	botaoCancelar(event);
    }
}
