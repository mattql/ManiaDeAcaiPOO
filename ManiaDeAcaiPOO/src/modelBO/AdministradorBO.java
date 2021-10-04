package modelBO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelDAO.AdministradorDAO;
import modelVO.AdministradorVO;

public class AdministradorBO implements BaseInterBO<AdministradorVO>{
    AdministradorDAO dao = new AdministradorDAO();

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
	
	/*public void Autenticar(AdministradorVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorID(vo);
			if(rs.next() == false) {
				throw new Exception("Erro ao Autenticar. Senha incorreta!");
			}else {
				dao.listar();
				}
			}
			catch(SQLException e) {
				throw new Exception(e.getMessage())
			}
	}*/

	@Override
	public void buscar(List<AdministradorVO> vo) throws Exception {
			AdministradorVO adm = new AdministradorVO();
            ResultSet rs = dao.pesquisarPorID(adm);
            try {
            if(rs.next()) {
                throw new Exception("Erro ao Remover. Login não existente.");
            } else {
               vo = dao.listar();
               for(AdministradorVO vo2: vo) {
            	   System.out.println("{" + vo2.getloginADM() + ", " + vo2.getsenhaADM() + "}");
               }
            }
        }
        catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
		
	}

	@Override
	public void buscarPorID(AdministradorVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarPorNome(AdministradorVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}
   


}