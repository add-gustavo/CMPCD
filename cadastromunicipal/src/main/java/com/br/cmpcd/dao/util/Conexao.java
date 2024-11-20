package com.br.cmpcd.dao.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexao {
    private static final String RESOURCE = "java:/comp/env/jdbc/Mysql";

    public static Connection getConexao() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(RESOURCE);
            return ds.getConnection();
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Erro ao obter conexão com o banco de dados.", e);
        }
    }
}
