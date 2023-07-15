package br.ufsm.csi.service;

import br.ufsm.csi.dao.GeneroDAO;
import br.ufsm.csi.model.Genero;

import java.sql.SQLException;

public class GeneroService {

    public boolean registrarGenero(String nome, String classificacao) throws SQLException {

        if(new GeneroDAO().setGenero(nome, classificacao)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean removerGenero(String idgenero) throws SQLException {

        if(new GeneroDAO().deleteGenero(idgenero)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizarGenero(String idgenero, String nome, String classificacao) throws SQLException{

        if (new GeneroDAO().updateGenero(idgenero, nome, classificacao)){
            return true;
        } else {
            return false;
        }
    }

    public Genero umGenero(String idgenero){
        return new GeneroDAO().umGenero(idgenero);
    }
}
