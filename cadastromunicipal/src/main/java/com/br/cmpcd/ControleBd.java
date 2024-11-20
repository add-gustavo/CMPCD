package com.br.cmpcd;

import java.io.IOException;

import DAO.ControlUsuario;
import DTO.Pessoa;
import DTO.Usuario;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControleBd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requisicao(request, response);
    };

    private void requisicao(HttpServletRequest request, HttpServletResponse response)
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
                default:
                    break;
            }
        } catch (ServletException e) {
        }

    };

    private void fazerLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario(request.getParameter("email"), request.getParameter("senha"));
        ControlUsuario control = new ControlUsuario();
        control.authentificacaoUsuario(usuario);
        System.out.println("Email:" + request.getParameter("email") + "senha: " + request.getParameter("senha"));

    };

    private void novoUsuarioPCD(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String confirmarsenha = request.getParameter("confirmar-senha");
        if (confirmarsenha.equals(senha)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/cadastro.jsp");
            dispatcher.forward(request, response);
            // Pessoa pessoa = new Pessoa(nome, email, confirmarsenha);
            // ControlUsuario control = new ControlUsuario();
            // control.adicionarUsuario(pessoa);
        } else {

        }
        // control.adicionarUsuario(pessoa);

    };

}
