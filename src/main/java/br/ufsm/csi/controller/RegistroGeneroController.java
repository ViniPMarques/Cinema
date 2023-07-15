package br.ufsm.csi.controller;

import br.ufsm.csi.service.GeneroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("registroGenero")
public class RegistroGeneroController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String classificacao = req.getParameter("classificacao");

        try{
            if(new GeneroService().registrarGenero(nome, classificacao)){
                req.getSession().setAttribute("sucesso","Gênero adicionado com sucesso!");
                resp.sendRedirect(req.getContextPath()+"/genero");
            }else{
                req.getRequestDispatcher("/WEB-INF/addGenero.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
