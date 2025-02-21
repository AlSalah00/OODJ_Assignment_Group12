
package foodOrderingSystem.Classes;

import foodOrderingSystem.jFrames.CustomerPage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class User {
    
    private String ID;
    private String username;
    private String email;
    private String phoneNo;
    private String password;
    private String role;
    private String balance;
    
    public User(String ID, String username, String email, String phoneNo, String password, String role) {
        this.ID = ID;
        this.username = username;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.role = role;
    }
    
    public User(String ID) {
        this.ID = ID;
    }
    
    public User(String ID, String username, String balance) {
        this.ID = ID;
        this.username = username;
        this.balance = balance;
    }
    
    public User() {}
    
    public String getID() {
        return ID;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhoneNo() {
        return phoneNo;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getRole() {
        return role;
    }
    
    public String getBalance() {
        return balance;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public void setBalance(String balance) {
        this.balance = balance;
    }
    
    public static boolean usernameExists(String filePath, String username) {
        try (Scanner scanner = new Scanner(new File("User.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userDetails = line.split(";");
                if (userDetails.length > 0 && userDetails[0].equals(username)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return false;
    }
    
    public void addUser() {
              
        if (usernameExists("User.txt", this.username)) {
            JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different username." , "Error", JOptionPane.ERROR_MESSAGE);          
        }
        
        else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("User.txt", true))) {
            writer.write(ID + "--" + username + "--" + email + "--" + phoneNo + "--" + password + "--" + role);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "User data saved successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not save user data." , "Error", JOptionPane.ERROR_MESSAGE);
        }
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Balance.txt", true))) {
            writer.write(ID + "--" + username + "--" + 0);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not save user balance." , "Error", JOptionPane.ERROR_MESSAGE);
        }
        }      
       
    }
    
    public void editUser() {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("User.txt"));
            ArrayList<String> lines = new ArrayList<>();
            String line;
            
            while ((line = br.readLine()) != null) {
                lines.add(line);               
            }
            br.close();
            
            FileWriter fw = new FileWriter("User.txt");
            for (int i = 0; i < lines.size(); i++) {
                String existingLine = lines.get(i);
                String[] data = existingLine.split("--");

                if (data[0].equals(ID)) { 
                    fw.write(
                            ID + "--"
                            + username + "--"
                            + email + "--"
                            + phoneNo + "--"
                            + password + "--"
                            + role + "\n"
                    );
                } else {
                    fw.write(existingLine + "\n");
                }
            }
            fw.close();
            
            JOptionPane.showMessageDialog(null, "Record updated successfully.","Info",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }
    
    
    public void delUser() {
        
        File inputFile = new File("User.txt");
        StringBuilder updatedContent = new StringBuilder();
        boolean recordFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split("--");
                if (data.length > 0 && data[0].equals(ID)) {
                    recordFound = true;
                    continue;
                }
                updatedContent.append(currentLine).append(System.lineSeparator());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file: " + e.getMessage());
            return;
        }

        if (!recordFound) {
            JOptionPane.showMessageDialog(null, "Record with ID " + ID + " not found.","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write(updatedContent.toString());
            JOptionPane.showMessageDialog(null, "Record with ID " + ID + " deleted successfully.","Info",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while writing to the file: " + e.getMessage());
        }
    }
    
    public List<String[]> viewAll() {
        
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("User.txt"))) {
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
    
    public void displayVendors(JComboBox ComboBox) {
        
         try (BufferedReader br = new BufferedReader(new FileReader("User.txt"))) {
             String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("--"); 
                if (parts.length == 6 && parts[5].trim().equalsIgnoreCase("Vendor")) { 
                    ComboBox.addItem(parts[1].trim());
                }
            }
         } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static User Login(String username, String password) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("User.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split("--");
                String userId = userData[0];
                String userUsername = userData[1];
                String userEmail = userData[2];
                String userPhoneNo = userData[3];
                String userPassword = userData[4];
                String userRole = userData[5];

                if (userUsername.equals(username) && userPassword.equals(password)) {
                    return new User(userId, userUsername, userEmail, userPhoneNo, userPassword, userRole);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file: " + e.getMessage());
        }
        return null;
    }
    
    public List<String[]> viewBalance() {
        
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("Balance.txt"))) {
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
    
    public void TopUp() {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Balance.txt"));
            ArrayList<String> lines = new ArrayList<>();
            String line;
            
            while ((line = br.readLine()) != null) {
                lines.add(line);               
            }
            br.close();
            
            FileWriter fw = new FileWriter("Balance.txt");
            for (int i = 0; i < lines.size(); i++) {
                String existingLine = lines.get(i);
                String[] data = existingLine.split("--");

                if (data[0].equals(ID)) { 
                    fw.write(
                            ID + "--"
                            + username + "--"
                            + balance + "\n"
                    );
                } else {
                    fw.write(existingLine + "\n");
                }
            }
            fw.close();
            
            JOptionPane.showMessageDialog(null, "Top up successful.","Info",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }
}
