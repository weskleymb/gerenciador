package br.senac.rn.gerenciador.web;

import br.senac.rn.gerenciador.dao.EmpresaDAO;
import br.senac.rn.gerenciador.model.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        PrintWriter writer = resposta.getWriter();
        writer.println("<html><body>");
        String filtro = requisicao.getParameter("filtro");
        writer.println("Buscar por Empresa");
        writer.println("<ul>");
        Collection<Empresa> empresas =  new EmpresaDAO().buscaPorSimilaridade(filtro);
        for (Empresa empresa : empresas) {
            writer.println("<li>");
            writer.println(empresa.getId() + " : " + empresa.getNome());
            writer.println("</li>");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
    }
    
}
