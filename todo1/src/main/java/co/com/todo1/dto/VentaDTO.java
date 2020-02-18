package co.com.todo1.dto;

import co.com.todo1.entities.DetalleStock;
import co.com.todo1.entities.DetalleVenta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaDTO {
	
	private DetalleVenta detalleVenta;
	private DetalleStock detalleStock;	

}
