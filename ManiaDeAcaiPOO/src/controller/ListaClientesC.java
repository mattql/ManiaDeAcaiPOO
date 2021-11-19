package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import modelBO.ClienteBO;
import modelVO.ClienteVO;
import view.Telas;

public class ListaClientesC implements Initializable{
	@FXML private TableView<ClienteVO> tabela;
	@FXML private TableColumn<ClienteVO, Integer> id;
	@FXML private TableColumn<ClienteVO, String> nome;
	@FXML private TableColumn<ClienteVO, String> endereco;
	@FXML private TableColumn<ClienteVO, String> telefone;
	@FXML private TableColumn<ClienteVO, String> email;
	@FXML private Pane paneEditar;
	@FXML private Pane paneExcluir;
	@FXML private TextField editarEmail;
    @FXML private TextField editarEndereco;
    @FXML private TextField editarNome;
    @FXML private TextField editarTelefone;
    @FXML private TextField campoPesquisar;


	ClienteBO cbo = new ClienteBO();
	
	private List<ClienteVO> clientes;
	private ObservableList<ClienteVO> oblClientes;
	private ObservableList<ClienteVO> oblPesquisarClientes;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		id.setCellValueFactory(new PropertyValueFactory<>("idPessoa"));
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		try {
			clientes = cbo.buscar();
			oblClientes = FXCollections.observableArrayList(clientes);
			tabela.setItems(oblClientes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void excluir(ActionEvent event) {
        paneExcluir.setVisible(true);
    }
	
	@FXML
    void cancelarPopup(ActionEvent event) {
		paneExcluir.setVisible(false);
    }

	ClienteVO cliente = new ClienteVO();
	ClienteVO novoCliente = new ClienteVO();
    @FXML
    void confirmarPopup(ActionEvent event) throws Exception {
    	if(tabela.getSelectionModel().getSelectedItem() != null) {
            cliente = tabela.getSelectionModel().getSelectedItem();
            cbo.remover(cliente);
            clientes = cbo.buscar();
			oblClientes = FXCollections.observableArrayList(clientes);
			tabela.setItems(oblClientes);
            cancelarPopup(event);
        }  
    }

	@FXML
    void abrirPainelEditar(ActionEvent event) throws Exception {
		paneEditar.setVisible(true);
		cliente = tabela.getSelectionModel().getSelectedItem();
		editarNome.setText(cliente.getNome());
		editarEndereco.setText(cliente.getEndereco());
		editarTelefone.setText(cliente.getTelefone());
		editarEmail.setText(cliente.getEmail());
    }
	
	@FXML
	void confirmarEditar(ActionEvent event) throws Exception {
		novoCliente = new ClienteVO();
		novoCliente.setNome(editarNome.getText());
		novoCliente.setEndereco(editarEndereco.getText());
		novoCliente.setTelefone(editarTelefone.getText());
		novoCliente.setEmail(editarEmail.getText());
		
		novoCliente.setIdPessoa(cliente.getIdPessoa());
		cbo.alterar(novoCliente);
		cbo.alterarEndereco(novoCliente);
		cbo.alterarTelefone(novoCliente);
		cbo.alterarEmail(novoCliente);
		
		clientes = cbo.buscar();
		oblClientes = FXCollections.observableArrayList(clientes);
		tabela.setItems(oblClientes);
		paneEditar.setVisible(false);
	    }
	
	@FXML
    void fecharEditar(ActionEvent event) {
		paneEditar.setVisible(false);
    }
	
	@FXML
    void abrirCadastrar(ActionEvent event) throws Exception {
		Telas.telaCadastroCliente();
    }
	
	@FXML
    void botaoPesquisar(ActionEvent event) throws Exception {
		
		
    }
	
	@FXML
    void menu(ActionEvent event) throws Exception {
		Telas.telaMenu();
    }
}