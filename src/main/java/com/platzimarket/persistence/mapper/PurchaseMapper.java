package com.platzimarket.persistence.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.platzimarket.domain.Purchase;
import com.platzimarket.domain.PurchaseItem;
import com.platzimarket.persistence.entity.Compra;
import com.platzimarket.persistence.entity.ComprasProducto;

public class PurchaseMapper {

	Purchase toPurchase(Compra compra) {
		
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(compra.getIdCompra());
		purchase.setClientId(compra.getIdCliente());
		purchase.setDate(compra.getFecha());
		purchase.setPaymentMethod(compra.getMedioPago());
		purchase.setComment(compra.getComentario());
		purchase.setState(compra.getEstado());
		ArrayList<PurchaseItem> listItems = new ArrayList<>();
		ArrayList<ComprasProducto> listaProductos = (ArrayList<ComprasProducto>) compra.getComprasProducto();
		PurchaseItemMapper mapper = new PurchaseItemMapper();
		for (ComprasProducto comprasProducto : listaProductos) {
			listItems.add(mapper.toPurchaseItem(comprasProducto));
		}
		purchase.setItems(listItems);
		return purchase;
	};
		
	Compra toCompra(Purchase purchase){
		Compra compra = new Compra();
		compra.setIdCompra(purchase.getPurchaseId());
		compra.setIdCliente(purchase.getClientId());
		compra.setFecha(purchase.getDate());
		compra.setMedioPago(purchase.getPaymentMethod());
		compra.setComentario(purchase.getComment());
		compra.setEstado(purchase.getState());
		ArrayList<ComprasProducto> listaProductos=new ArrayList<>();
		ArrayList<PurchaseItem> listItems = (ArrayList<PurchaseItem>) purchase.getItems();
		PurchaseItemMapper mapper = new PurchaseItemMapper();
		for (PurchaseItem purchaseItem : listItems) {
			listaProductos.add(mapper.toComprasProducto(purchaseItem));
		}
		compra.setComprasProducto(listaProductos);
		return compra;
	}


	
	
	
	
	
}
