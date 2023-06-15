package br.ufsm.csi.dao;

import br.ufsm.csi.model.Filme;
import br.ufsm.csi.model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO {
    private ConectaDB c = new ConectaDB();
    private Connection conn;

    public boolean setFilme(String titulo, String diretor, String genero, String sala) throws SQLException{
        try {
            conn = c.getConexao();
            String sql = "INSERT INTO filme (titulo, diretor, idgenero, idsala) VALUES (?,?,?,?);";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,titulo);
            pstmt.setString(2,diretor);
            pstmt.setInt(3,Integer.parseInt(genero));
            pstmt.setInt(4,Integer.parseInt(sala));
            int sucesso = pstmt.executeUpdate();
            if(sucesso==1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Filme> getFilmes(){
        try{
            conn = c.getConexao();
            String sql = "SELECT idfilme, titulo, diretor, nome FROM filme, genero " +
                    "WHERE filme.idgenero = genero.idgenero;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Filme> listFilmes = new ArrayList<>();
            while(rs.next()){
                Filme f = new Filme();
                f.setIdfilme(Integer.parseInt(rs.getString("idfilme")));
                f.setTitulo(rs.getString("titulo"));
                f.setDiretor(rs.getString("diretor"));
                f.setGenero(rs.getString("nome"));
                listFilmes.add(f);
            }
            return listFilmes;
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public boolean deleteFilme(String idfilme){
        try{
            conn = c.getConexao();
            String sql = "DELETE FROM filme WHERE idfilme = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(idfilme));
            int sucesso = pstmt.executeUpdate();
            if(sucesso==1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*public Filme umFilme(){
        try{
            conn = c.getConexao();
            String sql = "SELECT titulo, diretor, nome FROM filme, genero " +
                    "WHERE idfilme = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Filme> listFilmes = new ArrayList<>();
            while(rs.next()){
                Filme f = new Filme();
                f.setIdfilme(Integer.parseInt(rs.getString("idfilme")));
                f.setTitulo(rs.getString("titulo"));
                f.setDiretor(rs.getString("diretor"));
                f.setGenero(rs.getString("nome"));
                listFilmes.add(f);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }*/

    public boolean updateFilme(String idfilme, String titulo, String diretor, String genero, String sala){
        try{
            conn = c.getConexao();
            String sql = "UPDATE filme SET titulo=?, diretor=?, idgenero=?, idsala=? WHERE idfilme = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,titulo);
            pstmt.setString(2,diretor);
            pstmt.setInt(3,Integer.parseInt(genero));
            pstmt.setInt(4,Integer.parseInt(sala));
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
