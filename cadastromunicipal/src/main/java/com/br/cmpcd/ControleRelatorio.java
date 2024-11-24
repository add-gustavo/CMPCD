package com.br.cmpcd;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RelatorioDAO;

public class ControleRelatorio extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String relatorio = request.getParameter("acao");
        if (relatorio == null || relatorio.isEmpty()) {
            response.sendRedirect("erro.html"); // ou redirecionar para uma página de erro ou login
            return;
        }

        try {
            switch (relatorio) {

                case "tipo":
                    fornecerDadosTipoDeficiencia(request, response);
                    break;
                case "sexo":
                    fornecerDadosPorcentagemDeficientesPorSexo(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
        }

    };

    private void fornecerDadosTipoDeficiencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Object[]> dadosDeficiencia = null;
        try {
            // Obtem os dados do DAO
            RelatorioDAO dao = new RelatorioDAO();
            dadosDeficiencia = dao.getDadosTipoDeficiencia();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Prepara os dados no formato esperado
        List<Map<String, Object>> dadosList = new ArrayList<>();
        for (Object[] obj : dadosDeficiencia) {
            Map<String, Object> dado = new HashMap<>();
            dado.put("label", (String) obj[0]); // Nome da deficiência
            dado.put("value", (Integer) obj[1]); // Quantidade associada
            dadosList.add(dado);
        }

        // Define o tipo de resposta e codificação
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Converte a lista em JSON e escreve na resposta
        new Gson().toJson(dadosList, response.getWriter());
    }

    private void fornecerDadosPorcentagemDeficientesPorSexo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Object[]> dadosPorcentagem = null;
        try {
            // Obtém os dados do DAO
            RelatorioDAO dao = new RelatorioDAO();
            dadosPorcentagem = dao.getPorcentagemDeficientesPorSexo();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Prepara os dados no formato esperado
        List<Map<String, Object>> dadosList = new ArrayList<>();
        for (Object[] obj : dadosPorcentagem) {
            Map<String, Object> dado = new HashMap<>();
            dado.put("label", (String) obj[0]); // Sexo
            dado.put("value", (Double) obj[1]); // Porcentagem associada
            dadosList.add(dado);
        }

        // Define o tipo de resposta e codificação
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Converte a lista em JSON e escreve na resposta
        new Gson().toJson(dadosList, response.getWriter());
    }

}
