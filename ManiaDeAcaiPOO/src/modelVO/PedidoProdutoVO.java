package modelVO;

public class PedidoProdutoVO {
	private int codPedidoProduto;
	private PedidoVO cod_pedido;
	private ProdutoVO cod_produto;
	
	
	
	public int getCodPedidoProduto() {
		return codPedidoProduto;
	}
	public void setCodPedidoProduto(int codPedidoProduto) {
		this.codPedidoProduto = codPedidoProduto;
	}
	
	
	public PedidoVO getCod_pedido() {
		return cod_pedido;
	}
	public void setCod_pedido(PedidoVO cod_pedido) {
		this.cod_pedido = cod_pedido;
	}
	
	
	public ProdutoVO getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(ProdutoVO cod_produto) {
		this.cod_produto = cod_produto;
	}
	
}
