package modelVO;

public class ProdutoVO {
		private int idProduto;
		private String nomeProduto;
		private double precoProduto;
		private String categoriaProduto;
		
		
		//ID do Produto
		public int getIdProduto() {
			return idProduto;
		}
		public void setIdProduto(int idProduto) {
			if(idProduto < 0) {
				System.out.println("ID inv�lido.");
			}
			else
				this.idProduto = idProduto;
		}
		
		
		//Nome do Produto
		public String getnomeProduto() {
			return nomeProduto;
		}
		public void setnomeProduto(String nomeProduto) {
			if (nomeProduto == null) {
				System.out.println("Digite algo valido");
			}
			else {
				if(nomeProduto.equals(" ")) {
					System.out.println("Login invaldo");
				}
				else
					this.nomeProduto = nomeProduto;
			}
		}
		
		
		//Pre�o do Produto
		public double getprecoProduto() {
			return precoProduto;
		}
		public void setprecoProduto(double precoProduto) {
			if (precoProduto <= 0) {
					System.out.println("Digite um valor maior que 0");
			}
			else
				this.precoProduto = precoProduto;
		}
		
		
		//Categoria do Produto
		public String getcategoriaProduto() {
			return categoriaProduto;
		}
		public void setcategoriaProduto(String categoriaProduto) {
			if (categoriaProduto == null) {
				System.out.println("Digite algo valido!");
			}
			else
				this.categoriaProduto = categoriaProduto;
		}
}
