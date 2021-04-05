package com.platzimarket.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.platzimarket.domain.Category;
import com.platzimarket.domain.Product;
import com.platzimarket.persistence.entity.Categoria;
import com.platzimarket.persistence.entity.Producto;

@Component
public class ProductMapper {
	

	public Product toProduct(Producto producto) {
		Product product = new Product();
		product.setProductId(producto.getIdProducto());
		product.setName(producto.getNombre());
		product.setCategoryId(producto.getIdCategoria());
		product.setPrice(producto.getPrecioVenta());
		product.setStock(producto.getCantidadStock());
		product.setActive(producto.getEstado());
		CategoryMapper mapper = new CategoryMapper();
		Category category = null;
		Categoria categoria = producto.getCategoria();
		if(categoria!=null)
			category = mapper.toCategory(categoria);
		product.setCategory(category);;
		return product;
	};
	
	
	public List<Product> toProducts(List<Producto> productos){
		ArrayList<Product> products = new ArrayList<Product>();
		for (Producto producto : productos) {
			products.add(toProduct(producto));
			
		}
		return products;
	};
	
	
	
	
	public Producto toProducto(Product product) {
		Producto producto = new Producto();
		producto.setIdProducto(product.getProductId());
		producto.setNombre(product.getName());
		producto.setIdCategoria(product.getCategoryId());
		producto.setPrecioVenta(product.getPrice());
		producto.setCantidadStock(product.getStock());
		producto.setEstado(product.isActive());
		CategoryMapper mapper = new CategoryMapper();
		Categoria categoria = null;
		Category category = product.getCategory();
		if(category!=null)
			categoria = mapper.toCategoria(category);
		
		producto.setCategoria(categoria);

		return producto;
	};
	
}
