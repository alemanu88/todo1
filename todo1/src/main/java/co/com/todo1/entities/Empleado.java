package co.com.todo1.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EMPLEADO")
public class Empleado {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "IDEMPLEADO")
	private int idEmpleado;
	
	@Column(nullable = false, name = "NOMBRE")
	private String nombre;
	
	@Column(nullable = false, name = "APELLIDO")
	private String apellido;
	
	@Column(nullable = false, name = "TIPODOCUMENTO")
	private String tipoDocumento;
	
	@Column(nullable = false, name = "NUMDOCUMENTO")
	private String numDocumento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "empleado")
    private List<DetalleVenta> detalleVentas;
	
}
