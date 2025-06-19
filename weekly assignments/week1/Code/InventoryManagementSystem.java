import java.util.HashMap;
import java.util.Scanner;


class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName +
               ", Quantity: " + quantity + ", Price: ₹" + price;
    }
}

// Main class
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Product> inventory = new HashMap<>();

        // Pre-added sample products
        inventory.put("P101", new Product("P101", "Laptop", 10, 55000));
        inventory.put("P102", new Product("P102", "Keyboard", 25, 700));
        inventory.put("P103", new Product("P103", "Mouse", 40, 300));

        int choice;
        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. View All Products");
            System.out.println("2. Add New Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.println("\n--- Product List ---");
                    if (inventory.isEmpty()) {
                        System.out.println("No products in inventory.");
                    } else {
                        for (Product p : inventory.values()) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ₹");
                    double price = sc.nextDouble();
                    sc.nextLine(); // clear buffer

                    inventory.put(id, new Product(id, name, qty, price));
                    System.out.println(" Product added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Product ID to update: ");
                    String updateId = sc.nextLine();
                    if (inventory.containsKey(updateId)) {
                        System.out.print("Enter New Quantity: ");
                        int newQty = sc.nextInt();
                        System.out.print("Enter New Price: ₹");
                        double newPrice = sc.nextDouble();
                        sc.nextLine(); // clear buffer

                        Product p = inventory.get(updateId);
                        p.quantity = newQty;
                        p.price = newPrice;

                        System.out.println(" Product updated: " + p);
                    } else {                    System.out.println("Product ID not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to delete: ");
                    String deleteId = sc.nextLine();
                    if (inventory.remove(deleteId) != null) {
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("Product ID not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
