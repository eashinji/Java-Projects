import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.swing.*;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//---------------------------------------------------------------------
/*
* @author Eashinji
* @version 2024-06-10
*/
//Displays weather data (Temperature, Humidity and Description)
//---------------------------------------------------------------------

public class WeatherApp {

    // Replace with your actual OpenWeatherMap API key
    private static final String API_KEY = "Paste YOUR-API here! Can be obtained for free in Open Weather";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    public static void main(String[] args) {
        // Set up the Swing frame
        JFrame frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        // City input label
        JLabel cityLabel = new JLabel("Enter City:");
        cityLabel.setBounds(30, 30, 100, 25);
        frame.add(cityLabel);

        // City input text field
        JTextField cityField = new JTextField();
        cityField.setBounds(150, 30, 150, 25);
        frame.add(cityField);

        // Button to fetch weather data
        JButton fetchButton = new JButton("Get Weather");
        fetchButton.setBounds(150, 70, 150, 30);
        frame.add(fetchButton);

        // Labels to display weather information
        JLabel timeLabel = new JLabel("Local Time: ");
        timeLabel.setBounds(30, 120, 300, 25);
        frame.add(timeLabel);

        JLabel temperatureLabel = new JLabel("Temperature: ");
        temperatureLabel.setBounds(30, 150, 300, 25);
        frame.add(temperatureLabel);

        JLabel humidityLabel = new JLabel("Humidity: ");
        humidityLabel.setBounds(30, 180, 300, 25);
        frame.add(humidityLabel);

        JLabel descriptionLabel = new JLabel("Description: ");
        descriptionLabel.setBounds(30, 210, 300, 25);
        frame.add(descriptionLabel);

        // Action for the button to fetch weather data
        fetchButton.addActionListener(e -> {
            String city = cityField.getText();
            getWeatherData(city, timeLabel, temperatureLabel, humidityLabel, descriptionLabel);
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    private static void getWeatherData(String city, JLabel timeLabel, JLabel temperatureLabel,
                                       JLabel humidityLabel, JLabel descriptionLabel) {
        try {
            // Encode the city name to handle spaces and special characters
            String encodedCity = URLEncoder.encode(city, "UTF-8");

            // Build the URL for the API request
            String urlString = BASE_URL + encodedCity + "&appid=" + API_KEY + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check for successful response
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                JOptionPane.showMessageDialog(null, "Failed to retrieve weather data.");
                return;
            }

            // Parse the JSON response
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            // Extract weather data
            String description = jsonResponse.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
            double temperature = jsonResponse.getAsJsonObject("main").get("temp").getAsDouble();
            int humidity = jsonResponse.getAsJsonObject("main").get("humidity").getAsInt();

            // Get current date and time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String currentTime = now.format(formatter);

            // Update the labels with weather data
            timeLabel.setText("Local Time: " + currentTime);
            temperatureLabel.setText("Temperature: " + temperature + "°C");
            humidityLabel.setText("Humidity: " + humidity + "%");
            descriptionLabel.setText("Description: " + description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
