
package com.otrave.denuevo.controller;

import com.otrave.denuevo.model.Cliente;
import com.otrave.denuevo.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService serviCliente;
    
    @PostMapping("/cliente/create")
    public String createCliente(@RequestBody Cliente cli){
        serviCliente.createCliente(cli);
        return "Cliente cargado con exito.";
    }
    
    @DeleteMapping("/cliente/delete/{id}")
    public String deleteCliente(@PathVariable Long id){
        serviCliente.deleteCliente(id);
        return "Cliente borrado con exito.";
    }
    
    
    @GetMapping("/cliente/get/all")
    public List<Cliente> getAllCliente(){
        return serviCliente.getAllCliente();
    }
    
    @GetMapping("/cliente/get/{id}")
    public Cliente getOneCliente(@PathVariable Long id){
        Cliente cliente = serviCliente.getOneCliente(id);
        return cliente;
    }
    
    @PostMapping("/cliente/edit/{id}")
    public Cliente editCliente(@RequestBody Cliente cliente, @PathVariable Long id){
        cliente.setIdCliente(id);
        serviCliente.editCliente(cliente);
        return cliente;
    }
    
}
