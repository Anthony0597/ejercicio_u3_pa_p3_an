package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Item;
import com.example.demo.repo.IItemRepo;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemRepo itemRepo;
	
	@Override
	public void Insertar(Item item) {
		// TODO Auto-generated method stub
		
		if(this.itemRepo.BuscarCodigoBarras(item.getCodigoBarras())==null) {
			this.itemRepo.Insertar(item);
		}else {
			Item temp = this.itemRepo.BuscarCodigoBarras(item.getCodigoBarras());
			int stock=temp.getStock();
			stock++;
			temp.setStock(stock);
			this.itemRepo.Actualizar(temp);
		}
		/*
		Item temp = this.itemRepo.BuscarCodigoBarras(item.getCodigoBarras());
		if(temp!=null) {
			int stock=temp.getStock();
			stock++;
			temp.setStock(stock);
			this.itemRepo.Actualizar(temp);
		}else {
			this.itemRepo.Insertar(item);
		}*/
	}

	@Override
	public Item BuscarCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.itemRepo.BuscarCodigoBarras(codigoBarras);
	}


	@Override
	public void MostrarStock(String codigoBarras) {
		// TODO Auto-generated method stub
		Item item = this.itemRepo.BuscarStock(codigoBarras);
		System.out.println("Stock del item "+item.getNombre()+": "+item.getStock());
	}

}
