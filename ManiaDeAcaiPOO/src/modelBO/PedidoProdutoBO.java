package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelDAO.PedidoProdutoDAO;
import modelVO.PedidoProdutoVO;


public class PedidoProdutoBO implements BaseInterBO<PedidoProdutoVO>{
    PedidoProdutoDAO dao = new PedidoProdutoDAO();

	@Override
	public void cadastrar(PedidoProdutoVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorID(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Cadastrar. Já existe um PedidoProduto com esse ID.");
            } else {
                dao.inserir(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}

	@Override
	public void remover(PedidoProdutoVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorID(vo);
            if(rs.next() == false) {
                throw new Exception("Erro ao Remover. ID não existente.");
            } else {
                dao.remover(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
		
	}

	@Override
	public List<PedidoProdutoVO> buscar() throws Exception {
		PedidoProdutoVO pp = new PedidoProdutoVO();
		List<PedidoProdutoVO> vo = new ArrayList<PedidoProdutoVO>();
        ResultSet rs = dao.pesquisarPorID(pp);
        try {
        if(rs.next()) {
            throw new Exception("Erro ao Buscar. ID não existente.");
        } else {
            vo = dao.listar();
            return vo;
        	}
        }
        catch(SQLException e) {
        	throw new Exception(e.getMessage());
    	}
	}

	@Override
	public List<PedidoProdutoVO> buscarPorID(PedidoProdutoVO vo) throws Exception {
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public List<PedidoProdutoVO> buscarPorNome(PedidoProdutoVO vo) throws Exception {
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public void alterar(PedidoProdutoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
