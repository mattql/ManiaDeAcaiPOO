package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelDAO.ProdutoDAO;
import modelVO.ProdutoVO;

public class ProdutoBO implements BaseInterBO<ProdutoVO> {
	ProdutoDAO dao = new ProdutoDAO();
	@Override
	public void cadastrar(ProdutoVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next()) {
				throw new Exception("Erro ao cadastrar. Já existe um produto com esse ID.");
			} else {
				dao.inserir(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void alterar(ProdutoVO vo) throws Exception {
		//Alterar Nome
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Alterar Nome. ID não existente.");
			} else {
				dao.editar(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void alterarPreco(ProdutoVO vo) throws Exception {
		//Alterar Preco
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Alterar preço. ID não existente.");
			} else {
				dao.editarPreco(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void alterarCategoria(ProdutoVO vo) throws Exception {
		//Alterar Categoria
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Alterar categoria. ID não existente.");
			} else {
				dao.editarCategoria(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void remover(ProdutoVO vo) throws Exception {
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
	public void buscar(List<ProdutoVO> vo) throws Exception {
		ProdutoVO p = new ProdutoVO();
		ResultSet rs = dao.pesquisarPorID(p);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. ID não existente.");
			} else {
				vo = dao.listar();
				for(ProdutoVO vo2: vo) {
					System.out.println("{ " + vo2.getIdProduto() + ", " + vo2.getnomeProduto() + ", " + vo2.getprecoProduto()
						+ ", " + vo2.getcategoriaProduto() + " }");
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public void buscarPorID(ProdutoVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorID(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. ID não existente.");
			} else {
				List<ProdutoVO> produtos = dao.listar();
				for(ProdutoVO vo2: produtos) {
					System.out.println(vo2.getIdProduto());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void buscarPorNome(ProdutoVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorNome(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Nome não existente.");
			} else {
				List<ProdutoVO> produtos = dao.listar();
				for(ProdutoVO vo2: produtos) {
					System.out.println(vo2.getnomeProduto());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void buscarPorCategoria(ProdutoVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorCategoria(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Categoria não existente.");
			} else {
				List<ProdutoVO> produtos = dao.listar();
				for(ProdutoVO vo2: produtos) {
					System.out.println(vo2.getcategoriaProduto());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public void buscarPorPreco(ProdutoVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorPreco(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Preço não existente.");
			} else {
				List<ProdutoVO> produtos = dao.listar();
				for(ProdutoVO vo2: produtos) {
					System.out.println(vo2.getprecoProduto());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}	
	}
}
