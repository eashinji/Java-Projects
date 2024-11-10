Project Overview READ-ME
WeatherApp
WeatherApp is a Java-based graphical user interface (GUI) application that allows users to fetch and display real-time weather information for a given city. The application uses the OpenWeather API to retrieve weather data and presents it through a simple, user-friendly form.

Inventory Management
The Inventory Management program is a simple terminal-based application to manage and manipulate an inventory of items. It allows users to add, remove, view, update, and input items in batch. This program is designed to help manage inventory easily from the command line.

WeatherApp - Full Description
Overview
The WeatherApp is a Java-based application that allows users to get weather information for a given city. It uses the OpenWeather API to fetch real-time weather data and displays it in a graphical user interface (GUI) created using Java Swing.

Features
Weather Information: Displays the current temperature, humidity, and weather description for a given city.
User Input: Users can input a city name into a text field to get weather information.
Simple GUI: The application features a user-friendly interface with buttons, labels, and text fields.
Dependencies
Java: The application requires Java to run. Ensure that you have Java 8 or higher installed.

Gson Library: The application uses the Gson library for parsing JSON responses from the OpenWeather API.

You can download Gson from here: Gson GitHub

Alternatively, you can use the provided gson-2.11.0.jar file.

Setup and Installation
Prerequisites
Install Java: Make sure Java is installed on your system.

Download and install Java from Oracle's official website.
Download Gson Library: The Gson library is required to parse the JSON data from the OpenWeather API. You can download the necessary gson-2.11.0.jar file from the official Gson repository and place it in the same directory as your project or include it in your project classpath.

Running the Application
Compiling the Program:

Open a command prompt or PowerShell window.
Navigate to the src directory where your WeatherApp.java file is located.
Run the following command to compile the Java file:
bash
Copy code
javac -cp ".;C:\path\to\gson-2.11.0.jar" WeatherApp.java
Running the Program:

After compiling, you can run the program by using the following command:
bash
Copy code
java -cp ".;C:\path\to\gson-2.11.0.jar" WeatherApp
This command will start the application and open the GUI.

Creating a Batch File (Optional)
To make it easier to run the program, you can create a batch file (RunWeatherApp.bat) that executes the program with one click.

Open a text editor (e.g., Notepad).
Copy and paste the following lines into the editor:
batch
Copy code
@echo off
cd /d "C:\path\to\WeatherApp\src"
java -cp ".;C:\path\to\gson-2.11.0.jar" WeatherApp
pause
Save the file as RunWeatherApp.bat in the src directory.
Double-click the batch file to launch the application.
How to Use the Application
Launch the Application:

Either run the Java program via the command line or double-click the batch file to open the GUI.
Enter a City:

In the text box labeled "Enter City", type the name of the city you want to get weather data for.
Click "Get Weather":

After entering the city name, click the "Get Weather" button to fetch the weather data from the OpenWeather API.
View Weather Information:

The application will display the current temperature, humidity, and a weather description for the entered city in the GUI.
Error Handling
If an invalid city name is entered or there is a problem with the network connection, the application will show an error message indicating that the weather information could not be retrieved.
If there are any missing dependencies (like Gson), the program will fail to run, and you may need to resolve the dependency issue.
Inventory Management - Full Description
Overview
The Inventory Management program is a simple terminal-based Java application that allows users to manage an inventory of items. The program allows users to add, remove, view, update, and input items in batch from the command line interface (CLI).

Features
Add Item: Allows the user to add a new item to the inventory, including details like name, SKU, price, and quantity.
Remove Item: Removes an item from the inventory by SKU.
View Inventory: Displays the entire list of items in the inventory, or informs the user if the inventory is empty.
Update Item: Updates the details of an existing item (e.g., price, quantity).
Mass Input: Allows for batch input of multiple items from a predefined file or list.
Exit: Exits the program.
Prerequisites
Java: Ensure you have Java installed on your system. If not, install it from Oracle's official website.
Terminal/Command-Line Interface: You will need a terminal or command-line interface to run the program.
To Check if Java is Installed:
Open your terminal.
Type:
bash
Copy code
java -version
If Java is installed, it will show the version number. If not, follow the installation instructions on Oracle's website.

Running the Program Using Inventory.bat
Navigate to the Program Directory: Open your terminal and go to the directory where the Inventory.bat file is located.

Run the Program: In the terminal, type:

bash
Copy code
Inventory.bat
This batch file will automatically compile and run the program.

Program Interaction
When the program runs, you will be presented with the following menu options:

bash
Copy code
--- Inventory Management ---
1. Add Item
2. Remove Item
3. View Inventory
4. Update Item
5. Mass Input (Batch)
6. Exit
Select an option:
Add Item: Enter the name, SKU, price, and quantity of the item.
Remove Item: Enter the SKU of the item to remove.
View Inventory: View the list of items currently in your inventory.
Update Item: Change the price or quantity of an existing item by entering the SKU.
Mass Input (Batch): Import a list of items from a file to quickly add multiple items.
Exit: Quit the program.
File Structure
InventoryManagement.java: The main Java file with application code.
Inventory.bat: The batch file to run the program.
inventory.txt (if used): A file containing inventory items for batch input.
Notes
Data Persistence: Inventory data may not persist after closing the program unless explicitly saved to a file.
Error Handling: The program should handle invalid input and exceptions gracefully.
