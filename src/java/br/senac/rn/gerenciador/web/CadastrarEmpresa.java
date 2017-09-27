package br.senac.rn.gerenciador.web;

import br.senac.rn.gerenciador.dao.EmpresaDAO;
import br.senac.rn.gerenciador.model.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/novaEmpresa")
public class CadastrarEmpresa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        PrintWriter writer = resposta.getWriter();
        String nome = requisicao.getParameter("nome_empresa");
        Empresa empresa = new Empresa(nome);
        writer.println("<html><body>");
        new EmpresaDAO().adiciona(empresa);
        writer.println("Empresa " + empresa.getNome() + " adicionada!");
        writer.println("</body></html>");
    }
    
}
