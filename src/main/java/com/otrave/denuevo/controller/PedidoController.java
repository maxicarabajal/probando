
package com.otrave.denuevo.controller;

import com.otrave.denuevo.dto.PedidoDTO;
import com.otrave.denuevo.model.Pedido;
import com.otrave.denuevo.service.IPedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {
    
    @Autowired
    private IPedidoService serviPedido;
    
    @GetMapping("/pedido/get/all")
    public List<Pedido> getAllPedido(){
        return serviPedido.getAllPedido();
    }
    
    @GetMapping("/pedido/get/{id}")
    public PedidoDTO getOnePedido(@PathVariable Long id){
        PedidoDTO pedi = serviPedido.getOnePedido(id);
        return pedi;
    }
    
    @PostMapping("/pedido/create")
    public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pediDTO){
        PedidoDTO pedido = serviPedido.createPedido(pediDTO);
                
        return ResponseEntity.ok(pedido);
    }
    
    
    @DeleteMapping("/pedido/delete/{id}")
    public String deletePedido(@PathVariable Long id){
        serviPedido.deletePedido(id);
        return "Pedido borrado con exito.";
    }
    
    /*@PostMapping("/pedido/edit/{id}")
    public Pedido editPedido(@RequestBody Pedido pedi, @PathVariable Long id){
        pedi.setIdPedido(id);
        serviPedido.createPedido(pedi);
        return pedi;
    }*/
}
