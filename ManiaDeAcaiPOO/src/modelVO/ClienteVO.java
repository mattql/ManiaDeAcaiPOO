package modelVO;

public class ClienteVO {
	private String nomeCliente;
	private String telefoneCliente;
	
	//Nome do Cliente.
	public String getnomeCliente() {
		return nomeCliente;
	}
	public void setnomecliente(String nomeCliente) {
		if (nomeCliente.isEmpty()) {
			System.out.println("Nome inv�lido");
		}
		else
			this.nomeCliente = nomeCliente;
	}
	
	//Telefone do Cliente.
	public String gettelefoneCliente() {
		return telefoneCliente;
	}
	public void setnomeCliente(String nomeCliente) {
		if (nomeCliente.isEmpty()) {
			System.out.println("Telefone Inv�lido");
		}
		else 
			this.nomeCliente = nomeCliente;
	}
}
