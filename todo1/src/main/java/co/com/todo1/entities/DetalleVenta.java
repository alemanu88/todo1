package co.com.todo1.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DETALLE_VENTA")
public class DetalleVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "IDDETALLE")
	private int IdDetalle;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPRODUCTO", nullable = false)
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDEMPLEADO", nullable = false)
	private Empleado empleado;
	
	@Column(nullable = false, name = "FECHAVENTA")
	private Calendar fechaVenta;
	
	@Column(nullable = false, name = "PRECIOUND")
	private Double precioUnd;
	
	@Column(nullable = false, name = "CANTIDAD")
	private int cant;

}
