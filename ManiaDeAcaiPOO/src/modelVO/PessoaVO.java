package modelVO;

public abstract class PessoaVO {
	private int idPessoa;
	private String nome;
	private String endereco;
	private String telefone;
	
	
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		if(idPessoa < 0) {
			System.out.println("ID inválido.");
		} else
			this.idPessoa = idPessoa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == null) {
			System.out.println("Nome inválido.");
		} else
			this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco == null) {
			System.out.println("Endereço inválido.");
		} else
			this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone == null) {
			System.out.println("Telefone inválido.");
		} else
			this.telefone = telefone;
	}
}
