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
				System.out.println("ID inválido.");
			}
			else
				this.idProduto = idProduto;
		}
		
		
		//Nome do Produto
		public String getNomeProduto() {
			return nomeProduto;
		}
		public void setNomeProduto(String nomeProduto) {
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
		
		
		//Preço do Produto
		public double getPrecoProduto() {
			return precoProduto;
		}
		public void setPrecoProduto(double precoProduto) {
			if (precoProduto <= 0) {
					System.out.println("Digite um valor maior que 0");
			}
			else
				this.precoProduto = precoProduto;
		}
		
		
		//Categoria do Produto
		public String getCategoriaProduto() {
			return categoriaProduto;
		}
		public void setCategoriaProduto(String categoriaProduto) {
			if (categoriaProduto == null) {
				System.out.println("Digite algo valido!");
			}
			else
				this.categoriaProduto = categoriaProduto;
		}
}
