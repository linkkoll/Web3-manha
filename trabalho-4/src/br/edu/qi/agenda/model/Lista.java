package br.edu.qi.agenda.model;

import java.util.ArrayList;
import java.util.List;

public class Lista {

    private static List<Contato> lista;
    
    public static List<Contato> getInstance(){
        if (lista == null) {
            lista = new ArrayList();
        }
        
        return lista;
    }
}
