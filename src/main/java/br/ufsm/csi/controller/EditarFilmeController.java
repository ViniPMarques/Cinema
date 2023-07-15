package br.ufsm.csi.controller;
import br.ufsm.csi.dao.FilmeDAO;
import br.ufsm.csi.dao.GeneroDAO;
import br.ufsm.csi.dao.SalaDAO;
import br.ufsm.csi.model.Filme;
import br.ufsm.csi.service.FilmeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("editarFilme")
public class EditarFilmeController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String id = req.getParameter("id");
        Filme filme = new FilmeService().umFilme(id);
        System.out.println(filme.getTitulo());
        req.setAttribute("filme", filme);
        req.setAttribute("listSalas", new SalaDAO().getSalas());
        req.setAttribute("listGeneros", new GeneroDAO().getGeneros());
        req.getRequestDispatcher("/WEB-INF/edicao.jsp").forward(req, resp);
    }
}
