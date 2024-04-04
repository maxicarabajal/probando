
package com.otrave.denuevo.dto;

import lombok.Data;

@Data
public class DetallePedidoDTO {
    private Long idProducto;
    private String nombre;
    private int cantidad;
    private Double precio;
}
