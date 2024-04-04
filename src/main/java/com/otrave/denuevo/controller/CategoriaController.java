
package com.otrave.denuevo.controller;

import com.otrave.denuevo.model.Categoria;
import com.otrave.denuevo.service.ICategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
    
    @Autowired
    private ICategoriaService serviCategoria;
    
    @GetMapping("/categoria/get/all")
    public List<Categoria> getAllCategoria(){
        return serviCategoria.getAllCategoria();
    }
    
    @GetMapping("/categoria/get/{id}")
    public Categoria getOneCategoria(@PathVariable Long id){
        Categoria cate = serviCategoria.getOneCategoria(id);
        return cate;
    }
    
    @PostMapping("/categoria/create")
    public String createCategoria(@RequestBody Categoria cate){
        serviCategoria.createCategoria(cate);
        return "Categoria cargada con exito.";
    }
    
    @DeleteMapping("/categoria/delete/{id}")
    public String deleteCategoria(@PathVariable Long id){
        serviCategoria.deleteCategoria(id);
        return "Categoria eleminada con exito.";
    }
    
    @PostMapping("/categoria/edit/{id}")
    public Categoria editCategoria(@RequestBody Categoria cate, @PathVariable Long id){
        
        cate.setIdCategoria(id);
        serviCategoria.editCategoria(cate);
        return cate;
    }
    
    
}
