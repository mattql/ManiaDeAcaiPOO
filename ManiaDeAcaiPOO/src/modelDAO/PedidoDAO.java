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

public class PedidoDAO extends BaseDAO{
	public void inserir(PedidoVO pe) {
        conn = getConnection();
        String sql = "insert into Pedido (idpedido, cod_cliente, quantidadeprodutos, formadepagamento, statuspedido, datapedido, precototalpedido) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ptst;
    	try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, pe.getIdPedido());
			ptst.setInt(2, pe.getCliente().getIdCliente());
			ptst.setInt(3, pe.getQuantidadeProdutos());
			ptst.setString(4, pe.getFormaDePagamentoPedido());
			ptst.setString(5, pe.getStatusPedido());
			ptst.setDate(6, new java.sql.Date(pe.getDataPedido().getTime().getTime()));
			ptst.setDouble(7, pe.getPrecoTotalPedido());
			ptst.execute();
			
			PedidoProdutoDAO pp = new PedidoProdutoDAO();
			pp.inserir(pe.getInfoProduto());
			
		} catch (SQLException e) {
			e.printStackTrace();
	}
}
   	
	public void remover(PedidoVO pe) {
		conn = getConnection();
		String sql = "delete from Pedido where idpedido = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, pe.getIdPedido());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<PedidoVO> listar() {
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
	
	
	public void editarStatusPedido(PedidoVO pe) {
		conn = getConnection();
		String sql = "update Pedido set statuspedido = ? where idpedido = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, pe.getStatusPedido());
			ptst.setInt(2, pe.getIdPedido());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editarQuantidadeDeProdutos(PedidoVO pe) {
		conn = getConnection();
		String sql = "update Pedido set quantidadedeprodutos = ? where idpedido = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, pe.getQuantidadeProdutos());
			ptst.setInt(2, pe.getIdPedido());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarForma(PedidoVO pe) {
		conn = getConnection();
		String sql = "update Pedido set formadepagamento = ? where idpedido = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, pe.getFormaDePagamentoPedido());
			ptst.setInt(2, pe.getIdPedido());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
