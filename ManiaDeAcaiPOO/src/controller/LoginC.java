package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modelBO.AdministradorBO;
import modelVO.AdministradorVO;
import view.Telas;

public class LoginC {
	@FXML private TextField login;
	@FXML private PasswordField senha;
	@FXML private Label erroAut;
	@FXML private Pane paneCadastrar;
	@FXML private TextField cadastrarLogin;
    @FXML private TextField cadastrarSenha;
	
	AdministradorBO abo = new AdministradorBO();
	AdministradorVO vo = new AdministradorVO();

	@FXML
    void logar(ActionEvent event) throws Exception {
		AdministradorVO avo = new AdministradorVO();
		
		avo.setLogin(login.getText());
		avo.setSenha(senha.getText());

		try {
			AdministradorVO autenticado = abo.autenticar(avo);
			if (autenticado instanceof AdministradorVO) {
				Telas.telaMenu();
			}
		} catch (Exception e) {
			erroAut.setText("Login ou senha inválidos!");
			erroAut.setVisible(true);
		}
		//Telas.telaMenu();
    }
	
	@FXML
    void cadastrarAdmin(ActionEvent event) {
		paneCadastrar.setVisible(true);
    }

    @FXML
    void cancelarCadastro(ActionEvent event) {
    	paneCadastrar.setVisible(false);
    }

    @FXML
    void confirmarCadastro(ActionEvent event) throws Exception {
    	vo.setLogin(cadastrarLogin.getText());
    	vo.setSenha(cadastrarSenha.getText());
    	abo.cadastrar(vo);
    	cancelarCadastro(event);
    }
}
