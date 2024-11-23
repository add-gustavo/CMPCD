package DAO;

import DTO.Usuario_PcdSocial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.cmpcd.dao.util.Conexao;

public class Usuario_PcdSocialDAO {
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

    // Método para inserir os dados sociais do usuário no banco de dados
    public void inserirUsuarioPcdSocial(Usuario_PcdSocial usuarioPcdSocial) throws SQLException {
        String sql = "INSERT INTO Usuarios_Pcd_Social (codigo_usuario, ocupacao, nivelEscolaridade, rendaFamiliarPcapita, programaAssistenciaSocial) VALUES (?, ?, ?, ?, ?)";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioPcdSocial.getCodigoUsuario());
            stmt.setString(2, usuarioPcdSocial.getOcupacao());
            stmt.setString(3, usuarioPcdSocial.getNivelEscolaridade());
            stmt.setDouble(4, usuarioPcdSocial.getRendaFamiliarPcapita());
            stmt.setString(5, usuarioPcdSocial.getProgramaAssistenciaSocial());

            stmt.executeUpdate();
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar os dados sociais do usuário pelo código de usuário
    public Usuario_PcdSocial buscarUsuarioPcdSocialPorCodigoUsuario(int codigoUsuario) throws SQLException {
        String sql = "SELECT * FROM Usuarios_Pcd_Social WHERE codigo_usuario = ?";
        Usuario_PcdSocial usuarioPcdSocial = null;
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigoUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuarioPcdSocial = new Usuario_PcdSocial(
                        rs.getInt("codigo_usuario"),
                        rs.getString("ocupacao"),
                        rs.getString("nivelEscolaridade"),
                        rs.getDouble("rendaFamiliarPcapita"),
                        rs.getString("programaAssistenciaSocial"));
            }
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarioPcdSocial;
    }

    // Método para atualizar os dados sociais de um usuário
    public void atualizarUsuarioPcdSocial(Usuario_PcdSocial usuarioPcdSocial) throws SQLException {
        String sql = "UPDATE Usuarios_Pcd_Social SET ocupacao = ?, nivelEscolaridade = ?, rendaFamiliarPcapita = ?, programaAssistenciaSocial = ? WHERE codigo_usuario = ?";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuarioPcdSocial.getOcupacao());
            stmt.setString(2, usuarioPcdSocial.getNivelEscolaridade());
            stmt.setDouble(3, usuarioPcdSocial.getRendaFamiliarPcapita());
            stmt.setString(4, usuarioPcdSocial.getProgramaAssistenciaSocial());
            stmt.setInt(5, usuarioPcdSocial.getCodigoUsuario());

            stmt.executeUpdate();
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
