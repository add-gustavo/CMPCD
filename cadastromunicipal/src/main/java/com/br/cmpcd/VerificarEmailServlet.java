package com.br.cmpcd;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Usuario_PcdDAO;

public class VerificarEmailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        StringBuilder sb = new StringBuilder();
        String line;
        try (var reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }

        String requestBody = sb.toString();
        System.out.println("Corpo da requisição: " + requestBody);

        String email = null;
        try {
            @SuppressWarnings("deprecation")
            com.google.gson.JsonObject jsonObject = new com.google.gson.JsonParser().parse(requestBody)
                    .getAsJsonObject();
            email = jsonObject.get("email").getAsString();
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Requisição inválida.\"}");
            return;
        }

        System.out.println("Email: " + email);

        Usuario_PcdDAO dao = new Usuario_PcdDAO();
        boolean emailExiste = false;

        try {
            emailExiste = dao.verificarEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Erro ao verificar o email.\"}");
            return;
        }

        String jsonResponse = "{\"exists\": " + emailExiste + "}";
        response.getWriter().write(jsonResponse);
    }
}
