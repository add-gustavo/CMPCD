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

    public void cadastrarUsuarioPcd(Responsavel responsavel, Usuario_Pcd usuario_Pcd,
            Usuario_PcdContato usuario_PcdContato, Usuario_PcdDeficiencia usuario_PcdDeficiencia,
            Usuario_PcdMedico usuario_PcdMedico, Usuario_PcdSocial usuario_PcdSocial) throws SQLException {

        Conectar();
        try {
            conn.setAutoCommit(false); // Desabilita o commit automático

            // Insere o usuário PCD e captura o código gerado
            usuario_PcdDAO.inserirUsuarioPcd(usuario_Pcd);
            Usuario_Pcd usuario_PcdWcodigo = usuario_PcdDAO.buscarUsuarioPorNomeLogin(usuario_Pcd.getNomeLogin());

            // Agora, insere os dados nas tabelas dependentes passando o código do usuário
            usuario_PcdContato.setCodigoUsuario(usuario_PcdWcodigo.getCodigo());
            usuario_PcdContatoDAO.inserirContato(usuario_PcdContato);

            usuario_PcdDeficiencia.setCodigoUsuario(usuario_PcdWcodigo.getCodigo());
            usuario_PcdDeficienciaDAO.inserirDeficiencia(usuario_PcdDeficiencia);

            usuario_PcdMedico.setCodigoUsuario(usuario_PcdWcodigo.getCodigo());
            usuario_PcdMedicoDAO.inserirHistoricoMedico(usuario_PcdMedico);

            usuario_PcdSocial.setCodigoUsuario(usuario_PcdWcodigo.getCodigo());
            usuario_PcdSocialDAO.inserirUsuarioPcdSocial(usuario_PcdSocial);

            // Insere o responsável do usuário PCD
            responsavel.setCodigoUsuario(usuario_PcdWcodigo.getCodigo()); // Associa o código do usuário ao responsável
            responsavelDAO.inserirResponsavel(responsavel);

            // Se tudo ocorreu bem, realiza o commit
            conn.commit();
            Desconectar();
        } catch (SQLException e) {
            // Se ocorrer qualquer erro, faz rollback das ações realizadas
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Erro na transação. Rollback realizado.");
                }
            } catch (SQLException rollbackEx) {
                System.out.println("Erro ao realizar rollback: " + rollbackEx.getMessage());
            }
            // Exibe o erro que ocorreu durante a transação
            System.out.println("Erro durante a transação: " + e.getMessage());
        } finally {
            try {
                // Restaura o commit automático
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Erro ao restaurar commit automático: " + e.getMessage());
            }
        }
    }

    public UsuarioPcdInfo InformaçoesUsuarioPcd(String usuario) throws SQLException {

        Usuario_Pcd usuario_Pcd = usuario_PcdDAO.buscarUsuarioPorNomeLogin(usuario);
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
