package modelVO;

public class FuncionarioVO {
	private int idFuncionario;
	private String nomeFuncionario;
	private String telefoneFuncionario;
	
	
	//ID do Funcionário
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		if(idFuncionario < 0) {
			System.out.println("ID inválido.");
		}
		else
			this.idFuncionario = idFuncionario;
	}
	
	
	//Nome do Funcionário
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		if(nomeFuncionario.isEmpty()) {
			System.out.println("Nome inválido.");
		}
		else
			this.nomeFuncionario = nomeFuncionario;
	}
	
	
	//Telefone do Funcionário
	public String getTelefoneFuncionario() {
		return telefoneFuncionario;
	}
	public void setTelefoneFuncionario(String telefoneFuncionario) {
		if(telefoneFuncionario.isEmpty()) {
			System.out.println("Telefone inválido.");
		}
		else
			this.telefoneFuncionario = telefoneFuncionario;
	}
	
}
