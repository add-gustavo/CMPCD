package br.com.cmpcd;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/segundaServlet" })
public class SegundaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Define o tipo de conteúdo da resposta
        resp.setContentType("text/html");

        // Obtém o objeto PrintWriter para escrever a resposta
        PrintWriter writer = resp.getWriter();

        // Escreve o HTML de resposta
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Minha primeira Servlet</h1>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
