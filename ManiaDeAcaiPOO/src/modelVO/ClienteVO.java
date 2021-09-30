package modelVO;

public class ClienteVO extends PessoaVO{
	private String email;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email == null) {
			System.out.println("Email inválido.");
		} else
		this.email = email;
	}
}
