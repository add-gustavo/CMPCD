package com.br.cmpcd.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoTest {
    public static Connection getConexao() {
        Connection connection = null;
        try {
            String url = "jdbc:mariadb://localhost:3306/CMPCD";
            String user = "root";
            String password = "Info@1234";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem-sucedida!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
