package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Item;
import com.example.demo.service.IItemService;

@SpringBootApplication
public class EjercicioU3PaP3AnApplication implements CommandLineRunner {

	@Autowired
	IItemService itemService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioU3PaP3AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Funcionalidad 1:
		Item obj1 = new Item();
		obj1.setCodigoBarras("A152RT32");
		obj1.setNombre("Lapiz");
		obj1.setPrecio(new BigDecimal(0.45));
		obj1.setStock(1);
		obj1.setTipo("Utiles escolares");
		obj1.setDetalle(null);
		
		this.itemService.Insertar(obj1);
		
		//Funcionalidad 2:
		this.itemService.MostrarStock("A152RT32");
		
		//Funcionalidad opcional:
		this.itemService.Insertar(obj1);
		Item obj2 = this.itemService.BuscarCodigoBarras("A152RT32");
		System.out.println(obj2);
	}

}
