package modelDAO;

import java.sql.ResultSet;

public interface BaseInterDAO<VO> {

    public void inserir(VO vo);
    public void remover(VO vo);
    public void editar(VO vo);
    public ResultSet listar(VO vo);
    public ResultSet pesquisarPorID(VO vo);
    public ResultSet pesquisarPorNome(VO vo);
}