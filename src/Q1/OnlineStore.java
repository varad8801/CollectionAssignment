package Q1;

import java.util.ArrayList;
import java.util.HashMap;

public class OnlineStore {
	 private ArrayList<Order> orders;
	    private HashMap<String, ArrayList<Order>> customerOrders;
	    public OnlineStore() {
	        this.orders = new ArrayList<>();
	        this.customerOrders = new HashMap<>();
	        
	    }
	    public void addOrder(int id, String customerName, ArrayList<Items> items) {
	    	Order newOrder = new Order(id, customerName, items);
	    	orders.add(newOrder);
	    	if(customerOrders.containsKey(customerName)) {
	    		customerOrders.get(customerName).add(newOrder);
	    	}
	    	else {
	    		ArrayList<Order> newcustorder=new ArrayList<Order>();
	    		newcustorder.add(newOrder);
	    		customerOrders.put(customerName, newcustorder);
	    	}
	    }
	    public void removeOrder(int id) {
	    	Order ordertoremove=null;
	    	for(Order o:orders) {
	    		if(o.getId()==id) {
	    			ordertoremove=o;
	    			break;
	    		}
	    	}
	    	if (ordertoremove != null) {
	            orders.remove(ordertoremove);

	            // Also remove from customerOrders map
	            ArrayList<Order> customerOrderList = customerOrders.get(ordertoremove.customer_name);
	            customerOrderList.remove(ordertoremove);

	            // If the customer doesn't have any more orders, remove them from the map
	            if (customerOrderList.isEmpty()) {
	                customerOrders.remove(ordertoremove.customer_name);
	            }
	        }
	    }
	    public double calculateTotalRevenue() {
	        double totalRevenue = 0.0;
	        for (Order order : orders) {
	            totalRevenue += order.getTotalPrice();
	        }
	        return totalRevenue;
	    }
	    public ArrayList<Order> searchOrdersByCustomer(String customerName) {
	        return customerOrders.getOrDefault(customerName, new ArrayList<>());
	    }
	    
}
