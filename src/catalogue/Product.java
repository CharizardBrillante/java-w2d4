package catalogue;

public class Product {
	long id;
	String name;
	String category;
	double price;
	
	static long localId = 1000000;
	
	public Product(String name, String category, double price) {
		localId++;
		this.id = localId;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String toString() {
		return "id: " + this.id + ", name: " + this.name + ", category: " + this.category + ", price: " + this.price +"\n";
	}
}
