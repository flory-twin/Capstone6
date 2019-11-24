package co.grandcircus.Capstone6.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Capstone6.Model.User;
import co.grandcircus.Capstone6.Repo.UserRepo;

@Controller
public class LoginController {

	@Autowired
	UserRepo users;
	
	//Route from the index to the login page.
	@RequestMapping("/")
	public ModelAndView goToLogin() {
		return new ModelAndView("login-content");
	}
	
	//Either login succeeds--which takes us to display.jsp--or it fails, which boots us back to the login page.
	@RequestMapping("/login/submit")
	public ModelAndView attemptLogin(@RequestParam String email, @RequestParam String password) {
		User authenticatedUser = getUser(email, password);
		if (authenticatedUser != null) {
			ModelAndView tasklist = new ModelAndView("tasklist-content", "user", authenticatedUser);
			tasklist.addObject("tasks", authenticatedUser.getTasks());
			return tasklist;
		} else {
			return new ModelAndView("login-content", "error", "Either the email could not be found, or the password did not match. Please try again or create a new user.");
		}
		
	}
	
	// TODO. This is a decent first-run strategy for identifying the user who's trying to log in. And if the user is identified, we automatically know the user is authenticated. 
	// But to work correctly, the email should be the PK.
	public User getUser(@RequestParam String email, @RequestParam String password) {
		List<User> candidates = users.findByEmailIgnoreCase(email);
		if (candidates.size() > 0)
		{
			for (User u : candidates) {
				if (u.getPassword().equals(password))
				{
					return u;
				}
			}
		}
		// If no matching user has been found, then
		return null;
	}
}
