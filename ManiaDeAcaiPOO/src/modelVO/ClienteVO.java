package modelVO;
import java.util.*;


public class ClienteVO {
	private String nomeCliente;
	private String enderecoCliente;
	private String telefoneCliente;
	private Date dataPedido;
	
	//Nome do Cliente
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		if(nomeCliente.isEmpty()) {
			System.out.println("Nome inv�lido.");
		}
		else
			this.nomeCliente = nomeCliente;
	}
	
	//Endere�o do Cliente
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		if(enderecoCliente.isEmpty()) {
			System.out.println("Endere�o inv�lido.");
		}
		else
			this.enderecoCliente = enderecoCliente;
	}
	
	//Telefone do Cliente
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		if(telefoneCliente.isEmpty()) {
			System.out.println("Telefone inv�lido.");
		}
		else
			this.telefoneCliente = telefoneCliente;
	}
	
	//Data do Pedido
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		dataPedido = new Date();
		this.dataPedido = dataPedido;
	}
}
