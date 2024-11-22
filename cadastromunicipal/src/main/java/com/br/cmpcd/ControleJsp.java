package com.br.cmpcd;

import java.io.IOException;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.br.cmpcd.dao.util.Conexao;

public class ControleJsp extends HttpServlet {

    public ControleJsp() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requisicao(request, response);
    };

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                case "login":
                    login(request, response);
                    break;
                case "cadastro":
                    UsuarioPCD(request, response);
                    break;
                case "perfil":
                    Perfil(request, response);
                default:
                    break;
            }
        } catch (ServletException e) {
        }

    };

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexaoJDBC = Conexao.getConexao();
        if (conexaoJDBC != null) {
            System.out.println("Conexao aberta");
        } else {
            System.out.println("Sem conexao");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/login.jsp");
        dispatcher.forward(request, response);

    };

    private void Perfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexaoJDBC = Conexao.getConexao();
        if (conexaoJDBC != null) {
            System.out.println("Conexao aberta");
        } else {
            System.out.println("Sem conexao");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/login.jsp");
        dispatcher.forward(request, response);

    };

    private void UsuarioPCD(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/cadastrop1.jsp");
        dispatcher.forward(request, response);

    };

}