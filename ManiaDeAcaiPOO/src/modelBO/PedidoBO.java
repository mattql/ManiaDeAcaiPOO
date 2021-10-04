package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelDAO.PedidoDAO;
import modelVO.PedidoVO;

public class PedidoBO implements BaseInterBO<PedidoVO>{
	PedidoDAO dao = new PedidoDAO();
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
	public void buscar(List<PedidoVO> vo) throws Exception {
		PedidoVO p = new PedidoVO();
		ResultSet rs = dao.pesquisarPorID(p);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. ID não existente.");
			} else {
				vo = dao.listar();
				for(PedidoVO vo2: vo) {
					System.out.println("{ " + vo2.getIdPedido() + ", " + vo2.getCliente() + ", " + vo2.getInfoProduto() + ", " + vo2.getQuantidadeProdutos()
						+ ", " + vo2.getFormaDePagamentoPedido() + ", " + vo2.getStatusPedido() + ", " + vo2.getDataPedido() + ", " + vo2.getPrecoTotalPedido() + " }");
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public void buscarPorID(PedidoVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorID(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. ID não existente.");
			} else {
				List<PedidoVO> pedidos = dao.listar();
				for(PedidoVO vo2: pedidos) {
					System.out.println(vo2.getIdPedido());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public void buscarPorNome(PedidoVO vo) throws Exception {
		//Buscar por Nome do Cliente
		ResultSet rs = dao.pesquisarPorNome(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Nome do cliente não existente.");
			} else {
				List<PedidoVO> pedidos = dao.listar();
				for(PedidoVO vo2: pedidos) {
					System.out.println(vo2.getCliente().getNome());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void buscarPorStatus(PedidoVO vo) throws Exception {
		//Buscar por Status do Pedido
		ResultSet rs = dao.pesquisarPorStatus(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Status de pedido não existente.");
			} else {
				List<PedidoVO> pedidos = dao.listar();
				for(PedidoVO vo2: pedidos) {
					System.out.println(vo2.getStatusPedido());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void buscarPorData(PedidoVO vo) throws Exception {
		//Buscar pela data exata do pedido
		ResultSet rs = dao.pesquisarPorData(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Data não existente.");
			} else {
				List<PedidoVO> pedidos = dao.listar();
				for(PedidoVO vo2: pedidos) {
					System.out.println(vo2.getDataPedido());
				}
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
