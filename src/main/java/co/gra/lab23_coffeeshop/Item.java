package co.gra.lab23_coffeeshop;

public class Item  {
	private Long id;
	private String name;
	private String category;
	private String description;
	private Double price;
	
	public Item() {}
	
	public Item(Long id,String name, String category, String description, Double price ) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return " [ID= " + id + ", Name= " + name + ", Category= " + category + "]"+", Price = " + price + "]";
	}

	
}
