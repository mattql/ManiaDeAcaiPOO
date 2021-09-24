package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.UsuarioVO;

public class UsuarioDAO<VO extends UsuarioVO> extends BaseDAO<VO>{

	@Override
	public void inserir(VO vo) {
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
	public void remover(VO vo) {
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
	public void editar(VO vo) {
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
	
	public void editarLogin(VO vo) {
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
	
	public void editarNome(VO vo) {
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
	
	public void editarEndereco(VO vo) {
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
	
	public void editarTelefone(VO vo) {
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
	public ResultSet pesquisarPorID(VO vo) {
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
	public ResultSet pesquisarPorNome(VO vo) {
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
	
	public ResultSet pesquisarPorEndereco(VO vo) {
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
	
	public ResultSet pesquisarPorTelefone(VO vo) {
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

	@Override
	public ResultSet listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
