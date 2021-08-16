package modelVO;

public class ProdutoVO {
		private String nomeProduto;
		private double precoProduto;
		private String categoriaProduto;
		
		//Nomde do Produto.
		public String getnomeProduto() {
			return nomeProduto;
		}
		public String setnomeProduto(String nomeProduto) {
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
		return nomeProduto;
		}
		
		
		
		//Preco do Produto.
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
		


		//Categoria do Produto.
		public String getcategoriaProduto() {
			return categoriaProduto;
		}
		public void setcategoriaProduto(String categoriaProduto) {
			if (categoriaProduto == null) {
				System.out.println("Digite algo valigo!");
			}
			else{
					if(categoriaProduto.equals(" ")) {
						System.out.println("Nome de Categoria invalido");
					}
					else
						this.categoriaProduto = categoriaProduto;
			}
		}
}
