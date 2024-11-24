package com.br.cmpcd;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Control.ControleUsuarioPcd;
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

public class ControleUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao == null || acao.isEmpty()) {
            response.sendRedirect("erro.html"); // ou redirecionar para uma página de erro ou login
            return;
        }
        try {
            switch (acao) {

                case "atualizar-perfil":
                    paginaPerfil(request, response);
                    break;

                default:
                    break;
            }
        } catch (ServletException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao == null || acao.isEmpty()) {
            response.sendRedirect("erro.html"); // ou redirecionar para uma página de erro ou login
            return;
        }

        try {
            switch (acao) {

                case "fazer-login":
                    fazerLogin(request, response);
                    break;

                case "fazer-cadastro":
                    novoUsuarioPCD(request, response);
                    break;

                case "excluir-conta":
                    excluirConta(request, response);
                    break;
                case "atualizar-dadospessoais":
                    AtualizarDadosUsuario_Pcd(request, response);
                    break;
                case "atualizar-dadoscontato":
                    AtualizarDadosUsuario_PcdContato(request, response);
                    break;
                case "atualizar-dadosmedicos":
                    AtualizarDadosUsuario_PcdMedico(request, response);
                    break;
                case "atualizar-dadosdeficiencia":
                    AtualizarDadosUsuario_PcdDeficiencia(request, response);
                    break;
                case "atualizar-dadosreponsavel":
                    AtualizarDadosUsuario_PcdResponsavel(request, response);
                    break;
                case "atualizar-dadossociais":
                    AtualizarDadosUsuario_PcdSocial(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void AtualizarDadosUsuario_Pcd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formato da data esperado no HTML
            Date dataNascimento = null;
            try {
                java.util.Date utilDate = sdf.parse(request.getParameter("dataNascimento"));
                dataNascimento = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                System.out.println("Erro ao converter a data de nascimento: " + e.getMessage());
            }

            Usuario_Pcd usuario_Pcd = new Usuario_Pcd(Integer.parseInt(request.getParameter("codigo")),
                    request.getParameter("nomecompleto"),
                    request.getParameter("cpf"),
                    dataNascimento,
                    request.getParameter("sexo"),
                    request.getParameter("estadoCivil"),
                    request.getParameter("nomelogin"));
            System.out.println(usuario_Pcd.codigo + usuario_Pcd.cpf + usuario_Pcd.dataNascimento + usuario_Pcd.sexo
                    + usuario_Pcd.estadoCivil + usuario_Pcd.nomeLogin);

            Usuario_PcdDAO usuario_PcdDAO = new Usuario_PcdDAO();
            usuario_PcdDAO.atualizarUsuarioPcd(usuario_Pcd);
            paginaPerfil(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao atualizar o usuário: " + e.getMessage());
            request.getRequestDispatcher("/inicial.jsp").forward(request, response);
        }

    }

    private void AtualizarDadosUsuario_PcdContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {

            Usuario_PcdContato usuario_PcdContato = new Usuario_PcdContato(
                    Integer.parseInt(request.getParameter("codigo")),
                    request.getParameter("telefone"),
                    request.getParameter("endereco"));
            Usuario_PcdContatoDAO usuario_PcdContatoDAO = new Usuario_PcdContatoDAO();
            usuario_PcdContatoDAO.atualizarContato(usuario_PcdContato);
            System.out.println(usuario_PcdContato.getEndereco());
            paginaPerfil(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao atualizar o usuário: " + e.getMessage());
            request.getRequestDispatcher("/inicial.jsp").forward(request, response);
        }

    }

    private void AtualizarDadosUsuario_PcdMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            Usuario_PcdMedico usuario_PcdMedico = new Usuario_PcdMedico(
                    Integer.parseInt(request.getParameter("codigo")),
                    request.getParameter("historicoMedico"),
                    Boolean.parseBoolean(request.getParameter("usoMedicacao")),
                    request.getParameter("explicacaoUsoMedicacao"),
                    Boolean.parseBoolean(request.getParameter("fazAtendimentoEspecialista")),
                    request.getParameter("explicacaoAtendimentoEspecialista"),
                    Boolean.parseBoolean(request.getParameter("participaCentroApoio")),
                    request.getParameter("explicacaoParticipacaoCentroApoio"));
            Usuario_PcdMedicoDAO usuario_PcdMedicoDAO = new Usuario_PcdMedicoDAO();
            usuario_PcdMedicoDAO.atualizarHistoricoMedico(usuario_PcdMedico);
            paginaPerfil(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao atualizar o usuário: " + e.getMessage());
            request.getRequestDispatcher("/inicial.jsp").forward(request, response);
        }

    }

    private void AtualizarDadosUsuario_PcdDeficiencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            Usuario_PcdDeficiencia usuario_PcdDeficiencia = new Usuario_PcdDeficiencia(
                    Integer.parseInt(request.getParameter("codigo")),
                    request.getParameter("tipoDeficiencia"),
                    Boolean.parseBoolean(request.getParameter("necessidadeAcompanhante")), // Convertendo para boolean
                    Boolean.parseBoolean(request.getParameter("necessidadeEquipamento")),
                    request.getParameter("explicacaoNecessidadeEquipamento"),
                    Boolean.parseBoolean(request.getParameter("necessidadeTransporteAdaptado")),
                    request.getParameter("explicacaoNecessidadeAdaptacao"),
                    Boolean.parseBoolean(request.getParameter("necessidadeAdaptacaoLocalAtendimento")),
                    request.getParameter("explicacaoNecessidadeAdaptacaoLocalAtendimento"),
                    Boolean.parseBoolean("necessidadeApoioEducacional"),
                    request.getParameter("necessidadeEducacional"));

            System.out.println("no servlet" + usuario_PcdDeficiencia.getNecessidadeEducacional());

            Usuario_PcdDeficienciaDAO usuario_PcdDeficienciaDAO = new Usuario_PcdDeficienciaDAO();
            usuario_PcdDeficienciaDAO.atualizarDeficiencia(usuario_PcdDeficiencia);
            paginaPerfil(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao atualizar o usuário: " + e.getMessage());
            request.getRequestDispatcher("/inicial.jsp").forward(request, response);
        }

    }

    private void AtualizarDadosUsuario_PcdResponsavel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            Responsavel responsavel = new Responsavel(Integer.parseInt(request.getParameter("codigo")),
                    request.getParameter("nomecompletoResponsavel"),
                    request.getParameter("telefoneResponsavel"),
                    request.getParameter("emailResponsavel"),
                    request.getParameter("enderecoResponsavel"));
            System.out.println(responsavel.getEmail() + responsavel.getNomeCompleto() + responsavel.getEndereco());

            ResponsavelDAO responsavelDAO = new ResponsavelDAO();
            responsavelDAO.atualizarResponsavel(responsavel);
            paginaPerfil(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao atualizar o usuário: " + e.getMessage());
            request.getRequestDispatcher("/inicial.jsp").forward(request, response);
        }

    }

    private void AtualizarDadosUsuario_PcdSocial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            Usuario_PcdSocial usuario_PcdSocial = new Usuario_PcdSocial(
                    Integer.parseInt(request.getParameter("codigo")),
                    request.getParameter("ocupacao"),
                    request.getParameter("nivelEscolaridade"),
                    Double.parseDouble(request.getParameter("rendaFamiliarPCapita")), // Converte para double
                    request.getParameter("programaAssistenciaSocial"));

            Usuario_PcdSocialDAO usuario_PcdSocialDAO = new Usuario_PcdSocialDAO();
            usuario_PcdSocialDAO.atualizarUsuarioPcdSocial(usuario_PcdSocial);
            paginaPerfil(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao atualizar o usuário: " + e.getMessage());
            request.getRequestDispatcher("/inicial.jsp").forward(request, response);
        }

    }

    private void fazerLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        Usuario_Pcd usuario_Pcd = new Usuario_Pcd(request.getParameter("email"), request.getParameter("senha"));
        Usuario_PcdDAO usuario_PcdDAO = new Usuario_PcdDAO();

        Boolean acesso = usuario_PcdDAO.autentificacaoUsuario(usuario_Pcd);
        System.out.println(usuario_Pcd.getEmail() + usuario_Pcd.getSenha());

        if (acesso) {
            // Verificar se o usuário existe no banco
            Usuario_Pcd usuario = usuario_PcdDAO.buscarUsuarioPorEmail(usuario_Pcd.getEmail());
            if (usuario != null) {
                System.out.println("Usuário: " + usuario.getNomeLogin());
                HttpSession session = request.getSession();
                session.setAttribute("usuarioPcd", usuario);
                response.sendRedirect(request.getContextPath() + "/inicial.jsp");
            } else {
                // Se não encontrar o usuário, retorna erro
                request.setAttribute("erro", "Erro ao buscar o usuário.");
                request.getRequestDispatcher("/pagina/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("erro", "Email ou senha inválidos.");
            request.getRequestDispatcher("/pagina/login.jsp").forward(request, response);
        }
    }

    private void excluirConta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario_Pcd usuario_Pcd = new Usuario_Pcd(email, senha);
        Usuario_PcdDAO usuario_PcdDAO = new Usuario_PcdDAO();

        Boolean acesso = usuario_PcdDAO.autentificacaoUsuario(usuario_Pcd);

        if (acesso) {
            boolean excluido = usuario_PcdDAO.excluirUsuarioPcd(email);

            if (excluido) {
                // Excluir a sessão ativa (logout implícito)
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.invalidate();
                }

                // Criar uma nova sessão e adicionar mensagem de sucesso
                HttpSession novaSessao = request.getSession(true);
                novaSessao.setAttribute("sucesso", "Conta excluída com sucesso!");

                // Redirecionar para a página inicial
                response.sendRedirect(request.getContextPath() + "/inicial.jsp");
            } else {
                request.setAttribute("erro", "Erro ao excluir a conta. Tente novamente.");
                request.getRequestDispatcher("/pagina/authenticacao.jsp").forward(request, response);
            }
        } else {
            // Redireciona para a página de autenticação com erro
            request.setAttribute("erro", "Email ou senha inválidos");
            request.getRequestDispatcher("/pagina/authenticacao.jsp").forward(request, response);
        }
    }

    private void paginaPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        ControleUsuarioPcd controleUsuarioPcd = new ControleUsuarioPcd();

        // Obtém o nome de login do usuário (pode vir da URL, do formulário ou da
        // sessão)
        HttpSession session = request.getSession();
        Usuario_Pcd usuarioPcd = (Usuario_Pcd) session.getAttribute("usuarioPcd"); // Caso esteja armazenado na sessão

        // Chama o método para obter as informações do usuário
        UsuarioPcdInfo info = controleUsuarioPcd.InformacoesUsuarioPcd(usuarioPcd);

        // Obtém os dados do perfil
        Usuario_Pcd usuarioPcdData = info.getUsuarioPcd();
        Usuario_PcdContato contato = info.getContato();
        Usuario_PcdDeficiencia deficiencia = info.getDeficiencia();
        Usuario_PcdMedico medico = info.getMedico();
        Usuario_PcdSocial social = info.getSocial();
        Responsavel responsavel = info.getResponsavel();

        System.out.println(deficiencia.getNecessidadeEducacional());

        System.out.println(usuarioPcd.getSexo() + usuarioPcdData.getCodigo() + " " + contato.getCodigoUsuario() + " "
                + deficiencia.getCodigoUsuario() + " " + medico.getCodigoUsuario() + " " + social.getCodigoUsuario()
                + " " + responsavel.getCodigoUsuario());
        System.out.println(responsavel.getEmail() + responsavel.getNomeCompleto() + responsavel.getEndereco()
                + responsavel.getTelefone());
        // Verifica se os objetos não são nulos antes de adicionar à sessão
        if (usuarioPcdData != null) {
            session.setAttribute("usuarioPcd", usuarioPcdData);
        }
        if (contato != null) {
            session.setAttribute("contato", contato);
        }
        if (deficiencia != null) {
            session.setAttribute("deficiencia", deficiencia);
        }
        if (medico != null) {
            session.setAttribute("medico", medico);
        }
        if (social != null) {
            session.setAttribute("social", social);
        }
        if (responsavel != null) {
            session.setAttribute("responsavel", responsavel);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/perfil.jsp");
        dispatcher.forward(request, response);
    }

    private void novoUsuarioPCD(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formato da data esperado no HTML
            Date dataNascimento = null;
            try {
                java.util.Date utilDate = sdf.parse(request.getParameter("dataNascimento"));
                dataNascimento = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                System.out.println("Erro ao converter a data de nascimento: " + e.getMessage());
            }

            Usuario_Pcd usuario_Pcd = new Usuario_Pcd(
                    request.getParameter("nomecompleto"),
                    request.getParameter("cpf"),
                    dataNascimento,
                    request.getParameter("sexo"),
                    request.getParameter("estadoCivil"),
                    request.getParameter("nomelogin"),
                    request.getParameter("senha"),
                    request.getParameter("email"));

            Usuario_PcdContato usuario_PcdContato = new Usuario_PcdContato(
                    request.getParameter("telefone"),
                    request.getParameter("endereco"));

            Usuario_PcdSocial usuario_PcdSocial = new Usuario_PcdSocial(
                    request.getParameter("ocupacao"),
                    request.getParameter("nivelEscolaridade"),
                    Double.parseDouble(request.getParameter("rendaFamiliarPCapita")), // Converte para double
                    request.getParameter("programaAssistenciaSocial"));

            Usuario_PcdDeficiencia usuario_PcdDeficiencia = new Usuario_PcdDeficiencia(
                    request.getParameter("tipoDeficiencia"),
                    Boolean.parseBoolean(request.getParameter("necessidadeAcompanhante")), // Convertendo para boolean
                    Boolean.parseBoolean(request.getParameter("necessidadeEquipamento")),
                    request.getParameter("explicacaoNecessidadeEquipamento"),
                    Boolean.parseBoolean(request.getParameter("necessidadeTransporteAdaptado")),
                    request.getParameter("explicacaoNecessidadeAdaptacao"),
                    Boolean.parseBoolean(request.getParameter("necessidadeAdaptacaoLocalAtendimento")),
                    request.getParameter("explicacaoNecessidadeAdaptacaoLocalAtendimento"),
                    Boolean.parseBoolean("necessidadeApoioEducacional"),
                    request.getParameter("necessidadeEducacional"));

            Usuario_PcdMedico usuario_PcdMedico = new Usuario_PcdMedico(
                    request.getParameter("historicoMedico"),
                    Boolean.parseBoolean(request.getParameter("usoMedicacao")),
                    request.getParameter("explicacaoUsoMedicacao"),
                    Boolean.parseBoolean(request.getParameter("fazAtendimentoEspecialista")),
                    request.getParameter("explicacaoAtendimentoEspecialista"),
                    Boolean.parseBoolean(request.getParameter("participaCentroApoio")),
                    request.getParameter("explicacaoParticipacaoCentroApoio"));

            Responsavel responsavel = new Responsavel(
                    request.getParameter("nomecompletoResponsavel"),
                    request.getParameter("telefoneResponsavel"),
                    request.getParameter("emailResponsavel"),
                    request.getParameter("enderecoResponsavel"));

            ControleUsuarioPcd controleUsuarioPcd = new ControleUsuarioPcd();
            controleUsuarioPcd.cadastrarUsuarioPcd(responsavel, usuario_Pcd, usuario_PcdContato,
                    usuario_PcdDeficiencia, usuario_PcdMedico, usuario_PcdSocial);

            // Realiza o login do usuário após o cadastro
            fazerLogin(request, response);

        } catch (Exception e) {
            // Registre o erro e mostre uma mensagem ao usuário
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao cadastrar o usuário: " + e.getMessage());
            request.getRequestDispatcher("inicial.jsp").forward(request, response);
        }
    }

}