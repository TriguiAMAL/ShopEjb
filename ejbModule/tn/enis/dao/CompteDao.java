package tn.enis.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entity.Compte;

/**
 * Session Bean implementation class CompteDao
 */
@Stateless
@LocalBean
public class CompteDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Compte compte) {
		entityManager.persist(compte);
	}

	public Compte findById(Long rib) {
		return entityManager.find(Compte.class, rib);
	}

	public void delete(Compte compte) {
		entityManager.remove(compte);
	}

	public void update(Compte compte) {
		entityManager.merge(compte);
	}

	public List<Compte> findAll() {

		return entityManager.createQuery("select c from Compte c", Compte.class).getResultList();
	}
	public Compte findByCin(String cin) {
		return entityManager.createQuery("select c from Compte c where c.client.cin = :cin", Compte.class)
				.setParameter("cin", cin).getSingleResult();
	}


}
