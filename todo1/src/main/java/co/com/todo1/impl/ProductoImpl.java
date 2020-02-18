package co.com.todo1.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.todo1.dao.DetalleStockDao;
import co.com.todo1.dao.ProductoDao;
import co.com.todo1.entities.DetalleStock;
import co.com.todo1.entities.Producto;
import co.com.todo1.interfaces.IProducto;

@Service
public class ProductoImpl implements IProducto {

	@Autowired
	ProductoDao productoDao;
	
	@Autowired
	DetalleStockDao detalleStockDao;

	@Override
	public String adicionarProducto(Producto producto) {

		try {
			Producto prod = productoDao.save(producto);
			
			DetalleStock detalleStock = new DetalleStock();
			detalleStock.setCant(producto.getCantStock());
			detalleStock.setFecha(new Date());
			detalleStock.setProducto(prod);
			detalleStock.setMovimiento("entrada");
			detalleStock.setPrecioUnd(prod.getPrecio());
			detalleStockDao.save(detalleStock);
			
			return "Producto registrado exitosamente";
		} catch (Exception e) {
			return "Error al tratar de registrar el producto";
		}
	}

	@Override
	public String modificarProducto(Producto producto) {
		try {
			Optional<Producto> prodSave = productoDao.findById(producto.getIdProducto());
			if(!prodSave.isPresent()) {
				return "No se encuentra un registro relacionado al parametro dado";
			}
			productoDao.save(producto);
			return "Producto modificado exitosamente";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al tratar de modificar el producto";
		}
	}

	@Override
	public Producto consultarProductoById(int idProducto) {
		Optional<Producto> prodRes = productoDao.findById(idProducto);
		return prodRes.get();

	}

	@Override
	public List<Producto> consultarTodosProducto() {
		List<Producto> prodList = productoDao.findAll();
		return prodList;
	}

	public String eliminarProducto(int idProducto) {
		try {
			Optional<Producto> prodSave = productoDao.findById(idProducto);
			if(!prodSave.isPresent()) {
				return "No se encuentra un registro relacionado al parametro dado";
			}
			productoDao.deleteById(idProducto);
			return "Producto eliminado exitosamente";
		} catch (Exception e) {
			return "Error al eliminar producto";
		}
		
	}

}
