package br.ufsm.csi.controller;

import br.ufsm.csi.dao.GeneroDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("genero")
public class GeneroController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/genero.jsp");
        req.setAttribute("listGeneros", new GeneroDAO().getGeneros());
        dispatcher.forward(req, resp);
    }
}
