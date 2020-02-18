package co.com.todo1.entities;

import java.util.Date;

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
@Table(name = "DETALLE_STOCK")
public class DetalleStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "IDDETALLE")
	private int idDetalle;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPRODUCTO", nullable = false)
	private Producto producto;
    
    @Column(nullable = false, name = "FECHA")
	private Date fecha;
    
    @Column(nullable = false, name = "MOVIMIENTO")
	private String movimiento;
    
    @Column(nullable = false, name = "CANTIDAD")
	private int cant;
    
    @Column(nullable = false, name = "PRECIOUND")
    private Double precioUnd;

}
