package br.ufsm.csi.model;

public class Filme {
    private int idfilme;
    private String titulo;
    private String diretor;
    private int idgenero;
    private int idsala;
    private String genero;
    private String sala;

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Filme(int idfilme, String titulo, String diretor, String genero, String sala) {
        this.idfilme = idfilme;
        this.titulo = titulo;
        this.diretor = diretor;
        this.genero = genero;
        this.sala = sala;
    }

    public Filme() {
    }

    public int getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(int idfilme) {
        this.idfilme = idfilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }
}
