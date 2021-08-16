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
			System.out.println("Nome inválido");
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
			System.out.println("Telefone Inválido");
		}
		else 
			this.nomeCliente = nomeCliente;
	}
}
