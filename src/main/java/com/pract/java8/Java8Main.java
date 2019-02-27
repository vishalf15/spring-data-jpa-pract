package com.pract.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pract.java8.model.Dish;
import com.pract.java8.model.DishType;
import com.pract.java8.model.Trader;
import com.pract.java8.model.Transaction;

public class Java8Main {

	public static void main(String[] args) {
		Arrays.asList("HellO", "World").stream().map(c -> c.split("")).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList()).forEach(System.out::print);

		System.out.println("\n---------------------");
		// Arrays.asList(1, 2, 3, 4).stream().collect(Collectors.toMap(i, i *
		// i)).forEach(System.out::print);

		final Map<String, Integer> menuMap = getMenu().stream()
				.collect(Collectors.toMap(Dish::getName, Dish::getCalories));
		System.out.println(menuMap);

		getMenu().stream().filter(d -> d.isVeg() == false).collect(Collectors.toList()).forEach(System.out::print);

		System.out
				.println("\n===== Find all transactions in 2011 and sort by value (small to\r\n" + "high) ===========");
		getTransactions().stream().filter(t -> t.getYear() == 2011)
				.sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue())).collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("\n===== What are all the unique cities where the traders work? ===========");
		getTransactions().stream().map(t -> t.getTrader().getCity()).distinct().collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("\n====== Find all traders from Cambridge and sort them by name ==========");
		getTransactions().stream().map(t -> t.getTrader()).distinct().filter(t -> t.getCity().equals("Cambridge"))
				.sorted((t1, t2) -> t1.getName().compareTo(t2.getName())).collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("\n====== Return a string of all traders’ names sorted alphabetically ==========");
		System.out.println(getTransactions().stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("",
				(n1, n2) -> n1 + n2 + ", "));

		System.out.println("\n====== Return a string of all traders’ names sorted alphabetically ==========");
		getTransactions().stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("\n====== Are any traders based in Milan? ==========");
		System.out.println(getTransactions().stream().anyMatch(t -> t.getTrader().getCity().equals("Milan")));

		System.out.println("\n====== Print all transactions’ values from the traders living in Cambridge ==========");
		getTransactions().stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(t -> t.getTrader())
				.forEach(System.out::println);

		System.out.println("\n====== What’s the highest value of all the transactions? ==========");
		System.out.println(getTransactions().stream().map(t -> t.getValue()).reduce(Integer::max).get());
		System.out
				.println(getTransactions().stream().reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t1 : t2).get());

		System.out.println("\n====== Find the transaction with the smallest value ==========");
		System.out.println(getTransactions().stream().map(t -> t.getValue()).reduce(Integer::min).get());
		System.out
				.println(getTransactions().stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2).get());

		System.out.println("\n====== Find the Sum all transaction values ==========");
		System.out.println(getTransactions().stream().map(t -> t.getValue()).reduce(0, (t1, t2) -> t1 + t2));

		Stream.generate(Math::random).limit(5).forEach(System.out::print);
	}

	private static List<Transaction> getTransactions() {
		final Trader raoul = new Trader("Raoul", "Cambridge");
		final Trader mario = new Trader("Mario", "Milan");
		final Trader alan = new Trader("Alan", "Cambridge");
		final Trader brian = new Trader("Brian", "Cambridge");

		return Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
	}

	private static List<Dish> getMenu() {
		return Arrays.asList(new Dish("Poha", 400, "India", true, DishType.VEG),
				new Dish("Pork", 800, "US", false, DishType.NONVEG),
				new Dish("fish fry", 600, "China", false, DishType.NONVEG));
	}

}
