package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelDAO.FuncionarioDAO;
import modelVO.FuncionarioVO;


public class FuncionarioBO implements BaseInterBO<FuncionarioVO>{
    FuncionarioDAO dao = new FuncionarioDAO();
    FuncionarioVO fun = new FuncionarioVO();

	@Override
	public void cadastrar(FuncionarioVO vo) throws Exception {
		// TODO Auto-generated method stub
		try {
            ResultSet rs = dao.pesquisarPorID(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Cadastrar. Já existe um Funcionario com esse ID.");
            } else {
                dao.inserir(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}

	@Override
	public void alterar(FuncionarioVO vo) throws Exception {
		// TODO Auto-generated method stub
		// Alterando o Nome
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
	
	public void alterarEndereco(FuncionarioVO vo) throws Exception {
		
		// Alterando o Endereco:
		
		try {
            ResultSet rs = dao.pesquisarPorID(vo);
            if(rs.next() == false) {
                throw new Exception("Erro ao Alterar o Endereco. ID não existente.");
            } else {
                dao.editarEndereco(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}
	
	public void alterarTelefone(FuncionarioVO vo) throws Exception {
		
		// Alterando o Telefone:
		
		try {
            ResultSet rs = dao.pesquisarPorID(vo);
            if(rs.next() == false) {
                throw new Exception("Erro ao Alterar o Telefone. ID não existente.");
            } else {
                dao.editarTelefone(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}
	
	public void alterarSalario(FuncionarioVO vo) throws Exception {
		
		// Alterando o Salario:
		
		try {
            ResultSet rs = dao.pesquisarPorID(vo);
            if(rs.next() == false) {
                throw new Exception("Erro ao Alterar o Salario. ID não existente.");
            } else {
                dao.editarSalario(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}

	@Override
	public void remover(FuncionarioVO vo) throws Exception {
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
	public List<FuncionarioVO> buscar() throws Exception {
		FuncionarioVO c = new FuncionarioVO();
		List<FuncionarioVO> vo = new ArrayList<FuncionarioVO>();
		ResultSet rs = dao.pesquisarPorID(c);
		try {
			if(rs.next()) {
				throw new Exception("Erro ao Listar. ID não existente.");
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
	public List<FuncionarioVO> buscarPorID(FuncionarioVO vo) throws Exception {
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		ResultSet rs = dao.pesquisarPorID(vo);
		try {
			while(rs.next()) {
				fun.setIdPessoa(rs.getInt("idfuncionario"));
				fun.setNome(rs.getString("nomefuncionario"));
				fun.setEndereco(rs.getString("enderecofuncionario"));
				fun.setTelefone(rs.getString("telefonefuncionario"));
				fun.setSalario(rs.getDouble("salariofuncionario"));
				funcionarios.add(fun);
			}
			if(funcionarios.isEmpty()) {
				throw new Exception("Erro ao Listar. ID não existente.");
			} else {
				return funcionarios;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<FuncionarioVO> buscarPorNome(FuncionarioVO vo) throws Exception {
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		ResultSet rs = dao.pesquisarPorNome(vo);
		try {
			while(rs.next()) {
				fun.setIdPessoa(rs.getInt("idfuncionario"));
				fun.setNome(rs.getString("nomefuncionario"));
				fun.setEndereco(rs.getString("enderecofuncionario"));
				fun.setTelefone(rs.getString("telefonefuncionario"));
				fun.setSalario(rs.getDouble("salariofuncionario"));
				funcionarios.add(fun);
			}
			if(funcionarios.isEmpty()) {
				throw new Exception("Erro ao Listar. Nome não existente.");
			} else {
				return funcionarios;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<FuncionarioVO> buscarPorEndereco(FuncionarioVO vo) throws Exception {
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		ResultSet rs = dao.pesquisarPorEndereco(vo);
		try {
			while(rs.next()) {
				fun.setIdPessoa(rs.getInt("idfuncionario"));
				fun.setNome(rs.getString("nomefuncionario"));
				fun.setEndereco(rs.getString("enderecofuncionario"));
				fun.setTelefone(rs.getString("telefonefuncionario"));
				fun.setSalario(rs.getDouble("salariofuncionario"));
				funcionarios.add(fun);
			}
			if(funcionarios.isEmpty()) {
				throw new Exception("Erro ao Listar. Endereco não existente.");
			} else {
				return funcionarios;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<FuncionarioVO> buscarPorTelefone(FuncionarioVO vo) throws Exception {
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		ResultSet rs = dao.pesquisarPorTelefone(vo);
		try {
			while(rs.next()) {
				fun.setIdPessoa(rs.getInt("idfuncionario"));
				fun.setNome(rs.getString("nomefuncionario"));
				fun.setEndereco(rs.getString("enderecofuncionario"));
				fun.setTelefone(rs.getString("telefonefuncionario"));
				fun.setSalario(rs.getDouble("salariofuncionario"));
				funcionarios.add(fun);
			}
			if(funcionarios.isEmpty()) {
				throw new Exception("Erro ao Listar. Telefone não existente.");
			} else {
				return funcionarios;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<FuncionarioVO> buscarPorSalario(FuncionarioVO vo) throws Exception {
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		ResultSet rs = dao.pesquisarPorSalario(vo);
		try {
			while(rs.next()) {
				fun.setIdPessoa(rs.getInt("idfuncionario"));
				fun.setNome(rs.getString("nomefuncionario"));
				fun.setEndereco(rs.getString("enderecofuncionario"));
				fun.setTelefone(rs.getString("telefonefuncionario"));
				fun.setSalario(rs.getDouble("salariofuncionario"));
				funcionarios.add(fun);
			}
			if(funcionarios.isEmpty()) {
				throw new Exception("Erro ao Listar. Salario não existente.");
			} else {
				return funcionarios;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	

	

	
}