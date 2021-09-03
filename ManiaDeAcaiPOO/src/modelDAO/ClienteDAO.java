package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.ClienteVO;

public class ClienteDAO extends BaseDAO{
	public void inserir(ClienteVO c) {
		conn = getConnection();
		String sql = "insert into Cliente (idCliente, nomeCliente, enderecoCliente, telefoneCliente) values (?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, c.getIdCliente());
			ptst.setString(2, c.getNomeCliente());
			ptst.setString(3, c.getEnderecoCliente());
			ptst.setString(4, c.getTelefoneCliente());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(ClienteVO c) {
		conn = getConnection();
		String sql = "delete from Cliente where idCliente = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, c.getIdCliente());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ClienteVO> listar() {
		conn = getConnection();
		String sql = "select * from Cliente";
		ResultSet rs;
		Statement st;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ClienteVO c = new ClienteVO();
				c.setIdCliente(rs.getInt("idCliente"));
				c.setNomeCliente(rs.getString("nomeCliente"));
				c.setEnderecoCliente(rs.getString("enderecoCliente"));
				c.setTelefoneCliente(rs.getString("telefoneCliente"));
				clientes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	public void editar(ClienteVO c) {
		conn = getConnection();
		String sql = "update Cliente set nomeCliente = ? where idCliente = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, c.getNomeCliente());
			ptst.setInt(2, c.getIdCliente());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
