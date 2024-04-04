
package com.otrave.denuevo.service;

import com.otrave.denuevo.model.Categoria;
import com.otrave.denuevo.repository.ICategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService{
    
    @Autowired
    private ICategoriaRepository repoCategoria;

    @Override
    public List<Categoria> getAllCategoria() {
        return repoCategoria.findAll();
    }

    @Override
    public Categoria getOneCategoria(Long id) {
        Categoria categ = repoCategoria.findById(id).orElse(null);
        return categ;
    }

    @Override
    public void createCategoria(Categoria categoria) {
        repoCategoria.save(categoria);
    }

    @Override
    public void deleteCategoria(Long id) {
        repoCategoria.deleteById(id);
    }

    @Override
    public void editCategoria(Categoria categoria) {
        repoCategoria.save(categoria);
    }
    
}
