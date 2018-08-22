package co.gra.lab23_coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	// Dependency Injection
	@Autowired
	private AdminDao adminDao;

	@RequestMapping("/item")
	public ModelAndView showItemsAdmin(	@RequestParam(value="name", required=false) String name,
			@RequestParam(value="category", required=false) String category) {
		ModelAndView mav = new ModelAndView("adminview");
		if (name != null && !name.isEmpty()) {
			mav.addObject("items", adminDao.getItemsByName(name));
		} else if (category != null && !category.isEmpty()) {
			mav.addObject("items", adminDao.getItemByCategory(category));
		} else {
			mav.addObject("items", adminDao.getAllItems());
		}
		// list of categories needed for <select>
		mav.addObject("categories", adminDao.getItemCategories());
		return mav;
	}
	
	@RequestMapping("/users")
	public ModelAndView showUsers() {
		ModelAndView mav = new ModelAndView("userslist");
		List<Users> users = adminDao.getUsers();
		mav.addObject("users",users );
		return mav;
	}
	
	@RequestMapping("/item/create")
	public ModelAndView showCreateForm() {
		return new ModelAndView("item-form", "title", "Add an Item");
	}
	
	@RequestMapping(value="/item/create", method=RequestMethod.POST)
	public ModelAndView submitCreateForm(Items item) {
		adminDao.createItem(item);
		return new ModelAndView("redirect:/item");
	}
	
	@RequestMapping("/item/{id}/update")
	public ModelAndView showEditForm(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("item-form");
		mav.addObject("item", adminDao.getItemByID(id));
		mav.addObject("title", "Edit Item");
		return mav;
	}
	
	// same URL but different method
	@RequestMapping(value="/item/{id}/update", method=RequestMethod.POST)
	public ModelAndView submitEditForm(Items item, @PathVariable("id") Long id) {
		item.setId(id);
		adminDao.updateItem(item);
		return new ModelAndView("redirect:/item");
	}
	
	@RequestMapping("/item/{id}/delete")
	public ModelAndView delete(@PathVariable("id") Long id) {
		adminDao.deleteItem(id);
		return new ModelAndView("redirect:/item");
	}
	
	@RequestMapping("/admin-form")
	public ModelAndView showAdminForm() {
		ModelAndView mav = new ModelAndView("admin-form");
		return mav;
	}
	
	@RequestMapping("/admin-login")
	public ModelAndView adminLogin(@RequestParam("adminname") String adminname, 
								@RequestParam("password") String password) {
		ModelAndView mav;
		
		if(adminname.equals("admin") && password.equals("CoffeeLover2018")) {
			mav = new ModelAndView("redirect:/item");
		} else {
			mav= new ModelAndView("redirect:/admin-form");
		}
		return mav;
	}
	
}