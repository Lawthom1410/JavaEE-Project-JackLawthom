package qa.com.JavaEE_Project_JackLawthom.rest;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
	public String getAllUsers() {
		return this.service.getAllUsers();
	}
}
