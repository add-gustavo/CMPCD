package com.br.cmpcd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("pagina");

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

                case "relatorio":
                    pageRelatorio(request, response);
                    break;

                case "deslogar":
                    Deslogar(request, response);
                default:
                    break;
            }
        } catch (ServletException e) {
        }
    };

    private void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/pagina/login.jsp").forward(request, response);
    }

    private void Deslogar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("inicial.jsp");
    }

    private void Cadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/pagina/cadastro.jsp").forward(request, response);
    }

    private void pageRelatorio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/pagina/relatorio.jsp").forward(request, response);
    }

    private void Inicial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("inicial.jsp").forward(request, response);

    }

}
