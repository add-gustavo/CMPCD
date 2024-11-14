package CMPCD.Pastas.src.Forum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CMPCD.BACK.src.Connection.Conexao;
import CMPCD.BACK.src.DTO.Pessoa;

public class ControlTopico {
    Connection conn;
    ResultSet rs;
    PreparedStatement pstm;
    List<Postagem> postagens = new ArrayList<>();

    public void adicionarpostagem(String comentario, Pessoa autor, Topico topico) {
        String sql = "insert into Postagem (comentario, codigoautor, codigoTopico) values (?, ?, ?)";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, comentario);
            pstm.setInt(2, autor.getCodigo());
            pstm.setInt(3, topico.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void removerPostagem(Postagem postagem) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, postagem.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            // TODO: handle exception
        }
    }

    public void alterarPostagemComentario(Postagem postagem) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, postagem.getComentario());
            pstm.setInt(2, postagem.getCodigo());

        } catch (SQLException e) {
            // TODO: handle exception
        }
    }

    public List<Postagem> getTopicoPostagens(Topico topico) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, topico.getCodigo());
            rs = pstm.executeQuery();

            while (rs.next()) {
                Postagem postagem = new Postagem(rs.getInt("codigo"), rs.getString("comentario"),
                        rs.getString("datetime"), new Pessoa(rs.getInt("codigoAutor"), null), topico);
                postagens.add(postagem);
            }

        } catch (SQLException erro) {
            // TODO: handle exception
        }
        return postagens;
    }

}
