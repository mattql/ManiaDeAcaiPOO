package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelDAO.ClienteDAO;
import modelVO.ClienteVO;

public class ClienteBO implements BaseInterBO<ClienteVO> {
	ClienteDAO dao = new ClienteDAO();
	ClienteVO c = new ClienteVO();
	List<ClienteVO> clientes = new ArrayList<ClienteVO>();
	
	@Override
	public void cadastrar(ClienteVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next()) {
				throw new Exception("Erro ao cadastrar. J� existe um cliente com esse ID.");
			} else {
				dao.inserir(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void alterar(ClienteVO vo) throws Exception {
		//Alterar Nome
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Alterar Nome. ID n�o existente.");
			} else {
				dao.editar(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void alterarEndereco(ClienteVO vo) throws Exception {
		//Alterar Endereco
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Alterar Endereco. ID n�o existente.");
			} else {
				dao.editarEndereco(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public void alterarTelefone(ClienteVO vo) throws Exception {
		//Alterar Telefone
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Alterar Telefone. ID n�o existente.");
			} else {
				dao.editarTelefone(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public void alterarEmail(ClienteVO vo) throws Exception {
		//Alterar Email
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Alterar Email. ID n�o existente.");
			} else {
				dao.editarEmail(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}	
	}

	@Override
	public void remover(ClienteVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Remover. ID n�o existente.");
			} else {
				dao.remover(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public List<ClienteVO> buscar() throws Exception {
		ClienteVO c = new ClienteVO();
		List<ClienteVO> vo = new ArrayList<ClienteVO>();
		ResultSet rs = dao.pesquisarPorID(c);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. ID n�o existente.");
			} else {
				vo = dao.listar();
				return vo;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<ClienteVO> buscarPorID(ClienteVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorID(vo);
		try {
			while(rs.next()) {
				c.setIdPessoa(rs.getInt("IdCliente"));
				c.setNome(rs.getString("nomecliente"));
				c.setEndereco(rs.getString("enderecocliente"));
				c.setTelefone(rs.getString("telefonecliente"));
				c.setEmail(rs.getString("emailcliente"));
				clientes.add(c);
			}
			if(clientes.isEmpty()) {
				throw new Exception("Erro ao Listar. ID n�o existente.");
			} else {
				return clientes;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	

	@Override
	public List<ClienteVO> buscarPorNome(ClienteVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorNome(vo);
		try {
			while(rs.next()) {
				c.setIdPessoa(rs.getInt("IdCliente"));
				c.setNome(rs.getString("nomecliente"));
				c.setEndereco(rs.getString("enderecocliente"));
				c.setTelefone(rs.getString("telefonecliente"));
				c.setEmail(rs.getString("emailcliente"));
				clientes.add(c);
			}
			if(clientes.isEmpty()) {
				throw new Exception("Erro ao Listar. Nome n�o existente.");
			} else {
				return clientes;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	public List<ClienteVO> buscarPorEndereco(ClienteVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorEndereco(vo);
		try {
			while(rs.next()) {
				c.setIdPessoa(rs.getInt("IdCliente"));
				c.setNome(rs.getString("nomecliente"));
				c.setEndereco(rs.getString("enderecocliente"));
				c.setTelefone(rs.getString("telefonecliente"));
				c.setEmail(rs.getString("emailcliente"));
				clientes.add(c);
			}
			if(clientes.isEmpty()) {
				throw new Exception("Erro ao Listar. Endere�o n�o existente.");
			} else {
				return clientes;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<ClienteVO> buscarPorTelefone(ClienteVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorTelefone(vo);
		try {
			while(rs.next()) {
				c.setIdPessoa(rs.getInt("IdCliente"));
				c.setNome(rs.getString("nomecliente"));
				c.setEndereco(rs.getString("enderecocliente"));
				c.setTelefone(rs.getString("telefonecliente"));
				c.setEmail(rs.getString("emailcliente"));
				clientes.add(c);
			}
			if(clientes.isEmpty()) {
				throw new Exception("Erro ao Listar. Telefone n�o existente.");
			} else {
				return clientes;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<ClienteVO> buscarPorEmail(ClienteVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorEmail(vo);
		try {
			while(rs.next()) {
				c.setIdPessoa(rs.getInt("IdCliente"));
				c.setNome(rs.getString("nomecliente"));
				c.setEndereco(rs.getString("enderecocliente"));
				c.setTelefone(rs.getString("telefonecliente"));
				c.setEmail(rs.getString("emailcliente"));
				System.out.println(c.getEmail());
				clientes.add(c);
			}
			if(clientes.isEmpty()) {
				throw new Exception("Erro ao Listar. Email n�o existente.");
			} else {
				return clientes;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

}
