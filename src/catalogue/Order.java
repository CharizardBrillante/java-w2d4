package catalogue;

import java.time.LocalDate;
import java.util.ArrayList;


public class Order {
	long id;
	String status;
	LocalDate orderDate;
	LocalDate deliveryDate;
	ArrayList<Product> products;
	Customer customer;
	
	static long localId = 1000000;
	
	public Order(String status, LocalDate orderDate, LocalDate deliveryDate, ArrayList<Product> products, Customer customer) {
		localId++;
		this.id = localId;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.customer = customer;
		
	}
	
	public ArrayList<Product> getProducts(){
		return this.products;
	}
	
	public LocalDate getOrderDate() {
		return this.orderDate;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public String toString() {
		return "id: " + this.id + ", status: " + this.status + ", orderDate: " + this.orderDate + ", products: \n" + this.products + ", customer: " + this.customer + "\n";
	}
}
