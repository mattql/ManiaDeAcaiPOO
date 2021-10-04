package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelDAO.ClienteDAO;
import modelVO.ClienteVO;

public class ClienteBO implements BaseInterBO<ClienteVO>{
	ClienteDAO dao = new ClienteDAO();
	@Override
	public void cadastrar(ClienteVO vo) throws Exception{
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next()) {
				throw new Exception("Erro ao cadastrar. Já existe um cliente com esse ID.");
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
				throw new Exception("Erro ao Alterar Nome. ID não existente.");
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
				throw new Exception("Erro ao Alterar Endereco. ID não existente.");
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
				throw new Exception("Erro ao Alterar Telefone. ID não existente.");
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
				throw new Exception("Erro ao Alterar Email. ID não existente.");
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
				throw new Exception("Erro ao Remover. ID não existente.");
			} else {
				dao.remover(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public void buscar(List<ClienteVO> vo) throws Exception {
		ClienteVO c = new ClienteVO();
		ResultSet rs = dao.pesquisarPorID(c);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. ID não existente.");
			} else {
				vo = dao.listar();
				for(ClienteVO vo2: vo) {
					System.out.println("{ " + vo2.getIdPessoa() + ", " + vo2.getNome() + ", " + vo2.getEndereco()
						+ ", " + vo2.getTelefone() + ", " + vo2.getEmail() + " }");
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void buscarPorID(ClienteVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorID(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. ID não existente.");
			} else {
				List<ClienteVO> clientes = dao.listar();
				for(ClienteVO vo2: clientes) {
					System.out.println(vo2.getIdPessoa());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public void buscarPorNome(ClienteVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorNome(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Nome não existente.");
			} else {
				List<ClienteVO> clientes = dao.listar();
				for(ClienteVO vo2: clientes) {
					System.out.println(vo2.getNome());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void buscarPorEndereco(ClienteVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorEndereco(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Endereço não existente.");
			} else {
				List<ClienteVO> clientes = dao.listar();
				for(ClienteVO vo2: clientes) {
					System.out.println(vo2.getEndereco());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void buscarPorTelefone(ClienteVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorTelefone(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Telefone não existente.");
			} else {
				List<ClienteVO> clientes = dao.listar();
				for(ClienteVO vo2: clientes) {
					System.out.println(vo2.getTelefone());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void buscarPorEmail(ClienteVO vo) throws Exception {
		ResultSet rs = dao.pesquisarPorEmail(vo);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. Email não existente.");
			} else {
				List<ClienteVO> clientes = dao.listar();
				for(ClienteVO vo2: clientes) {
					System.out.println(vo2.getEmail());
				}
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

}
