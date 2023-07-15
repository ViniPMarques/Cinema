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

@WebServlet("atualizarSala")
public class AtualizarSalaController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idsala = req.getParameter("idsala");
        String nome = req.getParameter("nome");
        int cadeiras = Integer.parseInt(req.getParameter("cadeiras"));


        try {
            if (new SalaService().atualizarSala(idsala, nome, cadeiras)) {
                req.getSession().setAttribute("sucesso", "Gênero atualizado com sucesso!");
                resp.sendRedirect(req.getContextPath() + "/sala");
            } else {
                req.getRequestDispatcher("/WEB-INF/edicaoSala.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
