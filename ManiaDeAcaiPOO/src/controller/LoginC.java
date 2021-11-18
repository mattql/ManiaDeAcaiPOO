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
	@FXML private TextField login;
	@FXML private PasswordField senha;
	@FXML private Label erroAut;
	
	AdministradorBO abo = new AdministradorBO();

	@FXML
    void logar(ActionEvent event) throws Exception {
		AdministradorVO avo = new AdministradorVO();
		avo.setloginADM(login.getText());
		avo.setsenhaADM(senha.getText());

		try {
			AdministradorVO autenticado = abo.autenticar(avo);
			if (autenticado instanceof AdministradorVO) {
				Telas.telaMenu();
			}
		} catch (Exception e) {
			erroAut.setText("Login ou senha inválidos!");
			erroAut.setVisible(true);
		}
    }
}
