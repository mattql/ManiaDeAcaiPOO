package modelVO;

public class FuncionarioVO {
	private int idFuncionario;
	private String nomeFuncionario;
	private String telefoneFuncionario;
	
	
	//ID do Funcion�rio
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		if(idFuncionario < 0) {
			System.out.println("ID inv�lido.");
		}
		else
			this.idFuncionario = idFuncionario;
	}
	
	
	//Nome do Funcion�rio
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		if(nomeFuncionario.isEmpty()) {
			System.out.println("Nome inv�lido.");
		}
		else
			this.nomeFuncionario = nomeFuncionario;
	}
	
	
	//Telefone do Funcion�rio
	public String getTelefoneFuncionario() {
		return telefoneFuncionario;
	}
	public void setTelefoneFuncionario(String telefoneFuncionario) {
		if(telefoneFuncionario.isEmpty()) {
			System.out.println("Telefone inv�lido.");
		}
		else
			this.telefoneFuncionario = telefoneFuncionario;
	}
	
}
