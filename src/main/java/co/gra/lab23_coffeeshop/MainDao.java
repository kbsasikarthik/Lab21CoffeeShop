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
public class MainDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private List<Items> itemsList = new ArrayList<>();

	public List<Items> getAllItems() {
		String sql = "SELECT * FROM items";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Items.class));
	}
	
	public Items getItemByID(Long id) {
		String sql = "SELECT * FROM items WHERE id = ?"; 
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Items.class), id);
	}
	

	public List<Items> getItemsByName(String name) {
		String sql = "SELECT * FROM items WHERE name LIKE (?) ";
//		System.out.println();
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Items.class), "%"+name+"%");
		
	}
	
	/**
	 * Get set of food categories.
	 */
	public Set<String> getItemCategories() {
		Set<String> categories = new TreeSet<>();
		for(Items Items : itemsList) {
			categories.add(Items.getCategory());
		}
		return categories;
	}
		
	public List<Items> getItemByCategory(String category) {
		List<Items> matches = new ArrayList<>();
		for(Items items : itemsList) {
			if (items.getCategory().equalsIgnoreCase(category)) {
				matches.add(items);
			}
		}
		return matches;
	}
	
	// this is for the user
	public void createUser(Users users) {
		String sql = "INSERT INTO users (firstname, lastname, email, phone, password) VALUES(? ,?, ?, ?, ?)"; // fills in the ? with the values from room object parameter
		// the order of parameters for the ?'s should match the order of column names
		jdbcTemplate.update(sql, users.getFirstname(), users.getLastname(), users.getEmail(), users.getPhone(), users.getPassword());
		
	}
}
