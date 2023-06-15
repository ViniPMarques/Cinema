package br.ufsm.csi.controller;
import br.ufsm.csi.service.FilmeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("remocao")
public class RemocaoController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

            String idfilme = req.getParameter("id");
            try{
                if(new FilmeService().removerFilme(idfilme)){
                    req.getSession().setAttribute("retirado","Filme removido com sucesso!");
                    resp.sendRedirect(req.getContextPath()+"/principal");
                }else{
                    resp.sendRedirect(req.getContextPath()+"/principal");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        resp.sendRedirect(req.getContextPath()+"/principal");
    }
}
