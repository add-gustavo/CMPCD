import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection connect() {
        Connection conn = null;
        try {
            String url = "";
            conn = DriverManager.getConnection(url);

        } catch (SQLException erro) {
            // TODO: handle exception
        }
        return conn;
    }
}
