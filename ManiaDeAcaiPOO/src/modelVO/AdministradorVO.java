package modelVO;

public class AdministradorVO {
		private String loginADM;
		private String senhaADM;
		
		//Login do ADM
		public String getloginADM() {
			return loginADM;
		}
		public String setloginADM(String loginADM) {
			if (loginADM == null){
			}
			else {
				if(loginADM.equals("seuze")) {
					
				}
				else
					this.loginADM = loginADM;
			}
			return loginADM;
		}
		
		//Senha do ADM
		public String getsenhaADM() {
			return loginADM;
		}
		public String setsenhaADM(String senhaADM) {
			return this.senhaADM = senhaADM;
		}
}