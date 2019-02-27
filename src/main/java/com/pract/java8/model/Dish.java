package com.pract.java8.model;

public class Dish {

	private final String name;
	private final int calories;
	private final String origin;
	private final boolean isVeg;
	private final DishType dishType;

	public Dish(String n, int c, String o, boolean i, DishType d) {
		this.name = n;
		this.calories = c;
		this.origin = o;
		this.isVeg = i;
		this.dishType = d;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return this.name;
	}

	public int getCalories() {
		return this.calories;
	}

	public String getOrigin() {
		return this.origin;
	}

	public boolean isVeg() {
		return this.isVeg;
	}

	public DishType getDishType() {
		return this.dishType;
	}
}
