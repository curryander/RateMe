package app.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import app.model.Poi;



public class PoiDAOImpl implements PoiDAO {

	@PersistenceContext(name = "jpa-unit")
	private EntityManager em;

	@Override
	@Transactional
	public Poi readPoi(long id) {
		return em.find(Poi.class, id);
	}

	@Override
	@Transactional
	public List<Poi> readAllPois() {
		return em.createNamedQuery("Poi.findAll", Poi.class).getResultList();
	}
}
