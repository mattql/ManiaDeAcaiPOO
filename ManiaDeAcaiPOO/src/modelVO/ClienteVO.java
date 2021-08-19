package modelVO;


public class ClienteVO {
	private int idCliente;
	private String nomeCliente;
	private String enderecoCliente;
	private String telefoneCliente;
	
	
	//ID do Cliente
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		if(idCliente < 0) {
			System.out.println("ID inv�lido.");
		}
		else
			this.idCliente = idCliente;
	}
	
	
	//Nome do Cliente
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		if(nomeCliente == null) {
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
		if(enderecoCliente == null) {
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
		if(telefoneCliente == null) {
			System.out.println("Telefone inv�lido.");
		}
		else
			this.telefoneCliente = telefoneCliente;
	}
}
