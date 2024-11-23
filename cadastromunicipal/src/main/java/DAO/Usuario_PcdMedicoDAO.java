
package DAO;

import DTO.Usuario_PcdMedico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.cmpcd.dao.util.Conexao;

public class Usuario_PcdMedicoDAO {
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

    // Método para inserir o histórico médico de um usuário no banco de dados
    public void inserirHistoricoMedico(Usuario_PcdMedico medico) throws SQLException {
        String sql = "INSERT INTO Usuarios_Pcd_Medico (codigo_usuario, historicoMedicoRelevante, usoMedicacao, explicacao_uso_medicacao, atendimentoEspecialista, explicacao_atendimento_especialista, participacaoCentroApoio, explicacao_participacao_centro_apoio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, medico.getCodigoUsuario());
            stmt.setString(2, medico.getHistoricoMedicoRelevante());
            stmt.setBoolean(3, medico.isUsoMedicacao());
            stmt.setString(4, medico.getExplicacaoUsoMedicacao());
            stmt.setBoolean(5, medico.isAtendimentoEspecialista());
            stmt.setString(6, medico.getExplicacaoAtendimentoEspecialista());
            stmt.setBoolean(7, medico.isParticipacaoCentroApoio());
            stmt.setString(8, medico.getExplicacaoParticipacaoCentroApoio());

            stmt.executeUpdate();
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar o histórico médico de um usuário pelo código do usuário
    public Usuario_PcdMedico buscarHistoricoMedicoPorCodigoUsuario(int codigoUsuario) throws SQLException {
        String sql = "SELECT * FROM Usuarios_Pcd_Medico WHERE codigo_usuario = ?";
        Usuario_PcdMedico medico = null;
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigoUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                medico = new Usuario_PcdMedico(
                        rs.getInt("codigo_usuario"),
                        rs.getString("historicoMedicoRelevante"),
                        rs.getBoolean("usoMedicacao"),
                        rs.getString("explicacao_uso_medicacao"),
                        rs.getBoolean("atendimentoEspecialista"),
                        rs.getString("explicacao_atendimento_especialista"),
                        rs.getBoolean("participacaoCentroApoio"),
                        rs.getString("explicacao_participacao_centro_apoio"));
            }
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }

    // Método para atualizar o histórico médico de um usuário
    public void atualizarHistoricoMedico(Usuario_PcdMedico medico) throws SQLException {
        String sql = "UPDATE Usuarios_Pcd_Medico SET historicoMedicoRelevante = ?, usoMedicacao = ?, explicacao_uso_medicacao = ?, atendimentoEspecialista = ?, explicacao_atendimento_especialista = ?, participacaoCentroApoio = ?, explicacao_participacao_centro_apoio = ? WHERE codigo_usuario = ?";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getHistoricoMedicoRelevante());
            stmt.setBoolean(2, medico.isUsoMedicacao());
            stmt.setString(3, medico.getExplicacaoUsoMedicacao());
            stmt.setBoolean(4, medico.isAtendimentoEspecialista());
            stmt.setString(5, medico.getExplicacaoAtendimentoEspecialista());
            stmt.setBoolean(6, medico.isParticipacaoCentroApoio());
            stmt.setString(7, medico.getExplicacaoParticipacaoCentroApoio());
            stmt.setInt(8, medico.getCodigoUsuario());

            stmt.executeUpdate();
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}