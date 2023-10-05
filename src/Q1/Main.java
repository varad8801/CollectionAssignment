package Q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<Order>();
        Scanner sc = new Scanner(System.in);
        
        // Prompt for customer information
        System.out.println("Enter customer ID");
        int id = sc.nextInt();
        System.out.println("Enter customer Name");
        String cName = sc.next();
        
        
        List<Items> items = new ArrayList<Items>();
        boolean addMoreItems = true;
        
        while(addMoreItems) {
            System.out.println("Enter an item (or type 0 to finish)");
            String itm = sc.next();
            if (itm.equals("0")) {
                addMoreItems = false;
            } else {
            	System.out.println("Enter price");
            	int price=sc.nextInt();
                Items item = new Items(itm,price);
                items.add(item);
            }
        }
   
        Order newOrder = new Order(id, cName, items );
        orders.add(newOrder);
        
        for(Order o : orders) {
            System.out.println(o.toString());
        }
      
        sc.close();
    }
}
