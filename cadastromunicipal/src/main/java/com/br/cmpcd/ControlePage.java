package com.br.cmpcd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControlePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("pagina");
        if (acao == null || acao.isEmpty()) {
            response.sendRedirect("erro.html"); // ou redirecionar para uma página de erro ou login
            return;
        }

        try {
            switch (acao) {

                case "login":
                    Login(request, response);
                    break;

                case "cadastro":
                    Cadastro(request, response);
                    break;

                case "inicial":
                    Inicial(request, response);
                    break;

                case "authenticacao":
                    pageAuthenticacao(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
        }
    };

    private void pageAuthenticacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/pagina/authenticacao.jsp").forward(request, response);
    }

    private void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/pagina/login.jsp").forward(request, response);
    }

    private void Cadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/pagina/cadastro.jsp").forward(request, response);
    }

    private void Inicial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recupera a sessão, sem criar uma nova se não existir
        HttpSession session = request.getSession(false);

        // Verifica se o usuário está logado (para outras páginas que exigem login)
        if (session != null && session.getAttribute("usuarioPcd") != null) {
            // Se o usuário estiver logado, permite o acesso à página inicial
            request.getRequestDispatcher("inicial.jsp").forward(request, response);
        } else {
            // Aqui, estamos permitindo que o usuário não logado acesse a página inicial
            // A verificação do login pode ser necessária em outras páginas ou ao tentar
            // acessar recursos específicos
            request.getRequestDispatcher("inicial.jsp").forward(request, response);
        }
    }

}
