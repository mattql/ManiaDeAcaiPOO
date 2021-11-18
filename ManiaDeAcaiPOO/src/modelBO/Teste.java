package modelBO;

import modelVO.AdministradorVO;

public class Teste {

	public static void main(String[] args) throws Exception {
		ClienteBO c = new ClienteBO();
		
		AdministradorBO abo = new AdministradorBO();
		AdministradorVO avo = new AdministradorVO();
		
		/*avo.setloginADM("admin");
		avo.setsenhaADM("admin");
		abo.cadastrar(avo);*/
		
		System.out.println(abo.buscar().get(1).getloginADM());
		System.out.println(abo.buscar().get(1).getsenhaADM());
	}

}
