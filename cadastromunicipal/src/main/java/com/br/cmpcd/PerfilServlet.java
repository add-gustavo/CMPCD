package com.br.cmpcd;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.br.cmpcd.dao.util.Conexao;
import DAO.ControlUsuario;
import DTO.Pessoa;

@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recupera o login (nome do usuário) da URL
        String login = request.getParameter("nome_usuario");

        try {
            // Consulta o banco de dados para obter as informações do usuário
            ControlUsuario control = new ControlUsuario(Conexao.getConexao());
            Pessoa usuario = control.getInformacoesUsuario(login); // Método que busca o usuário no banco

            if (usuario != null) {
                // Adiciona o objeto de usuário à requisição para ser acessado na página JSP
                request.setAttribute("usuario", usuario);

                // Encaminha para a página de perfil
                RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/perfil.jsp");
                dispatcher.forward(request, response);
            } else {
                // Caso o usuário não exista, exibe uma mensagem de erro
                request.setAttribute("erro", "Usuário não encontrado.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/erro.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao carregar o perfil.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/erro.jsp");
            dispatcher.forward(request, response);
        }
    }
}
