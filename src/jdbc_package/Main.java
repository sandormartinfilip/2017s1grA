package jdbc_package;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		UserDAO userProc = new UserDAO();
		
		User user = new User("Filip", "Sandor", "0729908045", "filip_sandor@yahoo.com", "sandorfilip","filip.pass", true);
		//userProc.insertUser(user);
		
		//userProc.deleteUser(1);
		userProc.updateUserFirstName(2, "Marian");
		
		List<User> users = userProc.readAll();
		for(User u:users){
			System.out.println(u.toString());
		}
		
	}
}
