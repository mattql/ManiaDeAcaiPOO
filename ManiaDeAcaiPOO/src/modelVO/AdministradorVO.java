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
				System.out.println("Digite algo valido");
			}
			else {
				if(loginADM.equals(" ")) {
					System.out.println("Login invalido");
				}
				else
					this.loginADM = loginADM;
			}
		}
		
		//Senha do ADM
		public String getsenhaADM() {
			return senhaADM;
		}
		public String setsenhaADM(String senhaADM) {
			if (senhaADM == null) {
				System.out.println("Digite algo valido");
			}
			else {
				if(senhaADM.equals(" ")) {
					System.out.println("Login invalido");
				}
				else
					this.senhaADM = senhaADM;	
			}
		}
}
>>>>>>> ModelVO
