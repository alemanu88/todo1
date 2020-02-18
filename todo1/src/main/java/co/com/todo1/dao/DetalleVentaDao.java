package co.com.todo1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.todo1.entities.DetalleVenta;

public interface DetalleVentaDao extends JpaRepository<DetalleVenta, Integer> {

}
