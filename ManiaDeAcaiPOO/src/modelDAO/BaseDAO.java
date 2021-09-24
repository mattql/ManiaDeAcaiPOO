package modelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<VO> implements BaseInterDAO<VO>{
    private static Connection conn = null;
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String senha = "matheusmatheus";

    public static Connection getConnection() {
        if(conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, senha);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
        else return conn;
    }

    public static Connection closeConnection() {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
        else return conn;
    }

    public abstract void inserir(VO vo);
    public abstract void remover(VO vo);
    public abstract void editar(VO vo);
    public abstract ResultSet listar();
    public abstract ResultSet pesquisarPorID(VO vo);
    public abstract ResultSet pesquisarPorNome(VO vo);
}