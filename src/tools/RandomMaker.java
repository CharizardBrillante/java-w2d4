package tools;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import catalogue.Customer;
import catalogue.Order;
import catalogue.Product;

public class RandomMaker {
	
	//----------------------------------------------------- PRIVATE METHODS --------------------------------------------------------------------
	
	private static String randomString() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = ThreadLocalRandom.current().nextInt(4, 9);
		Random random = new Random();
		
		return random.ints(leftLimit, rightLimit + 1)
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();		
	}
	
	private static int randomTier() {
		return ThreadLocalRandom.current().nextInt(1, 6);
	}
	
	private static String randomStatus() {
		String[] status = new String[] {"Ordered", "Delivered"};
		return status[ThreadLocalRandom.current().nextInt(0, 2)];
	}
	
	private static LocalDate randomDate() {
		long minDay = LocalDate.of(2021, 1, 1).toEpochDay();
	    long maxDay = LocalDate.of(2021, 12, 31).toEpochDay();
	    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
	    return LocalDate.ofEpochDay(randomDay);
	}
	
	private static double randomPrice() {
		return 0.99 + 99 * new Random().nextDouble();
	}
	
	private static String randomCategory(){
		String[] categories = new String[] {"Books", "Babies", "Boys", "Sex toys"};
		return categories[ThreadLocalRandom.current().nextInt(0, 4)];
	}
	
	private static ArrayList<Product> randomProductsList(){
		ArrayList<Product> list = new ArrayList<Product>();
		for (int i = 0; i < ThreadLocalRandom.current().nextInt(1, 11); i++) {
			list.add(randomProduct());
		}
		return list;
	}
	
	//---------------------------------------------------------- PUBLIC METHODS -----------------------------------------------------
	
	public static Product randomProduct() {
		return new Product(randomString(), randomCategory(), randomPrice());
	}
	
	public static Customer randomCustomer() {
		return new Customer(randomString(), randomTier());
	}
	
	
	public static Order randomOrder(Customer customer) {
		return new Order(randomStatus(), randomDate(), randomDate(), randomProductsList(), customer);
	}

   
}
