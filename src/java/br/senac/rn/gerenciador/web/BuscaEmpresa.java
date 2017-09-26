package br.senac.rn.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        PrintWriter writer = resposta.getWriter();
        writer.println("<html><body>");
        writer.print("Busca feita com sucesso!");
        writer.println("</body></html>");
    }
    
}
