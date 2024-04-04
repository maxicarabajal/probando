
package com.otrave.denuevo.service;

import com.otrave.denuevo.model.Producto;
import com.otrave.denuevo.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository repoProducto;

    @Override
    public List<Producto> getAllProducto() {
        return repoProducto.findAll();
    }

    @Override
    public Producto getOneProducto(Long id) {
        Producto produ = repoProducto.findById(id).orElse(null);
        return produ;
    }

    @Override
    public void createProducto(Producto producto) {
        repoProducto.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        repoProducto.deleteById(id);
    }

    @Override
    public void editProducto(Producto producto) {
        repoProducto.save(producto);
    }
    
}
