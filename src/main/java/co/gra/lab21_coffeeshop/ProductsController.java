package co.gra.lab21_coffeeshop;
import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {
	
	@Autowired
	ProductService productService;
	
/*	@RequestMapping("/addtocart")
	public ModelAndView addToCart(String id, String name, String category, String description, double price, boolean checked, String quantity) {
		ModelAndView mav = new ModelAndView("addtocart");
		if (checked == true && Integer.parseInt(quantity)>0) {
			mav.addObject("products", productService.getProductsByID(Integer.parseInt(id)));
//			mav.addObject("category", category);
		} 
		return mav;
	}*/

	@RequestMapping("/product")
	public ModelAndView listProduct(@RequestParam(value="category", required=false) String category) {
		ModelAndView mav = new ModelAndView("list-product");
		if (category != null && !category.isEmpty()) {
			mav.addObject("products", productService.getProductsInCategory(category));
			mav.addObject("category", category);
		} else {
			mav.addObject("products", productService.getAllProducts());
		}
		return mav;
	}
	
/*	@RequestMapping("/add-product")
	public ModelAndView showFoodForm() {
		return new ModelAndView("product-form");
	}
	*/
	// Two controllers handling the same URL path, but this one handles the POST
	// which is triggered when the form submits.
//	@RequestMapping(value="/add-product", method=RequestMethod.POST)
	// When a POJO (Java Bean) is provided as a parameter, Spring MVC automatically
	// fills in all the properties from the request params!
//	public ModelAndView submitFoodForm(product product) {
//		productService.addProduct(product);
		// using a view name that starts with "redirect:" skips the JSP and instead
		// redirects the browser to the given URL, effectively redirecting to another
		// controller.
//		return new ModelAndView("redirect:/product");
//	}
}
