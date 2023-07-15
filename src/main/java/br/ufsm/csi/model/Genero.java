package br.ufsm.csi.model;

public class Genero {
    private int idgenero;
    private String nome;
    private String classificacao;


    public Genero() {
    }

    public Genero(int idgenero, String nome, String classificacao) {
        this.idgenero = idgenero;
        this.nome = nome;
        this.classificacao = classificacao;
    }

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
}
