package modelBO;

public interface BaseInterBO<VO> {
	public void cadastrar(VO vo) throws Exception;
	public void alterar(VO vo) throws Exception;
	public void remover(VO vo) throws Exception;
	public void buscar() throws Exception;
	public void buscarPorID(VO vo) throws Exception;
	public void buscarPorNome(VO vo) throws Exception;
}
