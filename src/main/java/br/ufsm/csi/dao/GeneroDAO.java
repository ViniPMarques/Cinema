package br.ufsm.csi.dao;

import br.ufsm.csi.model.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GeneroDAO {
    private ConectaDB c = new ConectaDB();
    private Connection conn;

    public boolean setGenero(String nome, String classificacao) throws SQLException {
        try {
            conn = c.getConexao();
            String sql = "INSERT INTO genero (nome, classificacao) VALUES (?,?);";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,nome);
            pstmt.setString(2,classificacao);
            int sucesso = pstmt.executeUpdate();
            if(sucesso==1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Genero> getGeneros(){
        try{
            conn = c.getConexao();
            String sql = "SELECT idgenero, nome, classificacao FROM genero;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Genero> listGeneros = new ArrayList<>();
            while(rs.next()){
                Genero f = new Genero();
                f.setIdgenero(Integer.parseInt(rs.getString("idgenero")));
                f.setNome(rs.getString("nome"));
                f.setClassificacao(rs.getString("classificacao"));
                listGeneros.add(f);
            }
            return listGeneros;
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public boolean deleteGenero(String idgenero){
        try{
            conn = c.getConexao();
            String sql = "DELETE FROM genero WHERE idgenero = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(idgenero));
            int sucesso = pstmt.executeUpdate();
            if(sucesso==1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Genero umGenero(String idgenero){
        try{
            conn = c.getConexao();
            String sql = "SELECT idgenero, nome, classificacao FROM genero WHERE idgenero = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(idgenero));
            ResultSet rs = pstmt.executeQuery();
            Genero genero = null;
            if (rs.next()){
                int id = rs.getInt("idgenero");
                String nome = rs.getString("nome");
                String classificacao = rs.getString("classificacao");
                genero = new Genero(id, nome, classificacao);
            }
            return genero;
        }catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public boolean updateGenero(String idgenero, String nome, String classificacao){
        try{
            conn = c.getConexao();
            String sql = "UPDATE genero SET nome=?, classificacao=? WHERE idgenero = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,nome);
            pstmt.setString(2,classificacao);
            pstmt.setInt(3,Integer.parseInt(idgenero));
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
