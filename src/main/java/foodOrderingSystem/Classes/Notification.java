
package foodOrderingSystem.Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Notification {
    
    private String username;
    private String message;
    private String date;

    public Notification(String username, String message, String date) { 
        this.username = username;  
        this.message = message;
        this.date = date;
    }
    
    public Notification() {
        
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setDate(String date) { 
        this.date = date;
    }

    public String getDate() { 
        return date;
    }
    
    public void sendNotification() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Notification.txt", true))) {
            writer.write(username + "--" + message + "--" + date);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Notification sent successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not send notification.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<String[]> ViewNotifications() {
        
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("Notification.txt"))) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split("--");
                records.add(data);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file: " + e.getMessage());
        }

        return records;
    }    
}

