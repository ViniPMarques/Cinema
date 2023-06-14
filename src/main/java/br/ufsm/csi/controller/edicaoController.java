package br.ufsm.csi.controller;
import br.ufsm.csi.service.FilmeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("edicao")
public class edicaoController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/WEB-INF/edicao.jsp");
        dispatcher.forward(req, resp);
    }
}
