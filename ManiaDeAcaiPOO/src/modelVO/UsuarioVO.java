package modelVO;

public class UsuarioVO {
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
			if(loginUsuario.equals(" ")) {
				
			}
			else
			this.loginUsuario = loginUsuario;
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
				if(senhaUsuario.Equals(" ")) {
					System.out.println("Login invalido");
				}
				else
					this.senhaUsuario = senhaUsuario;
			}
	}
}