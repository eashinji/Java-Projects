import java.text.DecimalFormat;
//---------------------------------------------------------------------
/*
* @author Eashinji
* @version 2024-07-08
*/
//---------------------------------------------------------------------

public class Item {
    private String name;
    private String sku;
    private double price;
    private int quantity;

    private static final DecimalFormat priceFormatter = new DecimalFormat("$#.00"); // Formatter for price

    // Constructor
    public Item(String name, String sku, double price, int quantity) {
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public double getPrice() {
        return price;
    }

    public String getFormattedPrice() {
        return priceFormatter.format(price); // Return formatted price
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Increase the quantity
    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    // Decrease the quantity
    public void decreaseQuantity(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Insufficient stock.");
        }
    }

    // Update item name
    public void updateName(String name) {
        this.name = name;
    }

    // Update item price
    public void updatePrice(double price) {
        this.price = price;
    }

    // To display the item information
    @Override
    public String toString() {
        return "Name: " + name + ", SKU: " + sku + ", Price: " + getFormattedPrice() + ", Quantity: " + quantity;
    }
}
