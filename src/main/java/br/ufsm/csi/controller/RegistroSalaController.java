package br.ufsm.csi.controller;

import br.ufsm.csi.service.SalaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("registroSala")
public class RegistroSalaController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        int cadeiras = Integer.parseInt(req.getParameter("cadeiras"));

        try{
            if(new SalaService().registrarSala(nome, cadeiras)){
                req.getSession().setAttribute("sucesso","Sala adicionada com sucesso!");
                resp.sendRedirect(req.getContextPath()+"/sala");
            }else{
                req.getRequestDispatcher("/WEB-INF/addSala.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
