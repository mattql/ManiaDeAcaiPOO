package modelBO;

public class Teste {

	public static void main(String[] args) throws Exception {
		ClienteBO c = new ClienteBO();
		
		System.out.println(c.buscar().get(0).getNome());
	}

}
