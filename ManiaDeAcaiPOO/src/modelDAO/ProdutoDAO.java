package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.ProdutoVO;

public class ProdutoDAO extends BaseDAO<ProdutoVO>{
	@Override
	public void inserir(ProdutoVO vo) {
		String sql = "insert into Produto (nomeProduto, precoProduto, categoriaProduto) values (?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getnomeProduto());
			ptst.setDouble(2, vo.getprecoProduto());
			ptst.setString(3, vo.getcategoriaProduto());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou, nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setIdProduto(generatedKeys.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(ProdutoVO vo) {
		String sql = "delete from Produto where idProduto = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getIdProduto());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editar(ProdutoVO vo) {
		String sql = "update Produto set nomeProduto = ? where idProduto = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getnomeProduto());
			ptst.setInt(2, vo.getIdProduto());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editarPreco(ProdutoVO vo) {
		String sql = "update Produto set precoProduto = ? where idProduto = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, vo.getprecoProduto());
			ptst.setInt(2, vo.getIdProduto());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editarCategoria(ProdutoVO vo) {
		String sql = "update Produto set categoriaProduto = ? where idProduto = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getcategoriaProduto());
			ptst.setInt(2, vo.getIdProduto());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProdutoVO> listar() {
		String sql = "select * from Produto";
		ResultSet rs;
		Statement st;
		List<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ProdutoVO p = new ProdutoVO();
				p.setIdProduto(rs.getInt("idProduto"));
				p.setnomeProduto(rs.getString("nomeProduto"));
				p.setprecoProduto(rs.getDouble("precoProduto"));
				p.setcategoriaProduto(rs.getString("categoriaProduto"));
				produtos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	@Override
	public ResultSet pesquisarPorID(ProdutoVO vo) {
		String sql = "select * from Produto where idProduto = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getIdProduto());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	@Override
	public ResultSet pesquisarPorNome(ProdutoVO vo) {
		String sql = "select * from Produto where nomeProduto = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getnomeProduto());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet pesquisarPorCategoria(ProdutoVO vo) {
		String sql = "select * from Produto where categoriaproduto = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getcategoriaProduto());
				rs = ptst.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
	}
	
	public ResultSet pesquisarPorPreco(ProdutoVO vo) {
		String sql = "select * from Produto where precoproduto = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setDouble(1, vo.getprecoProduto());
				rs = ptst.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
	}
}