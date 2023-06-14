package br.ufsm.csi.model;

public class Filme {
    private int idfilme;
    private String titulo;
    private String diretor;
    private int idgenero;
    private int idsala;

    private String genero;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
