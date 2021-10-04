package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelDAO.UsuarioDAO;
import modelVO.UsuarioVO;

public class UsuarioBO implements BaseInterBO<UsuarioVO>{
    UsuarioDAO dao = new UsuarioDAO();

	@Override
	public void cadastrar(UsuarioVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorNome(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Cadastrar. Já existe um Usuario com esse Nome.");
            } else {
                dao.inserir(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}

	@Override
	public void alterar(UsuarioVO vo) throws Exception {
		
		// Alterando a Senha:
		
		try {
            ResultSet rs = dao.pesquisarPorNome(vo);
            if(rs.next() == false) {
                throw new Exception("Erro ao Alterar Senha. Nome não existente.");
            } else {
                dao.editar(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}

	public void alterarLogin(UsuarioVO vo) throws Exception {
		
		//Alterando o Login:
		
		try {
            ResultSet rs = dao.pesquisarPorNome(vo);
            if(rs.next() == false) {
                throw new Exception("Erro ao Alterar Login. Nome não existente.");
            } else {
                dao.editarLogin(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}
	
	public void alterarEndereco(UsuarioVO vo) throws Exception {
		
		// Alterando o Endereco:
		
		try {
            ResultSet rs = dao.pesquisarPorNome(vo);
            if(rs.next() == false) {
                throw new Exception("Erro ao Alterar Endereço. Nome não existente.");
            } else {
                dao.editarEndereco(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}
	
	public void alterarTelefone(UsuarioVO vo) throws Exception {

		// Alterando o Telefone:
		
		try {
            ResultSet rs = dao.pesquisarPorNome(vo);
            if(rs.next() == false) {
                throw new Exception("Erro ao Alterar Telefone. Nome não existente.");
            } else {
                dao.editarTelefone(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}
	
	@Override
	public void remover(UsuarioVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorNome(vo);
            if(rs.next() == false) {
                throw new Exception("Erro ao Remover. Nome não existente.");
            } else {
                dao.remover(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}

	@Override
	public void buscar(List<UsuarioVO> vo) throws Exception {
		UsuarioVO usu = new UsuarioVO();
        ResultSet rs = dao.pesquisarPorID(usu);
        try {
        if(rs.next()) {
            throw new Exception("Erro ao Buscar. ID não existente.");
        } else {
           vo = dao.listar();
           for(UsuarioVO vo2: vo) {
        	   System.out.println("{" + vo2.getLogin() + ", " + vo2.getSenha() + ", " + vo2.getEndereco() +
        			   ", " + vo2.getTelefone() + "}");
           }
        }
    }
    catch(SQLException e) {
        throw new Exception(e.getMessage());
    }
	}

	
	@Override
	public void buscarPorID(UsuarioVO vo) throws Exception {
		
		try {
            ResultSet rs = dao.pesquisarPorID(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Buscar. ID não existente.");
            } else {
                List<UsuarioVO> usuario = dao.listar();
                for(UsuarioVO vo2: usuario) {
                	System.out.println(vo2.getIdPessoa());
                }
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}

	
	@Override
	public void buscarPorNome(UsuarioVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorNome(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Buscar. Nome não existente.");
            } else {
                List<UsuarioVO> usuario = dao.listar();
                for(UsuarioVO vo2: usuario) {
                	System.out.println(vo2.getNome());
                }
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
		
	}
	
	public void buscarPorEndereco(UsuarioVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorEndereco(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Buscar. Nome não existente.");
            } else {
                List<UsuarioVO> usuario = dao.listar();
                for(UsuarioVO vo2: usuario) {
                	System.out.println(vo2.getEndereco());
                }
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
		
	}
	
	public void buscarPorTelefone(UsuarioVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorTelefone(vo);
            if(rs.next()) {
                throw new Exception("Erro ao Buscar. Nome não existente.");
            } else {
                List<UsuarioVO> usuario = dao.listar();
                for(UsuarioVO vo2: usuario) {
                	System.out.println(vo2.getTelefone());
                }
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
		
	}



}