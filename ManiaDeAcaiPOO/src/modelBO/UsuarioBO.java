package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelDAO.UsuarioDAO;
import modelVO.UsuarioVO;

public class UsuarioBO implements BaseInterBO<UsuarioVO>{
    UsuarioDAO dao = new UsuarioDAO();
    UsuarioVO usu = new UsuarioVO();

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
	public List<UsuarioVO> buscar() throws Exception {
		List<UsuarioVO> vo = new ArrayList<UsuarioVO>();
		ResultSet rs = dao.pesquisarPorID(usu);
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
	public List<UsuarioVO> buscarPorID(UsuarioVO vo) throws Exception {
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		ResultSet rs = dao.pesquisarPorID(vo);
		try {
			while(rs.next()) {
				usu.setLogin(rs.getString("loginusuario"));
				usu.setSenha(rs.getString("senhausuario"));
				usu.setNome(rs.getString("nomeusuario"));
				usu.setEndereco(rs.getString("enderecousuario"));
				usu.setTelefone(rs.getString("telefoneusuario"));
				usuarios.add(usu);
			}
			if(usuarios.isEmpty()) {
				throw new Exception("Erro ao Listar. ID não existente.");
			} else {
				return usuarios;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public List<UsuarioVO> buscarPorNome(UsuarioVO vo) throws Exception {
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		ResultSet rs = dao.pesquisarPorNome(vo);
		try {
			while(rs.next()) {
				usu.setLogin(rs.getString("loginusuario"));
				usu.setSenha(rs.getString("senhausuario"));
				usu.setNome(rs.getString("nomeusuario"));
				usu.setEndereco(rs.getString("enderecousuario"));
				usu.setTelefone(rs.getString("telefoneusuario"));
				usuarios.add(usu);
			}
			if(usuarios.isEmpty()) {
				throw new Exception("Erro ao Listar. Nome não existente.");
			} else {
				return usuarios;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<UsuarioVO> buscarPorEndereco(UsuarioVO vo) throws Exception {
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		ResultSet rs = dao.pesquisarPorEndereco(vo);
		try {
			while(rs.next()) {
				usu.setLogin(rs.getString("loginusuario"));
				usu.setSenha(rs.getString("senhausuario"));
				usu.setNome(rs.getString("nomeusuario"));
				usu.setEndereco(rs.getString("enderecousuario"));
				usu.setTelefone(rs.getString("telefoneusuario"));
				usuarios.add(usu);
			}
			if(usuarios.isEmpty()) {
				throw new Exception("Erro ao Listar. Endereco não existente.");
			} else {
				return usuarios;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<UsuarioVO> buscarPorTelefone(UsuarioVO vo) throws Exception {
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		ResultSet rs = dao.pesquisarPorTelefone(vo);
		try {
			while(rs.next()) {
				usu.setLogin(rs.getString("loginusuario"));
				usu.setSenha(rs.getString("senhausuario"));
				usu.setNome(rs.getString("nomeusuario"));
				usu.setEndereco(rs.getString("enderecousuario"));
				usu.setTelefone(rs.getString("telefoneusuario"));
				usuarios.add(usu);
			}
			if(usuarios.isEmpty()) {
				throw new Exception("Erro ao Listar. Telefone não existente.");
			} else {
				return usuarios;
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

}