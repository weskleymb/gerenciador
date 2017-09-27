package br.senac.rn.gerenciador.web;

import br.senac.rn.gerenciador.dao.EmpresaDAO;
import br.senac.rn.gerenciador.model.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/novaEmpresa")
public class CadastrarEmpresa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        String nome = requisicao.getParameter("nome_empresa");
        Empresa empresa = new Empresa(nome);
        new EmpresaDAO().adiciona(empresa);
        requisicao.setAttribute("empresa", empresa);
        RequestDispatcher dispatcher = requisicao.getRequestDispatcher("/WEB-INF/sucesso.jsp");
        dispatcher.forward(requisicao, resposta);
    }
    
}
