
package com.otrave.denuevo.service;

import com.otrave.denuevo.model.DetallePedido;
import com.otrave.denuevo.repository.IDetallePedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoService implements IDetallePedidoService{
    
    @Autowired
    private IDetallePedidoRepository repoDetalle;

    @Override
    public List<DetallePedido> getAllDetallePedido() {
        return repoDetalle.findAll();
    }

    @Override
    public DetallePedido getOneDetallePedido(Long id) {
        DetallePedido detalle = repoDetalle.findById(id).orElse(null);
        return detalle;
    }

    @Override
    public void createDetallePedido(DetallePedido detalle) {
        repoDetalle.save(detalle);
    }

    @Override
    public void deleteDetallePedido(Long id) {
        repoDetalle.deleteById(id);
    }

    @Override
    public void editDetallePedido(DetallePedido detalle) {
        repoDetalle.save(detalle);
    }
    
}
