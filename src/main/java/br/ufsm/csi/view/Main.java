package br.ufsm.csi.view;

import br.ufsm.csi.dao.ConectaDB;

public class Main {
    public static void main(String[] args) {
        new ConectaDB().getConexao();
    }
}
