package br.ufsm.csi.controller;

import br.ufsm.csi.model.Genero;
import br.ufsm.csi.model.Sala;
import br.ufsm.csi.service.GeneroService;
import br.ufsm.csi.service.SalaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("editarSala")
public class EditarSalaController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Sala sala = new SalaService().umSala(id);
        System.out.println(sala.getNome());
        req.setAttribute("sala", sala);
        req.getRequestDispatcher("/WEB-INF/edicaoSala.jsp").forward(req, resp);
    }
}
