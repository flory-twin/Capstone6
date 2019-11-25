package co.grandcircus.Capstone6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	//Route from the index to the login page.
		@RequestMapping("/")
		public ModelAndView goToLogin() {
			return new ModelAndView("login-content");
		}
		
}
