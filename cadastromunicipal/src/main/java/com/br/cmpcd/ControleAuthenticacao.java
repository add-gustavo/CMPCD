package com.br.cmpcd;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Usuario_PcdDAO;
import DTO.Usuario_Pcd;

public class ControleAuthenticacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        System.out.println("Ação recebida: " + acao);
        request.setAttribute("acao", acao);
        request.getRequestDispatcher("/pagina/authenticacao.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String acao = request.getParameter("acao");
            String senhahash = Criptografia.conversterParaMD5(request.getParameter("senha"));
            Usuario_Pcd usuario_Pcd = new Usuario_Pcd(email, senhahash);

            Usuario_PcdDAO usuarioPcdDAO = new Usuario_PcdDAO();
            Boolean acesso;
            try {
                acesso = usuarioPcdDAO.autentificacaoUsuario(usuario_Pcd);
                if (acesso) {
                    Usuario_Pcd usuario = usuarioPcdDAO.buscarUsuarioPorEmail(email);
                    switch (acao) {
                        case "excluir-conta":
                            excluirConta(usuario, request, response);
                            break;
                        case "atualizar-senha":
                            HttpSession session = request.getSession();
                            session.setAttribute("usuarioPcd", usuario);
                            request.getRequestDispatcher("/pagina/senha.jsp").forward(request, response);
                            break;
                        case "atualizar-email":
                            HttpSession session2 = request.getSession();
                            session2.setAttribute("usuarioPcd", usuario);
                            request.getRequestDispatcher("/pagina/email.jsp").forward(request, response);
                            break;

                        default:
                            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação não reconhecida.");
                            break;
                    }
                } else {
                    request.setAttribute("errorMessage", "E-mail ou senha incorretos.");
                    request.getRequestDispatcher("/pagina/authenticacao.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    private void excluirConta(Usuario_Pcd usuario, HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {
        Usuario_PcdDAO usuario_PcdDAO = new Usuario_PcdDAO();

        boolean excluido = usuario_PcdDAO.excluirUsuarioPcd(usuario.getCodigo());

        if (excluido) {

            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }

            HttpSession novaSessao = request.getSession(true);
            novaSessao.setAttribute("sucesso", "Conta excluída com sucesso!");

            response.sendRedirect(request.getContextPath() + "/inicial.jsp");
        } else {
            request.setAttribute("erro", "Erro ao excluir a conta. Tente novamente.");
            request.getRequestDispatcher("/pagina/authenticacao.jsp").forward(request, response);
        }
    }

}
