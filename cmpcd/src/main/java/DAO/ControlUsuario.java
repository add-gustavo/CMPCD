package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import Connection.Conexao;
import DTO.Pessoa;

public class ControlUsuario {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<Pessoa> usuarios = new ArrayList<>();

    public void adicionarUsuario(Pessoa usuario) {
        String sql = "insert into Usuario (email, senha, nomelogin, nomeCompleto, dataNascimento, telefone, endereco, ocupacao, tipoDeficiencia, EnderecoBairro, Enderecorua, EnderecoNumeroRua, EnderecoComplemento) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, usuario.getSenha());
            pstm.setString(3, usuario.getNomelogin());
            pstm.setString(4, usuario.getNomeCompleto());
            pstm.setString(5, usuario.getDataNascimento());
            pstm.setString(6, usuario.getTelefone());
            pstm.setString(7, usuario.getTelefone());
            pstm.setString(8, usuario.getOcupacao());
            pstm.setString(9, usuario.getTipoDeficiencia());
            pstm.setString(10, usuario.getEnderecobairro());
            pstm.setString(11, usuario.getEnderecorua());
            pstm.setInt(12, usuario.getEndereconumeroCasa());
            pstm.setString(13, usuario.getEnderecocomplemento());

            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void excluirUsuario(Pessoa usuario) {
        String sql = "delete from Usuario where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioEmail(Pessoa usuario) {
        String sql = "update Usuario set email = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getEmail());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioNomelogin(Pessoa usuario) {
        String sql = "update Usuario set nomelogin = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNomelogin());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioSenha(Pessoa usuario) {
        String sql = "update Usuario set senha = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getSenha());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioNomeCompleto(Pessoa usuario) {
        String sql = "update Usuario set nomeCompleto = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNomeCompleto());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioDataNascimento(Pessoa usuario) {
        String sql = "update Usuario set dataNascimento = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getDataNascimento());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioTelefone(Pessoa usuario) {
        String sql = "update Usuario set telefone = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getTelefone());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioCpf(Pessoa usuario) {
        String sql = "update Usuario set cpf = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getCpf());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioOcupacao(Pessoa usuario) {
        String sql = "update Usuario set ocupacao = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getOcupacao());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioEnderecoRua(Pessoa usuario) {
        String sql = "update Usuario set EnderecoRua = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getEnderecorua());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioEnderecoBairro(Pessoa usuario) {
        String sql = "update Usuario set EnderecoBairro = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getEnderecobairro());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioEnderecoNumeroCasa(Pessoa usuario) {
        String sql = "update Usuario set EnderecoNumeroCasa = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, usuario.getEndereconumeroCasa());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioEnderecoComplemento(Pessoa usuario) {
        String sql = "update Usuario set EnderecoComplemento = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getEnderecocomplemento());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioTipoDeficiencia(Pessoa usuario) {
        String sql = "update Usuario set tipoDeficiente = ? where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getTipoDeficiencia());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public List<Pessoa> listarUsuarios() {
        String sql = "Select * from Usuario";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Pessoa usuario = new Pessoa(rs.getInt("codigo"), rs.getString("nomelogin"), rs.getString("email"));
                usuarios.add(usuario);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return usuarios;
    }

    public List<Pessoa> pesquisarUsuario(String pesquisa) {
        String sql = "";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pesquisa);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Pessoa usuario = new Pessoa(rs.getInt("codigo"), rs.getString("nomelogin"), rs.getString("email"));
                usuarios.add(usuario);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return usuarios;

    }

    public void getInformacoesUsuario(Pessoa usuario) {
        String sql = "Select * from Evento where codigo = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, usuario.getCodigo());
            rs = pstm.executeQuery();

            usuario.setNomeCompleto(rs.getString("nomeCompleto"));
            usuario.setCpf(rs.getString("cpf"));
            usuario.setDataNascimento(rs.getString("dataNascimento"));
            usuario.setTelefone(rs.getString("telefone"));
            usuario.setOcupacao(rs.getString("ocupacao"));
            usuario.setTipoDeficiencia(rs.getString("tipoDeficiencia"));
            usuario.setEnderecobairro(rs.getString("EnderecoBairro"));
            usuario.setEndereconumeroCasa(rs.getInt("EnderecoNumeroCasa"));
            usuario.setEnderecorua(rs.getString("EnderecoRua"));
            usuario.setEnderecocomplemento(rs.getString("EnderecoComplemento"));

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public ResultSet authentificacaoUsuario(Pessoa usuario) {
        String sql = "Select * from Usuario where email = ? and senha = ?";
        conn = new Conexao().connect();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, usuario.getSenha());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return null;
    }
}
