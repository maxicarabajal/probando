
package com.otrave.denuevo.service;

import com.otrave.denuevo.model.Producto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IProductoService {
    
    public List<Producto> getAllProducto();
    
    public Producto getOneProducto(Long id);
    
    public void createProducto(Producto producto);
    
    public void deleteProducto(Long id);
    
    public void editProducto(Producto producto);
}
