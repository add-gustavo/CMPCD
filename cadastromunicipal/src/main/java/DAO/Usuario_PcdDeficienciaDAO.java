package DAO;

import DTO.Usuario_PcdDeficiencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.cmpcd.dao.util.Conexao;

public class Usuario_PcdDeficienciaDAO {
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

    // Método para inserir a deficiência de um usuário no banco de dados
    public void inserirDeficiencia(Usuario_PcdDeficiencia deficiencia) throws SQLException {
        String sql = "INSERT INTO Usuarios_Pcd_Deficiencia (codigo_usuario, tipoDeficiencia, necessidadeAcompanhante, necessidadeEquipamento, explicacao_necessidade_equipamento, necessidadeAdaptacao, explicacao_necessidade_adaptacao, necessidadeAdaptacaoLocalAtendimento, explicacao_necessidade_adaptacao_local_atendimento, necessidadeEducacional) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, deficiencia.getCodigoUsuario());
            stmt.setString(2, deficiencia.getTipoDeficiencia());
            stmt.setBoolean(3, deficiencia.isNecessidadeAcompanhante());
            stmt.setBoolean(4, deficiencia.isNecessidadeEquipamento());
            stmt.setString(5, deficiencia.getExplicacaoNecessidadeEquipamento());
            stmt.setBoolean(6, deficiencia.isNecessidadeAdaptacao());
            stmt.setString(7, deficiencia.getExplicacaoNecessidadeAdaptacao());
            stmt.setBoolean(8, deficiencia.isNecessidadeAdaptacaoLocalAtendimento());
            stmt.setString(9, deficiencia.getExplicacaoNecessidadeAdaptacaoLocalAtendimento());
            stmt.setString(10, deficiencia.getNecessidadeEducacional());

            stmt.executeUpdate();
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar a deficiência de um usuário pelo código do usuário
    public Usuario_PcdDeficiencia buscarDeficienciaPorCodigoUsuario(int codigoUsuario) throws SQLException {
        String sql = "SELECT * FROM Usuarios_Pcd_Deficiencia WHERE codigo_usuario = ?";
        Usuario_PcdDeficiencia deficiencia = null;
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigoUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                deficiencia = new Usuario_PcdDeficiencia(
                        rs.getInt("codigo_usuario"),
                        rs.getString("tipoDeficiencia"),
                        rs.getBoolean("necessidadeAcompanhante"),
                        rs.getBoolean("necessidadeEquipamento"),
                        rs.getString("explicacao_necessidade_equipamento"),
                        rs.getBoolean("necessidadeAdaptacao"),
                        rs.getString("explicacao_necessidade_adaptacao"),
                        rs.getBoolean("necessidadeAdaptacaoLocalAtendimento"),
                        rs.getString("explicacao_necessidade_adaptacao_local_atendimento"),
                        rs.getString("necessidadeEducacional"));
            }
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deficiencia;
    }

    // Método para atualizar os dados da deficiência de um usuário
    public void atualizarDeficiencia(Usuario_PcdDeficiencia deficiencia) throws SQLException {
        String sql = "UPDATE usuario_pcd_deficiencia SET tipoDeficiencia = ?, necessidadeAcompanhante = ?, necessidadeEquipamento = ?, explicacao_necessidade_equipamento = ?, necessidadeAdaptacao = ?, explicacao_necessidade_adaptacao = ?, necessidadeAdaptacaoLocalAtendimento = ?, explicacao_necessidade_adaptacao_local_atendimento = ?, necessidadeEducacional = ? WHERE codigo_usuario = ?";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, deficiencia.getTipoDeficiencia());
            stmt.setBoolean(2, deficiencia.isNecessidadeAcompanhante());
            stmt.setBoolean(3, deficiencia.isNecessidadeEquipamento());
            stmt.setString(4, deficiencia.getExplicacaoNecessidadeEquipamento());
            stmt.setBoolean(5, deficiencia.isNecessidadeAdaptacao());
            stmt.setString(6, deficiencia.getExplicacaoNecessidadeAdaptacao());
            stmt.setBoolean(7, deficiencia.isNecessidadeAdaptacaoLocalAtendimento());
            stmt.setString(8, deficiencia.getExplicacaoNecessidadeAdaptacaoLocalAtendimento());
            stmt.setString(9, deficiencia.getNecessidadeEducacional());
            stmt.setInt(10, deficiencia.getCodigoUsuario());

            stmt.executeUpdate();
            Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
