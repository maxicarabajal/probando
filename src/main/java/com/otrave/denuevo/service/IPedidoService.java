
package com.otrave.denuevo.service;

import com.otrave.denuevo.dto.PedidoDTO;
import com.otrave.denuevo.model.Pedido;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IPedidoService {
    
    public List<Pedido> getAllPedido();
    
    public PedidoDTO getOnePedido(Long id);
    
    public PedidoDTO createPedido(PedidoDTO pedidoDTO);
    
    public void deletePedido(Long id);
    
    public void editPedido(Pedido pedido);
}
