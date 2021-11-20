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
import modelBO.ProdutoBO;
import modelVO.ClienteVO;
import modelVO.ProdutoVO;
import view.Telas;

public class ListaProdutosController implements Initializable{
    
    @FXML private TableView<ProdutoVO> tabela;
    @FXML private TableColumn<ProdutoVO, Integer> id;
    @FXML private TableColumn<ProdutoVO, String> nome;
    @FXML private TableColumn<ProdutoVO, Double> preco;
    @FXML private TableColumn<ProdutoVO, String> categoria;
    @FXML private TextField editarNome;
    @FXML private TextField editarPreco;
    @FXML private TextField editarCategoria;
    @FXML private Pane paneExcluir;
    @FXML private Pane paneEditar;
    @FXML private TextField campoPesquisar;
    @FXML private ComboBox<String> selecionarTipoPesquisa;
       
    ProdutoBO pbo = new ProdutoBO();
	
	private List<ProdutoVO> produtos;
	private ObservableList<ProdutoVO> oblProdutos;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listar();
		preencherCombobox();
	}
	
	public void listar() {
		id.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		nome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
		preco.setCellValueFactory(new PropertyValueFactory<>("precoProduto"));
		categoria.setCellValueFactory(new PropertyValueFactory<>("categoriaProduto"));

		try {
			produtos = pbo.buscar();
			oblProdutos = FXCollections.observableArrayList(produtos);
			tabela.setItems(oblProdutos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void excluir(ActionEvent event) {
		paneExcluir.setVisible(true);
    }
	
	@FXML
    void cancelarPopupExcluir(ActionEvent event) {
		paneExcluir.setVisible(false);
    }
	
	ProdutoVO produto = new ProdutoVO();
	ProdutoVO novoProduto = new ProdutoVO();
    @FXML
    void confirmarPopupExcluir(ActionEvent event) throws Exception {
    	if(tabela.getSelectionModel().getSelectedItem() != null) {
            produto = tabela.getSelectionModel().getSelectedItem();
            pbo.remover(produto);
            produtos = pbo.buscar();
			oblProdutos = FXCollections.observableArrayList(produtos);
			tabela.setItems(oblProdutos);
            cancelarPopupExcluir(event);
        }
    }
    
    @FXML
    void botaoEditar(ActionEvent event) {
    	paneEditar.setVisible(true);
		produto = tabela.getSelectionModel().getSelectedItem();
		editarNome.setText(produto.getNomeProduto());
		editarPreco.setText(String.valueOf(produto.getPrecoProduto()));
		editarCategoria.setText(produto.getCategoriaProduto());
    }
    
    @FXML
    void confirmarEditar(ActionEvent event) throws Exception {
    	novoProduto = new ProdutoVO();
    	novoProduto.setNomeProduto((editarNome.getText()));
    	novoProduto.setPrecoProduto(Double.parseDouble(editarPreco.getText()));
    	novoProduto.setCategoriaProduto(editarCategoria.getText());
		
    	novoProduto.setIdProduto(produto.getIdProduto());
		pbo.alterar(novoProduto);
		pbo.alterarPreco(novoProduto);
		pbo.alterarCategoria(novoProduto);
		
		produtos = pbo.buscar();
		oblProdutos = FXCollections.observableArrayList(produtos);
		tabela.setItems(oblProdutos);
		paneEditar.setVisible(false);
    }
    
    @FXML
    void cancelarEditar(ActionEvent event) {
    	paneEditar.setVisible(false);
    }
	
	@FXML
    void botaoCadastrar(ActionEvent event) throws Exception {
		Telas.telaCadastroProduto();
    }
	
	@FXML
    void botaoPesquisar(ActionEvent event) {
		String selectComboBox = selecionarTipoPesquisa.getSelectionModel().getSelectedItem();
		if(selectComboBox == "Nome") {
			ProdutoVO nomeProduto = new ProdutoVO();
			nomeProduto.setNomeProduto(campoPesquisar.getText());
			ObservableList<ProdutoVO> listarNomeProduto;
			id.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
			nome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
			preco.setCellValueFactory(new PropertyValueFactory<>("precoProduto"));
			categoria.setCellValueFactory(new PropertyValueFactory<>("categoriaProduto"));

			
			try {
				produtos = pbo.buscarPorNome(nomeProduto);
				listarNomeProduto = FXCollections.observableArrayList(produtos);
				tabela.setItems(listarNomeProduto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(selectComboBox == "Categoria") {
			ProdutoVO catProduto = new ProdutoVO();
			catProduto.setCategoriaProduto(campoPesquisar.getText());
			ObservableList<ProdutoVO> listarCategoriaProduto;
			id.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
			nome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
			preco.setCellValueFactory(new PropertyValueFactory<>("precoProduto"));
			categoria.setCellValueFactory(new PropertyValueFactory<>("categoriaProduto"));
			
			try {
				produtos = pbo.buscarPorCategoria(catProduto);
				listarCategoriaProduto = FXCollections.observableArrayList(produtos);
				tabela.setItems(listarCategoriaProduto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (selectComboBox == "") {
			listar();
		}
    }
	
	public void preencherCombobox() {
		ObservableList<String> pesquisa = FXCollections.observableArrayList("Nome", "Categoria", "");
		selecionarTipoPesquisa.setItems(pesquisa);	
	}

    @FXML
    void menu(ActionEvent event) throws Exception {
    	Telas.telaMenu();
    }
}
