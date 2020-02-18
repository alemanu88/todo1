package co.com.todo1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.todo1.entities.DetalleStock;

public interface DetalleStockDao extends JpaRepository<DetalleStock, Integer> {

}
