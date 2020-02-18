package co.com.todo1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.todo1.entities.Empleado;
import co.com.todo1.interfaces.IEmpleado;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class EmpleadoController {

	@Autowired
	IEmpleado iEmpleado;

	@PostMapping("/adicionarEmpleado")
	public Empleado adicionarEmpleado(@Valid @RequestBody Empleado empleado) {
		Empleado empleadoSaved = iEmpleado.adicionarEmpleado(empleado);
		System.out.println("guardando");
		return empleadoSaved;
	}

	@RequestMapping("/modificarEmpleado")
	public String modificarEmpleado(@Valid @RequestBody Empleado producto) {
		String res = iEmpleado.modificarEmpleado(producto);
		return res;
	}

	@RequestMapping("/consultarEmpleadoById")
	public Empleado consultarEmpleadoById(@RequestParam(name = "idEmpleado") int idEmpleado) {
		Empleado prod = iEmpleado.consultarEmpleadoById(idEmpleado);
		return prod;
	}

	@RequestMapping("/consultarTodosEmpleados")
	public List<Empleado> consultarTodosEmpleado() {
		System.out.println("viene del front");
		List<Empleado> listaProd = iEmpleado.consultarTodosEmpleado();
		return listaProd;
	}

	@DeleteMapping("/eliminarEmpleado/{idEmpleado}")
	public String eliminarEmpleado(@PathVariable int idEmpleado) {
		String msg = iEmpleado.eliminarEmpleado(idEmpleado);
		return msg;
	}

}
