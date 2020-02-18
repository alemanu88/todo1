package co.com.todo1.interfaces;

import java.util.List;

import co.com.todo1.entities.Empleado;

public interface IEmpleado {
	
	public Empleado adicionarEmpleado(Empleado empleado);
	
	public String modificarEmpleado(Empleado empleado);
	
	public Empleado consultarEmpleadoById(int empleado);
	
	public List<Empleado> consultarTodosEmpleado();
	
	public String eliminarEmpleado(int idEmpleado);	
	

}
