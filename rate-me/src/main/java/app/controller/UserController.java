package app.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import app.dto.RegistrationData;
import app.dto.UserResponseData;
import app.dao.UserDAO;
import app.model.User;


@Path("user")
public class UserController {

	@Inject
	private UserDAO userDAO;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(RegistrationData registrationData) {
		
		System.out.println();
		System.out.println("Register " + registrationData );
		
		final User createdUser = userDAO.createUser(registrationData);
		
	return Response.ok().entity(createdUser).build();
	}

	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("userId") int userId) {
		final User user = userDAO.readUser(userId);

		final UserResponseData userData = UserResponseData.fromEntity(user);

		return Response.ok().entity(userData).build();
	}
}
