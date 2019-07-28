package qa.com.JavaEE_Project_JackLawthom.service;

public interface UserService {
	String createUser(String user);
	String deleteUser(long id);
	String updateUser(long id, String user);
	String getAllUsers();
}
