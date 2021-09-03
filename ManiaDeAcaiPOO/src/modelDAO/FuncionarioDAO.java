package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.FuncionarioVO;

public class FuncionarioDAO extends BaseDAO{
	
	public void inserir(FuncionarioVO vo) {
		conn = getConnection();
		String sql = "insert into Funcionario (idFuncionario, nomeFuncionario, telefoneFuncionario) values(?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getIdFuncionario());
			ptst.setString(2, vo.getNomeFuncionario());
			ptst.setString(3, vo.getTelefoneFuncionario());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void removerBylogin(FuncionarioVO vo) {
		conn = getConnection();
		String sql = "delete from Funcionario where idFuncionario = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getIdFuncionario());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<FuncionarioVO> listar() {
		conn = getConnection();
		String sql = "select * from Funcionario";
		Statement st;
		ResultSet rs;
		List<FuncionarioVO> funcionario = new ArrayList<FuncionarioVO>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				FuncionarioVO vo = new FuncionarioVO();
				vo.setIdFuncionario(rs.getInt("idFuncionario"));
				vo.setNomeFuncionario(rs.getString("nomeFuncionario"));
				vo.setTelefoneFuncionario(rs.getString("telefoneFuncionario"));
				funcionario.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return funcionario;
		
	}
	public void editar(FuncionarioVO vo) {
		conn = getConnection();
		String sql = "update from Funcionario set idFuncionario = ? where nomeFuncionario = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getIdFuncionario());
			ptst.setString(2, vo.getNomeFuncionario());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
