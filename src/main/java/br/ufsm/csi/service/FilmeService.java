package br.ufsm.csi.service;

import br.ufsm.csi.dao.FilmeDAO;

import java.sql.SQLException;

public class FilmeService {

    public boolean registrarFilme(String titulo, String diretor, String  genero, String sala) throws SQLException {

        if(new FilmeDAO().setFilme(titulo,diretor,genero,sala)) {
            return true;
        } else {
            return false;
        }
    }
}
