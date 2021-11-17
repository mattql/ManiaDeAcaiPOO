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
import modelBO.ProdutoBO;
import modelVO.ProdutoVO;
import view.Telas;

public class ListaProdutosC implements Initializable{
	@FXML private TableView<ProdutoVO> tabela;
	@FXML private TableColumn<ProdutoVO, Integer> id;
	@FXML private TableColumn<ProdutoVO, String> nome;
	@FXML private TableColumn<ProdutoVO, Double> preco;
	@FXML private TableColumn<ProdutoVO, String> categoria;
	@FXML private Pane paneEditar;
	@FXML private TextField editarNome;
	@FXML private TextField editarPreco;
	@FXML private TextField editarCategoria;
	@FXML private Pane paneExcluir;
	
	
	ProdutoBO pbo = new ProdutoBO();
	
	private List<ProdutoVO> produtos;
	private ObservableList<ProdutoVO> oblProdutos;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
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
	void botaoCadastrar(ActionEvent event) throws Exception {
		Telas.telaCadastroProduto();
	}

	ProdutoVO produto = new ProdutoVO();
	ProdutoVO novoProduto = new ProdutoVO();
	@FXML
	void confirmarEditar(ActionEvent event) throws Exception {
		novoProduto = new ProdutoVO();
		novoProduto.setnomeProduto(editarNome.getText());
		novoProduto.setprecoProduto(Double.parseDouble(editarPreco.getText()));
		novoProduto.setcategoriaProduto(editarCategoria.getText());
		
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
	void botaoEditar(ActionEvent event) {
		paneEditar.setVisible(true);
		produto = tabela.getSelectionModel().getSelectedItem();
		editarNome.setText(produto.getnomeProduto());
		editarPreco.setText(String.valueOf(produto.getprecoProduto()));
		editarCategoria.setText(produto.getcategoriaProduto());
	}

	@FXML
	void botaoExcluir(ActionEvent event) {
		paneExcluir.setVisible(true);
	}
	
	@FXML
    void cancelarPopupExcluir(ActionEvent event) {
		paneExcluir.setVisible(false);
    }

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

}