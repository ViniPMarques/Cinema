package br.ufsm.csi.controller;

import br.ufsm.csi.service.GeneroService;
import br.ufsm.csi.service.SalaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("remocaoGenero")
public class RemocaoGeneroController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idgenero = req.getParameter("id");
        try{
            if(new GeneroService().removerGenero(idgenero)){
                req.getSession().setAttribute("retirado","Gênero removido com sucesso!");
                resp.sendRedirect(req.getContextPath()+"/genero");
            }else{
                resp.sendRedirect(req.getContextPath()+"/genero");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath()+"/genero");
    }
}
