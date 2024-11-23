package DAO;

import DTO.Usuario_PcdContato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.cmpcd.dao.util.Conexao;

public class Usuario_PcdContatoDAO {

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

    // Método para inserir um contato de usuário no banco de dados
    public void inserirContato(Usuario_PcdContato contato) throws SQLException {
        String sql = "INSERT INTO Usuarios_Pcd_Contato (codigo_usuario, telefone, endereco) VALUES (?, ?, ?)";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contato.getCodigoUsuario());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEndereco());
            stmt.executeUpdate();
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar um contato de usuário pelo código do usuário
    public Usuario_PcdContato buscarContatoPorCodigoUsuario(int codigoUsuario) throws SQLException {
        String sql = "SELECT * FROM Usuarios_Pcd_Contato WHERE codigo_usuario = ?";
        Usuario_PcdContato contato = null;
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigoUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                contato = new Usuario_PcdContato(
                        rs.getInt("codigo_usuario"),
                        rs.getString("telefone"),
                        rs.getString("endereco"));
            }
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contato;
    }

    // Método para atualizar os dados de contato de um usuário
    public void atualizarContato(Usuario_PcdContato contato) throws SQLException {
        String sql = "UPDATE Usuarios_Pcd_Contato SET telefone = ?, endereco = ? WHERE codigo_usuario = ?";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contato.getTelefone());
            stmt.setString(2, contato.getEndereco());
            stmt.setInt(3, contato.getCodigoUsuario());
            stmt.executeUpdate();
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um contato de usuário
}
