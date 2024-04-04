
package com.otrave.denuevo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Cliente {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idCliente;
    
    private String nombre;
    private String apellido;
    private String dni;
    
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
    
}
