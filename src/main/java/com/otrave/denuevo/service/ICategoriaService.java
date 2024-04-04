
package com.otrave.denuevo.service;

import com.otrave.denuevo.model.Categoria;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ICategoriaService {
    
    public List<Categoria> getAllCategoria();
    
    public Categoria getOneCategoria(Long id);
    
    public void createCategoria(Categoria categoria);
    
    public void deleteCategoria(Long id);
    
    public void editCategoria(Categoria categoria);
}
