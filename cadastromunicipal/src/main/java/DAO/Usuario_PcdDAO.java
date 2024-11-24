package DAO;

import DTO.Usuario_Pcd;
import java.sql.*;

import com.br.cmpcd.dao.util.Conexao;

public class Usuario_PcdDAO {
    private Connection conn;

    private void Conectar() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = Conexao.getConexao();
        }
    }

    private void Desconectar() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    // Método para inserir um usuário
    public void inserirUsuarioPcd(Usuario_Pcd usuarioPcd) throws SQLException {
        String sql = "INSERT INTO Usuarios_Pcd (nomeCompleto, cpf, dataNascimento, sexo, estadoCivil, nome_login, senha, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuarioPcd.getNomeCompleto());
            stmt.setString(2, usuarioPcd.getCpf());
            stmt.setDate(3, usuarioPcd.getDataNascimento());
            stmt.setString(4, usuarioPcd.getSexo());
            stmt.setString(5, usuarioPcd.getEstadoCivil());
            stmt.setString(6, usuarioPcd.getNomeLogin());
            stmt.setString(7, usuarioPcd.getSenha());
            stmt.setString(8, usuarioPcd.getEmail());
            stmt.executeUpdate();
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar um usuário pelo nome de login
    public Usuario_Pcd buscarUsuarioPorNomeLogin(String nomeLogin) throws SQLException {
        String sql = "SELECT * FROM Usuarios_Pcd WHERE nome_login = ?";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeLogin);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nomeCompleto = rs.getString("nomeCompleto");
                String cpf = rs.getString("cpf");
                Date dataNascimento = rs.getDate("dataNascimento");
                String sexo = rs.getString("sexo");
                String estadoCivil = rs.getString("estadoCivil");
                String senha = rs.getString("senha");
                String email = rs.getString("email");

                Desconectar();
                return new Usuario_Pcd(codigo, nomeCompleto, cpf, dataNascimento, sexo, estadoCivil, nomeLogin, senha,
                        email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null se o usuário não for encontrado
    }

    public Usuario_Pcd buscarUsuarioPorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Usuarios_Pcd WHERE email = ?";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nomeCompleto = rs.getString("nomeCompleto");
                String cpf = rs.getString("cpf");
                Date dataNascimento = rs.getDate("dataNascimento");
                String sexo = rs.getString("sexo");
                String estadoCivil = rs.getString("estadoCivil");
                String senha = rs.getString("senha");
                String nomeLogin = rs.getString("nome_login");

                Desconectar();
                return new Usuario_Pcd(codigo, nomeCompleto, cpf, dataNascimento, sexo, estadoCivil, nomeLogin, senha,
                        email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null se o usuário não for encontrado
    }

    // Método para atualizar os dados de um usuário
    public void atualizarUsuarioPcd(Usuario_Pcd usuarioPcd) throws SQLException {
        System.out.println("Método atualizarUsuarioPcd chamado para o usuário: " + usuarioPcd.getCodigo());

        String sql = "UPDATE Usuarios_Pcd SET nomeCompleto = ?, cpf = ?, dataNascimento = ?, sexo = ?, estadoCivil = ?, nome_login = ? WHERE codigo = ?";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuarioPcd.getNomeCompleto());
            stmt.setString(2, usuarioPcd.getCpf());
            stmt.setDate(3, usuarioPcd.getDataNascimento());
            stmt.setString(4, usuarioPcd.getSexo());
            stmt.setString(5, usuarioPcd.getEstadoCivil());
            stmt.setString(6, usuarioPcd.getNomeLogin());
            stmt.setInt(7, usuarioPcd.getCodigo());
            stmt.executeUpdate();
            System.out.println("Atualização realizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar usuário: " + e.getMessage());
        } finally {
            Desconectar();
        }
    }

    // Método para excluir um usuário
    public Boolean excluirUsuarioPcd(String email) throws SQLException {
        String sql = "DELETE FROM Usuarios_Pcd WHERE email = ?";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.executeUpdate();
            Desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean autentificacaoUsuario(Usuario_Pcd usuario_Pcd) throws SQLException {
        String sql = "SELECT * FROM Usuarios_Pcd WHERE email = ? AND senha = ?";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario_Pcd.getEmail());
            stmt.setString(2, usuario_Pcd.getSenha());

            ResultSet rs = stmt.executeQuery();
            Desconectar();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao realizar autenticação: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
