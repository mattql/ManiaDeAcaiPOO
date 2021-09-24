package modelDAO;

import static modelDAO.BaseDAO.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.ClienteVO;
import modelVO.FuncionarioVO;
import modelVO.ProdutoVO;

public class ProdutoDAO<VO extends ProdutoVO> extends BaseDAO<VO>{
	@Override
	public void inserir(VO vo) {
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
			
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(VO vo) {
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
	public void editar(VO vo) {
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

	public void editarPreco(VO vo) {
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

	public void editarCategoria(VO vo) {
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
	public ResultSet listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet pesquisarPorID(VO vo) {
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
	public ResultSet pesquisarPorNome(VO vo) {
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

	public ResultSet pesquisarPorCategoria(VO vo) {
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
	
	public ResultSet pesquisarPorPreco(VO vo) {
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
	/*public List<ProdutoVO> listar() {
		conn = getConnection();
		String sql = "select * from Produto";
		ResultSet rs;
		Statement st;
		List<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		try {
			st = conn.createStatement();
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
	}*/
}