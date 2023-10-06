package Q1Onlinestore;

import java.util.List;

public class Order {
 int id;
	 String customer_name; 
	 List<Items>items; 
	 double total_price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	public Order(int id, String customer_name, List<Items> items) {
		super();
		this.id = id;
		this.customer_name = customer_name;
		this.items = items;
		this.total_price = getTotalPrice();
	}
	public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Items item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
	@Override
	public String toString() {
		return "Order [id=" + id + ", customer_name=" + customer_name + ", items=" + items + ", total_price="
				+ total_price + "]";
	}
	
}