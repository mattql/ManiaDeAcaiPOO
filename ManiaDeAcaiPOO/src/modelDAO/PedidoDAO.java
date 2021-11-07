package modelDAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modelVO.PedidoProdutoVO;
import modelVO.PedidoVO;

public class PedidoDAO extends BaseDAO<PedidoVO>{ 	
	@Override
	public void inserir(PedidoVO vo) {
		String sql = "insert into Pedido (cliente, quantidadeprodutos, formadepagamentopedido, statuspedido, datapedido, precototalpedido) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ptst;
    	try {
    		ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setInt(1, vo.getCliente().getIdPessoa());
			ptst.setInt(2, vo.getQuantidadeProdutos());
			ptst.setString(3, vo.getFormaDePagamentoPedido());
			ptst.setString(4, vo.getStatusPedido());
			ptst.setDate(5, new java.sql.Date(vo.getDataPedido().getTime().getTime()));
			ptst.setDouble(6, vo.getPrecoTotalPedido());
			ptst.execute();
			
			PedidoProdutoDAO pp = new PedidoProdutoDAO();
			pp.inserir(vo.getInfoProduto());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(PedidoVO vo) {
		String sql = "delete from Pedido where idpedido = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getIdPedido());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<PedidoVO> listar() {
		String sql = "select * from Pedido";
		ResultSet rs;
		Statement st;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		List<PedidoProdutoVO> pedidoProduto = new ArrayList<PedidoProdutoVO>();
		
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				PedidoVO pe = new PedidoVO();
				Calendar calendar = Calendar.getInstance();
				
				pe.setIdPedido(rs.getInt("idpedido"));
				pe.getCliente().setIdPessoa(rs.getInt("cliente"));
				pe.setQuantidadeProdutos(rs.getInt("quantidadeprodutos"));
				pe.setFormaDePagamentoPedido(rs.getString("formadepagamentopedido"));
				pe.setStatusPedido(rs.getString("statuspedido"));
				calendar.setTime(rs.getDate("datapedido"));;
				pe.setDataPedido(calendar);
				pe.setPrecoTotalPedido(rs.getDouble("precototalpedido"));
				pedidos.add(pe);
					
				PedidoProdutoDAO ppdao = new PedidoProdutoDAO();
				pedidoProduto = ppdao.listar(pe);
				pe.setInfoProduto(pedidoProduto.toArray(new PedidoProdutoVO[pedidoProduto.size()]));
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidos;
	}

	@Override
	public void editar(PedidoVO vo) {
		String sql = "update Pedido set statuspedido = ? where idpedido = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getStatusPedido());
			ptst.setInt(2, vo.getIdPedido());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarQuantidade(PedidoVO vo) {
		String sql = "update Pedido set quantidadeprodutos = ? where idpedido = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getQuantidadeProdutos());
			ptst.setInt(2, vo.getIdPedido());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editarForma(PedidoVO vo) {
		String sql = "update Pedido set formadepagamentopedido = ? where idpedido = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getFormaDePagamentoPedido());
			ptst.setInt(2, vo.getIdPedido());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet pesquisarPorID(PedidoVO vo) {
		String sql = "select * from Pedido where idpedido = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getIdPedido());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet pesquisarPorNome(PedidoVO vo) {
		//Pesquisar por nome do cliente
		String sql = "select * from Pedido where cliente = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getCliente().getIdPessoa());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet pesquisarPorStatus(PedidoVO vo) {
		String sql = "select * from Pedido where statuspedido = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getStatusPedido());
				rs = ptst.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
	}
	
	public ResultSet pesquisarPorData(PedidoVO vo) {
		String sql = "select * from Pedido where datapedido = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setDate(1, new java.sql.Date(vo.getDataPedido().getTime().getTime()));
				rs = ptst.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
	}
}
