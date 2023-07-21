package app.dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import app.dto.RegistrationData;
import app.model.User;
import app.util.PasswordTools;



public class UserDAOImpl implements UserDAO {

	@PersistenceContext(name = "jpa-unit")
	private EntityManager em;


	@Override
	@Transactional
	public User createUser(RegistrationData data) {
		User user = new User();
		user.setCity(data.getCity());
		user.setEmail(data.getEmail());
		user.setFirstname(data.getFirstname());
		user.setLastname(data.getLastname());
		user.setStreet(data.getStreet());
		user.setStreetNr(data.getStreetNr());
		user.setUsername(data.getUsername());
		user.setZip(data.getZip());

		byte[] salt;
		byte[] passwordHash;
		try {
			salt = PasswordTools.generateSalt();
			passwordHash = PasswordTools.generatePasswordHash(data.getPassword(), salt);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR User creation failed: " + e.getMessage());
		}

		user.setPasswordSalt(salt);
		user.setPasswordHash(passwordHash);

		em.persist(user);
		em.flush();
		em.refresh(user);

		return user;
	}

	@Override
	@Transactional
	public User readUser(int id) {
		return em.find(User.class, id);
	}

	@Override
	@Transactional
	public User readUser(String userName) {
		return em.createNamedQuery("User.findByUserName", User.class).setParameter("userName", userName)
				.getSingleResult();
	}

}
