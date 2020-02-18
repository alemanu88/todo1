package co.com.todo1.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTO")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "IDPRODUCTO")
	private int idProducto;
	
	@Column(nullable = false, name = "DESCRIPCION")
	private String descripcion;
	
	@Column(nullable = false, name = "STOCK")
	private int cantStock;
	
	@Column(nullable = false, name = "PRECIO")
	private Double precio;
	
    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalleVentas;
    
    @OneToMany(mappedBy = "producto")
    private List<DetalleStock> detalleStocks;

}
