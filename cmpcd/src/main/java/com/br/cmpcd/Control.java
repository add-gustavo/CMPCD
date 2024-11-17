package com.br.cmpcd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ControlUsuario;
import DTO.Usuario;

@WebServlet("/controle")
public class Control extends HttpServlet {

    public Control() {
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
        try {
            switch (acao) {
                case "login":
                    login(request, response);
                    break;
                case "fazer-login":
                    fazerLogin(request, response);
                    break;
                case "cadastro":
                    UsuarioPCD(request, response);
                    break;
                case "inserir-Usuario":
                    novoUsuarioPCD(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
        }

    };

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/login.html");
        dispatcher.forward(request, response);

    };

    private void fazerLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario(request.getParameter("email"), request.getParameter("senha"));
        ControlUsuario control = new ControlUsuario();
        control.authentificacaoUsuario(usuario);

    };

    private void UsuarioPCD(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.html");
        dispatcher.forward(request, response);

    };

    private void novoUsuarioPCD(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pessoa pessoa = new Pessoa(request.getParameter("nome"),
        // request.getParameter()))
        // ControlUsuario control = new ControlUsuario();
        // control.adicionarUsuario(pessoa);

    };

}