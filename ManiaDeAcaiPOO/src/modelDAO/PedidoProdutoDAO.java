package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelVO.PedidoProdutoVO;
import modelVO.PedidoVO;

public class PedidoProdutoDAO extends BaseDAO{
	
	public void inserir(PedidoProdutoVO[] pp) {
		conn = getConnection();
		String sql = "insert into pedido_produto (cod_pedidoproduto, cod_pedido, cod_produto) values (?, ?, ?)";
		PreparedStatement ptst;
		try {
			for(int i = 0; i < pp.length; i++) {
			ptst = conn.prepareStatement(sql);
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
		conn = getConnection();
		String sql = "delete from PedidoProduto where cod_pedidoproduto = ?";
		PreparedStatement ptst;
		try {
			for(int i = 0; i < pp.length; i++) {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, pp[i].getCodPedidoProduto());
			ptst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<PedidoProdutoVO> listar(PedidoVO pedido) {
		conn = getConnection();
		String sql = "select * from PedidoProduto where codPedido = ?";
		PreparedStatement ptst;
		ResultSet rs;
		List<PedidoProdutoVO> pedidoproduto = new ArrayList<PedidoProdutoVO>();
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, pedido.getIdPedido());
			rs = ptst.executeQuery(sql);
			while(rs.next()) {
				PedidoProdutoVO pp = new PedidoProdutoVO();
				pp.setCodPedidoProduto(rs.getInt("cod_pedidoproduto"));
				pp.getCod_pedido().setIdPedido(rs.getInt("cod_pedido"));
				pp.getCod_produto().setIdProduto(rs.getInt("cod_produto"));
				pedidoproduto.add(pp);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidoproduto;		
	}
	
}

