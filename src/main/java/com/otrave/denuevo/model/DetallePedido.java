
package com.otrave.denuevo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class DetallePedido {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonIgnore
    private Long idDetallePedido;
    
    private int cantidad;
    
    //relacion muchos a uno con Producto(Un producto puede tener muchos DetallesPedidos)
    @ManyToOne()
    @JoinColumn( name = "producto_id")
    private Producto producto;
        
    private Double precio;
    
    //relacion muchos a uno con Pedido
    @ManyToOne()
    @JoinColumn( name = "pedido_id")
    private Pedido pedido;
}
