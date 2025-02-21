
package foodOrderingSystem.Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Notification {  // Correct class name
    
    private String username;
    private String message;
    private String date;  // Change Date → date to avoid conflicts

    public Notification(String username, String message, String date) { 
        this.username = username;  
        this.message = message;
        this.date = date;  // Ensure consistency
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
            writer.write(username + "--" + message + "--" + date);  // Ensure date is treated as a String
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Notification sent successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not send notification.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

