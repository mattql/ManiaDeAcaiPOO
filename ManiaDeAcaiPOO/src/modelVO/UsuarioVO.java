package modelVO;

public class UsuarioVO extends PessoaVO{
	private String loginUsuario;
	private String senhaUsuario;
	
	
	//Login
	public String getLogin() {
		return loginUsuario;
	}
	public void setLogin(String loginUsuario) {
		if (loginUsuario == null) {
			
		}
		else {
			//if(loginUsuario.equals(" ")) {
				this.loginUsuario = loginUsuario;
			//}	
		}
	}
	
	//Senha
	public String getSenha() {
		return senhaUsuario;
	}
	public void setSenha(String senhaUsuario) {
		if(senhaUsuario == null) {
			System.out.println("Digite algo valido");
		}		
			else {
				//if(senhaUsuario.equals(" ")) {
					this.senhaUsuario = senhaUsuario;
				//}	
			}
	}
}