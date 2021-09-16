package modelVO;
import java.util.*;

public class PedidoVO {
    private int idPedido;
    private ClienteVO cliente;
    private int quantidadeProdutos;
    private PedidoProdutoVO infoProduto[];
    private String formaDePagamentoPedido;
    private String statusPedido;
    private Calendar dataPedido;
    private double precoTotalPedido;
    
    
    //ID do Pedido
    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        if(idPedido < 0) {
            System.out.println("ID inválido.");
        }
        else
            this.idPedido = idPedido;
    }
    
    
    //Cliente do Pedido
    public ClienteVO getCliente() {
        return cliente;
    }
    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }
    
    
    //Quantidade de Produtos
    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }
    public void setQuantidadeProdutos(int quantidadeProdutos) {
        if(quantidadeProdutos < 0) {
            System.out.println("Quantidade inválida.");
        }
        else
            this.quantidadeProdutos = quantidadeProdutos;
    }
    
    
    //Produtos do Pedido
    public PedidoProdutoVO[] getInfoProduto() {
        return infoProduto;
    }
    public void setInfoProduto(PedidoProdutoVO[] infoProduto) {
        this.infoProduto = infoProduto;
    }
    
    
    //Forma de Pagamento
    public String getFormaDePagamentoPedido() {
        return formaDePagamentoPedido;
    }
    public void setFormaDePagamentoPedido(String formaDePagamentoPedido) {
        if(formaDePagamentoPedido == null) {
        System.out.println("Adicione algo válido");    
        }
        else
            this.formaDePagamentoPedido = formaDePagamentoPedido;
    }
    
    
    //Status do Pedido
    public String getStatusPedido() {
        return statusPedido;
    }
    public void setStatusPedido(String statusPedido) {
        if(statusPedido == null) {
        System.out.println("Adicione algo válido");
        }
        else
            this.statusPedido = statusPedido;
    }
    
    
    //Data do Pedido
    public Calendar getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(Calendar dataPedido) {
        Calendar data = Calendar.getInstance();
        dataPedido = data;
        System.out.println("Data e Hora atual: "+ dataPedido.getTime());
        this.dataPedido = dataPedido;
    }
    
    
    //Preço Total do Pedido
    public double getPrecoTotalPedido() {
        return precoTotalPedido;
    }
    public void setPrecoTotalPedido(double precoTotalPedido) {
        if(precoTotalPedido < 0) {
            System.out.println("Preço inválido.");
        }
        else
            this.precoTotalPedido = precoTotalPedido;
    }
}