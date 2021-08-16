package modelVO;
import java.util.*;


public class ClienteVO {
	private String nomeCliente;
<<<<<<< HEAD
	private String enderecoCliente;
	private String telefoneCliente;
	private Date dataPedido;
	
	
	//Nome do Cliente
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		if(nomeCliente.isEmpty()) {
			System.out.println("Nome inválido.");
=======
	private String telefoneCliente;
	
	//Nome do Cliente.
	public String getnomeCliente() {
		return nomeCliente;
	}
	public void setnomecliente(String nomeCliente) {
		if (nomeCliente.isEmpty()) {
			System.out.println("Nome inválido");
>>>>>>> a3b51840906d31390e2104bbbbf1463f29fa779f
		}
		else
			this.nomeCliente = nomeCliente;
	}
	
<<<<<<< HEAD
	//Endereço do Cliente
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		if(enderecoCliente.isEmpty()) {
			System.out.println("Endereço inválido.");
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
			System.out.println("Telefone inválido.");
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

	
=======
	//Telefone do Cliente.
	public String gettelefoneCliente() {
		return telefoneCliente;
	}
	public void setnomeCliente(String nomeCliente) {
		if (nomeCliente.isEmpty()) {
			System.out.println("Telefone Inválido");
		}
		else 
			this.nomeCliente = nomeCliente;
	}
>>>>>>> a3b51840906d31390e2104bbbbf1463f29fa779f
}
