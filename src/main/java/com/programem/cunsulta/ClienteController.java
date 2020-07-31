package com.programem.cunsulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    
    private ListaCliente listaCliente = new ListaCliente();

    @GetMapping("/")
    public String clienteForm(){
      return "clienteForm";
    }

    @PostMapping(path="/insere") // Map ONLY POST Requests
    public @ResponseBody String addNewCliente (
         @RequestParam String nome
        ,@RequestParam Integer idade
        ,@RequestParam String endereco
        ) {

            Cliente c = new Cliente();

            c.setNome(nome);
            c.setIdade(idade);
            c.setEndereco(endereco);

            clienteRepository.save(c);

            return nome+" de "+idade+" anos, residente do endereço: "+endereco+" foi inserido(a) em nosso banco de dados";
    }

    @GetMapping(path="/lista")
    public @ResponseBody String getAllCliente() {
      
      Iterable<Cliente> resultado = clienteRepository.findAll();
      
      return listaCliente.exibeListaCliente(resultado);
  }

  //FILTRO FORM HERE
  @GetMapping(path="/filtroForm")
  public String filtroForm(){
    return "filtroForm";
  }

  @GetMapping(path="/filtro")
  public @ResponseBody String getCliente(@RequestParam Integer idade) {
    
    Iterable<Cliente> resultado = clienteRepository.findCliente(idade);
    
    return listaCliente.exibeListaCliente(resultado);
}
}