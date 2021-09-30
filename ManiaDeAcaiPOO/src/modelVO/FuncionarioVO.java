package modelVO;

public class FuncionarioVO extends PessoaVO{
	private double salario;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if(salario < 1100) {
			System.out.println("Salário inválido. Não pode ser menor que o salário mínimo.");
		} else
		this.salario = salario;
	}
}
