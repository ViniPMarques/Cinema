package br.ufsm.csi.controller;

import br.ufsm.csi.service.FilmeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("atualizarFilme")
public class AtualizarFilmeController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idfilme = req.getParameter("idfilme");
        String titulo = req.getParameter("titulo");
        String diretor = req.getParameter("diretor");
        String genero = req.getParameter("genero");
        String sala = req.getParameter("sala");


        try {
            if (new FilmeService().atualizarFilme(idfilme, titulo, diretor, genero, sala)) {
                req.getSession().setAttribute("sucesso", "Filme atualizado com sucesso!");
                resp.sendRedirect(req.getContextPath() + "/principal");
            } else {
                req.getRequestDispatcher("/WEB-INF/edicao.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
