package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.AdministradorVO;

public class AdministradorDAO<VO extends AdministradorVO> extends BaseDAO<VO>{

	@Override
	public void inserir(VO vo) {
		
		String sql = "insert into Administrador (loginADM, senhaADM) values(?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getloginADM());
			ptst.setString(2, vo.getsenhaADM());
		  
			int affectedRows = ptst.executeUpdate();
				
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou, nenhuma linha foi alterada. ");
			}
			ResultSet generatedKey = ptst.getGeneratedKeys();
			if (generatedKey.next()) {
				vo.setloginADM(generatedKey.getString(1));
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
		String sql = "delete from Administrador where loginADM = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getloginADM());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editar(VO vo) {
		// TODO Auto-generated method stub
		String sql = "update from Administrador set senhaADM = ? where loginADM = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getsenhaADM());
			ptst.setString(2, vo.getloginADM());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarLogin(VO vo) {
		// TODO Auto-generated method stub
		String sql = "update from Administrador set loginADM = ? where senhaADM = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getloginADM());
			ptst.setString(2, vo.getsenhaADM());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet pesquisarPorID(VO vo) {
		// TODO Auto-generated method stub
		String sql = "select * from Administrador where loginADM = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getloginADM());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet pesquisarPorNome(VO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
