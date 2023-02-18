package com.example.demo.repo;

import com.example.demo.modelo.Item;

public interface IItemRepo {
	public void Insertar(Item item);
	public Item BuscarCodigoBarras(String codigoBarras);
	public Item BuscarStock(String codigoBarras);
	public void Actualizar(Item item);
}
