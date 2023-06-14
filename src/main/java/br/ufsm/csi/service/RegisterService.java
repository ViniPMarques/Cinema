package br.ufsm.csi.service;

import br.ufsm.csi.dao.UsuarioDAO;
import br.ufsm.csi.model.Usuario;

import java.sql.SQLException;

public class RegisterService {
    public boolean registrar(String login, String senha) throws SQLException {

        if(new UsuarioDAO().setUsuario(login,senha)) {
            return true;
        } else {
            return false;
        }
    }
}
