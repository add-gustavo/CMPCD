package CMPCD.BACK.src.Eventos;

import CMPCD.BACK.src.Connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlEventos {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<Evento> eventos = new ArrayList<>();

    public void adicionarEvento(String titulo, String descricao, String texto, String keywords, Imagem imagem) {
        String sql = "insert into Evento(titulo, descricao, texto, keywords, imagemPrincipal, imagemSecundaria1, imagemSecundaria2, imagemSecundaria3) values(?, ?, ?, ?, ?, ?, ?, ?)";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, titulo);
            pstm.setString(2, descricao);
            pstm.setString(3, texto);
            pstm.setString(4, keywords);

            // pesquisar como colocar imagens no backend e banco de dados;
            pstm.setString(5, imagem.getImagemPrincipal());
            pstm.setString(6, imagem.getImagemSecundaria1());
            pstm.setString(7, imagem.getImagemSecundaria2());
            pstm.setString(8, imagem.getImagemSecundaria3());

            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            // TODO: handle exception
        }

    }

    public void removerEvento(Evento evento) {
        String sql = "delete from Evento where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, evento.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarEventoTitulo(Evento evento) {
        String sql = "update Evento set titulo = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, evento.getTitulo());
            pstm.setString(2, evento.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }

    }

    public void alterarEventoDescricao(Evento evento) {
        String sql = "update Evento set descricao = ? where id = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, evento.getDescrição());
            pstm.setString(2, evento.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarEventoTexto(Evento evento) {
        String sql = "update Evento set texto = ? where id = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, evento.getTexto());
            pstm.setString(2, evento.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarEventoKeywords(Evento evento) {
        String sql = "update Evento set keywords = ? where id = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, evento.getKeywords());
            pstm.setString(2, evento.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    // resolver Imagem Principal
    public void alterarEventoImagemPrincipal(Evento evento) {
        String sql = "update Evento set imagemPrincipal = ? where id = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, evento.getImagens().getImagemPrincipal());
            pstm.setString(2, evento.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    // resolver Imagens Secundárias
    public void alterarEventoImagemSecundaria(Evento evento) {
        String sql = "update Evento set imagemSecundaria1 = ?, imagemSecundaria2 = ?, imagemSecundaria3 = ? where id = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, evento.getImagens().getImagemSecundaria1());
            pstm.setString(2, evento.getImagens().getImagemSecundaria2());
            pstm.setString(3, evento.getImagens().getImagemSecundaria3());
            pstm.setString(2, evento.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    // mostrar os eventos
    public List<Evento> listarEventos() {
        String sql = "Select * from Evento";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Evento evento = new Evento(rs.getString("codigo"), rs.getString("titulo"), rs.getString("descricao"),
                        rs.getString("keywords"), new Imagem(rs.getString("imagemPrincipal")));
                eventos.add(evento);
            }
        } catch (SQLException erro) {
            // TODO: handle exception
        }

        return eventos;
    }

    // barra de pesquisa para eventos
    public List<Evento> pesquisarEvento(String pesquisa) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pesquisa);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Evento evento = new Evento(rs.getString("codigo"), rs.getString("titulo"), rs.getString("descricao"),
                        rs.getString("keywords"), new Imagem(rs.getString("imagemPrincipal")));
                eventos.add(evento);
            }
        } catch (SQLException erro) {
            // TODO: handle exception
        }
        return eventos;
    }

    // Detalhes do Evento todo
    public void getEvento(Evento evento) {
        String sql = "Select * from Evento where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, evento.getCodigo());
            rs = pstm.executeQuery();

            evento.setDate(rs.getString("data"));
            evento.setTexto(rs.getString("texto"));
            evento.getImagens().setImagemSecundaria1(rs.getString("imagemSecundaria1"));
            evento.getImagens().setImagemSecundaria2(rs.getString("imagemSecundaria2"));
            evento.getImagens().setImagemSecundaria3(rs.getString("imagemSecundaria3"));
        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }
}
