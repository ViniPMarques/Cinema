package br.ufsm.csi.controller;

import br.ufsm.csi.service.FilmeService;
import br.ufsm.csi.service.GeneroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("atualizarGenero")
public class AtualizarGeneroController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idgenero = req.getParameter("idgenero");
        String nome = req.getParameter("nome");
        String classificacao = req.getParameter("classificacao");


        try {
            if (new GeneroService().atualizarGenero(idgenero, nome, classificacao)) {
                req.getSession().setAttribute("sucesso", "Gênero atualizado com sucesso!");
                resp.sendRedirect(req.getContextPath() + "/genero");
            } else {
                req.getRequestDispatcher("/WEB-INF/edicaoGenero.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
