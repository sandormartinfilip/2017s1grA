
import java.util.List;

import model.User;
import service.UserService;

public class MainClass {

	public static void main(String[] args) {

		UserService userService = new UserService();
		User user = new User("fname2", "lname2", "0721222222", "dada@da", "papa", "papa", true);
		
		//create
		userService.create(user);
		
		//update
		User update = user;
		update.setEmail("nunu@nu");
		update.setIdUser(2);
		userService.update(update);
		
		//delete
		userService.delete(3);
		
		//view
		List<User> users = userService.view();
		for(User usr : users){
			System.out.println(usr.toString());
		}
	}

}
