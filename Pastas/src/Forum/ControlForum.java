package CMPCD.Pastas.src.Forum;

import CMPCD.BACK.src.Connection.Conexao;
import CMPCD.BACK.src.DTO.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlForum {
    Connection conn;
    ResultSet rs;
    PreparedStatement pstm;
    List<Topico> topicos = new ArrayList<>();

    public void adicionarTopico(String titulo, Pessoa autor) {
        String sql = "insert into Topico (titulo, autor) values (?,?)";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, titulo);
            pstm.setInt(2, autor.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void removerTopico(Topico topico) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, topico.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarTopicoTitulo(Topico topico) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, topico.getTitulo());
            pstm.setInt(2, topico.getCodigo());
        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public List<Topico> listarTopico() {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Topico topico = new Topico(rs.getInt("codigo"), rs.getString("titulo"),
                        new Pessoa(rs.getInt("codigoAutor"), null));
                topicos.add(topico);

            }
        } catch (SQLException erro) {
            // TODO: handle exception
        }

        return topicos;
    }

    public List<Topico> pesquisarTopicos(String pesquisa) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pesquisa);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Topico topico = new Topico(rs.getInt("codigo"), rs.getString("titulo"),
                        new Pessoa(rs.getInt("codigoAutor"), null));
                topicos.add(topico);
            }
        } catch (SQLException erro) {
            // TODO: handle exception
        }
        return topicos;
    }

}
