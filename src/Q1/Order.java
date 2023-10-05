package Q1;

import java.util.List;

public class Order {
 int id;
	 String customer_name; 
	 List<Items>items; 
	 int total_price;
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
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public Order(int id, String customer_name, List<Items> items) {
		super();
		this.id = id;
		this.customer_name = customer_name;
		this.items = items;
		this.total_price = getTotal_price();
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
