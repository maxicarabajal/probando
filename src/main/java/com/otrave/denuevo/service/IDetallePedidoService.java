
package com.otrave.denuevo.service;

import com.otrave.denuevo.model.DetallePedido;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IDetallePedidoService {
    
    public List<DetallePedido> getAllDetallePedido();
    
    public DetallePedido getOneDetallePedido(Long id);
    
    public void createDetallePedido(DetallePedido detalle);
    
    public void deleteDetallePedido(Long id);
    
    public void editDetallePedido(DetallePedido detalle);
}
