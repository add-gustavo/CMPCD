package CMPCD.BACK.src.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import CMPCD.BACK.src.Connection.Conexao;

public class ControlAdministrador {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<Usuario> administradores = new ArrayList<>();

    public void adicionarAdministrador(String nomelogin, String senha) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nomelogin);
            pstm.setString(2, senha);

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }

    }

    public void excluirAdministrador(Administrador admin) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, admin.getCodigo());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarAdministradorNomeLogin(Administrador admin) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, admin.getNomelogin());
            pstm.setString(2, admin.getCodigo());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarAdministradorSenha(Administrador admin) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, admin.getSenha());
            pstm.setString(2, admin.getCodigo());
        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

}
