package qa.com.JavaEE_Project_JackLawthom.persistence.repo;

public interface UserRepo {
	String createUser(String user);
	String deleteUser(long id);
	String updateUser(long id, String user);
	String getAllUsers();
	String getUserByUsername(String username);
	String getUserById(long id);
}
