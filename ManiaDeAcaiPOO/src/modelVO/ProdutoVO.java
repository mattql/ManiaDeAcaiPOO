package modelVO;

import java.util.ArrayList;

public class ProdutoVO {
	
		//Definindo os nomes dos Produtos em uma Array;
		public static void nome(String[] args) {
			String Produto1 = "Açaí 300ml";
			String Produto2 = "Açaí 500ml ";
			String Produto3 = "Açaí 700ml";
			String Produto4 = "Tapioca Tradicional";
			String Produto5 = "Tapioca Mista";
			String Produto6 = "Tapioca Nordestina";
			String Produto7 = "Croissant";
			String Produto8 = "Água 350ml";
			String Produto9 = "Água com gás 350ml";
			 
			ArrayList<String> nomeProduto = new ArrayList<>();
			nomeProduto.add(Produto1);
			nomeProduto.add(Produto2);
			nomeProduto.add(Produto3);
			nomeProduto.add(Produto4);
			nomeProduto.add(Produto5);
			nomeProduto.add(Produto6);
			nomeProduto.add(Produto7);
			nomeProduto.add(Produto8);
			nomeProduto.add(Produto9);
		
			
			System.out.println(nomeProduto);
		}
			

		
		//Definindo os preços dos Produtos;
		public static void preco(double[] args) {
			double Produto1 = 16.00;
			double Produto2 = 20.00;
			double Produto3 = 24.00;
			double Produto4 = 12.00;
			double Produto5 = 13.50;
			double Produto6 = 15.50;
			double Produto7 = 18.00;
			double Produto8 = 5.00;
			double Produto9 = 6.50;
			
			ArrayList<double> precoProduto = new ArrayList<> ();
			precoProduto.add(Produto1);
			precoProduto.add(Produto2);
			precoProduto.add(Produto3);
			precoProduto.add(Produto4);
			precoProduto.add(Produto5);
			precoProduto.add(Produto6);
			precoProduto.add(Produto7);
			precoProduto.add(Produto8);
			precoProduto.add(Produto9);
			
		}	
		
		//Definindo a Cadegoria de cada Produto.
		public static void cadegoria(String[] args) {
			String Produto1 = "Açaí";
			String Produto2 = "Açaí";
			String Produto3 = "Açaí";
			String Produto4 = "Lanche";
			String Produto5 = "Lanche";
			String Produto6 = "Lanche";
			String Produto7 = "Lanche";
			String Produto8 = "Bebida";
			String Produto9 = "Bebida";
			
			
			ArrayList<String> cadegoriaProduto = new ArrayList<> ();
			cadegoriaProduto.add(Produto1);
			cadegoriaProduto.add(Produto2);
			cadegoriaProduto.add(Produto3);
			cadegoriaProduto.add(Produto4);
			cadegoriaProduto.add(Produto5);
			cadegoriaProduto.add(Produto6);
			cadegoriaProduto.add(Produto7);
			cadegoriaProduto.add(Produto8);
			cadegoriaProduto.add(Produto9);
			
		}
}
