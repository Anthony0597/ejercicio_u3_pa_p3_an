package com.example.demo.service;

import com.example.demo.modelo.Item;

public interface IItemService {
	public void Insertar(Item item);
	public Item BuscarCodigoBarras(String codigoBarras);
	public void MostrarStock(String codigoBarras);
}
