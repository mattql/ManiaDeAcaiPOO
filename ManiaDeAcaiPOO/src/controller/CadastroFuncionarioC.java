package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modelBO.FuncionarioBO;
import modelVO.FuncionarioVO;
import view.Telas;

public class CadastroFuncionarioC {
	FuncionarioBO f = new FuncionarioBO();
	FuncionarioVO fvo = new FuncionarioVO();
	
    @FXML private TextField nome;
    @FXML private TextField endereco;
    @FXML private TextField telefone;
    @FXML private TextField salario;
    @FXML private Pane confirmacaoCadastro;
    
    
    @FXML
    void botaoCancelar(ActionEvent event) throws Exception {
    	Telas.telaListaFuncionario();
    }

    @FXML
    void botaoConfirmar(ActionEvent event) {
    	confirmacaoCadastro.setVisible(true);
    }
    
    @FXML
    void cancelarPopup(ActionEvent event) {
    	confirmacaoCadastro.setVisible(false);
    }

    @FXML
    void confirmarPopup(ActionEvent event) throws Exception {
    	fvo.setNome(nome.getText());
    	fvo.setEndereco(endereco.getText());
    	fvo.setTelefone(telefone.getText());
    	fvo.setSalario(Double.parseDouble(salario.getText()));
    	f.cadastrar(fvo);
    	botaoCancelar(event);
    }
}
