package br.ufsm.csi.service;

import br.ufsm.csi.dao.SalaDAO;
import br.ufsm.csi.model.Sala;

import java.sql.SQLException;

public class SalaService {
    public boolean registrarSala(String nome, Integer cadeiras) throws SQLException {

        if(new SalaDAO().setSala(nome, cadeiras)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean removerSala(String idsala) throws SQLException {

        if(new SalaDAO().deleteSala(idsala)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizarSala(String idsala, String nome, Integer cadeiras) throws SQLException{

        if (new SalaDAO().updateSala(idsala, nome, cadeiras)){
            return true;
        } else {
            return false;
        }
    }

    public Sala umSala(String idsala){
        return new SalaDAO().umSala(idsala);
    }
}
