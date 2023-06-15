package br.ufsm.csi.controller;

import br.ufsm.csi.dao.FilmeDAO;
import br.ufsm.csi.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("login")
public class LoginController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Bateu no login");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        System.out.println(login+ " - "+senha);

        try {
            if(new LoginService().autenticar(login, senha)){
                HttpSession session = req.getSession();
                session.setAttribute("login", "true");
                resp.sendRedirect(req.getContextPath()+"/principal");
            }else{
                req.getSession().setAttribute("erro","Erro no login");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}