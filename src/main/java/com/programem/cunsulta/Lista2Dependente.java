package com.programem.cunsulta;

public class Lista2Dependente {
    String exibeLista2Dependente(Iterable<Dependente> lista2){
        String html = "";

        for(Dependente d : lista2){
            html = html +
            "<h1>"+d.getNome()+"<h1>"+
            "<p>"+d.getIdade()+"</p>"+
            "<p>"+d.getCliente()+"</p>"+
            "<br>"
            ;
        }
        return html;
    }
}