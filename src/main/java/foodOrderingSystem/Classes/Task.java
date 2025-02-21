
package foodOrderingSystem.Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Task {
    
    
    private String OrderId;
    private String CustomerName;
    private String Vendor;
    private String DeliveryRunner;
    private String ItemName;
    private String Quantity;
    private String Date;
    private String Status;
    
    
    public Task(String OrderId, String CustomerName, String Vendor, String DeliveryRunner, 
            String ItemName, String Quantity, String Date, String Status) {
        
        this.OrderId = OrderId;
        this.CustomerName = CustomerName;
        this.Vendor = Vendor;
        this.DeliveryRunner = DeliveryRunner;
        this.ItemName = ItemName;
        this.Quantity = Quantity; 
        this.Date = Date; 
        this.Status = Status;
    }
    
    public Task() {
        
    }
    
    public String getOrderId() {
        return OrderId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getVendor() {
        return Vendor;
    }
    
    public String getDeliveryRunner() {
        return DeliveryRunner;
    }
    
    public String getItemName() {
        return ItemName;
    }
    
    public String getQuantity() {
        return Quantity;
    }
    
     public String getDate() {
        return Date;
    }
     
    public String getStatus() {
        return Status;
    }
    
    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public void setVendor(String Vendor) {
        this.Vendor = Vendor;
    }
    
    public void setDeliveryRunner(String DeliveryRunner) {
        this.DeliveryRunner = DeliveryRunner;
    }
    
    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }
    
    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }
        
    public void setDate(String Date) {
        this.Date = Date;
    }
    
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    public void addTask() {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Task.txt", true))) {
            writer.write(OrderId + "--" + CustomerName + "--" + Vendor + "--" + DeliveryRunner + "--" + Date + "--" + 
                    ItemName + "--" + Quantity + "--" + Status);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Task added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not add task." , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateOrderStatus() {
       
          try {
            BufferedReader br = new BufferedReader(new FileReader("Task.txt"));
            ArrayList<String> lines = new ArrayList<>();
            String line;
            
            while ((line = br.readLine()) != null) {
                lines.add(line);               
            }
            br.close();
            
            FileWriter fw = new FileWriter("Task.txt");
            for (int i = 0; i < lines.size(); i++) {
                String existingLine = lines.get(i);
                String[] data = existingLine.split("--");

                if (data[0].equals(OrderId)) { 
                    fw.write(
                            OrderId + "--"
                            + CustomerName + "--"
                            + Vendor + "--"
                            + DeliveryRunner + "--"                                
                            + ItemName + "--"
                            + Quantity + "--"
                            + Date + "--"  
                            + Status + "\n"
                            
                    );
                } else {
                    fw.write(existingLine + "\n");
                }
            }
            fw.close();
            
            JOptionPane.showMessageDialog(null, "Status updated successfully.","Info",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
     }
    
    
    public List<String[]> ViewTasks() {
        
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("Task.txt"))) {
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
