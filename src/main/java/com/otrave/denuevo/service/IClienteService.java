
package com.otrave.denuevo.service;

import com.otrave.denuevo.model.Cliente;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IClienteService {
    
    public List<Cliente> getAllCliente();
    
    public Cliente getOneCliente(Long id);
    
    public void createCliente(Cliente cliente);
    
    public void deleteCliente(Long id);
    
    public void editCliente(Cliente cliente);

    
}
