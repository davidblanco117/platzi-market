package com.platzimarket.persistence.mapper;


import org.springframework.stereotype.Component;
import com.platzimarket.domain.Category;
import com.platzimarket.persistence.entity.Categoria;

@Component
public class CategoryMapper {

	Category toCategory(Categoria categoria) {
		Category category = new Category();
		category.setCategoryId(categoria.getIdCategoria());
		category.setCategory(categoria.getDescripcion());
		category.setActive(categoria.getEstado());
		return category;
	};
	
	
	Categoria toCategoria(Category category) {
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(category.getCategoryId());
		categoria.setEstado(category.isActive());
		categoria.setDescripcion(category.getCategory());
		
		
		return categoria;
	};
	
	
	
}
