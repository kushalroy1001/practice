

import java.util.Arrays;
import java.util.Comparator;

class Product {
    String productId;
    String productName;
    String category;

    Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ECommerceSearch {

    // Linear Search by productName
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search by productName (assumes array is sorted)
    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        // 2. Setup: Product List
        Product[] productList = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Mouse", "Electronics"),
            new Product("P003", "Chair", "Furniture"),
            new Product("P004", "Shoes", "Fashion"),
            new Product("P005", "Notebook", "Stationery")
        };

        // 3. Implementation

        // Linear Search (unsorted array)
        System.out.println("Linear Search for 'Shoes':");
        Product result1 = linearSearch(productList, "Shoes");
        if (result1 != null) {
            System.out.println("Found: " + result1);
        } else {
            System.out.println("Product not found.");
        }

        // Binary Search (sort array by name first)
        Arrays.sort(productList, Comparator.comparing(p -> p.productName.toLowerCase()));
        System.out.println("\nBinary Search for 'Shoes':");
        Product result2 = binarySearch(productList, "Shoes");
        if (result2 != null) {
            System.out.println("Found: " + result2);
        } else {
            System.out.println("Product not found.");
        }

        // 4. Analysis:
        System.out.println("\nAnalysis:");
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n)");
        System.out.println("Binary search is faster for large, sorted datasets. For small or unsorted arrays, linear search is simpler.");
    }
}
