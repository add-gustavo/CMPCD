package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    // private static String resource = "java:/comp/env/jdbc/Mysql";

    public Connection connect() {
        Connection conn = null;
        try {
            String url = "";
            conn = DriverManager.getConnection(url);

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return conn;
    }
}
