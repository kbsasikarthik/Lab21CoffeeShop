package co.gra.lab23_coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CoffeeShopController {

	// Dependency Injection
	@Autowired
	private MainDao mainDao;

	@RequestMapping("/")
	public ModelAndView showHomePage() {
		// parameter inside the constructor represents the jsp file we create
		List<Item> items = mainDao.getAllItems();
		return new ModelAndView("list", "items", items);
	}
	
	@RequestMapping("/items/{id}") // redirects to the rooms depending on the id number
	public ModelAndView showProduct(@PathVariable("id") Long id){
		ModelAndView mav = new ModelAndView("details");
		mav.addObject("items", mainDao.getItemByID(id));
		return mav;
	}
	
	@RequestMapping("/register-form")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("userregisterform");
		return mav;
	}
	
	@RequestMapping("/add-user")
	public ModelAndView addUser(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
								@RequestParam("email") String email, @RequestParam("phone") String phone, 
								@RequestParam("password1") String password1, @RequestParam("password2") String password2) {
		ModelAndView mav;
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(email);
		user.setPhone(phone);
		if(password1.equals(password2)) {
			user.setPassword(password1);
			mainDao.createUser(user);
			mav = new ModelAndView("adduser");
			mav.addObject(user);
		} else {
			mav = new ModelAndView("userregisterform" );
		}
		return mav;
	}
	
	@RequestMapping("/itemsbyname")
	public ModelAndView listItems(@RequestParam(value="name", required=false) String name) {
		ModelAndView mav = new ModelAndView("list");
		System.out.println(name);
		if (name != null && !name.isEmpty()) {
//			List<Item> itemsByName= itemsDao.getItemsByName(name);
			List<Item> items = mainDao.getItemsByName(name);
			System.out.println(items);
//			mav= new ModelAndView("list", "items", items);
			mav.addObject("items", items);
			mav.addObject("name", name);
		} else {
			mav =new ModelAndView("redirect:/");
		}
		return mav;
	}
}