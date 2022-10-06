package catalogue;

public class Customer {
	long id;
	String name;
	Integer tier;
	
	static long localId = 1000000;
	
	public Customer(String name, Integer tier) {
		localId++;
		this.id = localId;
		this.name = name;
		this.tier = tier;
	}
	
	public Integer getTier() {
		return this.tier;
	}
	
	public String toString() {
		return "id: " + this.id + ", name: " + this.name + ", tier: " + this.tier + "\n";
	}
}
