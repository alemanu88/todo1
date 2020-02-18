package co.com.todo1.interfaces;

import java.util.List;

import co.com.todo1.entities.Producto;

public interface IProducto {
	
	public String adicionarProducto(Producto producto);
	
	public String modificarProducto(Producto producto);
	
	public Producto consultarProductoById(int producto);
	
	public List<Producto> consultarTodosProducto();
	
	public String eliminarProducto(int idProducto);	

}
