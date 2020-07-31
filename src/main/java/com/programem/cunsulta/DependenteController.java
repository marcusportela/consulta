package com.programem.cunsulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dependente")
public class DependenteController {

    @Autowired
    private DependenteRepository DependenteRepository;

    private Lista2Dependente lista2Dependente = new Lista2Dependente();

    @GetMapping("/")
    public String dependenteForm(){
      return "dependenteForm";
    }

    @PostMapping(path="/insere2") // Map ONLY POST Requests
    public @ResponseBody String addNewDependente (
         @RequestParam String nome
        ,@RequestParam Integer idade
        ,@RequestParam String cliente
        ) {

            Dependente d = new Dependente();

            d.setNome(nome);
            d.setIdade(idade);
            d.setCliente(cliente);

            DependenteRepository.save(d);

            return nome+" de "+idade+" anos, Filho(a) do(a) cliente: "+cliente+" foi inserido(a) em nosso banco de dados";
    }

    @GetMapping(path="/lista2")
    public @ResponseBody String getAllDependente() {
      
        Iterable<Dependente> resultado = DependenteRepository.findAll();
        
        return lista2Dependente.exibeLista2Dependente(resultado);
  }
  //INICIANDO FILTRO
  @GetMapping(path="/filtroForm2") 
  public String filtroForm2(){
    return "filtroForm2";
  }

  @GetMapping(path="/filtro2")
  public @ResponseBody String getDependente(@RequestParam Integer idade) {
    
    Iterable<Dependente> resultado = DependenteRepository.findDependente(idade);
    
    return lista2Dependente.exibeLista2Dependente(resultado);
}
}