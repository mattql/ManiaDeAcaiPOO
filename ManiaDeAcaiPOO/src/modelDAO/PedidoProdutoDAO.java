package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelVO.PedidoProdutoVO;
import modelVO.PedidoVO;
import modelVO.UsuarioVO;

public class PedidoProdutoDAO extends BaseDAO<PedidoProdutoVO>{
	PedidoProdutoDAO dao = new PedidoProdutoDAO();
	PedidoProdutoVO pp = new PedidoProdutoVO();
    
	public void inserir(PedidoProdutoVO[] pp) {
		String sql = "insert into pedido_produto (idpedidoproduto, cod_pedido, cod_produto) values (?, ?, ?)";
		PreparedStatement ptst;
		try {
			for(int i = 0; i < pp.length; i++) {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, pp[i].getCodPedidoProduto());
			ptst.setInt(2, pp[i].getCod_pedido().getIdPedido());
			ptst.setInt(3, pp[i].getCod_produto().getIdProduto());
			ptst.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(PedidoProdutoVO[] pp) {
		String sql = "delete from PedidoProduto where idpedidoproduto = ?";
		PreparedStatement ptst;
		try {
			for(int i = 0; i < pp.length; i++) {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, pp[i].getCodPedidoProduto());
			ptst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void inserir(PedidoProdutoVO vo) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void remover(PedidoProdutoVO vo) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void editar(PedidoProdutoVO vo) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<PedidoProdutoVO> listar() {
		List<PedidoProdutoVO> vo = new ArrayList<PedidoProdutoVO>();
		ResultSet rs = dao.pesquisarPorID(pp);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. ID não existente.");
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
	public ResultSet pesquisarPorID(PedidoProdutoVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ResultSet pesquisarPorNome(PedidoProdutoVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
