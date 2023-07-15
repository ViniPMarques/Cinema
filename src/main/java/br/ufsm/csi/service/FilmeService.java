package br.ufsm.csi.service;

import br.ufsm.csi.dao.FilmeDAO;
import br.ufsm.csi.model.Filme;

import java.sql.SQLException;

public class FilmeService {

    public boolean registrarFilme(String titulo, String diretor, String  genero, String sala, String film) throws SQLException {

        if(new FilmeDAO().setFilme(titulo,diretor,genero,sala,film)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean removerFilme(String idfilme) throws SQLException {

        if(new FilmeDAO().deleteFilme(idfilme)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizarFilme(String idfilme, String titulo, String diretor, String genero, String sala, String film) throws SQLException{

        if (new FilmeDAO().updateFilme(idfilme, titulo, diretor, genero, sala, film)){
            return true;
        } else {
            return false;
        }
    }

    public Filme umFilme(String idfilme){
        return new FilmeDAO().umFilme(idfilme);
    }
}
