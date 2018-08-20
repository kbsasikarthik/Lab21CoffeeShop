package co.gra.lab21_coffeeshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

// The @Component annotation makes this is a singleton Spring Bean,
// created and managed by Spring. (Alternatively, could use @Service)
@Component
public class ProductService {
	
	private List<product> productsList = new ArrayList<>();
	
	public ProductService() {
		productsList.add(new product(1,"Colombian Milds", "Dark", "Includes coffees from Colombia, Kenya, and Tanzania, all of which are washed arabicas.",7.99));
		productsList.add(new product(2,"Ethiopian Yirgacheffe", "Ground", " From the area of the town of Yirga Cheffe in the Sidamo (now Oromia) region of Ethiopia.", 6.99));
		productsList.add(new product(3,"Hawaiian Kona ", "Roasted", "Grown on the slopes of Hualalai in the Kona District on the Big Island of Hawaii.",9.45));
		productsList.add(new product(4,"Mocha", "Ground", "Yemeni coffee traded through the once major port of Mocha. Not to be confused with the preparation style (coffee with cocoa).", 8.59));
		productsList.add(new product(5,"Tanzania Peaberry", "Roasted", "Grown on Mount Kilimanjaro in Tanzania. \"Peaberry\" means that the beans come one to a cherry (coffee fruit) instead of the usual two.", 6.99));
		productsList.add(new product(6,"Jamaican Blue Mountain", "Roasted", "From the Blue Mountain region of Jamaica. This coffee was once so widely traded that \"java\" became a slang term for coffee.", 7.99));
		productsList.add(new product(7,"Kenya AA", "Dark", "From Kenya. The \"AA\" is a grade/rating within Kenya's coffee auction system. Known among coffee enthusiasts to have an \"acidic\" flavor.", 5.99));
	}
	
	/**
	 * Get list of all foods.
	 */
	public List<product> getAllProducts() {
		return productsList;
	}
	
	public List<product> getProductsByID(int id) {
		List<product> cart = new ArrayList<>();
		for(product product : productsList) {
			if (product.getId() == id) {
				cart.add(product);
			}
		}
		return cart;
	}
	
	/**
	 * Get list of foods in a given category.
	 */
	public List<product> getProductsInCategory(String category) {
		List<product> matches = new ArrayList<>();
		for(product product : productsList) {
			if (product.getCategory().equalsIgnoreCase(category)) {
				matches.add(product);
			}
		}
		return matches;
	}
	
	/**
	 * Get list of food with name matching a keyword.
	 */
	public List<product> getProductByKeyword(String keyword) {
		keyword = keyword.toLowerCase();
		List<product> matches = new ArrayList<>();
		for(product product : productsList) {
			if (product.getName().toLowerCase().contains(keyword)) {
				matches.add(product);
			}
		}
		return matches;
	}
	
	/**
	 * Get set of food categories.
	 */
	public Set<String> getCategories() {
		Set<String> categories = new TreeSet<>();
		for(product product : productsList) {
			categories.add(product.getCategory());
		}
		return categories;
	}

	/**
	 * Add a food to the list
	 */
	public void addProduct(product product) {
		productsList.get(product.getId());
	}
}
