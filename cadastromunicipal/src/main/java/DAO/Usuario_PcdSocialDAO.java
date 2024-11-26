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

    public void inserirUsuarioPcdSocial(Usuario_PcdSocial usuarioPcdSocial) throws SQLException {
        String sql = "INSERT INTO Usuarios_Pcd_Social (codigo_usuario, ocupacao, nivelEscolaridade, rendaFamiliarPcapita, programaAssistenciaSocial) VALUES (?, ?, ?, ?, ?)";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioPcdSocial.getCodigoUsuario());
            stmt.setString(2, usuarioPcdSocial.getOcupacao());
            stmt.setString(3, usuarioPcdSocial.getNivelEscolaridade());
            stmt.setString(4, usuarioPcdSocial.getRendaFamiliarPcapita());
            stmt.setString(5, usuarioPcdSocial.getProgramaAssistenciaSocial());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Desconectar();

        }
    }

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
                        rs.getString("rendaFamiliarPcapita"),
                        rs.getString("programaAssistenciaSocial"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Desconectar();

        }
        return usuarioPcdSocial;
    }

    public void atualizarUsuarioPcdSocial(Usuario_PcdSocial usuarioPcdSocial) throws SQLException {
        String sql = "UPDATE Usuarios_Pcd_Social SET ocupacao = ?, nivelEscolaridade = ?, rendaFamiliarPcapita = ?, programaAssistenciaSocial = ? WHERE codigo_usuario = ?";
        Conectar();
        try {
            conn.setAutoCommit(false);

            String checkUserExistSql = "SELECT COUNT(*) FROM Usuarios_Pcd WHERE codigo = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkUserExistSql)) {
                checkStmt.setInt(1, usuarioPcdSocial.getCodigoUsuario());
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    throw new SQLException("Usuário não encontrado.");
                }
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, usuarioPcdSocial.getOcupacao());
                stmt.setString(2, usuarioPcdSocial.getNivelEscolaridade());
                stmt.setString(3, usuarioPcdSocial.getRendaFamiliarPcapita());
                stmt.setString(4, usuarioPcdSocial.getProgramaAssistenciaSocial());
                stmt.setInt(5, usuarioPcdSocial.getCodigoUsuario());

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    conn.commit();
                } else {
                    throw new SQLException("Nenhuma linha afetada.");
                }
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
                Desconectar();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
