package qa.com.JavaEE_Project_JackLawthom.service;

import javax.inject.Inject;

import qa.com.JavaEE_Project_JackLawthom.persistence.domain.User;
import qa.com.JavaEE_Project_JackLawthom.persistence.repo.UserRepo;
import qa.com.JavaEE_Project_JackLawthom.util.JSONUtil;

public class UserServiceImpl implements UserService {
	
	@Inject
	private JSONUtil gson;
	
	@Inject
	private UserRepo repo;

	public String createUser(String user) {
		User userObj = gson.convertJson(user, User.class);
		String existingUser = this.repo.getUserByUsername(userObj.getUsername());
		if (existingUser.equals("Invalid Username")) {
			return this.repo.createUser(user);	
		} else {
			return "Username Taken";
		}				
	}
	
	public String deleteUser(long id) {
		return this.repo.deleteUser(id);
	}
	
	public String updateUser(long id, String user) {
		return this.repo.updateUser(id, user);
	}
	
	public String getAllUsers() {
		return this.repo.getAllUsers();
	}
	
	public String login(String username, String password) {
		String user = this.repo.getUserByUsername(username);
		if (user.equals("Invalid Username")) {
			return user;
		} else if (!this.gson.convertJson(user, User.class).getPassword().equals(password)) {
			return "Invalid Password";
		} else {
			return gson.getJson(this.gson.convertJson(user, User.class).getUserId());
		}
	}
	
	public String getUserById(long id) {
		return this.repo.getUserById(id);
	}
}
