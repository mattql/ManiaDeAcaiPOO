package modelVO;

public class AdministradorVO {
		private int idadmin;
		private String login;
		private String senha;
		
		//Codigo Admin
		public int getIdadmin() {
			return idadmin;
		}
				
		public void setIdadmin(int idadmin) {
					
			if(idadmin >= 0)this.idadmin = idadmin;
		}
		
		//Login do ADM
		public String getLogin() {
			
			return login;
			
		}
		public void setLogin(String login) {
			if ( login == null) 
			{
				System.out.println("Login não pode ser nulo");
			}
			else 
			{
				if( login.equals("") ) 
				{
				 System.out.println("Login não pode ser vazio");	
				}
				else 
				{
					this.login = login;	
				}
			}
			
			
		}
		
		//Senha do ADM
		public String getSenha() {
			return senha;
			
		}
		public void setSenha(String senha) {
			if ( senha == null) 
			{
				System.out.println("Senha inválida");
			}
			else 
			{
				if( senha.equals("") ) 
				{
					System.out.println("Senha inválida");
				}
				else if ( senha.length() >= 4 && senha.length() <= 16 )
				{
					this.senha = senha;
				}
			}
			
		}
}