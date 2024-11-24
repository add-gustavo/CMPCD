package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.cmpcd.dao.util.Conexao;

public class RelatorioDAO {

    Connection conn;

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

    public List<Object[]> getDadosTipoDeficiencia() throws SQLException {
        List<Object[]> dados = new ArrayList<>();
        String sql = "SELECT tipoDeficiencia, COUNT(*) AS quantidade FROM Usuarios_Pcd_Deficiencia GROUP BY tipoDeficiencia";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] registro = new Object[2];
                registro[0] = rs.getString("tipoDeficiencia");
                registro[1] = rs.getInt("quantidade");
                dados.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Desconectar();
        }
        return dados;
    }

    public List<Object[]> getPorcentagemDeficientesPorSexo() throws SQLException {
        List<Object[]> dados = new ArrayList<>();
        String sql = "SELECT sexo,(COUNT(*) * 100.0 / (SELECT COUNT(*) FROM Usuarios_Pcd)) AS porcentagem FROM Usuarios_Pcd GROUP BY sexo;";
        Conectar();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] registro = new Object[2];
                registro[0] = rs.getString("sexo");
                registro[1] = rs.getDouble("porcentagem");
                dados.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Desconectar();
        }
        return dados;
    }
}
