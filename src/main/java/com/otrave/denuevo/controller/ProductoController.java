
package com.otrave.denuevo.controller;

import com.otrave.denuevo.model.Producto;
import com.otrave.denuevo.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService serviProducto;
    
    @GetMapping("/producto/get/all")
    public List<Producto> getAllProducto(){
        return serviProducto.getAllProducto();
    }
    
    @GetMapping("/producto/get/{id}")
   public Producto getOneProducto(@PathVariable Long id){
       Producto produ = serviProducto.getOneProducto(id);
       return produ;
    }
   
   @PostMapping("/producto/create")
   public String createProducto(@RequestBody Producto produ){
       serviProducto.createProducto(produ);
       return "Producto cargado con exito.";
   }
   
   @DeleteMapping("/producto/delete/{id}")
   public String deleteProducto(@PathVariable Long id){
       serviProducto.deleteProducto(id);
       return "Producto eliminado con exito.";
    }
   
   @PostMapping("/producto/edit/{id}")
   public Producto editProducto(@RequestBody Producto produ, @PathVariable Long id){
       produ.setIdProducto(id);
       serviProducto.editProducto(produ);
       return produ;
   }
   
}
