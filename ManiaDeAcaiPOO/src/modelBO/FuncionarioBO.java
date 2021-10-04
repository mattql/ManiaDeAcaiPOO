package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelDAO.FuncionarioDAO;
import modelVO.FuncionarioVO;


public class FuncionarioBO implements BaseInterBO<FuncionarioVO>{
    FuncionarioDAO dao = new FuncionarioDAO();

	@Override
	public void cadastrar(FuncionarioVO vo) throws Exception {
		// TODO Auto-generated method stub
		try {
            ResultSet rs = dao.pesquisarPorID(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Cadastrar. J� existe um Funcionario com esse ID.");
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
                throw new Exception("Erro ao Alterar Nome. ID n�o existente.");
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
                throw new Exception("Erro ao Alterar o Endereco. ID n�o existente.");
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
                throw new Exception("Erro ao Alterar o Telefone. ID n�o existente.");
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
                throw new Exception("Erro ao Alterar o Salario. ID n�o existente.");
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
	public void buscar(List<FuncionarioVO> vo) throws Exception {
		FuncionarioVO fun = new FuncionarioVO();
        ResultSet rs = dao.pesquisarPorID(fun);
        try {
        if(rs.next()) {
            throw new Exception("Erro ao Buscar. ID n�o existente.");
        } else {
           vo = dao.listar();
           for(FuncionarioVO vo2: vo) {
        	   System.out.println("{ " + vo2.getNome() + ", " + vo2.getEndereco() + ", " + vo2.getTelefone() + ","
        			   + vo2.getSalario() + "}");
           		}
        	}
        }
        catch(SQLException e) {
        	throw new Exception(e.getMessage());
    	}
	}
	
	@Override
	public void buscarPorID(FuncionarioVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorID(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Buscar. ID n�o existente.");
            } else {
                List<FuncionarioVO> funcionario = dao.listar();
                for(FuncionarioVO vo2: funcionario) {
                	System.out.println(vo2.getIdPessoa());
                }
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
		
	}

	@Override
	public void buscarPorNome(FuncionarioVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorNome(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Buscar. Nome n�o existente.");
            } else {
                List<FuncionarioVO> funcionario = dao.listar();
                for(FuncionarioVO vo2: funcionario) {
                	System.out.println(vo2.getNome());
                }
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
		
	}
	
	public void buscarPorEndereco(FuncionarioVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorEndereco(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Buscar. Endereco n�o existente.");
            } else {
                List<FuncionarioVO> funcionario = dao.listar();
                for(FuncionarioVO vo2: funcionario) {
                	System.out.println(vo2.getEndereco());
                }
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
		
	}
	
	public void buscarPorTelefone(FuncionarioVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorTelefone(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Buscar. Telefone n�o existente.");
            } else {
                List<FuncionarioVO> funcionario = dao.listar();
                for(FuncionarioVO vo2: funcionario) {
                	System.out.println(vo2.getTelefone());
                }
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
		
	}
	
	public void buscarPorSalario(FuncionarioVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorSalario(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Buscar. Salario n�o existente.");
            } else {
                List<FuncionarioVO> funcionario = dao.listar();
                for(FuncionarioVO vo2: funcionario) {
                	System.out.println(vo2.getSalario());
                }
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
		
	}


	
}