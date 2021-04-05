package com.platzimarket.persistence.mapper;


import com.platzimarket.domain.PurchaseItem;
import com.platzimarket.persistence.entity.ComprasProducto;
import com.platzimarket.persistence.entity.ComprasProductoPK;

public class PurchaseItemMapper {

	
	PurchaseItem toPurchaseItem(ComprasProducto producto) {
		PurchaseItem pi = new PurchaseItem();
		pi.setQuantity(producto.getCantidad());
		pi.setActive(producto.getEstado());
		pi.setTotal(producto.getTotal());
		pi.setProductId(producto.getId().getIdProducto());
		return pi;
	}
	
	
	ComprasProducto toComprasProducto(PurchaseItem purchaseItem) {
		
		ComprasProducto cp = new ComprasProducto();
		cp.setCantidad(purchaseItem.getQuantity());
		cp.setEstado(purchaseItem.isActive());
		cp.setTotal(purchaseItem.getTotal());
		ComprasProductoPK cpPK = new ComprasProductoPK();
		cpPK.setIdProducto(purchaseItem.getProductId());
		cp.setId(cpPK);
		return cp;	
		
	}
	
	
	
	
	
	
}
