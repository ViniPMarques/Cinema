package br.ufsm.csi.controller;

import br.ufsm.csi.dao.GeneroDAO;
import br.ufsm.csi.dao.SalaDAO;
import br.ufsm.csi.model.Filme;
import br.ufsm.csi.service.FilmeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("addFilme")
public class AddFilmeController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setAttribute("listSalas", new SalaDAO().getSalas());
        req.setAttribute("listGeneros", new GeneroDAO().getGeneros());
        req.getRequestDispatcher("/WEB-INF/addFilme.jsp").forward(req, resp);
//
//        RequestDispatcher dispatcher;
//        dispatcher = req.getRequestDispatcher("/WEB-INF/addFilme.jsp");
//        dispatcher.forward(req, resp);
    }
}
