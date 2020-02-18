package co.com.todo1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.todo1.entities.Producto;
import co.com.todo1.interfaces.IProducto;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	IProducto iProducto;

	@RequestMapping("/adicionarProducto")
	public String adicionarProducto(@Valid @RequestBody Producto producto) {
		String res = iProducto.adicionarProducto(producto);
		return res;
	}

	@RequestMapping("/modificarProducto")
	public String modificarProducto(@Valid @RequestBody Producto producto) {
		String res = iProducto.modificarProducto(producto);
		return res;
	}

	@RequestMapping("/consultarProductoById")
	public Producto consultarProductoById(@RequestParam(name = "idProducto") int idProducto) {
		Producto prod = iProducto.consultarProductoById(idProducto);
		return prod;
	}

	@RequestMapping("/consultarTodosProductos")
	public List<Producto> consultarTodosProducto() {
		List<Producto> listaProd = iProducto.consultarTodosProducto();
		return listaProd;
	}

	@DeleteMapping("/eliminarProducto/{idProducto}")
	public String eliminarProducto(@PathVariable int idProducto) {
		String msg = iProducto.eliminarProducto(idProducto);
		return msg;
	}

}
