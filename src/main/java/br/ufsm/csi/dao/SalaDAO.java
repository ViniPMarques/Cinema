package br.ufsm.csi.dao;

import br.ufsm.csi.model.Sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaDAO {
    private ConectaDB c = new ConectaDB();
    private Connection conn;

    public boolean setSala(String nome, Integer cadeiras) throws SQLException {
        try {
            conn = c.getConexao();
            String sql = "INSERT INTO sala (nome, cadeiras) VALUES (?,?);";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,nome);
            pstmt.setInt(2,cadeiras);
            int sucesso = pstmt.executeUpdate();
            if(sucesso==1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Sala> getSalas(){
        try{
            conn = c.getConexao();
            String sql = "SELECT idsala, nome, cadeiras FROM sala;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Sala> listSalas = new ArrayList<>();
            while(rs.next()){
                Sala f = new Sala();
                f.setIdsala(Integer.parseInt(rs.getString("idsala")));
                f.setNome(rs.getString("nome"));
                f.setCadeiras(rs.getInt("cadeiras"));
                listSalas.add(f);
            }
            return listSalas;
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public boolean deleteSala(String idsala){
        try{
            conn = c.getConexao();
            String sql = "DELETE FROM sala WHERE idsala = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(idsala));
            int sucesso = pstmt.executeUpdate();
            if(sucesso==1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Sala umSala(String idsala){
        try{
            conn = c.getConexao();
            String sql = "SELECT idsala, nome, cadeiras FROM sala WHERE idsala = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(idsala));
            ResultSet rs = pstmt.executeQuery();
            Sala sala = null;
            while(rs.next()){
                int id = rs.getInt("idsala");
                String nome = rs.getString("nome");
                int cadeiras = rs.getInt("cadeiras");
                sala = new Sala(id, nome, cadeiras);
            }
            return sala;
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public boolean updateSala(String idsala, String nome, Integer cadeiras){
        try{
            conn = c.getConexao();
            String sql = "UPDATE sala SET nome=?, cadeiras=? WHERE idsala = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,nome);
            pstmt.setInt(2,cadeiras);
            pstmt.setInt(3,Integer.parseInt(idsala));
            int sucesso = pstmt.executeUpdate();
            if(sucesso==1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
