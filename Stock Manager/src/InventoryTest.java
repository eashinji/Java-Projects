import java.util.Scanner;

public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Inventory");
            System.out.println("4. Update Item");
            System.out.println("5. Mass Input (Batch)");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter SKU: ");
                    String addSku = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double addPrice = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int addQuantity = scanner.nextInt();
                    inventory.addItem(addName, addSku, addPrice, addQuantity);
                    break;
                case 2:
                    System.out.print("Enter SKU of item to remove: ");
                    String removeSku = scanner.nextLine();
                    System.out.print("Enter quantity to remove: ");
                    int removeQuantity = scanner.nextInt();
                    inventory.removeItem(removeSku, removeQuantity);
                    break;
                case 3:
                    inventory.displayInventory();
                    break;
                case 4:
                    System.out.print("Enter SKU of item to update: ");
                    String updateSku = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateItem(updateSku, newName, newPrice, newQuantity);
                    break;
                case 5:
                    System.out.print("How many items would you like to add? ");
                    int numberOfItems = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    for (int i = 0; i < numberOfItems; i++) {
                        System.out.println("Enter details for item " + (i + 1));

                        System.out.print("Enter item name: ");
                        String batchName = scanner.nextLine();
                        System.out.print("Enter SKU: ");
                        String batchSku = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double batchPrice = scanner.nextDouble();
                        System.out.print("Enter quantity: ");
                        int batchQuantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        inventory.addItem(batchName, batchSku, batchPrice, batchQuantity);
                    }
                    break;
                case 6:
                    inventory.saveInventory(); // Save inventory to file before exiting
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Exiting program.");
    }
}
