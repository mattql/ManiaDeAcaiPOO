package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelVO.PedidoProdutoVO;
import modelVO.PedidoVO;

public class PedidoProdutoDAO extends BaseDAO<PedidoProdutoVO>{
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
	
	public List<PedidoProdutoVO> listar(PedidoVO pedido) {
		String sql = "select * from PedidoProduto where codPedido = ?";
		PreparedStatement ptst;
		ResultSet rs;
		List<PedidoProdutoVO> pedidoproduto = new ArrayList<PedidoProdutoVO>();
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, pedido.getIdPedido());
			rs = ptst.executeQuery(sql);
			while(rs.next()) {
				PedidoProdutoVO pp = new PedidoProdutoVO();
				pp.setCodPedidoProduto(rs.getInt("idpedidoproduto"));
				pp.getCod_pedido().setIdPedido(rs.getInt("cod_pedido"));
				pp.getCod_produto().setIdProduto(rs.getInt("cod_produto"));
				pedidoproduto.add(pp);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidoproduto;		
	}

	@Override
	public void inserir(PedidoProdutoVO vo) {
		//Método não utilizado
	}

	@Override
	public void remover(PedidoProdutoVO vo) {
		//Método não utilizado	
	}

	@Override
	public void editar(PedidoProdutoVO vo) {
		//Método não utilizado
	}

	@Override
	public List<PedidoProdutoVO> listar() {
		//Método não utilizado
		return null;
	}

	@Override
	public ResultSet pesquisarPorID(PedidoProdutoVO vo) {
		//Método não utilizado
		return null;
	}

	@Override
	public ResultSet pesquisarPorNome(PedidoProdutoVO vo) {
		//Método não utilizado
		return null;
	}
	
}
