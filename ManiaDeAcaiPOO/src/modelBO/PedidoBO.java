package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import modelDAO.PedidoDAO;
import modelDAO.PedidoProdutoDAO;
import modelVO.PedidoProdutoVO;
import modelVO.PedidoVO;

public class PedidoBO implements BaseInterBO<PedidoVO>{
	PedidoDAO dao = new PedidoDAO();
	PedidoVO p = new PedidoVO();
	List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
	Calendar calendar = Calendar.getInstance();
	List<PedidoProdutoVO> pedidoProduto = new ArrayList<PedidoProdutoVO>();
	
	@Override
	public void cadastrar(PedidoVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next()) {
				throw new Exception("Erro ao cadastrar. Já existe um pedido com esse ID.");
			} else {
				dao.inserir(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void alterar(PedidoVO vo) throws Exception {
		//Alterar Status
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Alterar Status. ID não existente.");
			} else {
				dao.editar(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void alterarForma(PedidoVO vo) throws Exception {
		//Alterar Forma de Pagamento
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Alterar Forma de Pagamento. ID não existente.");
			} else {
				dao.editarForma(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void alterarQuantidade(PedidoVO vo) throws Exception {
		//Alterar Quantidade de Produtos
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Alterar Quantidade de Produtos. ID não existente.");
			} else {
				dao.editarQuantidade(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void remover(PedidoVO vo) throws Exception {
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
	public List<PedidoVO> buscar() throws Exception {
		List<PedidoVO> vo = new ArrayList<PedidoVO>();
		ResultSet rs = dao.pesquisarPorID(p);
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
	public List<PedidoVO> buscarPorID(PedidoVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorID(vo);
		try {
			while(rs.next()) {
				p.setIdPedido(rs.getInt("IdPedido"));
				p.getCliente().setIdPessoa((rs.getInt("cliente")));
				p.setQuantidadeProdutos(rs.getInt("quantidadeprodutos"));
				p.setFormaDePagamentoPedido(rs.getString("formadepagamentopedido"));
				p.setStatusPedido(rs.getString("statuspedido"));
				calendar.setTime(rs.getDate("datapedido"));;
				p.setDataPedido(calendar);
				p.setPrecoTotalPedido(rs.getDouble("precototalpedido"));
				pedidos.add(p);
				
				PedidoProdutoDAO ppdao = new PedidoProdutoDAO();
				pedidoProduto = ppdao.listar(p);
				p.setInfoProduto(pedidoProduto.toArray(new PedidoProdutoVO[pedidoProduto.size()]));
			}
			if(rs.next()) {
				throw new Exception("Erro ao Listar. ID não existente.");
			} else {
				return pedidos;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<PedidoVO> buscarPorNome(PedidoVO vo) throws Exception {
		//Buscar por Nome do Cliente
		ResultSet rs = dao.pesquisarPorNome(vo);
		try {
			while(rs.next()) {
				p.setIdPedido(rs.getInt("IdPedido"));
				p.getCliente().setIdPessoa((rs.getInt("cliente")));
				p.setQuantidadeProdutos(rs.getInt("quantidadeprodutos"));
				p.setFormaDePagamentoPedido(rs.getString("formadepagamentopedido"));
				p.setStatusPedido(rs.getString("statuspedido"));
				calendar.setTime(rs.getDate("datapedido"));;
				p.setDataPedido(calendar);
				p.setPrecoTotalPedido(rs.getDouble("precototalpedido"));
				pedidos.add(p);
				
				PedidoProdutoDAO ppdao = new PedidoProdutoDAO();
				pedidoProduto = ppdao.listar(p);
				p.setInfoProduto(pedidoProduto.toArray(new PedidoProdutoVO[pedidoProduto.size()]));
			}
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Nome não existente.");
			} else {
				return pedidos;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<PedidoVO> buscarPorStatus(PedidoVO vo) throws Exception {
		//Buscar por Status do Pedido
		ResultSet rs = dao.pesquisarPorStatus(vo);
		try {
			while(rs.next()) {
				p.setIdPedido(rs.getInt("IdPedido"));
				p.getCliente().setIdPessoa((rs.getInt("cliente")));
				p.setQuantidadeProdutos(rs.getInt("quantidadeprodutos"));
				p.setFormaDePagamentoPedido(rs.getString("formadepagamentopedido"));
				p.setStatusPedido(rs.getString("statuspedido"));
				calendar.setTime(rs.getDate("datapedido"));;
				p.setDataPedido(calendar);
				p.setPrecoTotalPedido(rs.getDouble("precototalpedido"));
				pedidos.add(p);
				
				PedidoProdutoDAO ppdao = new PedidoProdutoDAO();
				pedidoProduto = ppdao.listar(p);
				p.setInfoProduto(pedidoProduto.toArray(new PedidoProdutoVO[pedidoProduto.size()]));
			}
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Status não existente.");
			} else {
				return pedidos;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<PedidoVO> buscarPorData(PedidoVO vo) throws Exception {
		//Buscar pela data exata do pedido
		ResultSet rs = dao.pesquisarPorData(vo);
		try {
			while(rs.next()) {
				p.setIdPedido(rs.getInt("IdPedido"));
				p.getCliente().setIdPessoa((rs.getInt("cliente")));
				p.setQuantidadeProdutos(rs.getInt("quantidadeprodutos"));
				p.setFormaDePagamentoPedido(rs.getString("formadepagamentopedido"));
				p.setStatusPedido(rs.getString("statuspedido"));
				calendar.setTime(rs.getDate("datapedido"));;
				p.setDataPedido(calendar);
				p.setPrecoTotalPedido(rs.getDouble("precototalpedido"));
				pedidos.add(p);
				
				PedidoProdutoDAO ppdao = new PedidoProdutoDAO();
				pedidoProduto = ppdao.listar(p);
				p.setInfoProduto(pedidoProduto.toArray(new PedidoProdutoVO[pedidoProduto.size()]));
			}
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Data não existente.");
			} else {
				return pedidos;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void relatorioDia(PedidoVO vo) throws Exception {
		
	}
	
	public void relatorioSemana(PedidoVO vo) throws Exception {
		
	}
	
	public void relatorioMes(PedidoVO vo) throws Exception {
		
	}
	
}
