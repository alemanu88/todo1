package co.com.todo1.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.todo1.dao.DetalleStockDao;
import co.com.todo1.dao.DetalleVentaDao;
import co.com.todo1.dao.ProductoDao;
import co.com.todo1.entities.DetalleStock;
import co.com.todo1.entities.DetalleVenta;
import co.com.todo1.entities.Producto;
import co.com.todo1.interfaces.IKardex;

@Service
public class KardexImpl implements IKardex{
	
	@Autowired
	ProductoDao productoDao;
	
	@Autowired
	DetalleVentaDao detalleVentaDao;
	
	@Autowired
	DetalleStockDao detalleStockDao;
	
	

	@Override
	public String ventaProducto(DetalleVenta detalleVenta) {
		
		int saldo = 0;
		//Validar si el producto cuenta con stock disponible para la cantidad solicitada en la venta
		Optional<Producto> prod = productoDao.findById(detalleVenta.getProducto().getIdProducto());
		if(prod.get().getCantStock() < detalleVenta.getCant()) {
			return "No se encuentra la cantidad requeridad en el stock del producto";
		}

		detalleVentaDao.save(detalleVenta);
		
		DetalleStock detalleStock = new DetalleStock();
		detalleStock.setCant(detalleVenta.getCant());
		detalleStock.setFecha(new Date());
		detalleStock.setProducto(detalleVenta.getProducto());
		detalleStock.setMovimiento("salida");
		detalleStockDao.save(detalleStock);
		
		
		saldo = prod.get().getCantStock() - detalleVenta.getCant();
		//Actualizar cantidad de stock del producto
		Producto producto  = new Producto();
		producto.setCantStock(saldo);
		producto.setDescripcion(prod.get().getDescripcion());
		producto.setPrecio(prod.get().getPrecio());
		producto.setIdProducto(prod.get().getIdProducto());
		
		productoDao.save(producto);
		
		
		return "Venta realizada exitosamente";
	}

}
