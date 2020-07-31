package com.programem.cunsulta;

public class ListaCliente {
    
    String exibeListaCliente(Iterable<Cliente> lista){
        String html = "";

        for(Cliente c : lista){
            html = html +
            "<h1>"+c.getNome()+"</h1>"+
            "<p>"+c.getIdade()+"</p>"+
            "<p>"+c.getEndereco()+"</p>"+
            "<br>"
            ;
        }
        return html;
    }
}