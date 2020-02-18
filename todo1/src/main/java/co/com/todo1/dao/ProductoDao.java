package co.com.todo1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.todo1.entities.Producto;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Integer>{	
   

}
