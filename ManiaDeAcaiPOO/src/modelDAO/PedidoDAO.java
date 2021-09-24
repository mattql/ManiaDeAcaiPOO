package modelDAO;


import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;
import modelVO.ClienteVO;
import modelVO.PedidoProdutoVO;
import modelVO.PedidoVO;
import modelVO.ProdutoVO;

public class PedidoDAO<VO extends PedidoVO> extends BaseDAO<VO>{ 	
	@Override
	public void inserir(VO vo) {
		String sql = "insert into Pedido (cod_cliente, quantidadeprodutos, formadepagamento, statuspedido, datapedido, precototalpedido) values (?, ?, ?, ?, ?, ?)";
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
	public void remover(VO vo) {
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
	public ResultSet listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public List<PedidoVO> listar() {
		conn = getConnection();
		String sql = "select * from Pedido";
		ResultSet rs;
		Statement st;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		List<PedidoProdutoVO> pedidoProduto = new ArrayList<PedidoProdutoVO>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				PedidoVO pe = new PedidoVO();
				Calendar calendar = Calendar.getInstance();
				
				pe.setIdPedido(rs.getInt("idpedido"));
				pe.getCliente().setIdCliente(rs.getInt("cod_cliente"));
				pe.setQuantidadeProdutos(rs.getInt("quantidadedeprodutos"));
				pe.setFormaDePagamentoPedido(rs.getString("formadepagamneto"));
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
	
	public ResultSet pesquisarPorData(PedidoVO pe) {
		conn = getConnection();
		String sql = "select * from Pedido where datapedido = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setDate(1, new java.sql.Date(pe.getDataPedido().getTime().getTime()));
				rs = ptst.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
	}

	public ResultSet pesquisarPorCliente(PedidoVO pe) {
		conn = getConnection();
		String sql = "select * from Pedido where cod_cliente = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setInt(1, pe.getCliente().getIdCliente());
				rs = ptst.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
	}*/

	@Override
	public void editar(VO vo) {
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
	
	public void editarQuantidadeDeProdutos(VO vo) {
		String sql = "update Pedido set quantidadedeprodutos = ? where idpedido = ?";
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

	public void editarForma(VO vo) {
		String sql = "update Pedido set formadepagamento = ? where idpedido = ?";
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
	public ResultSet pesquisarPorID(VO vo) {
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
	public ResultSet pesquisarPorNome(VO vo) {
		//Pesquisar por nome do cliente
		String sql = "select * from Pedido where cod_cliente = ?";
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

	public ResultSet pesquisarPorStatus(VO vo) {
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
	
	public ResultSet pesquisarPorData(VO vo) {
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
