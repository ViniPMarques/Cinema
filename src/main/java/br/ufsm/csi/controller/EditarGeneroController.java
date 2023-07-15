package br.ufsm.csi.controller;

import br.ufsm.csi.model.Genero;
import br.ufsm.csi.service.GeneroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("editarGenero")
public class EditarGeneroController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Genero genero = new GeneroService().umGenero(id);
        System.out.println(genero.getNome());
        req.setAttribute("genero", genero);
        req.getRequestDispatcher("/WEB-INF/edicaoGenero.jsp").forward(req, resp);
    }
}
