
package com.otrave.denuevo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Categoria {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idCategoria;
    
    private String nombre;
    
    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
    
}
