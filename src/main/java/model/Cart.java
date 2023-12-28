package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> items;
	private double totalPrice;

	public Cart() {
		this.items = new ArrayList<>();
		this.totalPrice = 0.0;
	}

	public List<Product> getItems() {
		return items;
	}

	public void addItem(Product product) {
		items.add(product);
		totalPrice += product.getPrice();
	}

	public void removeItem(Product product) {
		items.remove(product);
		totalPrice -= product.getPrice();
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void clearCart() {
		items.clear();
		totalPrice = 0.0;
	}
}
