package br.ufsm.csi.controller;

import br.ufsm.csi.model.Sala;
import br.ufsm.csi.service.FilmeService;
import br.ufsm.csi.service.SalaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("remocaoSala")
public class RemocaoSalaController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idsala = req.getParameter("id");
        try{
            if(new SalaService().removerSala(idsala)){
                req.getSession().setAttribute("retirado","Sala removida com sucesso!");
                resp.sendRedirect(req.getContextPath()+"/sala");
            }else{
                resp.sendRedirect(req.getContextPath()+"/sala");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath()+"/sala");
    }
}
