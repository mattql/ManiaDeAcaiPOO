package modelBO;

import java.util.List;

public interface BaseInterBO<VO> {
	public void cadastrar(VO vo) throws Exception;
	public void alterar(VO vo) throws Exception;
	public void remover(VO vo) throws Exception;
	public List<VO> buscar() throws Exception;
	public List<VO> buscarPorID(VO vo) throws Exception;
	public List<VO> buscarPorNome(VO vo) throws Exception;
}
