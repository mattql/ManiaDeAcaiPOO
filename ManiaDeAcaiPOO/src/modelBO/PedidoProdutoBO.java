package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	public void buscar(List<PedidoProdutoVO> vo) throws Exception {
		PedidoProdutoVO pp = new PedidoProdutoVO();
        ResultSet rs = dao.pesquisarPorID(pp);
        try {
        if(rs.next()) {
            throw new Exception("Erro ao Buscar. ID não existente.");
        } else {
           vo = dao.listar();
           for(PedidoProdutoVO vo2: vo) {
        	   System.out.println("{ " + vo2.getCod_pedido() + ", " + vo2.getCod_produto() + "}");
           		}
        	}
        }
        catch(SQLException e) {
        	throw new Exception(e.getMessage());
    	}
	}

	@Override
	public void buscarPorID(PedidoProdutoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarPorNome(PedidoProdutoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(PedidoProdutoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
