package co.gra.lab23_coffeeshop;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MainDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Items> getAllItems() {
		return em.createQuery("FROM Items", Items.class).getResultList();
	}
	
	public Items getItemByID(Long id) {
		return em.find(Items.class, id);
	}
	
	public List<Items> getItemsByName(String name) {
		return em.createQuery("FROM Items WHERE LOWER(name) LIKE :regex", Items.class)
				.setParameter("regex", "%" + name.toLowerCase() + "%")
				.getResultList();	
	}

	public Set<String> getItemCategories() {
		List<String> categoryList = em.createQuery("SELECT DISTINCT category FROM Items", String.class)
				.getResultList();
		return new TreeSet<>(categoryList);
	}
		
	public List<Items> getItemByCategory(String category) {
		return em.createQuery("FROM Items WHERE LOWER(category) = :category", Items.class)
				.setParameter("category", category.toLowerCase())
				.getResultList();
	}
	
	// this is for the user
	public void createUser(Users users) {
		em.persist(users);
	}
}
