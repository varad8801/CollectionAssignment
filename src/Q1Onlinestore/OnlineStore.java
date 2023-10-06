package Q1Onlinestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
	    
	    
	    
	    ///
	    
	    
	
	        public static void main(String[] args) {
	            OnlineStore store = new OnlineStore();
	            Scanner scanner = new Scanner(System.in);
	            
	            while (true) {
	                System.out.println("\nMain Menu:");
	                System.out.println("1. Add Order");
	                System.out.println("2. Remove Order");
	                System.out.println("3. Calculate Total Revenue");
	                System.out.println("4. Search Orders by Customer");
	                System.out.println("5. Exit");
	                System.out.print("Enter your choice: ");
	                
	                int choice = scanner.nextInt();
	                scanner.nextLine(); // Consume the newline character
	                
	                switch (choice) {
	                case 1:
	                    System.out.print("Enter order ID: ");
	                    int id = scanner.nextInt();
	                    scanner.nextLine(); // Consume the newline character
	                    
	                    System.out.print("Enter customer name: ");
	                    String customerName = scanner.nextLine();
	                    
	                    ArrayList<Items> items = new ArrayList<>();
	                    
	                    // Get items from user input
	                    while (true) {
	                        System.out.print("Enter item name (or 'done' to finish): ");
	                        String itemName = scanner.nextLine();
	                        if (itemName.equalsIgnoreCase("done")) {
	                            break;
	                        }
	                        
	                        System.out.print("Enter item price: ");
	                        double itemPrice = scanner.nextDouble();
	                        scanner.nextLine(); // Consume the newline character
	                        
	                        Items item = new Items(itemName, itemPrice);
	                        items.add(item);
	                    }
	                    
	                    store.addOrder(id, customerName, items);
	                    System.out.println("Order added successfully!");
	                    break;

	                        
	                    case 2:
	                        System.out.print("Enter order ID to remove: ");
	                        int orderIdToRemove = scanner.nextInt();
	                        store.removeOrder(orderIdToRemove);
	                        System.out.println("Order removed successfully!");
	                        break;
	                        
	                    case 3:
	                        double totalRevenue = store.calculateTotalRevenue();
	                        System.out.println("Total Revenue: $" + totalRevenue);
	                        break;
	                        
	                    case 4:
	                        System.out.print("Enter customer name to search orders: ");
	                        String searchCustomerName = scanner.nextLine();
	                        ArrayList<Order> customerOrders = store.searchOrdersByCustomer(searchCustomerName);
	                        System.out.println("Orders for " + searchCustomerName + ":");
	                        for (Order order : customerOrders) {
	                            System.out.println(order.toString()); // Assuming you have a toString method in Order class
	                        }
	                        break;
	                        
	                    case 5:
	                        System.out.println("Exiting...");
	                        scanner.close(); // Close scanner before exiting
	                        System.exit(0);
	                        break;
	                        
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            }
	        }
	    

	    
}
