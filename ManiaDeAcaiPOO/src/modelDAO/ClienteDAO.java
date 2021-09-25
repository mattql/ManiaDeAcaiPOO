package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelVO.ClienteVO;
import modelVO.PedidoVO;

public class ClienteDAO<VO extends ClienteVO> extends BaseDAO<VO>{
	@Override
	public void inserir(VO vo) {
		String sql = "insert into Cliente (nomeCliente, enderecoCliente, telefoneCliente, emailCliente) values (?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setString(3, vo.getTelefone());
			ptst.setString(4, vo.getEmail());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou, nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setIdPessoa(generatedKeys.getInt(1));
			}
			
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(VO vo) {
		String sql = "delete from Cliente where idCliente = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getIdPessoa());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editar(VO vo) {
		String sql = "update Cliente set nomeCliente = ? where idCliente = ?";
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
		String sql = "update Cliente set enderecoCliente = ? where idCliente = ?";
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
		String sql = "update Cliente set telefoneoCliente = ? where idCliente = ?";
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
	
	public void editarEmail(VO vo) {
		String sql = "update Cliente set emailCliente = ? where idCliente = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getEmail());
			ptst.setInt(2, vo.getIdPessoa());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List <VO> listar() {
		String sql = "select * from Cliente";
		ResultSet rs;
		Statement st;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ClienteVO c = new ClienteVO();
				c.setIdPessoa(rs.getInt("idCliente"));
				c.setNome(rs.getString("nomeCliente"));
				c.setEndereco(rs.getString("enderecoCliente"));
				c.setTelefone(rs.getString("telefoneCliente"));
				c.setEmail(rs.getString("telefoneCliente"));
				clientes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List<VO>) clientes;
	}

	@Override
	public ResultSet pesquisarPorID(VO vo) {
		String sql = "select * from Cliente where idcliente = ?";
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
		String sql = "select * from Cliente where nomecliente = ?";
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
		String sql = "select * from Cliente where enderecocliente = ?";
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
	
		String sql = "select * from Cliente where telefonecliente = ?";
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
	
	public ResultSet pesquisarPorEmail(VO vo) {
		
		String sql = "select * from Cliente where emailcliente = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getEmail());
				rs = ptst.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
	}
}
