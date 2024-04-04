
package com.otrave.denuevo.service;

import com.otrave.denuevo.model.Cliente;
import com.otrave.denuevo.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private IClienteRepository repoCliente;

    @Override
    public List<Cliente> getAllCliente() {
        return repoCliente.findAll();
    }

    @Override
    public void createCliente(Cliente cliente) {
        repoCliente.save(cliente);
    }

    @Override
    public Cliente getOneCliente(Long id) {
        Cliente cliente = repoCliente.findById(id).orElse(null);
        return cliente;
    }

    @Override
    public void deleteCliente(Long id) {
        repoCliente.deleteById(id);
    }

    @Override
    public void editCliente(Cliente cliente) {
        repoCliente.save(cliente);
    }

    
}
