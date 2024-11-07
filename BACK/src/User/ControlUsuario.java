package CMPCD.BACK.src.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import CMPCD.BACK.src.Connection.Conexao;

public class ControlUsuario {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(String email, String senha, String nomelogin, String nomeCompleto,
            String dataNascimento, String telefone, String endereco, String ocupacao, String tipoDeficiencia) {
        String sql = "insert into Usuario (email, senha, nomelogin, nomeCompleto, dataNascimento, telefone, endereco, ocupacao, tipoDeficiencia) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, email);
            pstm.setString(2, senha);
            pstm.setString(3, nomelogin);
            pstm.setString(4, nomeCompleto);
            pstm.setString(5, dataNascimento);
            pstm.setString(6, telefone);
            pstm.setString(7, endereco);
            pstm.setString(8, ocupacao);
            pstm.setString(9, tipoDeficiencia);

            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void excluirUsuario(Usuario usuario) {
        String sql = "delete from Usuario where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarUsuarioEmail(Usuario usuario) {
        String sql = "update Usuario set email = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getEmail());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarUsuarioSenha(Usuario usuario) {
        String sql = "update Usuario set senha = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getSenha());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarUsuarioNomeCompleto(Usuario usuario) {
        String sql = "update Usuario set nomeCompleto = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNomeCompleto());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarUsuarioDataNascimento(Usuario usuario) {
        String sql = "update Usuario set dataNascimento = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getDataNascimento());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarUsuarioTelefone(Usuario usuario) {
        String sql = "update Usuario set telefone = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getTelefone());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarUsuarioEndereco(Usuario usuario) {
        String sql = "update Usuario set cpf = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getCpf());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public void alterarUsuarioTipoDeficiencia(Usuario usuario) {
        String sql = "update Usuario set tipoDeficiente = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getTipoDeficiencia());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public List<Usuario> listarUsuarios() {
        String sql = "Select * from Usuario";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("codigo"), rs.getString("nomelogin"));
                usuarios.add(usuario);
            }
        } catch (SQLException erro) {
            // TODO: handle exception
        }

        return usuarios;
    }

    public List<Usuario> pesquisarUsuario(String pesquisa) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pesquisa);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("codigo"), rs.getString("nomelogin"));
                usuarios.add(usuario);
            }
        } catch (SQLException erro) {
            // TODO: handle exception
        }
        return usuarios;

    }

    public void getInformacoesUsuario(Usuario usuario) {
        String sql = "Select * from Evento where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, usuario.getCodigo());
            rs = pstm.executeQuery();
            usuario.setEmail(rs.getString("email"));
            usuario.setNomeCompleto(rs.getString("nomeCompleto"));
            usuario.setCpf(rs.getString("cpf"));
            usuario.setDataNascimento("dataNascimento");
            usuario.setTelefone("telefone");
            usuario.setTipoDeficiencia("tipoDeficiencia");

        } catch (SQLException erro) {
            // TODO: handle exception
        }
    }

    public ResultSet authentificacaoUsuario(Usuario usuario) {
        String sql = "Select * from Usuario where email = ? and senha = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, usuario.getSenha());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            return null;
        }
    }
}
