package modelVO;

public class AdministradorVO {
		private int idadmin;
		private String loginADM;
		private String senhaADM;
		
		//Codigo Admin
		public int getIdadmin() {
			return idadmin;
		}
				
		public void setIdadmin(int idadmin) {
					
			if(idadmin >= 0)this.idadmin = idadmin;
		}
		
		//Login do ADM
		public String getloginADM() {
			return loginADM;
		}
		
		public void setloginADM(String loginADM) {
			if (loginADM == null){
				System.out.println("Login Inv�lido");
			}
			else {
				if(loginADM.equals("")) {
					 System.out.println("Login n�o pode ser vazio");
				}
				else {
					this.loginADM = loginADM;
				}	
			}
		}
		
		//Senha do ADM
		public String getsenhaADM() {
			return senhaADM;
		}
		
		public void setsenhaADM(String senhaADM) {
			if (senhaADM == null) {
				System.out.println("Senha inv�lida");
			}
			else {
				if(senhaADM.equals("")) {
					System.out.println("Senha inv�lida");
				}
				else if (senhaADM.length() >= 4 && senhaADM.length() <= 16) {
					this.senhaADM = senhaADM;
				}				
			}
		}
}