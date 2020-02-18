package co.com.todo1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.todo1.entities.Empleado;

public interface EmpleadoDao extends JpaRepository <Empleado, Integer>{

}
