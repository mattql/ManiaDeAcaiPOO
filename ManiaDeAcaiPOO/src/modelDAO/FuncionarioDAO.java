package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.FuncionarioVO;

public class FuncionarioDAO<VO extends FuncionarioVO> extends BaseDAO<VO>{

	@Override
	public void inserir(VO vo) {
		String sql = "insert into Funcionario (nomeFuncionario, enderecofuncioanrio, telefoneFuncionario, salariofuncionario) values(?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setString(3, vo.getTelefone());
			ptst.setDouble(4, vo.getSalario());
		  
			int affectedRows = ptst.executeUpdate();
				
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou, nenhuma linha foi alterada. ");
			}
			ResultSet generatedKey = ptst.getGeneratedKeys();
			if (generatedKey.next()) {
				vo.setIdPessoa(generatedKey.getInt(1));
			}
			else {
				throw new SQLException("A inserção falhou, nenhuma id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(VO vo) {
		// TODO Auto-generated method stub
		String sql = "delete from Funcionario where idFuncionario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getIdPessoa ());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editar(VO vo) {
		// TODO Auto-generated method stub
		String sql = "update from Funcionario set nomeFuncionario = ? where idFuncionario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setInt(2, vo.getIdPessoa());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarEndereco(VO vo) {
		// TODO Auto-generated method stub
		String sql = "update from Funcionario set enderecoFuncionario = ? where idFuncionario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getEndereco());
			ptst.setInt(2, vo.getIdPessoa());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarTelefone(VO vo) {
		// TODO Auto-generated method stub
		String sql = "update from Funcionario set telefoneFuncionario = ? where idFuncionario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getTelefone());
			ptst.setInt(2, vo.getIdPessoa());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarSalario(VO vo) {
		// TODO Auto-generated method stub
		String sql = "update from Funcionario set salarioFuncionario = ? where idFuncionario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, vo.getSalario());
			ptst.setInt(2, vo.getIdPessoa());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet pesquisarPorID(VO vo) {
		// TODO Auto-generated method stub
		String sql = "select * from Funcionario where idfuncionario = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getIdPessoa());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet pesquisarPorNome(VO vo) {
		// TODO Auto-generated method stub
		String sql = "select * from Funcionario where nomefuncionario = ?";
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
		String sql = "select * from Funcionario where enderecoFuncionario = ?";
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
		String sql = "select * from Funcionario where telefoneFuncionario = ?";
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
	
	public ResultSet pesquisarPorSalario(VO vo) {
		// TODO Auto-generated method stub
		String sql = "select * from Funcionario where salarioFuncionario = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, vo.getSalario());
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
