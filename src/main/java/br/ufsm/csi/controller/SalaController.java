package br.ufsm.csi.controller;

import br.ufsm.csi.dao.SalaDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("sala")
public class SalaController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/sala.jsp");
        req.setAttribute("listSalas", new SalaDAO().getSalas());
        dispatcher.forward(req, resp);
    }
}
