package co.com.todo1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.todo1.entities.DetalleVenta;
import co.com.todo1.interfaces.IKardex;

@RestController
@RequestMapping("/kardex")
public class KardexController {
	
	@Autowired
	IKardex iKardex;
	
	@RequestMapping(value = "/ventaProducto")
	public String venta(@Valid @RequestBody DetalleVenta detalleVenta) {
		String msg = iKardex.ventaProducto(detalleVenta);
		return msg;
		
	}

}
