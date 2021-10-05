package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelDAO.AdministradorDAO;
import modelVO.AdministradorVO;


public class AdministradorBO implements BaseInterBO<AdministradorVO>{
    AdministradorDAO dao = new AdministradorDAO();
    AdministradorVO a = new AdministradorVO();
    
	@Override
	public void cadastrar(AdministradorVO vo) throws Exception {
		try {
	            ResultSet rs = dao.pesquisarPorID(vo);
	            if(rs.next()) {
	                throw new Exception("Erro ao Cadastrar. Já existe um Administrador com esse Login.");
	            } else {
	                dao.inserir(vo);
	            }
	        }
	        catch(SQLException e) {
	            throw new Exception(e.getMessage());
	        }
	}

	@Override
	public void alterar(AdministradorVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorID(vo);
            if(rs.next() == false) {
                throw new Exception("Erro ao Alterar Senha. Login não existente.");
            } else {
                dao.editar(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}
	
	public void alterarlogin(AdministradorVO vo) throws Exception {
		try {
            ResultSet rs = dao.pesquisarPorID(vo);
            if(rs.next() == false) {
                throw new Exception("Erro ao Alterar Nome. Login não existente.");
            } else {
                dao.editarLogin(vo);
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
	}

	@Override
	public void remover(AdministradorVO vo) throws Exception {
		 try {
	            ResultSet rs = dao.pesquisarPorID(vo);
	            if(rs.next() == false) {
	                throw new Exception("Erro ao Remover. Login não existente.");
	            } else {
	                dao.remover(vo);
	            }
	        }
	        catch(SQLException e) {
	            throw new Exception(e.getMessage());
	        }
	}

	@Override
	public List<AdministradorVO> buscar() throws Exception {
		List<AdministradorVO> vo = new ArrayList<AdministradorVO>();
		ResultSet rs = dao.pesquisarPorID(a);
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
	public List<AdministradorVO> buscarPorID(AdministradorVO vo) throws Exception {

		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<AdministradorVO> buscarPorNome(AdministradorVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
   
}