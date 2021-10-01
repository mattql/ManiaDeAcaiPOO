package modelBO;

public interface BaseInterBO<VO> {
	public void cadastrar(VO vo) throws Exception;
	public void alterar(VO vo);
	public void remover(VO vo);
	public void editar(VO vo);
	public void buscar();
	public void buscarPorID(VO vo);
	public void buscarPorNome(VO vo);
}
