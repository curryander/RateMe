package app.dao;

import app.dto.RegistrationData;
import app.model.User;

public interface UserDAO {
	User createUser(RegistrationData data);

	User readUser(int id);

	User readUser(String userName);
}
