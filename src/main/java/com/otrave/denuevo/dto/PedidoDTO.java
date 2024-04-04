
package com.otrave.denuevo.dto;

import java.util.List;
import lombok.Data;

@Data
public class PedidoDTO {
    private Long clienteId;
    
    private Double precioTotal;
    
    private List<DetallePedidoDTO> detalles;
}
