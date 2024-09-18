package com.tns.onlineshopping.application;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tns.onlineshopping.entities.Admin;
import com.tns.onlineshopping.entities.Customer;
import com.tns.onlineshopping.entities.Order;
import com.tns.onlineshopping.entities.Product;
import com.tns.onlineshopping.entities.ProductQuantityPair;
import com.tns.onlineshopping.services.AdminService;
import com.tns.onlineshopping.services.CustomerService;
import com.tns.onlineshopping.services.OrderService;
import com.tns.onlineshopping.services.ProductService;

public class OnlineShopping {
	private static ProductService productService = new ProductService();
	private static CustomerService customerService = new CustomerService();
	private static OrderService orderService = new OrderService();
	private static AdminService adminService = new AdminService();
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
				while (true) {
					System.out.println("1. Admin Menu");
					System.out.println("2. Customer Menu");
					System.out.println("3. Exit");
					System.out.println("Choose an option: ");
					int choice = scanner.nextInt();
					
					switch (choice) {
					case 1: //Admin module
						int adminChoice;
						do {
							System.out.println("\nAdmin Menu:");
							System.out.println("1. Add product");
							System.out.println("2. Remove Product");
							System.out.println("3. View Products");
							System.out.println("4. Create admin");
							System.out.println("5. View Admins");
							System.out.println("6. Update order status");
							System.out.println("7. View orders");
							System.out.println("8. Return");
							System.out.println("Choose an option");
							adminChoice = scanner.nextInt();
							 
							switch (adminChoice) {
							case 1:
								addProduct(scanner);
								break;
							case 2:
								removeProduct(scanner);
								break;
							case 3:
								viewProducts(scanner);
								break;
							case 4:
								createAdmin(scanner);
								break;
							case 5:
								viewsAdmins(scanner);
								break;
							case 6:
								updateOrderStatus(scanner);
								break;
							case 7:
								viewOrders();
								break;
							case 8:
								System.out.println("Exiting admin...");
								break;
							default:
								System.out.println("Invalid choice! Please try again.");
								break;
							 }
						}while(adminChoice != 8);
					 case 2://Customer module
						 int customerChoice;
						 do {
							 System.out.println("\nCustomer menu:");
							 System.out.println("1. Create customer");
							 System.out.println("2. View customers");
							 System.out.println("3. Place order");
							 System.out.println("4. View orders");
							 System.out.println("5. View products");
							 System.out.println("6. Return");
							 System.out.println("Choose an option: ");
							 customerChoice = scanner.nextInt();
							 switch (customerChoice) {
							 case 1:
								 createCustomer(scanner);
								 break;
							 case 2:
								 viewCustomers();
								 break;
							 case 3:
								 placeOrder(scanner);
								 break;
							 case 4:
								 viewOrders();
								 break;
							 case 5:
								 viewProducts(scanner);
								 break;
							 case 6:
								 System.out.println("Exiting customer menu...");
								 break;
					         default:
					        	 System.out.println("Invalid choice! Please try again.");
							 }
						 }while(customerChoice != 6);
					 break;
					 case 3:
						 System.out.println("Exiting...");
						 scanner.close();
						 return;
					 default:
							 System.out.println("invalid choice! Please try again.");
					}
				}
	}
	private static void viewCustomers() {
		    
		    List<Customer> customers = customerService.getCustomers();
		    
		    
		    if (customers.isEmpty()) {
		        System.out.println("No customers available.");
		    } else {
		        
		        System.out.println("Customer List:");
		        for (Customer customer : customers) {
		            System.out.println(customer); 
		        }
		    }
		}
	
	private static void createCustomer(Scanner scanner) {
		    System.out.println("Enter customer ID: ");
		    int customerId = scanner.nextInt();
		    scanner.nextLine(); 
		    System.out.println("Enter customer username: ");
		    String username = scanner.nextLine();
		    System.out.println("Enter customer email: ");
		    String email = scanner.nextLine();
		    System.out.println("Enter customer address: ");
		    String address = scanner.nextLine();
		    
		    Customer customer = new Customer(customerId, username, email, address);
		    
		    customerService.addCustomer(customer);
		    
		    System.out.println("Customer created successfully!");
		}

	private static void viewOrders() {
        for (Order order : orderService.getOrders()) 
        {
            System.out.println(order);};}

	private static void updateOrderStatus(Scanner scanner) {
		
		    System.out.println("Enter order ID to update: ");
		    int orderId = scanner.nextInt();
		    scanner.nextLine(); 
		    System.out.println("Enter new status (Completed/Delivered/Cancelled):");
		    String status = scanner.nextLine();
		    Order order = orderService.getOrder(orderId); 
		    order.setStatus(status);
		    System.out.println("Order status updated successfully!");
		}

	private static void viewsAdmins(Scanner scanner) {
	
		    List<Admin> admins = adminService.getAdmins();
		    
		    if (admins.isEmpty()) {
		        System.out.println("No admins available.");
		    } else {
		        System.out.println("Admin List:");
		        for (Admin admin : admins) {
		            System.out.println(admin); 
		        }
		    }
		}

	private static void createAdmin(Scanner scanner) {
		    System.out.print("Enter admin ID: ");
		    int adminId = scanner.nextInt();
		    scanner.nextLine(); 
		    System.out.print("Enter admin name: ");
		    String name = scanner.nextLine();
		    System.out.print("Enter admin password: ");
		    String password = scanner.nextLine();
		    System.out.print("Enter admin address: ");
		    String address = scanner.nextLine();

		    Admin admin = new Admin(adminId, name, password,address);
		    adminService.addAdmin(admin);
		    System.out.println("Admin created successfully!");
		}

	private static void viewProducts(Scanner scanner) {
		    List<Product> products = productService.getProducts();
		    
		    if (products.isEmpty()) {
		        System.out.println("No products available.");
		    } else {
		        System.out.println("Product List:");
		        for (Product product : products) {
		            System.out.println(product); 
		        }
		    }
		}
	private static void placeOrder(Scanner scanner) {
		   
	    System.out.print("Enter order ID: ");
	    int orderId = scanner.nextInt();

	    System.out.print("Enter customer ID: ");
	    int customerId = scanner.nextInt();

	    Customer customer = customerService.getCustomers().stream()
	            .filter(c -> c.getUserId() == customerId)
	            .findFirst()
	            .orElse(null);

	    if (customer == null) {
	        System.out.println("Customer not found! Please check the customer ID.");
	        return;
	    }

	    
	    List<ProductQuantityPair> productQuantityPairs = new ArrayList<>();
	    boolean moreProducts = true;

	    while (moreProducts) {
	        System.out.print("Enter product ID: ");
	        int productId = scanner.nextInt();
	        System.out.print("Enter quantity: ");
	        int quantity = scanner.nextInt();

	        
	        Product product = productService.getProducts().stream()
	                .filter(p -> p.getProductId() == productId)
	                .findFirst()
	                .orElse(null);

	        if (product == null) {
	            System.out.println("Product not found! Please check the product ID.");
	            continue;
	        }

	        
	        if (product.getStockQuantity() < quantity) {
	            System.out.println("Insufficient stock for product " + product.getName() + ". Available quantity: " + product.getStockQuantity());
	            continue; 
	        }
	        productQuantityPairs.add(new ProductQuantityPair(product, quantity));
	        System.out.print("Would you like to add another product? (yes/no): ");
	        String response = scanner.next();
	        moreProducts = response.equalsIgnoreCase("yes");
	    }
	    Order order = new Order(orderId, customer, productQuantityPairs);
	    orderService.placeOrder(order);
	    System.out.println("Order placed successfully!");		
}
	
	private static void addProduct(Scanner scanner) {
		System.out.println("Enter product ID: ");
		int productId = scanner.nextInt();
		System.out.println("Enter product name: ");
		String name = scanner.next();
		System.out.println("Enter product price: ");
		double price = scanner.nextDouble();
		System.out.println("Enter stock quantity: ");
		int stockQuantity = scanner.nextInt();
		
		Product product = new Product(productId, name, price, stockQuantity);
		productService.addProduct(product);
		System.out.println("Product added successfully!");
	}
	private static void removeProduct(Scanner scanner) {
		System.out.println("Enter Product ID: ");
		int productId = scanner.nextInt();
		
		productService.removeProduct(productId);
		System.out.println("Product removed successfully!");
	}
	
}
	
	
