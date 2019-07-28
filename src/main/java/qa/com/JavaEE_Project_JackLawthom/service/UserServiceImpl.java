package qa.com.JavaEE_Project_JackLawthom.service;

import javax.inject.Inject;

import qa.com.JavaEE_Project_JackLawthom.persistence.repo.UserRepo;

public class UserServiceImpl implements UserService {
	
	@Inject
	private UserRepo repo;

	public String createUser(String user) {
		return this.repo.createUser(user);
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

}
