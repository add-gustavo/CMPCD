package com.br.cmpcd;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Usuario_PcdDAO;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class VerificarNomeLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Lê o corpo da requisição como JSON
        StringBuilder sb = new StringBuilder();
        String line;
        try (var reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }

        String requestBody = sb.toString();
        System.out.println("Corpo da requisição: " + requestBody);

        // Parseia o JSON recebido
        String nomeLogin = null;
        try {
            // Usando a versão mais recente do Gson
            JsonObject jsonObject = JsonParser.parseString(requestBody).getAsJsonObject();
            nomeLogin = jsonObject.get("nomeLogin").getAsString();
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Requisição inválida. JSON mal formatado.\"}");
            return;
        }

        System.out.println("Nome de Login: " + nomeLogin);

        // Verifica o nome no banco de dados
        Usuario_PcdDAO dao = new Usuario_PcdDAO();
        boolean nomeExiste = false;

        try {
            nomeExiste = dao.verificarNomeLogin(nomeLogin);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Erro ao verificar o nome de login.\"}");
            return;
        }

        // Cria a resposta JSON
        String jsonResponse = "{\"exists\": " + nomeExiste + "}";
        response.getWriter().write(jsonResponse);
    }
}
