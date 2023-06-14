package br.ufsm.csi.model;

public class Usuario {
    private int idusuario;
    private String login;
    private String senha;

    public Usuario(int idusuario, String login, String senha) {
        this.idusuario = idusuario;
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
