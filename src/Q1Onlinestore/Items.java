package Q1Onlinestore;

public class Items {
	
	private String item_name;
	private double price;

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public Items(String item_name, double price) {
		super();
		this.item_name = item_name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Items [item_name=" + item_name + ", price=" + price + "]";
	}
	
	
}