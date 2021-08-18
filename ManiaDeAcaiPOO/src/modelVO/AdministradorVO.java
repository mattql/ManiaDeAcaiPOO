package modelVO;

public class AdministradorVO {
		private String loginADM;
		private String senhaADM;
		
		//Login do ADM
		public String getloginADM() {
			return loginADM;
		}
		public void setloginADM(String loginADM) {
			if (loginADM == null){
				System.out.println("Digite algo valido");
			}
			else {
				if(loginADM.equals(" ")) {
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
				System.out.println("Digite algo valido");
			}
			else {
				if(senhaADM.equals(" ")) {
					this.senhaADM = senhaADM;
				}					
			}
		}
}