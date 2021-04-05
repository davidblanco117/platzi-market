package com.platzimarket.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.platzimarket.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {
	
	//@Query(value ="select * from productos where idCategoria = ?", nativeQuery = true)
	List<Producto> findByIdCategoria(int idCategoria);
	
	Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
	
	
	

}
