package modelVO;

public class FuncionarioVO extends PessoaVO{
	private double salario;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if(salario < 1100) {
			System.out.println("Sal�rio inv�lido. N�o pode ser menor que o sal�rio m�nimo.");
		} else
		this.salario = salario;
	}
}
