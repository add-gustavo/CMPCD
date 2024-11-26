package Control;

import java.sql.Connection;
import java.sql.SQLException;

import com.br.cmpcd.dao.util.Conexao;

import DAO.ResponsavelDAO;
import DAO.Usuario_PcdContatoDAO;
import DAO.Usuario_PcdDAO;
import DAO.Usuario_PcdDeficienciaDAO;
import DAO.Usuario_PcdMedicoDAO;
import DAO.Usuario_PcdSocialDAO;
import DTO.Responsavel;
import DTO.UsuarioPcdInfo;
import DTO.Usuario_Pcd;
import DTO.Usuario_PcdContato;
import DTO.Usuario_PcdDeficiencia;
import DTO.Usuario_PcdMedico;
import DTO.Usuario_PcdSocial;

public class ControleUsuarioPcd {

    private ResponsavelDAO responsavelDAO = new ResponsavelDAO();
    private Usuario_PcdContatoDAO usuario_PcdContatoDAO = new Usuario_PcdContatoDAO();
    private Usuario_PcdDAO usuario_PcdDAO = new Usuario_PcdDAO();
    private Usuario_PcdDeficienciaDAO usuario_PcdDeficienciaDAO = new Usuario_PcdDeficienciaDAO();
    private Usuario_PcdMedicoDAO usuario_PcdMedicoDAO = new Usuario_PcdMedicoDAO();
    private Usuario_PcdSocialDAO usuario_PcdSocialDAO = new Usuario_PcdSocialDAO();
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

    public void cadastrarUsuarioPcd(UsuarioPcdInfo usuarioPcdInfo) throws SQLException {

        Conectar();
        try {
            conn.setAutoCommit(false);

            usuario_PcdDAO.inserirUsuarioPcd(usuarioPcdInfo.getUsuarioPcd());
            Usuario_Pcd usuario_PcdWcodigo = usuario_PcdDAO
                    .buscarUsuarioPorEmail(usuarioPcdInfo.getUsuarioPcd().getEmail());

            Usuario_PcdContato usuario_PcdContato = usuarioPcdInfo.getContato();
            usuario_PcdContato.setCodigoUsuario(usuario_PcdWcodigo.getCodigo());
            usuario_PcdContatoDAO.inserirContato(usuario_PcdContato);

            Usuario_PcdDeficiencia usuario_PcdDeficiencia = usuarioPcdInfo.getDeficiencia();
            usuario_PcdDeficiencia.setCodigoUsuario(usuario_PcdWcodigo.getCodigo());
            usuario_PcdDeficienciaDAO.inserirDeficiencia(usuario_PcdDeficiencia);

            Usuario_PcdMedico usuario_PcdMedico = usuarioPcdInfo.getMedico();
            usuario_PcdMedico.setCodigoUsuario(usuario_PcdWcodigo.getCodigo());
            usuario_PcdMedicoDAO.inserirHistoricoMedico(usuario_PcdMedico);

            Usuario_PcdSocial usuario_PcdSocial = usuarioPcdInfo.getSocial();
            usuario_PcdSocial.setCodigoUsuario(usuario_PcdWcodigo.getCodigo());
            usuario_PcdSocialDAO.inserirUsuarioPcdSocial(usuario_PcdSocial);

            Responsavel responsavel = usuarioPcdInfo.getResponsavel();
            responsavel.setCodigoUsuario(usuario_PcdWcodigo.getCodigo());
            responsavelDAO.inserirResponsavel(responsavel);

            conn.commit();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Erro na transação. Rollback realizado.");
                }
            } catch (SQLException rollbackEx) {
                System.out.println("Erro ao realizar rollback: " + rollbackEx.getMessage());
            }
            System.out.println("Erro durante a transação: " + e.getMessage());
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Erro ao restaurar commit automático: " + e.getMessage());
            }
            Desconectar();
        }
    }

    public UsuarioPcdInfo InformacoesUsuarioPcd(Usuario_Pcd usuario) throws SQLException {

        Usuario_Pcd usuario_Pcd = usuario_PcdDAO.buscarUsuarioPorEmail(usuario.getEmail());
        int codigo_usuario = usuario_Pcd.getCodigo();
        Usuario_PcdContato contato = usuario_PcdContatoDAO.buscarContatoPorCodigoUsuario(codigo_usuario);
        Usuario_PcdDeficiencia deficiencia = usuario_PcdDeficienciaDAO
                .buscarDeficienciaPorCodigoUsuario(codigo_usuario);
        Usuario_PcdMedico medico = usuario_PcdMedicoDAO.buscarHistoricoMedicoPorCodigoUsuario(codigo_usuario);
        Usuario_PcdSocial social = usuario_PcdSocialDAO.buscarUsuarioPcdSocialPorCodigoUsuario(codigo_usuario);
        Responsavel responsavel = responsavelDAO.buscarResponsavelPorCodigoUsuario(codigo_usuario);
        UsuarioPcdInfo info = new UsuarioPcdInfo(usuario_Pcd, contato, deficiencia, medico, social, responsavel);

        return info;
    }

}
