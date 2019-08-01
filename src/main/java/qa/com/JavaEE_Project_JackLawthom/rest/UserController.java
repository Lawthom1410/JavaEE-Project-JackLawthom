package qa.com.JavaEE_Project_JackLawthom.rest;

import java.nio.channels.AcceptPendingException;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import qa.com.JavaEE_Project_JackLawthom.service.UserService;

@Path("/User")
public class UserController {

	@Inject
	private UserService service;
	
	@Path("/create")
	@POST
	public String createUser(String user) {
		return this.service.createUser(user);
	}
	
	@Path("/delete/{id}")
	@DELETE
	public String deleteUser(@PathParam("id") long id) {
		return this.service.deleteUser(id);
	}
	
	@Path("/update/{id}")
	@POST
	public String updateUser(@PathParam("id") long id, String user) {
		return this.service.updateUser(id, user);
	}
	
	@Path("/getAll")
	@GET
	public String getAllUsers() {
		if (this.service == null) {
			throw new AcceptPendingException();
		}
		return this.service.getAllUsers();
	}
	
	@Path("/login/{username}/{password}")
	@GET
	public String login(
			@PathParam("username") String username,
			@PathParam("password") String password) {
		return this.service.login(username, password);
	}
	
	@Path("/getById/{id}")
	@GET
	public String getUserById(@PathParam("id") long id) {
		return this.service.getUserById(id);
	}
}
