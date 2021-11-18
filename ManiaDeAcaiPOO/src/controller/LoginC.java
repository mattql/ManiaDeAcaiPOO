package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelBO.AdministradorBO;
import modelVO.AdministradorVO;
import view.Telas;

public class LoginC {
	private Telas view;
	@FXML private TextField login;
	@FXML private PasswordField senha;
	@FXML private Label erro;
	
	AdministradorBO bo = new AdministradorBO();
	AdministradorVO vo = new AdministradorVO();

	@FXML
    void logar(ActionEvent event) throws Exception {
		Telas.telaMenu();
		//Telas.telaListaCliente();
		//Telas.telaListaProdutos();
		//Telas.telaListaProdutosFunc();
		//Telas.telaCadastroFuncionario();
		//Telas.telaListaFuncionario();
    }

}
