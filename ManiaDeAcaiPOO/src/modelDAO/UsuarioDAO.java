package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.UsuarioVO;

public class UsuarioDAO extends BaseDAO{
	public void inserir(UsuarioVO u) {
		conn = getConnection();
		String sql = "insert into Usuario (loginUsuario, senhaUsuario) values (?, ?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, u.getLogin());
			ptst.setString(2, u.getSenha());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(UsuarioVO u) {
		conn = getConnection();
		String sql = "delete from Usuario where loginUsuario = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, u.getLogin());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<UsuarioVO> listar() {
		conn = getConnection();
		String sql = "select * from Usuario";
		ResultSet rs;
		Statement st;
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				UsuarioVO u = new UsuarioVO();
				u.setLogin(rs.getString("loginUsuario"));
				u.setSenha(rs.getString("senhaUsuario"));
				usuarios.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public void editar(UsuarioVO u) {
		conn = getConnection();
		String sql = "update Usuario set senhaUsuario = ? where loginUsuario = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, u.getLogin());
			ptst.setString(2, u.getSenha());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
