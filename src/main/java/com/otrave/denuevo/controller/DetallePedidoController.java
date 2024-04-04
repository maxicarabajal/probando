
package com.otrave.denuevo.controller;

import com.otrave.denuevo.model.DetallePedido;
import com.otrave.denuevo.service.IDetallePedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetallePedidoController {
    
    @Autowired
    private IDetallePedidoService serviDetalle;
    
    @GetMapping("/detalle/get/all")
    public List<DetallePedido> getAllDetallePedido(){
        return serviDetalle.getAllDetallePedido();
    }
    
    @GetMapping("/detalle/get/{id}")
    public DetallePedido getOneDetallePedido(@PathVariable Long id){
        DetallePedido detalle = serviDetalle.getOneDetallePedido(id);
        return detalle;
    }
    
    @PostMapping("/detalle/create")
    public String createDetallePedido(@RequestBody DetallePedido detalle){
        serviDetalle.createDetallePedido(detalle);
        return "DetallePedido realizado con exito.";
    }
    
    @DeleteMapping("/detalle/delete/{id}")
    public String deleteDetallePedido(@PathVariable Long id){
        serviDetalle.deleteDetallePedido(id);
        return "Detalle Pedido borrado con exito.";
    }
    
    @PostMapping("/pedido/edit/{id}")
    public DetallePedido editDetallePedido(@RequestBody DetallePedido detalle, @PathVariable Long id){
        detalle.setIdDetallePedido(id);
        serviDetalle.createDetallePedido(detalle);
        return detalle;
    }
}
