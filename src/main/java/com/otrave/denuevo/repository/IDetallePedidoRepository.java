
package com.otrave.denuevo.repository;

import com.otrave.denuevo.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetallePedidoRepository extends JpaRepository <DetallePedido, Long>{
    
}
