package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.AdministradorVO;

public class AdministradorDAO extends BaseDAO{
	
	public void inserir(AdministradorVO vo) {
		conn = getConnection();
		String sql = "insert into Administrador (loginADM, senhaADM) values(?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getloginADM());
			ptst.setString(2, vo.getsenhaADM());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void removerBylogin(AdministradorVO vo) {
		conn = getConnection();
		String sql = "delete from Administrador where loginADM = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getloginADM());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<AdministradorVO> listar() {
		conn = getConnection();
		String sql = "select * from Administrador";
		Statement st;
		ResultSet rs;
		List<AdministradorVO> administrador = new ArrayList<AdministradorVO>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AdministradorVO vo = new AdministradorVO();
				vo.setloginADM(rs.getString("loginADM"));
				vo.setsenhaADM(rs.getString("senhaADM"));
				administrador.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return administrador;
		
	}
	
	
	public void editarsenha(AdministradorVO vo) {
		conn = getConnection();
		String sql = "update from Administrador set senhaADM = ? where loginADM = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getsenhaADM());
			ptst.setString(2, vo.getloginADM());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editarlogin(AdministradorVO vo) {
		conn = getConnection();
		String sql = "update from Administrador set loginADM = ? where loginADM = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getloginADM());
			ptst.setString(2, vo.getloginADM());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
