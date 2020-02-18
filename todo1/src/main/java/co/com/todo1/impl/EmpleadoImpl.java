package co.com.todo1.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.todo1.dao.EmpleadoDao;
import co.com.todo1.entities.Empleado;
import co.com.todo1.interfaces.IEmpleado;

@Service
public class EmpleadoImpl implements IEmpleado{
	
	@Autowired
	EmpleadoDao empleadoDao;

	@Override
	public Empleado adicionarEmpleado(Empleado empleado) {

		Empleado empleadoSaved = new Empleado();
		try {
			empleadoDao.save(empleado);
			return empleadoSaved;
		} catch (Exception e) {
			return empleadoSaved;
		}
	}

	@Override
	public String modificarEmpleado(Empleado empleado) {
		try {
			Optional<Empleado> empleadoSave = empleadoDao.findById(empleado.getIdEmpleado());			
			if(!empleadoSave.isPresent()) {
				return "No se encuentra un registro relacionado al parametro dado";
			}
			empleadoDao.save(empleado);
			return "Empleado modificado exitosamente";
		} catch (Exception e) {
			return "Error al tratar de modificar el empleado";
		}
	}

	@Override
	public Empleado consultarEmpleadoById(int idEmpleado) {
		Optional<Empleado> empleadoRes = empleadoDao.findById(idEmpleado);
		return empleadoRes.get();

	}

	@Override
	public List<Empleado> consultarTodosEmpleado() {
		List<Empleado> empleadoList = empleadoDao.findAll();
		return empleadoList;
	}

	public String eliminarEmpleado(int idEmpleado) {
		try {
			Optional<Empleado> empleadoSave = empleadoDao.findById(idEmpleado);
			if(!empleadoSave.isPresent()) {
				return "No se encuentra un registro relacionado al parametro dado";
			}
			empleadoDao.deleteById(idEmpleado);
			return "Empleado eliminado exitosamente";
		} catch (Exception e) {
			return "Error al eliminar empleado";
		}
		
	}



}
