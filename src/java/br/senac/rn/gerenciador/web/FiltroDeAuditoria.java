package br.senac.rn.gerenciador.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest requisicao, ServletResponse resposta, FilterChain cadeia) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) requisicao;
        HttpServletResponse resp = (HttpServletResponse) resposta;
        String uri = req.getRequestURI();
        System.out.println("Usuario acessando a URI " + uri);
        cadeia.doFilter(requisicao, resposta);
    }

    @Override
    public void destroy() {}
    
}
