package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.ProdutoVO;

public class ProdutoDAO extends BaseDAO{
	public void inserir(ProdutoVO p) {
		conn = getConnection();
		String sql = "insert into Produto (idProduto, nomeProduto, precoProduto, categoriaProduto) values (?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, p.getIdProduto());
			ptst.setString(2, p.getnomeProduto());
			ptst.setDouble(3, p.getprecoProduto());
			ptst.setString(4, p.getcategoriaProduto());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(ProdutoVO p) {
		conn = getConnection();
		String sql = "delete from Produto where idProduto = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, p.getIdProduto());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ProdutoVO> listar() {
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
	}
	
	public void editar(ProdutoVO p) {
		conn = getConnection();
		String sql = "update Produto set nomeProduto = ? where idProduto = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, p.getnomeProduto());
			ptst.setInt(2, p.getIdProduto());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
