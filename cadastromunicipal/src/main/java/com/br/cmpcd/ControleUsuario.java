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
import DAO.Usuario_PcdDAO;
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

                case "atualizar-perfil":
                    paginaPerfil(request, response);
                    break;

                case "excluir-conta":
                    excluirConta(request, response);
                    break;

                case "authenticacao":
                    authenticacao(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fazerLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        Usuario_Pcd usuario_Pcd = new Usuario_Pcd(request.getParameter("email"), request.getParameter("senha"));

        Usuario_PcdDAO usuario_PcdDAO = new Usuario_PcdDAO();

        Boolean acesso = usuario_PcdDAO.autentificacaoUsuario(usuario_Pcd);
        System.out.println(usuario_Pcd.getEmail() + usuario_Pcd.getSenha());

        if (acesso) {

            Usuario_Pcd usuario = usuario_PcdDAO.buscarUsuarioPorEmail(usuario_Pcd.getEmail());
            System.out.println("Usuario" + usuario.getNomeLogin());
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("/cadastromunicipal/pagina/principal.jsp");
        } else {

            request.setAttribute("erro", "Email ou senha inválidos");
            request.getRequestDispatcher("/pagina/login.jsp").forward(request, response);

        }
    }

    private void excluirConta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Validações básicas de entrada
        if (email == null || senha == null || email.isEmpty() || senha.isEmpty()) {
            request.setAttribute("erro", "Preencha todos os campos");
            request.getRequestDispatcher("/pagina/authenticacao.jsp").forward(request, response);
            return;
        }

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

    private void authenticacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/pagina/authenticacao.jsp").forward(request, response);
    }

    private void paginaPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        ControleUsuarioPcd controleUsuarioPcd = new ControleUsuarioPcd();
        String usuario = request.getParameter("usuario.nomeLogin");
        System.out.println("Pagina Perfil: ");
        System.out.println(usuario);
        UsuarioPcdInfo info = controleUsuarioPcd.InformaçoesUsuarioPcd(usuario);

        Usuario_Pcd usuarioPcd = info.getUsuarioPcd();
        Usuario_PcdContato contato = info.getContato();
        Usuario_PcdDeficiencia deficiencia = info.getDeficiencia();
        Usuario_PcdMedico medico = info.getMedico();
        Usuario_PcdSocial social = info.getSocial();
        Responsavel responsavel = info.getResponsavel();

        System.out.println(usuarioPcd.getCodigo() + " " + contato.getCodigoUsuario() + " "
                + deficiencia.getCodigoUsuario() + " " + medico.getCodigoUsuario() + " " + social.getCodigoUsuario()
                + " " + responsavel.getCodigoUsuario());
        // Adicionar os dados como atributos na request
        HttpSession session = request.getSession();
        session.setAttribute("usuarioPcd", usuarioPcd);
        session.setAttribute("contato", contato);
        session.setAttribute("deficiencia", deficiencia);
        session.setAttribute("medico", medico);
        session.setAttribute("social", social);
        session.setAttribute("responsavel", responsavel);

        // Redirecionar para a página JSP de perfil
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina//perfil.jsp");
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
                    request.getParameter("necessidadeApoioEducacional"));

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
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } finally {
            // Certifique-se de que a conexão será fechada
        }
    }

}