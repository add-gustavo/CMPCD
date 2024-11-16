package br.com.cmpcd;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import DAO.ControlUsuario;
import DTO.Pessoa;

@WebServlet("/controle")
public class Control extends HttpServlet {

    public Control() {
        super();
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {
        requisicao(request, response);
    };

    protected void doPost(javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {

    };

    @Override
    private void requisicao(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException ,java.io.IOException {
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
        } catch (Exception e) {
            throw.new.ServletException;
        }
        
    };

    @Override
    private void login(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
        dispatcher.forward(request, response);

    };

    @Override
    private void fazerLogin(javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {
        Pessoa pessoa = new Pessoa(request.getParameter("email"), request.getParameter("senha"));
        ControlUsuario control = new ControlUsuario();
        control.authentificacaoUsuario(pessoa);

    };

    @Override
    private void UsuarioPCD(javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.html");
        dispatcher.forward(request, response);

    };

    @Override
    private void novoUsuarioPCD(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException ,java.io.IOException {
         Pessoa pessoa = new Pessoa(request.getParameter("nome"), request.getParameter()))
         ControlUsuario control = new ControlUsuario();
         control.adicionarUsuario(pessoa);
        
    };

}
