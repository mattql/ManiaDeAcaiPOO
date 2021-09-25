package modelDAO;

import java.sql.ResultSet;
import java.util.List;

public interface BaseInterDAO<VO> {

    public void inserir(VO vo);
    public void remover(VO vo);
    public void editar(VO vo);
    public List <VO> listar();
    public ResultSet pesquisarPorID(VO vo);
    public ResultSet pesquisarPorNome(VO vo);
}