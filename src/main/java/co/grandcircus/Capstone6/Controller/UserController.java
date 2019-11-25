package co.grandcircus.Capstone6.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Capstone6.Model.Task;
import co.grandcircus.Capstone6.Model.User;
import co.grandcircus.Capstone6.Repo.UserRepo;

@Controller
public class UserController {
	
	@Autowired
	UserRepo users;
	
	@RequestMapping("/users/create")
	public ModelAndView createNewUser() {
		return new ModelAndView("createuser-content");
	}
	
	@RequestMapping("/users/create/submit")
	public ModelAndView acceptUserAndRouteToTasklist(@RequestParam String email, @RequestParam String password) {
		User brandSpankinNewUser = new User(email, password, new ArrayList<Task>()); 
		users.save(brandSpankinNewUser);
		
		ModelAndView newUsersTaskList = new ModelAndView("tasklist-content", "user", brandSpankinNewUser);
		newUsersTaskList.addObject("tasks", brandSpankinNewUser.getTasks());
		
		return newUsersTaskList;
	}
}
