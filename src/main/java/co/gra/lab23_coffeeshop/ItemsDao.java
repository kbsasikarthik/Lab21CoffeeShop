package co.gra.lab23_coffeeshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private List<Item> itemsList = new ArrayList<>();

	public List<Item> getAllItems() {
		String sql = "SELECT * FROM items";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Item.class));
	}
	
	public Item getItemByID(Long id) {
		String sql = "SELECT * FROM items WHERE id = ?"; 
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Item.class), id);
	}
	
	/**
	 * Get list of foods in a given category.
	 */
	public List<Item> getItemsByName(String name) {
		String sql = "SELECT * FROM items WHERE name LIKE '?[%]' ";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Item.class));
	}
	
	/**
	 * Get set of food categories.
	 */
	public Set<String> getItemCategories() {
		Set<String> categories = new TreeSet<>();
		for(Item Item : itemsList) {
			categories.add(Item.getCategory());
		}
		return categories;
	}
	
	public void createUser(User user) {
		String sql = "INSERT INTO users (firstname, lastname, email, phone, password) VALUES(? ,?, ?, ?, ?)"; // fills in the ? with the values from room object parameter
		// the order of parameters for the ?'s should match the order of column names
		jdbcTemplate.update(sql, user.getFirstname(), user.getLastName(), user.getEmail(), user.getPhone(), user.getPassword());
		
	}
	
	public List<Item> getItemByCategory(String category) {
		List<Item> matches = new ArrayList<>();
		for(Item item : itemsList) {
			if (item.getCategory().equalsIgnoreCase(category)) {
				matches.add(item);
			}
		}
		return matches;
	}
//	public List<Product> getItemsByName(String name) {
//		List<Product> matches = new ArrayList<>();
//		for(Product product : productsList) {
//			if (product.getName().equalsIgnoreCase(name)) {
//				matches.add(product);
//			}
//		}
//		return matches;
//	}
}
