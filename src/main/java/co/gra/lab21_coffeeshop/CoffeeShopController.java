package co.gra.lab21_coffeeshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {

// parameter inside the annotation matches the URL in the browser
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		// parameter inside the constructor represents the jsp file we create
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	@RequestMapping("/register-form")
	public ModelAndView showForm() {
		// parameter inside the constructor represents the jsp file we create
		ModelAndView mav = new ModelAndView("registerform");
		return mav;
	}
	@RequestMapping("/add-user")
	public ModelAndView addUser(@RequestParam("firstname") String firstname) {
//		},@RequestParam("lastname") String lastname,@RequestParam("email") String email,
//			@RequestParam("phone") int phone, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView("adduser");
		mav.addObject("fname", firstname);
		return mav;
}
}