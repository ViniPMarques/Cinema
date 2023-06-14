package br.ufsm.csi.model;

public class Sala {
    private int idsala;
    private String nome;
    private int cadeiras;
    private boolean vip;

    public Sala() {
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

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
