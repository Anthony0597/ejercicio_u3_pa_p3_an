package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ItemRepoImpl implements IItemRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void Insertar(Item item) {
		// TODO Auto-generated method stub
		this.entityManager.persist(item);
	}

	@Override
	public Item BuscarCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNamedQuery("Item.BuscarCodigoBarras");
		query.setParameter("datoCodigo", codigoBarras);
		return (Item) query.getSingleResult();
	}


	@Override
	public void Actualizar(Item item) {
		// TODO Auto-generated method stub
		this.entityManager.merge(item);
	}

	@Override
	public Item BuscarStock(String codigoBarras) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Item> query = builder.createQuery(Item.class);
		Root<Item> tablaFrom = query.from(Item.class);
		
		Predicate condicion = builder.equal(tablaFrom.get("codigoBarras"), codigoBarras);
		
		query.select(tablaFrom).where(condicion);
		
		TypedQuery<Item> mySQL = this.entityManager.createQuery(query);
		return mySQL.getSingleResult();
	}

}
