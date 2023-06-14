package br.ufsm.csi.dao;

import br.ufsm.csi.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean setUsuario(String login, String senha) throws SQLException {
        try(Connection con = new ConectaDB().getConexao()){
            String sql = "INSERT INTO usuario (login,senha) VALUES (?,?);";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, login);
            pt.setString(2, senha);
            System.out.println("sql: "+pt.toString());
            int sucesso = pt.executeUpdate();
            if (1 == sucesso) {
                return true;
            }
            return false;
        }
    }

    public boolean getUsuario(String login, String senha){
        try(Connection con = new ConectaDB().getConexao()){
            String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, login);
            pt.setString(2, senha);
            System.out.println("sql: "+pt.toString());
            ResultSet rs = pt.executeQuery();

            if (rs.next()){
                return true;
            }

            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
