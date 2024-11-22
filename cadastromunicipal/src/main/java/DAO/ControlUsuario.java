package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import DTO.Pessoa;
import DTO.Usuario;

public class ControlUsuario {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<Usuario> usuarios = new ArrayList<>();

    public ControlUsuario(Connection conn) {
        this.conn = conn;
    }

    public void adicionarUsuario(Pessoa pessoa) {
        String sqlUsuario = "INSERT INTO Usuario (nome_login, senha, email) VALUES (?, ?, ?)";
        String sqlUsuarioPcd = "INSERT INTO Usuario_Pcd (codigo_usuario, nomeCompleto, cpf, dataNascimento, tipoDeficiencia, endereco, ocupacao, genero, estadoCivil, grauDeficiencia, necessidadeAcompanhante, necessidadeEquipamento, necessidadeAdaptacao, necessidadeAdaptacaoLocalAtendimento, nivelEscolaridade, necessidadeEducacional, rendaFamiliarPCapita, programaAssistenciaSocial, historicoMedicoRelevante, usoMedicacao, participacaoCentroApoio, atendimentoEspecialista, telefone) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmUsuario = conn.prepareStatement(sqlUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmUsuario.setString(1, pessoa.getNomelogin());
            pstmUsuario.setString(2, pessoa.getSenha());
            pstmUsuario.setString(3, pessoa.getEmail());
            pstmUsuario.executeUpdate();

            ResultSet rs = pstmUsuario.getGeneratedKeys();
            int codigoUsuario = 0;
            if (rs.next()) {
                codigoUsuario = rs.getInt(1);
            }
            rs.close();
            pstmUsuario.close();

            PreparedStatement pstmUsuarioPcd = conn.prepareStatement(sqlUsuarioPcd);
            pstmUsuarioPcd.setInt(1, codigoUsuario); // Chave estrangeira
            pstmUsuarioPcd.setString(2, pessoa.getNomeCompleto());
            pstmUsuarioPcd.setString(3, pessoa.getCpf());
            pstmUsuarioPcd.setString(4, pessoa.getDataNascimento());
            pstmUsuarioPcd.setString(5, pessoa.getTipoDeficiencia());
            pstmUsuarioPcd.setString(6, pessoa.getEndereco());
            pstmUsuarioPcd.setString(7, pessoa.getOcupacao());
            pstmUsuarioPcd.setString(8, pessoa.getGenero());
            pstmUsuarioPcd.setString(9, pessoa.getEstadocivil());
            pstmUsuarioPcd.setString(10, pessoa.getGrauDeficiencia());
            pstmUsuarioPcd.setBoolean(11, pessoa.getNecessidadeAcompanhante());
            pstmUsuarioPcd.setBoolean(12, pessoa.getNecessidadeEquipamento());
            pstmUsuarioPcd.setBoolean(13, pessoa.getNecessidadeTransporteAdaptado());
            pstmUsuarioPcd.setBoolean(14, pessoa.getNecessidadeAdaptacaoLocalAtendimento());
            pstmUsuarioPcd.setString(15, pessoa.getNivelEscolaridade());
            pstmUsuarioPcd.setBoolean(16, pessoa.getNecessidadeApoioEducacional());
            pstmUsuarioPcd.setDouble(17, pessoa.getRendaFamiliarPCapita());
            pstmUsuarioPcd.setBoolean(18, pessoa.getProgramaAssistenciasocial());
            pstmUsuarioPcd.setString(19, pessoa.getHistoricoMedicoRelevante());
            pstmUsuarioPcd.setBoolean(20, pessoa.getUsoMedicacao());
            pstmUsuarioPcd.setBoolean(21, pessoa.getParticipaCentroApoio());
            pstmUsuarioPcd.setBoolean(22, pessoa.getAtendimentoEspecialista());
            pstmUsuarioPcd.setString(23, pessoa.getTelefone());

            pstmUsuarioPcd.execute();
            pstmUsuarioPcd.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void excluirUsuario(Pessoa usuario) {
        String sql = "delete from Usuario where codigo = ?";
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

    public void alterarUsuarioEnderecoComplemento(Pessoa usuario) {
        String sql = "update Usuario set EnderecoComplemento = ? where codigo = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getEndereco());
            pstm.setInt(2, usuario.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterarUsuarioTipoDeficiencia(Pessoa usuario) {
        String sql = "update Usuario set tipoDeficiente = ? where codigo = ?";
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

    public List<Usuario> listarUsuarios() {
        String sql = "Select * from Usuario";
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("codigo"), rs.getString("nomelogin"), rs.getString("email"));
                usuarios.add(usuario);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return usuarios;
    }

    public List<Usuario> pesquisarUsuario(String pesquisa) {
        String sql = "";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pesquisa);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("codigo"), rs.getString("nomelogin"), rs.getString("email"));
                usuarios.add(usuario);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return usuarios;

    }

    public Pessoa getInformacoesUsuario(String nomeLogin) {
        // SQL para pegar o código do usuário na tabela Usuario
        String sqlUsuario = "SELECT * FROM Usuario WHERE nome_login = ?";

        try {
            // Preparando a consulta para pegar os dados do usuário
            pstm = conn.prepareStatement(sqlUsuario);
            pstm.setString(1, nomeLogin); // Passando o nomeLogin para procurar os dados

            // Executa a consulta
            rs = pstm.executeQuery();

            // Verifica se o usuário foi encontrado na tabela Usuario
            if (rs.next()) {
                // Obtém os dados necessários do usuário
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                // Agora buscamos os dados na tabela Usuario_Pcd, utilizando o codigo
                int codigoUsuario = rs.getInt("codigo"); // Pega o código do usuário

                // SQL para pegar os dados do usuário na tabela Usuario_Pcd
                String sqlUsuarioPcd = "SELECT * FROM Usuario_Pcd WHERE codigo = ?";
                pstm = conn.prepareStatement(sqlUsuarioPcd);
                pstm.setInt(1, codigoUsuario); // Passa o código do usuário

                rs = pstm.executeQuery();

                // Verifica se o usuário foi encontrado na tabela Usuario_Pcd
                if (rs.next()) {
                    // Preenche os dados da classe Pessoa com os dados obtidos
                    String nomeCompleto = rs.getString("nomeCompleto");
                    String cpf = rs.getString("cpf");
                    String dataNascimento = rs.getString("dataNascimento");
                    String tipoDeficiencia = rs.getString("tipoDeficiencia");
                    String endereco = rs.getString("EnderecoBairro"); // Atributo de endereço
                    String ocupacao = rs.getString("ocupacao");
                    String genero = rs.getString("genero");
                    String estadocivil = rs.getString("estadoCivil");
                    String grauDeficiencia = rs.getString("grauDeficiencia");
                    boolean necessidadeAcompanhante = rs.getBoolean("necessidadeAcompanhante");
                    boolean necessidadeEquipamento = rs.getBoolean("necessidadeEquipamento");
                    boolean necessidadeTransporteAdaptado = rs.getBoolean("necessidadeTransporteAdaptado");
                    boolean necessidadeAdaptacaoLocalAtendimento = rs
                            .getBoolean("necessidadeAdaptacaoLocalAtendimento");
                    String nivelEscolaridade = rs.getString("nivelEscolaridade");
                    boolean necessidadeApoioEducacional = rs.getBoolean("necessidadeApoioEducacional");
                    double rendaFamiliarPCapita = rs.getDouble("rendaFamiliarPCapita");
                    boolean programaAssistenciasocial = rs.getBoolean("programaAssistenciasocial");
                    String historicoMedicoRelevante = rs.getString("historicoMedicoRelevante");
                    boolean usoMedicacao = rs.getBoolean("usoMedicacao");
                    boolean participaCentroApoio = rs.getBoolean("participaCentroApoio");
                    boolean atendimentoEspecialista = rs.getBoolean("atendimentoEspecialista");
                    String telefone = rs.getString("telefone");

                    // Agora criamos o objeto Pessoa com os dados recuperados
                    Pessoa usuario = new Pessoa(nomeLogin, email, senha, nomeCompleto, cpf, dataNascimento,
                            tipoDeficiencia,
                            endereco, ocupacao, genero, estadocivil, grauDeficiencia,
                            necessidadeAcompanhante, necessidadeEquipamento, necessidadeTransporteAdaptado,
                            necessidadeAdaptacaoLocalAtendimento, nivelEscolaridade, necessidadeApoioEducacional,
                            rendaFamiliarPCapita, programaAssistenciasocial, historicoMedicoRelevante, usoMedicacao,
                            participaCentroApoio, atendimentoEspecialista, telefone);

                    return usuario;
                } else {
                    System.out.println("Usuário não encontrado na tabela Usuario_Pcd.");
                    return null;
                }

            } else {
                System.out.println("Usuário não encontrado na tabela Usuario.");
                return null;
            }

        } catch (SQLException erro) {
            erro.printStackTrace();
            return null;
        }
    }

    public ResultSet authentificacaoUsuario(Usuario usuario) {
        String sql = "Select * from Usuario where email = ? and senha = ?";
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