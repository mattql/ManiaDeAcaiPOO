package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelDAO.ProdutoDAO;
import modelVO.ProdutoVO;

public class ProdutoBO implements BaseInterBO<ProdutoVO> {
	ProdutoDAO dao = new ProdutoDAO();
	ProdutoVO p = new ProdutoVO();
	List<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
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
	public List<ProdutoVO> buscar() throws Exception {
		ProdutoVO p = new ProdutoVO();
		List<ProdutoVO> vo = new ArrayList<ProdutoVO>();
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
	public List<ProdutoVO> buscarPorID(ProdutoVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorID(vo);
		try {
			while(rs.next()) {
				p.setIdProduto(rs.getInt("IdProduto"));
				p.setnomeProduto(rs.getString("nomeproduto"));
				p.setprecoProduto(rs.getDouble("precoproduto"));
				p.setcategoriaProduto(rs.getString("categoriaproduto"));
				produtos.add(p);
			}
			if(produtos.isEmpty()) {
				throw new Exception("Erro ao Listar. ID não existente.");
			} else {
				return produtos;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<ProdutoVO> buscarPorNome(ProdutoVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorNome(vo);
		try {
			while(rs.next()) {
				p.setIdProduto(rs.getInt("IdProduto"));
				p.setnomeProduto(rs.getString("nomeproduto"));
				p.setprecoProduto(rs.getDouble("precoproduto"));
				p.setcategoriaProduto(rs.getString("categoriaproduto"));
				produtos.add(p);
			}
			if(produtos.isEmpty()) {
				throw new Exception("Erro ao Listar. Nome não existente.");
			} else {
				return produtos;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<ProdutoVO> buscarPorCategoria(ProdutoVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorCategoria(vo);
		try {
			while(rs.next()) {
				p.setIdProduto(rs.getInt("IdProduto"));
				p.setnomeProduto(rs.getString("nomeproduto"));
				p.setprecoProduto(rs.getDouble("precoproduto"));
				p.setcategoriaProduto(rs.getString("categoriaproduto"));
				produtos.add(p);
			}
			if(produtos.isEmpty()) {
				throw new Exception("Erro ao Listar. Categoria não existente.");
			} else {
				return produtos;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<ProdutoVO> buscarPorPreco(ProdutoVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorPreco(vo);
		try {
			while(rs.next()) {
				p.setIdProduto(rs.getInt("IdProduto"));
				p.setnomeProduto(rs.getString("nomeproduto"));
				p.setprecoProduto(rs.getDouble("precoproduto"));
				p.setcategoriaProduto(rs.getString("categoriaproduto"));
				produtos.add(p);
			}
			if(produtos.isEmpty()) {
				throw new Exception("Erro ao Listar. Preço não existente.");
			} else {
				return produtos;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}	
	}
}
