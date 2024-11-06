Inventory Management - README
Overview
The Inventory Management program is a simple terminal-based application to manage and manipulate an inventory of items. It allows users to add, remove, view, update, and input items in batch. This program is designed to help you manage your inventory easily from the command line.

Prerequisites
Before running the program, ensure that you have the following:

Java installed on your system.
A terminal or command-line interface.
To Check if Java is Installed:
Open your terminal.
Type the following command:
Copy code
java -version
If Java is installed, the version will be displayed. If not, you'll need to install Java.
Running the Program in Terminal Using Inventory.bat
Step 1: Ensure Java is Installed
Before running the .bat file, make sure you have Java installed on your system. You can check by running:

Copy code
java -version
Step 2: Navigate to the Program Directory
Open your terminal and navigate to the folder where the Inventory.bat file is located.

Step 3: Run the Program Using Inventory.bat
Once you're in the correct directory, run the batch file (Inventory.bat) by typing the following command in the terminal:

Copy code
Inventory.bat
This will automatically compile and run the Inventory Management program.

Step 4: Interacting with the Program
Once the program starts, you'll see the following options displayed in the terminal:

mathematica
Copy code
--- Inventory Management ---
1. Add Item
2. Remove Item
3. View Inventory
4. Update Item
5. Mass Input (Batch)
6. Exit
Select an option:
Step 5: Select an Option
1. Add Item: Allows you to add a new item to the inventory. You will be prompted to enter the item's details (e.g., name, SKU, price, quantity).

2. Remove Item: Lets you remove an item from the inventory by specifying its SKU.

3. View Inventory: Displays a list of all the items in the inventory. If the inventory is empty, it will show a message saying "Inventory is empty."

4. Update Item: Allows you to update the details of an existing item (e.g., change price, quantity, or name). You'll be asked to provide the SKU of the item and the new details.

5. Mass Input (Batch): Enables you to input multiple items in bulk using a predefined list of items. You will be prompted to provide a file or input the details of multiple items.

6. Exit: Exits the program.

Example Interaction
mathematica
Copy code
--- Inventory Management ---
1. Add Item
2. Remove Item
3. View Inventory
4. Update Item
5. Mass Input (Batch)
6. Exit
Select an option: 3
Inventory is empty.
Step 6: Exiting the Program
To exit the program at any time, simply select option 6. Exit. The application will terminate and return to the command prompt.

File Structure
The program assumes the following file structure:

InventoryManagement.java: The main Java file containing the application code.
Inventory.bat: The batch file that runs the program.
inventory.txt (if used for batch input): A file that may contain pre-defined inventory entries in CSV format.
Notes
Data Persistence: Depending on your implementation, the inventory data may not persist after the program is closed unless you have added functionality to save and load inventory from a file.
Error Handling: Ensure to handle invalid inputs and exceptions (e.g., invalid SKU or incorrect format) gracefully within the program.
