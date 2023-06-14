package br.ufsm.csi.service;

import br.ufsm.csi.dao.UsuarioDAO;

import java.sql.SQLException;

public class LoginService {
    public boolean autenticar(String login, String senha) throws SQLException {

        if(new UsuarioDAO().getUsuario(login,senha)) {
            return true;
        } else {
            return false;
        }
    }
}
