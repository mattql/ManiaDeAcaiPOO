package controller;

import java.net.URL;
import java.util.List;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import modelBO.FuncionarioBO;
import modelVO.ClienteVO;
import modelVO.FuncionarioVO;
import view.Telas;

public class ListaFuncionariosC implements Initializable{
	
	@FXML private TableView<FuncionarioVO> tabela;
	@FXML private TableColumn<FuncionarioVO, Integer> id;
	@FXML private TableColumn<FuncionarioVO, String> nome;
	@FXML private TableColumn<FuncionarioVO, String> endereco;
	@FXML private TableColumn<FuncionarioVO, String> telefone;
	@FXML private TableColumn<FuncionarioVO, Double> salario;
    @FXML private TextField editarNome;
    @FXML private TextField editarEndereco;
    @FXML private TextField editarTelefone;
    @FXML private TextField editarSalario;
    @FXML private Pane paneEditar;
    @FXML private Pane paneExcluir;
    @FXML private TextField campoPesquisar;
    @FXML private ComboBox<String> selecionarTipoPesquisa;
    
    FuncionarioBO fbo = new FuncionarioBO();
	
	private List<FuncionarioVO> funcionarios;
	private ObservableList<FuncionarioVO> oblFuncionarios;
    
    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	listar();
    	preencherCombobox();
	}
    
    public void listar() {
    	id.setCellValueFactory(new PropertyValueFactory<>("idPessoa"));
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
		
		try {
			funcionarios = fbo.buscar();
			oblFuncionarios = FXCollections.observableArrayList(funcionarios);
			tabela.setItems(oblFuncionarios);
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
    
    FuncionarioVO funcionario = new FuncionarioVO();
    FuncionarioVO novoFuncionario = new FuncionarioVO();
    @FXML
    void confirmarPopup(ActionEvent event) throws Exception {
    	if(tabela.getSelectionModel().getSelectedItem() != null) {
            funcionario = tabela.getSelectionModel().getSelectedItem();
            fbo.remover(funcionario);
            funcionarios = fbo.buscar();
			oblFuncionarios = FXCollections.observableArrayList(funcionarios);
			tabela.setItems(oblFuncionarios);
            cancelarPopup(event);
        } 
    }
    
    @FXML
    void abrirPainelEditar(ActionEvent event) {
    	paneEditar.setVisible(true);
		funcionario = tabela.getSelectionModel().getSelectedItem();
		editarNome.setText(funcionario.getNome());
		editarEndereco.setText(funcionario.getEndereco());
		editarTelefone.setText(funcionario.getTelefone());
		editarSalario.setText(String.valueOf((funcionario.getSalario())));
    }
    
    @FXML
    void confirmarEditar(ActionEvent event) throws Exception {
    	novoFuncionario = new FuncionarioVO();
    	novoFuncionario.setNome(editarNome.getText());
    	novoFuncionario.setEndereco(editarEndereco.getText());
    	novoFuncionario.setTelefone(editarTelefone.getText());
    	novoFuncionario.setSalario(Double.parseDouble(editarSalario.getText()));
		
    	novoFuncionario.setIdPessoa(funcionario.getIdPessoa());
		fbo.alterar(novoFuncionario);
		fbo.alterarEndereco(novoFuncionario);
		fbo.alterarTelefone(novoFuncionario);
		fbo.alterarSalario(novoFuncionario);
		
		funcionarios = fbo.buscar();
		oblFuncionarios = FXCollections.observableArrayList(funcionarios);
		tabela.setItems(oblFuncionarios);
		paneEditar.setVisible(false);
    }
    
    @FXML
    void botaoPesquisar(ActionEvent event) {
		String selectComboBox = selecionarTipoPesquisa.getSelectionModel().getSelectedItem();
		if(selectComboBox == "Nome") {
			FuncionarioVO nomeFuncionario = new FuncionarioVO();
			nomeFuncionario.setNome(campoPesquisar.getText());
			ObservableList<FuncionarioVO> listarNomeFuncionario;
			id.setCellValueFactory(new PropertyValueFactory<>("idPessoa"));
			nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
			telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
			salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
			
			try {
				funcionarios = fbo.buscarPorNome(nomeFuncionario);
				listarNomeFuncionario = FXCollections.observableArrayList(funcionarios);
				tabela.setItems(listarNomeFuncionario);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(selectComboBox == "Telefone") {
			FuncionarioVO telFunc = new FuncionarioVO();
			telFunc.setTelefone(campoPesquisar.getText());
			ObservableList<FuncionarioVO> listarTelefoneFuncionario;
			id.setCellValueFactory(new PropertyValueFactory<>("idPessoa"));
			nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
			telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
			salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
			
			try {
				funcionarios = fbo.buscarPorTelefone(telFunc);
				listarTelefoneFuncionario = FXCollections.observableArrayList(funcionarios);
				tabela.setItems(listarTelefoneFuncionario);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(selectComboBox == "Salário") {
			FuncionarioVO salarioFuncionario = new FuncionarioVO();
			salarioFuncionario.setSalario(Double.parseDouble(campoPesquisar.getText()));
			ObservableList<FuncionarioVO> listarSalarioFuncionario;
			id.setCellValueFactory(new PropertyValueFactory<>("idPessoa"));
			nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
			telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
			salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
			
			try {
				funcionarios = fbo.buscarPorSalario(salarioFuncionario);
				listarSalarioFuncionario = FXCollections.observableArrayList(funcionarios);
				tabela.setItems(listarSalarioFuncionario);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (selectComboBox == "") {
			listar();
		}
    }
    
    public void preencherCombobox() {
		ObservableList<String> pesquisa = FXCollections.observableArrayList("Nome", "Telefone", "Salário", "");
		selecionarTipoPesquisa.setItems(pesquisa);	
	}

    @FXML
    void fecharEditar(ActionEvent event) {
    	paneEditar.setVisible(false);
    }
    
    @FXML
    void abrirCadastrar(ActionEvent event) throws Exception {
		Telas.telaCadastroFuncionario();
    }
    
    @FXML
    void menu(ActionEvent event) throws Exception {
    	Telas.telaMenu();
    }

}
