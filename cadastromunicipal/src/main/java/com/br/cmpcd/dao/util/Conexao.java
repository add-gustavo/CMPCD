package com.br.cmpcd.dao.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexao {
    private static final String RESOURCE = "java:comp/env/jdbc/MariaDB";

    // Método para obter a conexão
    public static Connection getConexao() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(RESOURCE);
            return ds.getConnection();
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Erro ao obter conexão com o banco de dados.", e);
        }
    }

    // Método para fechar a conexão (devolver ao pool)
    public static void fecharConexao(Connection conn) {
        if (conn != null) {
            try {
                conn.close(); // Devolve a conexão para o pool
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
