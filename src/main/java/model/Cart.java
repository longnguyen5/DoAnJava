package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Item> items;

	public Cart() {
		items = new ArrayList<>();
	}

	public List<Item> getItems() {
		return items;
	}

	public int getQuantityById(int id) {
		return getItemById(id).getQuantity();
	}
	
	private Item getItemById(int id) {
		for(Item i:items) {
			if(i.getProduct().getProductId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public void addItem(Item t) {
		if(getItemById(t.getProduct().getProductId()) != null) {
			Item m = getItemById(t.getProduct().getProductId());
			m.setQuantity(m.getQuantity()+t.getQuantity());
		}else
			items.add(t);
	}
	
	public void removeItem(int id) {
		if(getItemById(id) != null) {
			items.remove(getItemById(id));
		}
	}
	
	public double getTotalMoney() {
		double t = 0;
		for(Item i:items)
			t += (i.getQuantity()*i.getPrice());
		return t;
	}
	
	public Cart(String txt, List<Product> list) {
		items = new ArrayList<>();
		try {
			if(txt != null && txt.length()!= 0) {
				String [] s = txt.split(",");
				for (String i:s) {
					String [] n = i.split(":");
					int id = Integer.parseInt(n[0]);
					int quantity = Integer.parseInt(n[1]);
					Product p = getProductById(id, list);
					Item t = new Item(p, quantity, p.getPrice());
					addItem(t);
				}
			}
		}catch(NumberFormatException e) {
			
		}
		
	}

	private Product getProductById(int id, List<Product> list) {
		for (Product i:list) {
			if(i.getProductId() == id)
				return i;
		}
		return null;
	}
}