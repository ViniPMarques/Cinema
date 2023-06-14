package br.ufsm.csi.controller;
import br.ufsm.csi.service.RegisterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("registro")
public class RegistroController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Bateu no login");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        System.out.println(login + " - " + senha);

        RequestDispatcher dispatcher;

        try {
            if (new RegisterService().registrar(login, senha)) {
                dispatcher = req.getRequestDispatcher("/index.jsp");
            } else {
                dispatcher = req.getRequestDispatcher("/index.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        dispatcher.forward(req, resp);
    }
}

