package modelBO;

import modelVO.AdministradorVO;
import modelVO.ProdutoVO;

public class Teste {

	public static void main(String[] args) throws Exception {
		ClienteBO c = new ClienteBO();
		
		AdministradorBO abo = new AdministradorBO();
		AdministradorVO avo = new AdministradorVO();
		
		ProdutoBO pbo = new ProdutoBO();
		ProdutoVO pvo = new ProdutoVO();
		
		/*pvo.setnomeProduto("Água 300ml");
		pvo.setprecoProduto(8);
		pvo.setcategoriaProduto("Bebida");
		pbo.cadastrar(pvo);*/
		
		/*avo.setloginADM("admin");
		avo.setsenhaADM("admin");
		abo.cadastrar(avo);*/
		
		//System.out.println(pbo.buscar().get(1).getnomeProduto());
		//System.out.println(pbo.buscar().get(1).getprecoProduto());
	}

}
