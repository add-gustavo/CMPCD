package com.br.cmpcd;

import javax.servlet.*;
import java.io.IOException;

public class CharsetEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialização, caso necessário
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Defina a codificação como UTF-8 para todas as requisições
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Continue com o processamento da requisição
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup, caso necessário
    }
}
