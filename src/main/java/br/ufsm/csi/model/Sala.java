package br.ufsm.csi.model;

public class Sala {
    private int idsala;
    private String nome;
    private int cadeiras;

    public Sala() {
    }

    public Sala(int idsala, String nome, int cadeiras) {
        this.idsala = idsala;
        this.nome = nome;
        this.cadeiras = cadeiras;
    }

    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(int cadeiras) {
        this.cadeiras = cadeiras;
    }

}
