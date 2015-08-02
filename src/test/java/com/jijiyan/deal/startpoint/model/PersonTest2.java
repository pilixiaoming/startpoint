package com.jijiyan.deal.startpoint.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class PersonTest2 {
	@Test
	public void savePerson() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("startpointunit");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(new Person("帅呆了1", new Date(), Gender.FEMALE, "I am good"));
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}
	
	@Test
	public void findPerson() {
		//get don't need transcation
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("startpointunit");
		EntityManager em = factory.createEntityManager();
		//em.getTransaction().begin();
		Person p = em.find(Person.class, 1);
		//em.getTransaction().commit();
		System.out.println(p.getName());
		em.close();
		factory.close();
		
	}
	
	@Test
	public void findLazyPerson() {
		//get don't need transcation
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("startpointunit");
		EntityManager em = factory.createEntityManager();
		//em.getTransaction().begin();
		Person p = em.getReference(Person.class, 1);
		//em.getTransaction().commit();
		System.out.println(p.getName());
		em.close();
		factory.close();
		
	}
	
	@Test
	public void update() {
		//get don't need transcation
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("startpointunit");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Person p = em.find(Person.class, 1);
		p.setName("修改了");
		em.getTransaction().commit();
		System.out.println(p.getName());
		em.close();
		factory.close();
	}
	
	@Test
	public void query() {
		//get don't need transcation
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("startpointunit");
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select p from Person p where p.id>?1");
		query.setParameter(1, 0);
		List<Person> list = query.getResultList();
		for(Person p : list){
			System.out.println(p.getName());
		}
		em.close();
		factory.close();
	}
	
	@Test
	public void delete() {
		//get don't need transcation
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("startpointunit");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("delete from Person p where p.id=?1");
		query.setParameter(1, 1);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	@Test
	public void updateQuery() {
		//get don't need transcation
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("startpointunit");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("update Person p set p.name = :name where p.id=:id");
		query.setParameter("name","不帅了");
		query.setParameter("id",1);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
