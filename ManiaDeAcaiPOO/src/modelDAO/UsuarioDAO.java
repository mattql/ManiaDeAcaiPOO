package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.FuncionarioVO;
import modelVO.UsuarioVO;

public class UsuarioDAO extends BaseDAO<UsuarioVO>{

	@Override
	public void inserir(UsuarioVO vo) {
		// TODO Auto-generated method stub
		String sql = "insert into Usuario (loginUsuario, senhaUsuario, nomeUsuario, enderecoUsuario, telefoneUsuario) values(?, ?, ?, ?, ?)";
		PreparedStatement ptst; 
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getLogin());
			ptst.setString(2, vo.getSenha());
			ptst.setString(3, vo.getNome());
			ptst.setString(4, vo.getEndereco());
			ptst.setString(5, vo.getTelefone());
		  
			int affectedRows = ptst.executeUpdate();
				
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou, nenhuma linha foi alterada. ");
			}
			ResultSet generatedKey = ptst.getGeneratedKeys();
			if (generatedKey.next()) {
				vo.setLogin(generatedKey.getString(1));
			}
			else {
				throw new SQLException("A inserção falhou, nenhuma login foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(UsuarioVO vo) {
		// TODO Auto-generated method stub
		String sql = "delete from Usuario where loginUsuario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getLogin());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editar(UsuarioVO vo) {
		// TODO Auto-generated method stub
		String sql = "update from Usuario set senhaUsuario = ? where loginUsuario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getSenha());
			ptst.setString(2, vo.getLogin());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarLogin(UsuarioVO vo) {
		// TODO Auto-generated method stub
		String sql = "update from Usuario set loginUsuario = ? where senhaUsuario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getLogin());
			ptst.setString(2, vo.getSenha());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarNome(UsuarioVO vo) {
		// TODO Auto-generated method stub
		String sql = "update from Usuario set nomeUsuario = ? where loginUsuario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getLogin());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarEndereco(UsuarioVO vo) {
		// TODO Auto-generated method stub
		String sql = "update from Usuario set enderecoUsuario = ? where loginUsuario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getEndereco());
			ptst.setString(2, vo.getLogin());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarTelefone(UsuarioVO vo) {
		// TODO Auto-generated method stub
		String sql = "update from Usuario set telefoneUsuario = ? where loginUsuario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getTelefone());
			ptst.setString(2, vo.getLogin());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet pesquisarPorID(UsuarioVO vo) {
		// TODO Auto-generated method stub
		String sql = "select * from Usuario where loginUsuario = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getLogin());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet pesquisarPorNome(UsuarioVO vo) {
		// TODO Auto-generated method stub
		String sql = "select * from Usuario where nomeUsuario = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet pesquisarPorEndereco(UsuarioVO vo) {
		// TODO Auto-generated method stub
		String sql = "select * from Usuario where enderecoUsuario = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getEndereco());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet pesquisarPorTelefone(UsuarioVO vo) {
		// TODO Auto-generated method stub
		String sql = "select * from Usuario where telefoneUsuario = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getTelefone());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public List <UsuarioVO> listar() {
		String sql = "select * from Usuario";
		ResultSet rs;
		Statement st;
		List<UsuarioVO> usuario = new ArrayList<UsuarioVO>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				UsuarioVO c = new UsuarioVO();
				c.setLogin(rs.getString("loginUsuario"));
				c.setSenha(rs.getString("senhaUsuario"));
				c.setNome(rs.getString("nomeUsuario"));
				c.setEndereco(rs.getString("enderecoUsuario"));
				c.setTelefone(rs.getString("salarioFuncionario"));
				usuario.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	
}
