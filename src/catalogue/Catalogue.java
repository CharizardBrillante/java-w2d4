package catalogue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import tools.Discount;
import tools.RandomMaker;

public class Catalogue {

	public static void main(String[] args) {
		
		Predicate<String> isBook = (c) -> c.equals("Books");
		Predicate<Double> greaterThen100 = (p) -> p < 100;
		Predicate<String> isBaby = (c) -> c.equals("Babies");
		Predicate<String> isBoy = (c) -> c.equals("Boys");
		Predicate<Integer> isTier2 = (t) -> t == 2;
		Predicate<LocalDate> isWithinRange = (d) -> !d.isBefore(LocalDate.parse("2021-02-01")) || d.isAfter(LocalDate.parse("2021-04-01"));
		
		Discount discount10 = (p) -> p * 0.9;
		
		//Instances of lists
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<Order> orders = new ArrayList<Order>();
		ArrayList<Product> products = new ArrayList<Product>();
		
		//fill the lists
		for (int i = 0; i < 100; i++) {
			customers.add(RandomMaker.randomCustomer());
			products.add(RandomMaker.randomProduct());
		}
		for (int i = 0; i < 100; i++) {
			orders.add(RandomMaker.randomOrder(customers.get(i)));
		}
		
		
		//----------------------------------- EXERCISE 1 ---------------------------------------
		System.out.println("\n                                    *** Books with price lower than 100 ***                                   \n ");
		System.out.println(ex1(products, isBook, greaterThen100));
		
		
		//---------------------------------- EXERCISE 2 ----------------------------------------
		System.out.println("\n                                   *** Orders with products for babies ***                                    \n ");
		System.out.println(ex2(orders, isBaby));
		
		//---------------------------------- EXERCISE 3 ----------------------------------------
		System.out.println("\n                                   *** Boys products discount ***                                     \n");
		System.out.println( "new prices: " + ex3(products, isBoy, discount10));
		
		//---------------------------------- EXERCISE 4 ----------------------------------------
		System.out.println("\n                                   *** Tier 2 customers orders between Aeb 2021 and Apr 2021 ***                                     \n");
		System.out.println(ex4(orders, isTier2, isWithinRange));
	}
	
	
	//METHODS
	
	public static List<Product> ex1(ArrayList<Product> products, Predicate<String> isBook, Predicate<Double> greaterThen100){
		return products.stream()
			.filter(p -> isBook.test(p.getCategory()))
			.filter(p -> greaterThen100.test(p.getPrice()))
			.collect(Collectors.toList());
	}
	public static List<Order> ex2(ArrayList<Order> orders, Predicate<String> isBaby){
		return orders.stream()
			.filter(o -> 
				o.getProducts()
				.stream()
				.anyMatch(p -> isBaby.test(p.getCategory()))
			)	
			.collect(Collectors.toList());
	}
	
	public static List<Double> ex3(ArrayList<Product> products, Predicate<String> isBoy, Discount discount10){
		return products.stream()
				.filter(p -> isBoy.test(p.getCategory()))
				.map(p -> discount10.discount(p.getPrice()))
				.collect(Collectors.toList());
	}
	
	public static List<Order> ex4(ArrayList<Order> orders, Predicate<Integer> isTier2, Predicate<LocalDate> isWithinRange){
		return orders.stream()
			.filter(o -> isTier2.test(o.getCustomer().getTier()))
			.filter(o -> isWithinRange.test(o.getOrderDate()))
			.collect(Collectors.toList());
	}
	
}
