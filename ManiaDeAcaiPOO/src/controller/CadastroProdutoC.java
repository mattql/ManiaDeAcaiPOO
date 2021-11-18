package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modelBO.ProdutoBO;
import modelVO.ProdutoVO;
import view.Telas;

public class CadastroProdutoC {
	ProdutoBO p = new ProdutoBO();
	ProdutoVO pvo = new ProdutoVO();
	
    @FXML private TextField nome;
    @FXML private TextField preco;
    @FXML private TextField categoria;
    @FXML private Pane confirmacaoCadastro;
    
    @FXML 
    void botaoCancelar(ActionEvent event) throws Exception {
    	Telas.telaListaProdutos();
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
    	pvo.setnomeProduto(nome.getText());
    	pvo.setprecoProduto(Double.parseDouble(preco.getText()));
    	pvo.setcategoriaProduto(categoria.getText());
    	p.cadastrar(pvo);
    	botaoCancelar(event);
    }

}
