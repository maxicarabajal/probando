
package com.otrave.denuevo.service;

import com.otrave.denuevo.dto.DetallePedidoDTO;
import com.otrave.denuevo.dto.PedidoDTO;
import com.otrave.denuevo.model.DetallePedido;
import com.otrave.denuevo.model.Pedido;
import com.otrave.denuevo.model.Producto;
import com.otrave.denuevo.repository.IClienteRepository;
import com.otrave.denuevo.repository.IDetallePedidoRepository;
import com.otrave.denuevo.repository.IPedidoRepository;
import com.otrave.denuevo.repository.IProductoRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService implements IPedidoService{
    
    @Autowired
    private IPedidoRepository repoPedido;
    
    @Autowired
    private IProductoRepository repoProducto;
    
    @Autowired
    private IDetallePedidoRepository repoDetalle;
    
    @Autowired 
    private IClienteRepository repoCliente;

    @Override
    public List<Pedido> getAllPedido() {
        return repoPedido.findAll();
    }

    @Override
    public PedidoDTO getOnePedido(Long id) {
        Pedido pedido = repoPedido.findById(id).orElse(null);
        
        PedidoDTO pediDTO = convertDTO(pedido);
        
        return pediDTO;
    }

    @Transactional
    @Override
    public PedidoDTO createPedido(PedidoDTO pedidoDTO) {
        
        Pedido pedido = new Pedido();
        pedido.setCliente(repoCliente.findById(pedidoDTO.getClienteId()).orElse(null));
        List<DetallePedido> detallesGuardados = new ArrayList<>();
        double precioTotal = 0;
        
        for(DetallePedidoDTO detalleDTO: pedidoDTO.getDetalles()){
            Producto producto = repoProducto.findById(detalleDTO.getIdProducto()).orElse(null);
            if(producto.getStock()>=detalleDTO.getCantidad()){
                producto.setStock(producto.getStock()-detalleDTO.getCantidad());
                repoProducto.save(producto);
                
                
                DetallePedido detalle = new DetallePedido();
                detalle.setPedido(pedido);
                detalle.setProducto(producto);
                detalle.setCantidad(detalleDTO.getCantidad());
                detalle.setPrecio(producto.getPrecio()*detalleDTO.getCantidad());
                detallesGuardados.add(detalle);
                
                precioTotal += producto.getPrecio() * detalleDTO.getCantidad();
                
            }
            else{
                throw new RuntimeException("Stock insuficiente para el procuto: "+producto.getNombre());
            }
        }
        //asignamos los datos restantes de pedido y lo guardamos en la base de datos
        pedido.setDetalles(detallesGuardados);
        pedido.setTotal(precioTotal);
        repoPedido.save(pedido);
        //en base al pedido obtenido lo convertimos en dto para retornarlo y enviar los datos importantes
        return convertDTO(pedido);
    }
    
    
    public PedidoDTO convertDTO(Pedido pedido){
        PedidoDTO pediDTO = new PedidoDTO();
        
        pediDTO.setClienteId(pedido.getCliente().getIdCliente());
        pediDTO.setPrecioTotal(pedido.getTotal());
        
        List<DetallePedidoDTO> detallesDTO = new ArrayList<>();
        
        for(DetallePedido det:pedido.getDetalles()){
            DetallePedidoDTO detalleDTO = new DetallePedidoDTO();
            detalleDTO.setIdProducto(det.getIdDetallePedido());
            detalleDTO.setIdProducto(det.getProducto().getIdProducto());
            detalleDTO.setCantidad(det.getCantidad());
            detalleDTO.setPrecio(det.getPrecio());
            detalleDTO.setNombre(det.getProducto().getNombre());
            
            detallesDTO.add(detalleDTO);
            
        }
        
        pediDTO.setDetalles(detallesDTO);
                
        
        return pediDTO;
    }

    @Override
    public void deletePedido(Long id) {
        repoPedido.deleteById(id);
        
    }

    @Override
    public void editPedido(Pedido pedido) {
        repoPedido.save(pedido);
    }
}
