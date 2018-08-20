package co.gra.lab21_coffeeshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {

//	@Autowired
//	User user;
	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		// parameter inside the constructor represents the jsp file we create
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping("/register-form")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("registerform");
		return mav;
	}
	
	@RequestMapping("/add-user")
	public ModelAndView addUser(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
								@RequestParam("email") String email, @RequestParam("phone") String phone, 
								@RequestParam("password1") String password1, @RequestParam("password2") String password2) {

		ModelAndView mav = new ModelAndView("adduser");
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(email);
		user.setPhone(phone);
		if(password1.equals(password2)) {
			user.setPassword(password1);
			mav=mav.addObject("user", user);
		} else 
			mav= new ModelAndView("registerform" );
//			return mav.addObject("test", "registerform");
		return mav;
	}
}