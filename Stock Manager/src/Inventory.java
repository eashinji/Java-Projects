import java.io.*;
import java.util.ArrayList;
import java.util.List;

//---------------------------------------------------------------------
/*
* @author Eashinji
* @version 2024-07-08
*/
//---------------------------------------------------------------------
public class Inventory {
    private List<Item> items;
    private static final String FILE_NAME = "inventory.txt"; // File to store inventory data

    // Constructor
    public Inventory() {
        items = new ArrayList<>();
        loadInventory(); // Load inventory from file on startup
    }

    // Add an item to the inventory
    public void addItem(String name, String sku, double price, int quantity) {
        Item item = findItem(sku);
        if (item != null) {
            item.increaseQuantity(quantity); // If item exists, increase quantity
        } else {
            items.add(new Item(name, sku, price, quantity)); // If item does not exist, add new item
        }
    }

    // Remove an item from the inventory
    public void removeItem(String sku, int quantity) {
        Item item = findItem(sku);
        if (item != null) {
            item.decreaseQuantity(quantity);
        } else {
            System.out.println("Item not found with SKU: " + sku);
        }
    }

    // Find an item in the inventory by SKU
    private Item findItem(String sku) {
        for (Item item : items) {
            if (item.getSku().equals(sku)) {
                return item;
            }
        }
        return null;
    }

    // Update an existing item
    public void updateItem(String sku, String newName, double newPrice, int newQuantity) {
        Item item = findItem(sku);
        if (item != null) {
            item.updateName(newName);
            item.updatePrice(newPrice);
            item.setQuantity(newQuantity);
        } else {
            System.out.println("Item not found with SKU: " + sku);
        }
    }

    // Display the current inventory
    public void displayInventory() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    // Save inventory to file
    public void saveInventory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Item item : items) {
                writer.write(item.getName() + "," + item.getSku() + "," + item.getPrice() + "," + item.getQuantity());
                writer.newLine();
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Load inventory from file
    private void loadInventory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[0];
                    String sku = data[1];
                    double price = Double.parseDouble(data[2]);
                    int quantity = Integer.parseInt(data[3]);
                    items.add(new Item(name, sku, price, quantity));
                }
            }
            System.out.println("Inventory loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
}
